import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class cliente {

    public static void main(String[] args) {
        String dir = "localhost";
        int puerto = 6600;
        Scanner sc = new Scanner(System.in);

        try {
            Socket socket = new Socket(dir, puerto);
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            DataInputStream in = new DataInputStream(socket.getInputStream());

            boolean continuar = true;



            while (continuar) {


                System.out.println("\nIntroduce el primer número:");
                int n1 = pedirEnteroPositivo(sc);

                System.out.println("Introduce el segundo número:");
                int n2 = pedirEnteroPositivo(sc);

                String numerosParaEnviar = n1 + "," + n2;
                out.writeUTF(numerosParaEnviar);

                String respuesta = in.readUTF();
                System.out.println(">> Respuesta del servidor: " + respuesta);

                System.out.println("\n¿Desea comprobar otro par de números? (s/n):");
                String opcion = sc.nextLine();

                if (opcion.equalsIgnoreCase("n") || opcion.equalsIgnoreCase("no")) {
                    continuar = false;
                    out.writeUTF("quit"); 
                }
            }

            in.close();
            out.close();
            socket.close();
            System.out.println("Cliente finalizado.");

        } catch (Exception e) {
            System.out.println("Error de conexión: " + e.getMessage());
        }
        sc.close();
    }


    private static int pedirEnteroPositivo(Scanner sc) {
        int numero = 0;
        boolean valido = false;

        while (!valido) {
            try {
                String entrada = sc.nextLine();
                numero = Integer.parseInt(entrada); 

                if (numero > 0) {
                    valido = true; 
                } else {
                    System.out.println("ERROR: El número debe ser positivo. Inténtalo de nuevo:");
                }
            } catch (NumberFormatException e) {
                System.out.println("ERROR: Eso no es un número entero válido. Inténtalo de nuevo:");
            }
        }
        return numero;
    }
}