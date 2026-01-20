
import java.net.ServerSocket;
import java.net.Socket;

public class ServerHilos {

    public static ServerSocket servidor;

    public static void iniciarServer(int puerto) {

        try {
            servidor = new ServerSocket(puerto);
            System.out.println("Server iniciado en el peurto: " + puerto);

            while (true) {
                Socket cliente = servidor.accept();
                System.out.println("Cliente conectado: " + cliente.getInetAddress());

                HiloServidor hilo = new HiloServidor(cliente);
                hilo.start();
            }

        } catch (Exception e) {
            System.out.println("Error al iniciar el sever: " + e);
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        iniciarServer(1234);
    }
}
