
import java.net.ServerSocket;
import java.net.Socket;

public class ServerHilos {

    public static ServerSocket servidor;

    public static void iniciarServer(int puerto) {

        try {
            // Crear el socket del servidor
            servidor = new ServerSocket(puerto);
            System.out.println("Server iniciado en el peurto: " + puerto);

            // Bucle infinito para aceptar conexiones de clientes
            while (true) {

                // Aceptar una conexión entrante
                Socket cliente = servidor.accept();
                System.out.println("Cliente conectado: " + cliente.getInetAddress());

                // Crear y arrancar un nuevo hilo para manejar al cliente
                HiloServidor hilo = new HiloServidor(cliente);

                // Iniciar el hilo para manejar la comunicación con el cliente
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
