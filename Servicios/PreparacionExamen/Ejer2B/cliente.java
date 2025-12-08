
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

            System.out.println("Para salir debes escribir quit en ambos\n");

            System.out.println("Numeros de Eurojackpot");
            System.out.println("Dame 5 numeros separados por comas entre 1 y 50 o escribe quit para salir");
            System.out.print("Ejemplo: 12, 12, 12, 12, 12 \n");
            String fraseNumeros = sc.nextLine();

            fraseNumeros = filtroNumeros(fraseNumeros);

            System.out.println("Soles de Eurojackpot");
            System.out.println("Dame 2 numeros separados por comas entre 1 y 12 o escribe quit para salir");
            System.out.print("Ejemplo: 5, 7 \n");
            String fraseSoles = sc.nextLine();

            fraseSoles = filtroSoles(fraseSoles);

            String mensaje = fraseNumeros + ";" + fraseSoles;

            // cutre pero funciona
            if (mensaje.equals("quit;quit")) {

                byte[] enviar = mensaje.getBytes();

                DatagramPacket enviarDatos = new DatagramPacket(enviar, enviar.length, addresss, port);

                socket.send(enviarDatos);
                corte = true;
                break; //no me queda otra
            }

            byte[] enviar = mensaje.getBytes();

            DatagramPacket enviarDatos = new DatagramPacket(enviar, enviar.length, addresss, port);

            socket.send(enviarDatos);

            byte[] recibir = new byte[1024];
            DatagramPacket recibirDatos = new DatagramPacket(recibir, recibir.length);

            socket.receive(recibirDatos);
            String respuesta = new String(recibirDatos.getData(), 0, recibirDatos.getLength()).trim();
            System.out.println("recibido: " + respuesta);

        } // fin while

    }

    private static String filtroNumeros(String frase) {
        if (frase.equals("quit")) {
            return "quit";
        }

        String[] numeros = frase.split(",");

        if (numeros.length != 5) {
            return "No son 5 numeros";
        }

        int min = 1;
        int max = 50;

        for (String numero : numeros) {
            int num = Integer.parseInt(numero.trim());

            if (num < min || num > max) {
                return "Los numeros deben estar entre " + min + " y " + max;
            }

        }
        return frase;
    }

    private static String filtroSoles(String frase) {
        if (frase.equals("quit")) {
            return "quit";
        }

        String[] numeros = frase.split(",");

        if (numeros.length != 2) {
            return "No son 2 numeros";
        }

        int min = 1;
        int max = 12;

        for (String numero : numeros) {
            int num = Integer.parseInt(numero.trim());

            if (num < min || num > max) {
                return "Los numeros deben estar entre " + min + " y " + max;
            }

        }
        return frase;
    }

}
