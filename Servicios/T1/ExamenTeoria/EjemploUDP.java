
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class EjemploUDP {

    // FUNCIONAMIENTO UDP
    //El Servidor está esperando (socket.receive) en un puerto fijo (11234). No acepta una conexión, simplemente espera un paquete.
    //El Cliente crea un paquete y lo "lanza" a la dirección y puerto del servidor.
    //El Servidor procesa el dato y extrae del paquete recibido la dirección de retorno (getAddress(), getPort()) para responder.

    public static void server() throws IOException {

        int port = 11234;

        // el server espera en este puerto un paquete
        DatagramSocket socket = new DatagramSocket(port);

        byte[] recibir = new byte[1024];
        byte[] enviar;
        boolean cortar = false;

        System.out.println("Arrancado el server Falangista...");

        while (!cortar) {

            // para recibir datos necesitamos un paquete y su tamaño
            DatagramPacket recibirDatos = new DatagramPacket(recibir, recibir.length);
            // le decimos que reciba los datos
            socket.receive(recibirDatos);

            // crea una frase con los datos recibidos y lo muestra en pantalla
            //  getData(): Saca el array de bytes.
            // getLength(): Dice cuántos bytes llegaron 
            String frase = new String(recibirDatos.getData(), 0, recibirDatos.getLength()).trim();
            System.out.println("recibido: " + frase);

            if (!frase.equals("quit")) {

                // crea un String que devuelve si es narcisista o no
                String devolver = comprobarNarciso(frase);

                // convierte el String a bytes para enviarlo
                enviar = devolver.getBytes();

                // para enviar datos necesitamos un paquete con los datos, su tamaño, la dirección y el puerto
                DatagramPacket enviarDatos = new DatagramPacket(enviar, enviar.length, recibirDatos.getAddress(), recibirDatos.getPort());
                // getAddress(): Obtiene la dirección IP del remitente.
                // getPort(): Obtiene el puerto del remitente.

                // envia los datos
                socket.send(enviarDatos);
            } else {
                cortar = true;
                System.out.println("Cerrando...");
            }

        }
    }

    public static void cliente() throws IOException {

        int port = 11234;
        String server = "localhost";

        InetAddress addresss = InetAddress.getByName(server);

        // crear el socket
        DatagramSocket socket = new DatagramSocket();
        boolean corte = false;

        Scanner sc = new Scanner(System.in);

        while (!corte) {

            System.out.println("Dame un numero de 3 cifras: ");
            String frase = sc.nextLine();

            // revisa que no sea quit o que tenga 3 cifras
            frase = filtroFrase(frase);

            byte[] enviar = frase.getBytes();
            
            // se crea el paquete a enviar
            // para enviar datos necesitamos un paquete con los datos, su tamaño, la dirección y el puerto
            DatagramPacket enviarDatos = new DatagramPacket(enviar, enviar.length, addresss, port);

            // le decimos que envie los datos
            socket.send(enviarDatos);

            if (!frase.equals("quit")) {

                byte[] recibir = new byte[1024];

                // para recibir datos necesitamos un paquete y su tamaño
                DatagramPacket recibirDatos = new DatagramPacket(recibir, recibir.length);

                // le decimos que reciba los datos
                socket.receive(recibirDatos);

                // crea un String con los datos recibidos y lo muestra en pantalla
                String mensaje = new String(recibirDatos.getData(), 0, recibirDatos.getLength());
                //  getData(): Saca el array de bytes.
                // getLength(): Dice cuántos bytes llegaron

                System.out.println("recibido: " + mensaje);

            } else {
                System.out.println("cerrando server...");
                corte = !corte;
            }

        } // fin while

    }

    private static String comprobarNarciso(String frase) {
        int n = Integer.parseInt(frase);
        int temp = n;
        int suma = 0;

        int digitos = String.valueOf(n).length();

        while (temp > 0) {
            int digito = temp % 10;
            suma += Math.pow(digito, digitos);
            temp /= 10;
        }

        if (suma == n) {
            return "Es narcisista";
        } else {
            return "No es narcisista";
        }
    }

    private static String filtroFrase(String frase) {
        if (frase.equals("quit")) {
            return "quit";
        }

        Integer numero = Integer.parseInt(frase);

        if (numero >= 100 && numero <= 999) {
            return String.valueOf(numero);
        } else {
            return "no";
        }
    }
}
