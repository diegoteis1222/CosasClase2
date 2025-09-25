import java.io.DataInputStream;
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
        DataInputStream in = new DataInputStream(cliente.getInputStream());
        String msg = in.readUTF();
        System.out.println("Mensaje recibido: " + msg);

        servidor.close();

    }

}
