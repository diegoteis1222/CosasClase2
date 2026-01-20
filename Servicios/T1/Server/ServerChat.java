import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerChat {

    public static void main(String[] args) throws IOException {

        System.out.println("Iniciando el puto chat...");
        int puerto = 6000;

        ServerSocket servidor = new ServerSocket(puerto);
        System.out.println("Servidor escuchando en " + servidor.getLocalPort());

        Socket cliente = servidor.accept();
        System.out.println("Se conectó alguien");

        boolean conexion = true;

        do {
            try {

                DataInputStream in = new DataInputStream(cliente.getInputStream());
                String msg = in.readUTF();
                System.out.println("Mensaje recibido: " + msg);

                DataOutputStream out = new DataOutputStream(cliente.getOutputStream());
                out.writeUTF("Contestao");

                if (msg.equalsIgnoreCase("exit")) {
                    conexion = false;
                }

            } catch (IOException e) {

                System.out.println("El cliente se ha desconectado");
            }
        } while (conexion);

        // servidor.close();

    }

}
