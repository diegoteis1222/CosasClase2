
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class clienteSuper {

    public static void main(String[] args) throws Exception {

        ArrayList<Producto> carrito = Producto.generaCarrito();

        // Cuakero cuakero1 = new Cuakero("Pato Lucas", 4, "Verde");
        // Cuakero cuakero2 = new Cuakero("Daisy", 3, "Blanco");
        // Cuakero cuakero3 = new Cuakero("Donald", 5, "Amarillo");

        // array.add(cuakero3);
        // array.add(cuakero2);
        // array.add(cuakero1);

        // for (Cuakero cuakero : array) {
        // cuakero.mostrarInfo();
        // System.out.println();
        // }

        String dir = "localhost";
        int puerto = 6600;

        Socket socket = new Socket(dir, puerto);

        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());

        out.writeObject(carrito);

        System.out.println("Array enviado al servidor.");

        ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
        String pvp = (String) ois.readObject();
        System.out.println("Su ticket: " + pvp);

        out.close();
        socket.close();

        System.out.println("Conexión cerrada.");

    }
}
