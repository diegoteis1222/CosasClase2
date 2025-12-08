
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Cliente {

    public static void main(String[] args) {
        String host = "localhost";
        int puerto = 1234;

        try {
            // Conectarse al servidor
            Socket socket = new Socket(host, puerto);
            System.out.println("Conectado al servidor de chat.");

            // Flujos
            PrintWriter fSalida = new PrintWriter(socket.getOutputStream(), true);

            // IMPORTANTE: si no lee desde teclado no deja escribir 
            BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));

            // Nombre del usuario
            System.out.print("Introduce tu nombre de usuario: ");
            String nombre = teclado.readLine();
            fSalida.println(nombre);

            // creamos el hilo
            HiloCliente hiloEscucha = new HiloCliente(socket);

            // iniciamos el hilo
            hiloEscucha.start();

            // mensaje a enviar
            String inputLine;

            // mientras llegue algo
            while ((inputLine = teclado.readLine()) != null) {

                // Si el cliente envía "quit" salimos
                if (inputLine.trim().equalsIgnoreCase("quit")) {
                    break;
                }
                // si no es quit enviamos lo que dijo 
                fSalida.println(nombre + ": " + inputLine);
            }

            // Cerrar 
            socket.close();

        } catch (Exception e) {
            System.out.println("Error en el cliente: " + e.getMessage());
        }
    }
}
