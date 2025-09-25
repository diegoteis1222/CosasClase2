import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;

public class ProtoCliente {

    public static void main(String[] args) throws IOException {
        int port = 6000;

        try {

            ServerSocket socket = new ServerSocket(port);

            System.out.println("----IP local usada por el cliente----");
            InetAddress inetAddress = socket.getInetAddress();

            System.out.println("Puerto local: " + socket.getLocalPort());

            System.out.println("----Datos de conexion externa----");
            System.out.println("Puerto remoto: " + socket.getLocalPort());
            System.out.println("Host remoto: " + inetAddress.getHostName());
            System.out.println("Dirección IP remota: " + inetAddress.getHostAddress());

            java.net.Socket clientSocket = socket.accept();

            DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());
            out.writeUTF("Quien quisiera tener la dicha que tiene el galloooooo");

            clientSocket.close();
            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
