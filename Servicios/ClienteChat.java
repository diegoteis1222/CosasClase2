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

                DataInputStream in = new DataInputStream(cliente.getInputStream());
                String msg = in.readUTF();
                System.out.println("Mensaje recivido: " + msg);
                System.out.println("--------------------------------------------------");

                if (envio.equalsIgnoreCase("exit")) {
                    conexion = false;
                }

            } while (conexion);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
