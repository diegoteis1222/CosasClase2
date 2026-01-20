
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class cliente {

    public static void main(String[] args) throws Exception {

        String dir = "localhost";
        int puerto = 6600;

        Socket socket = new Socket(dir, puerto);
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce dos numeros separados por una coma:");
        String numeros = sc.nextLine();

        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        DataInputStream in = new DataInputStream(socket.getInputStream());

        boolean continuar = true;

        while (continuar) {

            String numerosFiltrados = filtro2Numeros(numeros);

            out.writeUTF(numerosFiltrados);

            String respuesta = in.readUTF();
            System.out.println("Respuesta del servidor: " + respuesta);

            System.out.println("Quiere comprobar mas numeros? (no para salir)");
            String seguir = sc.nextLine();

            if (seguir.equals("no")) {
                continuar = false;
                in.close();
                out.close();
                socket.close();
                sc.close();
                System.out.println("Conexión cerrada.");
            } else {
                System.out.println("Introduce dos numeros separados por una coma:");
                numeros = sc.nextLine();
            }
        }
    }

    private static String filtro2Numeros(String frase) {

        String[] numeros = frase.split(",");

        if (numeros.length != 2) {
            return "No son 2 numeros";
        }

        return frase;
    }
}
