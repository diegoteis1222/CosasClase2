
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class server {

    public static void main(String[] args) throws Exception {

        ArrayList<Asignatura> entrada = new ArrayList<Asignatura>();
        int puerto = 6600;

        ServerSocket servidor = new ServerSocket(puerto);

        Socket socket = servidor.accept();
        System.out.println("Cliente conectado.");

        ObjectInputStream in = new ObjectInputStream(socket.getInputStream());

        entrada = (ArrayList<Asignatura>) in.readObject();

        double sumaPrimero = 0, contadorPrimero = 0;
        double sumaSegundo = 0, contadorSegundo = 0;

        for (Asignatura asignatura : entrada) {
            if (asignatura.getCurso().equals("1DAM")) {
                sumaPrimero += asignatura.getNota();
                contadorPrimero++;
            } else if (asignatura.getCurso().equals("2DAM")) {
                sumaSegundo += asignatura.getNota();
                contadorSegundo++;
            }
        }

        double mediaPrimero = sumaPrimero / contadorPrimero;
        double mediaSegundo = sumaSegundo / contadorSegundo;
        double mediaTotal = (sumaPrimero + sumaSegundo) / (contadorPrimero + contadorSegundo);

        String resultado = "media 1DAM: " + mediaPrimero + ", media 2DAM: " + mediaSegundo + ", media total: " + mediaTotal;

        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        out.writeObject(resultado);

        System.out.println("Resultado enviado al cliente.");
        System.out.println("Cerrando el server....");

        in.close();
        out.close();
        socket.close();
        servidor.close();
    }

}
