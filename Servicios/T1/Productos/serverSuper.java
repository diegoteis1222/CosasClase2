
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class serverSuper {

    public static void main(String[] args) throws Exception {

        ArrayList<Producto> entrada = new ArrayList<Producto>();
        int puerto = 6600;

        ServerSocket servidor = new ServerSocket(puerto);

        Socket socket = servidor.accept();

        ObjectInputStream in = new ObjectInputStream(socket.getInputStream());

        entrada = (ArrayList<Producto>) in.readObject();

        // System.out.println("Array recibido del cliente.");
        // for (Cuakero cuakero : entrada) {
        // cuakero.mostrarInfo();
        // System.out.println();
        // }

        String cadena = Producto.generarTicket(entrada);
        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
        oos.writeObject(cadena);

        System.out.println("Ticket enviado");

        System.out.println("Cerrando el server....");

        in.close();
        socket.close();
        servidor.close();
    }

}
