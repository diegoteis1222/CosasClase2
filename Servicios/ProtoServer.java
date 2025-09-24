import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ProtoServer {

    public static void main(String[] args) throws IOException {
        int puerto = 6000;

        ServerSocket servidor = new ServerSocket(puerto);
        System.out.println("Servidor escuchando en " + servidor.getLocalPort());

        Socket cliente = servidor.accept();

        Socket cliente2 = servidor.accept();

        servidor.close();
    }

}
