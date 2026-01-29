export type OdooRecord = Record<string, any> & { id: number }

type JsonRpcResponse<T> = {
  jsonrpc: '2.0'
  id: number
  result?: T
  error?: {
    code: number
    message: string
    data?: {
      message?: string
      debug?: string
      name?: string
      arguments?: string[]
    }
  }
}

type SearchReadParams = {
  model: string
  fields: string[]
  domain?: unknown[]
  limit?: number
  offset?: number
  order?: string
}

const odooUrl = import.meta.env.VITE_ODOO_URL
const odooDb = import.meta.env.VITE_ODOO_DB
const odooUser = import.meta.env.VITE_ODOO_USERNAME
const odooPassword = import.meta.env.VITE_ODOO_PASSWORD

// Usa proxy de Vite en desarrollo, URL completa en producción
const jsonRpcUrl = import.meta.env.DEV ? '/jsonrpc' : `${odooUrl}/jsonrpc`

const validateConfig = () => {
  if (!odooUrl || !odooDb || !odooUser || !odooPassword) {
    throw new Error(
      'Configura VITE_ODOO_URL, VITE_ODOO_DB, VITE_ODOO_USERNAME y VITE_ODOO_PASSWORD en tu entorno.'
    )
  }
}

const jsonRpcCall = async <T>(params: Record<string, unknown>, id = 1): Promise<T> => {
  const response = await fetch(jsonRpcUrl, {
    method: 'POST',
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify({
      jsonrpc: '2.0',
      method: 'call',
      params,
      id,
    }),
  })

  if (!response.ok) {
    throw new Error(`Error HTTP ${response.status} al conectar con Odoo`) 
  }

  const data = (await response.json()) as JsonRpcResponse<T>

  if (data.error) {
    const message = data.error.data?.message ?? data.error.message
    throw new Error(`Odoo error: ${message}`)
  }

  if (data.result === undefined) {
    throw new Error('Respuesta inválida de Odoo')
  }

  return data.result
}

const login = async (): Promise<number> => {
  validateConfig()

  const uid = await jsonRpcCall<number>({
    service: 'common',
    method: 'login',
    args: [odooDb, odooUser, odooPassword],
  })

  if (!uid) {
    throw new Error('No se pudo autenticar en Odoo. Revisa usuario/contraseña.')
  }

  return uid
}

const searchRead = async ({
  model,
  fields,
  domain = [],
  limit = 100,
  offset = 0,
  order,
}: SearchReadParams): Promise<OdooRecord[]> => {
  const uid = await login()

  return jsonRpcCall<OdooRecord[]>({
    service: 'object',
    method: 'execute_kw',
    args: [
      odooDb,
      uid,
      odooPassword,
      model,
      'search_read',
      [domain],
      {
        fields,
        limit,
        offset,
        order,
      },
    ],
  })
}

export const fetchOdooPartners = async (options?: Partial<SearchReadParams>) =>
  searchRead({
    model: 'res.partner',
    fields: ['name', 'email', 'phone', 'city', 'country_id'],
    ...options,
  })

export const fetchOdooTrips = async ({
  model,
  fields,
  limit,
  offset,
  order,
}: {
  model: string
  fields: string[]
  limit?: number
  offset?: number
  order?: string
}) =>
  searchRead({
    model,
    fields,
    limit,
    offset,
    order,
  })

export const parseCsvFields = (value: string): string[] =>
  value
    .split(',')
    .map((field) => field.trim())
    .filter(Boolean)

export const getDisplayName = (record: OdooRecord): string =>
  (record.display_name ?? record.name ?? `Registro ${record.id}`) as string
