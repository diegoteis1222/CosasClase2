
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class cliente {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        ArrayList<casa> listaCasas = new ArrayList<casa>();

        System.out.print("¿Cuántas casas quieres valorar?: ");
        int numeroCasas = sc.nextInt();

        for (int i = 1; i <= numeroCasas; i++) {
            System.out.println("\n--- Casa " + (i) + " ---");
            System.out.print("Número de habitaciones: ");
            int habitaciones = sc.nextInt();

            System.out.print("Número de baños: ");
            int baños = sc.nextInt();

            // hace falta, si no no va
            sc.nextLine(); 

            System.out.print("¿Tiene trastero? (s/si para afirmar): ");
            String respuesta = sc.nextLine();

            boolean trastero = false;

            if (respuesta.equals("s") || respuesta.equals("si")) {
                trastero = true;
            }

            listaCasas.add(new casa(habitaciones, baños, trastero));
        }

        String dir = "localhost";
        int puerto = 6600;

        System.out.println("Conectando al servidor...");
        Socket socket = new Socket(dir, puerto);

        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        out.writeObject(listaCasas);
        System.out.println("Datos enviados al servidor. Esperando tasación...");

        ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
        String resultado = (String) ois.readObject();

        System.out.println("\n--- RESULTADO DEL SERVIDOR ---");
        System.out.println(resultado);

        out.close();
        ois.close();
        socket.close();
        sc.close();

        System.out.println("Conexión cerrada.");
    }
}
