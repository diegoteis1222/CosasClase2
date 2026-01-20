
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class server {

    public static void main(String[] args) throws Exception {
        int puerto = 6600;
        ServerSocket servidor = new ServerSocket(puerto);

        System.out.println("Servidor iniciado en el puerto " + puerto + ". Esperando clientes...");

        Socket socket = servidor.accept();
        System.out.println("Cliente conectado desde: " + socket.getInetAddress());

        ObjectInputStream in = new ObjectInputStream(socket.getInputStream());

        ArrayList<casa> listaCasas = (ArrayList<casa>) in.readObject();

        String respuesta = "";
        int contadorCasas = 0;

        System.out.println("Procesando " + listaCasas.size() + " casas...");

        for (casa c : listaCasas) {
            String resultadoCasa = calcularPrecio(c);

            respuesta += resultadoCasa + "\n";
            contadorCasas++;
        }

        respuesta += "\nTotal de casas valoradas: " + contadorCasas;

        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        out.writeObject(respuesta);

        System.out.println("Resultado enviado al cliente.");

        in.close();
        out.close();
        socket.close();

    }

    public static String calcularPrecio(casa c) {

        int ValorHabitacion = 75;
        int ValorBaño = 50;
        int ValorTrastero = 100;

        String textoTrastero = "con";

        if (c.isTrastero() == false) {
            ValorTrastero = 0;
            textoTrastero = "sin";
        }

        int precioFinal = c.getHabitaciones() * ValorHabitacion + c.getBaños() * ValorBaño + ValorTrastero;

        return "El alquiler de la casa con " + c.getHabitaciones() + " habitaciones, "
                + c.getBaños() + " baño y " + textoTrastero + " trastero vale: " + precioFinal + " leuros";
    }
}
