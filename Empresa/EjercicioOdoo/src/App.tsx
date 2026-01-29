import { useEffect, useMemo, useState } from 'react'
import './App.css'
import {
  type OdooRecord,
  fetchOdooPartners,
  fetchOdooTrips,
  getDisplayName,
  parseCsvFields,
} from './odooClient'

const PARTNER_FIELDS = ['name', 'email', 'phone', 'city', 'country_id']

function App() {
  const [partners, setPartners] = useState<OdooRecord[]>([])
  const [trips, setTrips] = useState<OdooRecord[]>([])
  const [loading, setLoading] = useState(true)
  const [error, setError] = useState<string | null>(null)

  const tripFields = useMemo(
    () =>
      parseCsvFields(
        import.meta.env.VITE_ODOO_TRIP_FIELDS ??
          'titulo,fecha_inicio,duracion,plazas,estado,conductor_id,vehiculo_id,plazas_ocupadas,display_name'
      ),
    []
  )

  const tripModel = import.meta.env.VITE_ODOO_TRIP_MODEL ?? 'viajes.viaje'

  useEffect(() => {
    let isMounted = true

    const loadData = async () => {
      try {
        setLoading(true)
        setError(null)

        const [partnersResult, tripsResult] = await Promise.all([
          fetchOdooPartners({ fields: PARTNER_FIELDS, limit: 200 }),
          fetchOdooTrips({ model: tripModel, fields: tripFields, limit: 200 }),
        ])

        if (!isMounted) return

        setPartners(partnersResult)
        setTrips(tripsResult)
      } catch (err) {
        if (!isMounted) return
        setError(err instanceof Error ? err.message : 'Error cargando datos de Odoo')
      } finally {
        if (!isMounted) return
        setLoading(false)
      }
    }

    loadData()

    return () => {
      isMounted = false
    }
  }, [tripFields, tripModel])

  const partnerCount = partners.length
  const tripCount = trips.length

  return (
    <div className="page">
      <header className="hero">
        <div>
          <p className="eyebrow">Panel Odoo</p>
          <h1>Partners y viajes</h1>
          <p className="subtitle">
            Listado en tiempo real desde tu instancia de Odoo.
          </p>
        </div>
        <div className="stats">
          <div>
            <span className="stat-label">Partners</span>
            <span className="stat-value">{partnerCount}</span>
          </div>
          <div>
            <span className="stat-label">Viajes</span>
            <span className="stat-value">{tripCount}</span>
          </div>
        </div>
      </header>

      {loading && <div className="state">Cargando datos…</div>}
      {error && (
        <div className="state state-error">
          <p>{error}</p>
          <p>Revisa las variables VITE_ODOO_* y la conexión con Odoo.</p>
        </div>
      )}

      {!loading && !error && (
        <main className="grid">
          <section className="panel">
            <h2>Partners</h2>
            <ul className="list">
              {partners.map((partner) => (
                <li key={partner.id} className="list-item">
                  <div>
                    <strong>{getDisplayName(partner)}</strong>
                    <p className="muted">
                      {partner.email ?? 'Sin email'} · {partner.phone ?? 'Sin teléfono'}
                    </p>
                    <p className="muted">
                      {partner.city ?? 'Sin ciudad'} · {partner.country_id?.[1] ?? 'Sin país'}
                    </p>
                  </div>
                  <span className="pill">#{partner.id}</span>
                </li>
              ))}
            </ul>
          </section>

          <section className="panel">
            <h2>Viajes</h2>
            <p className="muted">Modelo: {tripModel}</p>
            <ul className="list">
              {trips.map((trip) => (
                <li key={trip.id} className="list-item">
                  <div>
                    <strong>{getDisplayName(trip)}</strong>
                    <p className="muted">
                      Inicio: {trip.fecha_inicio ?? 'Sin fecha'} · Duración:{' '}
                      {trip.duracion ?? '—'} días
                    </p>
                    <p className="muted">
                      Plazas: {trip.plazas ?? '—'} · Ocupadas:{' '}
                      {trip.plazas_ocupadas ?? '—'}%
                    </p>
                    <p className="muted">Estado: {trip.estado ?? '—'}</p>
                    {trip.conductor_id && (
                      <p className="muted">Conductor: {trip.conductor_id[1]}</p>
                    )}
                    {trip.vehiculo_id && (
                      <p className="muted">Vehículo: {trip.vehiculo_id[1]}</p>
                    )}
                  </div>
                  <span className="pill">#{trip.id}</span>
                </li>
              ))}
            </ul>
          </section>
        </main>
      )}
    </div>
  )
}

export default App
