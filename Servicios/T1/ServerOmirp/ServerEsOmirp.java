
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerEsOmirp {

    public static void main(String[] args) {

        String direccion = "localhost";
        int puerto = 6500;

        try {
            ServerSocket servidor = new ServerSocket(puerto);
            System.out.println("Servidor iniciado en el puerto: " + puerto);

            while (true) {
                Socket socket = servidor.accept();
                System.out.println("Cliente conectado: " + socket.toString());

                HiloServidor hilo = new HiloServidor(socket);
                hilo.start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
