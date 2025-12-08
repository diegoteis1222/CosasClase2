import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class server {

    public static void main(String[] args) {
        int puerto = 6600;

        try (ServerSocket servidor = new ServerSocket(puerto)) {
            System.out.println("Servidor iniciado. Esperando conexión...");

            Socket socket = servidor.accept();
            System.out.println("Cliente conectado desde: " + socket.getInetAddress());

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            boolean continuar = true;

            while (continuar) {
                try {
                    String mensaje = in.readUTF();

                    if (mensaje.equalsIgnoreCase("quit")) {
                        continuar = false;
                        System.out.println("Cliente solicitó desconexión.");
                    } else {
                        boolean sonAmigos = comprobarAmigos(mensaje);

                        if (sonAmigos) {
                            out.writeUTF("SI son numeros amigos.");
                        } else {
                            out.writeUTF("NO son numeros amigos.");
                        }
                    }
                } catch (IOException ex) {
                    System.out.println("Conexión perdida con el cliente.");
                    continuar = false;
                }
            }

            in.close();
            out.close();
            socket.close();
            System.out.println("Servidor cerrado.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean comprobarAmigos(String numeros) {
        try {
            String[] nums = numeros.split(",");
            if (nums.length != 2) return false;

            int num1 = Integer.parseInt(nums[0].trim());
            int num2 = Integer.parseInt(nums[1].trim());

            if (sumaDivisores(num1) == num2 && sumaDivisores(num2) == num1) {
                return true;
            }

        } catch (NumberFormatException e) {
            return false;
        }
        return false;
    }

    private static int sumaDivisores(int n) {
        int suma = 0;
        for (int i = 1; i <= n / 2; i++) {
            if (n % i == 0) {
                suma += i;
            }
        }
        return suma;
    }
}