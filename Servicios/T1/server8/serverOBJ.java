
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class serverOBJ {

    public static void main(String[] args) throws Exception {

        ArrayList<Cuakero> entrada = new ArrayList<Cuakero>();
        int puerto = 6500;

        ServerSocket servidor = new ServerSocket(puerto);

        Socket socket = servidor.accept();

        ObjectInputStream in = new ObjectInputStream(socket.getInputStream());

        entrada = (ArrayList<Cuakero>) in.readObject();

        System.out.println("Array recibido del cliente.");
        for (Cuakero cuakero : entrada) {
            cuakero.mostrarInfo();
            System.out.println();
        }

        in.close();
        socket.close();
        servidor.close();
    }

}
