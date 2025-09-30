import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ClienteChat {

    public static void main(String[] args) throws IOException {
        String host = "localhost";
        int puerto = 6000;

        Scanner scanner = new Scanner(System.in);

        try {
            Socket cliente = new Socket(host, puerto);

            System.out.println("Datos del cliente:");
            System.out.println("Puerto remoto: " + cliente.getPort());
            System.out.println("Host remoto: " + cliente.getInetAddress().getHostName());
            System.out.println("Dirección IP remota: " + cliente.getInetAddress().getHostAddress());

            boolean conexion = true;

            do {

                DataOutputStream out = new DataOutputStream(cliente.getOutputStream());
                System.out.print("Escribe un mensaje: ");
                String envio = scanner.nextLine();
                out.writeUTF(envio);

                try {
                    int numero = Integer.parseInt(envio);
                esPerfecto(numero);
                } catch (Exception e) {
                    System.out.println("Error: Solo puedes meter numeros");
                }

                DataInputStream in = new DataInputStream(cliente.getInputStream());
                String msg = in.readUTF();
                System.out.println("Mensaje recivido: " + ecoMayus(msg));
                System.out.println("--------------------------------------------------");

                if (envio.equalsIgnoreCase("exit")) {
                    conexion = false;
                }

            } while (conexion);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void esPerfecto(int numero) {
        int suma = 0;
        for (int i = 1; i < numero; i++) {
            if (numero % i == 0) {
                suma += i;
            }
        }
        if (suma == numero) {
            System.out.println(numero + " es un número perfecto.");
        } else {
            System.out.println(numero + " no es un número perfecto.");
        }
    }

    public static String ecoMayus(String llega) {
        return llega.toUpperCase();
    }
}
