
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class server {

    private static final int[] primitiva = {6, 7, 8, 9, 10, 11};

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

            for (int i = 0; i < primitiva.length; i++) {

                int num = Integer.parseInt(numero.trim());

                if (num == primitiva[i]) {
                    devolver.append(num).append(" ");
                }
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
            resultado += "No acertaste almenos 3 numeros.";
        }

        return resultado;
    }

}
