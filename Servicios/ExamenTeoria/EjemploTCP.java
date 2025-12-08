
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class EjemploTCP {

    // Ignorar que no está la clase Producto, son solo metodos
    // FUNCIONAMIENTO TCP
    //El Servidor Escucha: En new ServerSocket(puerto) abre el puerto 6600 y espera
    //El Servidor Espera: En servidor.accept() detiene la ejecución del programa hasta que alguien llame
    //El Cliente Conecta: En new Socket(dir, puerto) inicia la conexión con el servidor
    //Establecimiento del Canal: Una vez conectados, el servidor retorna un objeto Socket
    //Intercambio de Datos:
    //Cliente envía ArrayList.
    //Servidor recibe, procesa y responde con un String.
    //Ambos cierran los flujos 
    public static void server() throws Exception {

        // Array de productos recibido del cliente
        ArrayList<Producto> entrada = new ArrayList<Producto>();

        int puerto = 6600;

        // el server escucha en el puerto marcado
        ServerSocket servidor = new ServerSocket(puerto);

        // el server espera a que un cliente se conecte y lo acepta
        Socket socket = servidor.accept();

        // recibe el paquete del cliente
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream());

        // lee el objeto recibido y lo castea a ArrayList<Producto>
        entrada = (ArrayList<Producto>) in.readObject();

        String cadena = Producto.generarTicket(entrada);

        // crea el flujo de salida para enviar datos al cliente
        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());

        // envía la cadena al cliente
        oos.writeObject(cadena);

        System.out.println("Ticket enviado");

        System.out.println("Cerrando el server....");

        // cierra los flujos y el socket
        in.close();
        oos.close();
        socket.close();
        servidor.close();
    }

    public static void cliente() throws Exception {

        ArrayList<Producto> carrito = Producto.generaCarrito();

        String dir = "localhost";
        int puerto = 6600;

        // crea el socket para conectarse al servidor
        Socket socket = new Socket(dir, puerto);

        // crea el flujo de salida para enviar datos al servidor
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());

        // envía el array al servidor
        out.writeObject(carrito);

        System.out.println("Array enviado al servidor.");

        // crea el flujo de entrada para recibir datos del servidor
        ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());

        // recibe los datos del server y los castea a String
        String pvp = (String) ois.readObject();
        System.out.println("Su ticket: " + pvp);

        // cierra los flujos y el socket
        ois.close();
        out.close();
        socket.close();

        System.out.println("Conexión cerrada.");

    }
}
