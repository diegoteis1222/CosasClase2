package servicio;

import modelo.Canal;
import modelo.Mensaje;

public class RegistroMensajes {

    public static Mensaje[] mensajes = new Mensaje[Canal.MAX_MENSAJES];

    public static int siguienteId, totalMensajes;

    public static boolean enviar(String remitente, String destinatario, String texto) {

        if (totalMensajes >= Canal.MAX_MENSAJES) {
            return false;
        }

        Mensaje m = new Mensaje(siguienteId++, remitente, destinatario, texto);
        mensajes[totalMensajes++] = m;
        return true;
    }

    public static Mensaje[] bandejaDeEntrada(String email) {

        int contador = 0;
        for (int i = 0; i < totalMensajes; i++) {
            if (mensajes[i].getDestinatario().equals(email)) {
                contador++;
            }
        }

        Mensaje[] resultado = new Mensaje[contador];
        int idx = 0;
        for (int i = 0; i < totalMensajes; i++) {
            if (mensajes[i].getDestinatario().equals(email)) {
                resultado[idx++] = mensajes[i];
            }
        }
        return resultado;
    }

    public static int getTotalMensajes() {
        return totalMensajes;
    }

}
