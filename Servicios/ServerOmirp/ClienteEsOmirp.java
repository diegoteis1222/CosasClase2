
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClienteEsOmirp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Comprobador de entero primo y reverso primo");

        String direccion = "localhost";
        int puerto = 6500;
        boolean continuar = true;

        try {
            
            Socket socket = new Socket(direccion, puerto);
            PrintWriter salida = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            while (continuar) {
                System.out.print("Ingrese un numero entero (o 'quit' para salir): ");
                String cadena = scanner.nextLine();

                salida.println(cadena);

                if (cadena.equalsIgnoreCase("quit")) {
                    System.out.println("Cerrando conexion...");
                    continuar = false;
                    break;
                }

                String respuesta = entrada.readLine();
                System.out.println("Respuesta del servidor: " + respuesta);

            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

    }
}
