
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

public class HiloCliente extends Thread {

    Socket socket;
    BufferedReader fEntrada;

    public HiloCliente(Socket socket) {
        this.socket = socket;

    }

    @Override
    public void run() {
        try {
            fEntrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // mensaje a enviar
            String mensaje;

            while ((mensaje = fEntrada.readLine()) != null) {
                System.out.println(mensaje);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
