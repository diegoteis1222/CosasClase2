import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClienteHilos {

    public static void main(String[] args) {

        String host = "localhost";
        int puerto = 1234;

        try (
                Socket socket = new Socket(host, puerto);
                PrintWriter salida = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
        ) {
            System.out.println("Conectado al servidor. Escribe mensajes para enviar (o 'quit' para salir):");
            String mensajeUsuario;

            while (true) {
                System.out.print("Mensaje: ");
                mensajeUsuario = teclado.readLine();

                if (mensajeUsuario == null) {
                    break;
                }
                
                salida.println(mensajeUsuario);

                if ("quit".equalsIgnoreCase(mensajeUsuario.trim())) {
                    System.out.println("Fin de la transmisión.");
                    break;
                }

                String respuestaServidor = entrada.readLine();
                
                if (respuestaServidor != null) {
                    System.out.println("Respuesta del servidor: " + respuestaServidor);
                } else {
                    System.out.println("El servidor ha cerrado la conexión.");
                    break;
                }
            }

        } catch (Exception e) {
            System.err.println("Error en el cliente: " + e.getMessage());
        }
    }
}