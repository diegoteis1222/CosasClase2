
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class cliente {

    public static void main(String[] args) throws IOException {

        int port = 11234;
        String server = "localhost";

        InetAddress addresss = InetAddress.getByName(server);

        DatagramSocket socket = new DatagramSocket();
        boolean corte = false;

        Scanner sc = new Scanner(System.in);

        while (!corte) {

            System.out.println("Dame 6 numeros separados por comas o escribe 0 para salir");
            System.out.print("Ejemplo: 12, 12, 12, 12, 12, 12 \n");
            String frase = sc.nextLine();

            frase = filtro6Numeros(frase);

            byte[] enviar = frase.getBytes();
            DatagramPacket enviarDatos = new DatagramPacket(enviar, enviar.length, addresss, port);

            socket.send(enviarDatos);

            if (!frase.equals("0")) {

                byte[] recibir = new byte[1024];
                DatagramPacket recibirDatos = new DatagramPacket(recibir, recibir.length);

                socket.receive(recibirDatos);
                String mensaje = new String(recibirDatos.getData(), 0, recibirDatos.getLength());
                System.out.println("recibido: " + mensaje);

            } else {
                System.out.println("cerrando server...");
                corte = !corte;
            }

        } // fin while

    }

    private static String filtro6Numeros(String frase) {
        if (frase.equals("0")) {
            return "0";
        }

        String[] numeros = frase.split(",");

        if (numeros.length != 6) {
            return "No son 6 numeros";
        }

        int min = 1;
        int max = 49;

        for (String numero : numeros) {
            int num = Integer.parseInt(numero.trim());

            if (num < min || num > max) {
                return "Los numeros deben estar entre " + min + " y " + max;
            }

        }
        return frase;
    }

}
