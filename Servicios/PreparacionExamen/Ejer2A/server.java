
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class server {

    private static final int primitiva1 = 6;
    private static final int primitiva2 = 7;
    private static final int primitiva3 = 8;
    private static final int primitiva4 = 9;
    private static final int primitiva5 = 10;
    private static final int primitiva6 = 11;

    public static void main(String[] args) throws IOException {

        int port = 11234;
        DatagramSocket socket = new DatagramSocket(port);

        byte[] recibir = new byte[1024];
        byte[] enviar;
        boolean cortar = false;

        System.out.println("Arrancado el server ...");

        while (!cortar) {

            DatagramPacket recibirDatos = new DatagramPacket(recibir, recibir.length);
            socket.receive(recibirDatos);

            String frase = new String(recibirDatos.getData(), 0, recibirDatos.getLength()).trim();
            System.out.println("recibido: " + frase);

            if (!frase.equals("0")) {

                String devolver = comprobadorPrimitiva(frase);
                devolver += ganadorPrimitiva(devolver);

                enviar = devolver.getBytes();
                DatagramPacket enviarDatos = new DatagramPacket(enviar, enviar.length, recibirDatos.getAddress(), recibirDatos.getPort());

                socket.send(enviarDatos);
            } else {
                cortar = true;
                System.out.println("Cerrando...");
            }

        }

    }

    private static String comprobadorPrimitiva(String frase) {

        String[] numeros = frase.split(",");

        StringBuilder devolver = new StringBuilder("");

        for (String numero : numeros) {
            int num = Integer.parseInt(numero.trim());

            // que asco da esto
            if (num == primitiva1 || num == primitiva2 || num == primitiva3 || num == primitiva4 || num == primitiva5 || num == primitiva6) {
                devolver.append(num).append(" ");
            }
        }
        return devolver.toString();
    }

    private static String ganadorPrimitiva(String devolver) {

        devolver = devolver.trim();

        int cantidadAciertos = devolver.split(" ").length;

        String resultado = " ";

        if (cantidadAciertos == 6) {
            resultado += "Acertaste todos los numeros";
        } else if (cantidadAciertos >= 5) {
            resultado += "Acertaste 5 numeros";
        } else if (cantidadAciertos >= 4) {
            resultado += "Acertaste 4 numeros";
        } else if (cantidadAciertos >= 3) {
            resultado += "Acertaste 3 numeros";
        } else {
            resultado += "No acertaste 3 numeros.";
        }

        return resultado;
    }

}
