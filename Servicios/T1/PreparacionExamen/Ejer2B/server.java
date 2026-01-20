import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class server {

    private static final int[] eurojackpot = {6, 7, 8, 9, 10};
    private static final int[] soles = {1, 2};

    public static void main(String[] args) throws IOException {

        int port = 11234;
        DatagramSocket socket = new DatagramSocket(port);

        byte[] recibir = new byte[1024];
        boolean cortar = false;

        System.out.println("Arrancado el server ...");

        while (!cortar) {
            recibir = new byte[1024]; // Limpiar buffer
            DatagramPacket recibirDatos = new DatagramPacket(recibir, recibir.length);
            socket.receive(recibirDatos);

            String frase = new String(recibirDatos.getData(), 0, recibirDatos.getLength()).trim();
            System.out.println("recibido: " + frase);

            if (!frase.equals("quit;quit")) {

                String[] partes = frase.split(";");
                
                // Obtenemos la parte de números y la parte de soles
                String numsUser = partes[0];
                String solesUser = "";
                
                // Verificamos si llegaron soles para evitar error de indice
                if (partes.length > 1) {
                    solesUser = partes[1];
                }

                // Llamamos a los métodos pasando el String, no el Array
                String aciertosNumeros = comprobadorNumeros(numsUser);
                String aciertosSoles = comprobadorSoles(solesUser);

                // Pasamos los dos resultados al método ganador
                String devolver = ganadorEurojackpot(aciertosNumeros, aciertosSoles);

                byte[] enviar = devolver.getBytes();
                DatagramPacket enviarDatos = new DatagramPacket(enviar, enviar.length, recibirDatos.getAddress(), recibirDatos.getPort());

                socket.send(enviarDatos);
            } else {
                cortar = true;
                System.out.println("Cerrando...");
            }
        }
        socket.close();
    }

    private static String comprobadorNumeros(String frase) {
        String[] numeros = frase.split(",");
        StringBuilder devolver = new StringBuilder("");

        for (String numero : numeros) {
            for (int i = 0; i < eurojackpot.length; i++) {
                try {
                    int num = Integer.parseInt(numero.trim());
                    if (num == eurojackpot[i]) {
                        devolver.append(num).append(" ");
                    }
                } catch (NumberFormatException e) {
                }
            }
        }
        return devolver.toString();
    }

    private static String comprobadorSoles(String frase) {
        String[] misSoles = frase.split(",");
        StringBuilder devolver = new StringBuilder("");

        for (String sol : misSoles) {
            for (int i = 0; i < soles.length; i++) {
                try {
                    int num = Integer.parseInt(sol.trim());
                    if (num == soles[i]) {
                        devolver.append(num).append(" ");
                    }
                } catch (NumberFormatException e) {
                }
            }
        }
        return devolver.toString();
    }

    private static String ganadorEurojackpot(String aciertosNumeros, String aciertosSoles) {

        aciertosNumeros = aciertosNumeros.trim();
        aciertosSoles = aciertosSoles.trim();

        int cantidadNumeros = 0;
        if (!aciertosNumeros.isEmpty()) {
            cantidadNumeros = aciertosNumeros.split(" ").length;
        }

        int cantidadSoles = 0;
        if (!aciertosSoles.isEmpty()) {
            cantidadSoles = aciertosSoles.split(" ").length;
        }

        String resultado = "Has tenido " + cantidadNumeros + " numeros acertados y " + cantidadSoles + " soles acertados ";



        return resultado;
    }
}