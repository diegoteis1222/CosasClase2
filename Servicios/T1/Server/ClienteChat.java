import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ClienteChat {

    public static void main(String[] args) throws IOException {
        String host = "localhost";
        int puerto = 6000;

        Scanner scanner = new Scanner(System.in);

        Socket cliente = new Socket(host, puerto);

        System.out.println("Datos del cliente:");
        System.out.println("Puerto remoto: " + cliente.getPort());
        System.out.println("Host remoto: " + cliente.getInetAddress().getHostName());
        System.out.println("Dirección IP remota: " + cliente.getInetAddress().getHostAddress());

        boolean conexion = true;

        do {

            DataOutputStream out = new DataOutputStream(cliente.getOutputStream());
            System.out.print("Escribe un mensaje: ");
            String envio = scanner.nextLine();
            out.writeUTF(envio);

            String palabra = envio;
            boolean palin = palindromo(palabra);

            if (palin) {
                System.out.println(palabra + " es palindromo");
            } else {
                System.out.println(palabra + " no es palindromo");
            }

            DataInputStream in = new DataInputStream(cliente.getInputStream());
            String msg = in.readUTF();
            System.out.println("Mensaje recivido: " + msg.toUpperCase());
            System.out.println("--------------------------------------------------");

            if (envio.equalsIgnoreCase("quit")) {
                conexion = false;
            }

        } while (conexion);

    }

    public static void esPerfecto(int numero) {
        int suma = 0;
        for (int i = 1; i < numero; i++) {
            if (numero % i == 0) {
                suma += i;
            }
        }
        if (suma == numero) {
            System.out.println(numero + " es un número perfecto.");
        } else {
            System.out.println(numero + " no es un número perfecto.");
        }
    }

    public static boolean palindromo(String palabra) {

        if (palabra.isEmpty()) {
            return false;
        }

        palabra = palabra.toUpperCase().replaceAll("[,. ]", "");

        StringBuilder builder = new StringBuilder(palabra);

        String palabraInversa = builder.reverse().toString();

        return palabra.equals(palabraInversa);
    }
}
