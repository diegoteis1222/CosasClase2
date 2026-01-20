
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class server {

    public static void main(String[] args) throws Exception {

        int puerto = 6600;

        ServerSocket servidor = new ServerSocket(puerto);

        Socket socket = servidor.accept();
        System.out.println("Cliente conectado.");

        DataInputStream in = new DataInputStream(socket.getInputStream());
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());

        boolean continuar = true;

        while (continuar) {

            String numeros = in.readUTF();
            System.out.println("Numeros recibidos: " + numeros);

            if (numeros.equals("quit")) {
                continuar = false;
                in.close();
                out.close();
                socket.close();
                servidor.close();
                System.out.println("Conexión cerrada.");
            } else {
                if (numerosAmigos(numeros)) {
                    out.writeUTF("Son numeros amigos");
                } else {
                    out.writeUTF("No son numeros amigos");
                }

            }

        }

    }

    public static boolean numerosAmigos(String numeros) {

        String[] nums = numeros.split(",");
        int num1 = Integer.parseInt(nums[0].trim());
        int num2 = Integer.parseInt(nums[1].trim());

        if (!primo(num1) || !primo(num2)) {
            return false;
        }

        if (num1 + 2 != num2) {
            return false;
        }

        return true;
    }

    public static boolean primo(int n) {

        // Variables
        boolean primo = true;
        int i = 2;

        while (i < n && primo) {

            if (n % i == 0) {
                primo = false;
            }
            i++;
        }
        return primo;
    }
}
