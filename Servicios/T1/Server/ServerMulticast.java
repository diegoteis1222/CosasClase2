
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class ServerMulticast {

    public static void main(String[] args) throws Exception {

        int port = 12345;

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        MulticastSocket ms = new MulticastSocket(port);

        InetAddress grupo = InetAddress.getByName("255.0.0.1");

        ms.joinGroup(grupo);

        String cadena = "";

        System.out.println("Server iniciado, escriba algo: ");

        while (!cadena.equalsIgnoreCase("salir")) {

            byte[] buf = cadena.getBytes();

            DatagramPacket paq = new DatagramPacket(buf, buf.length, grupo, port);

            ms.send(paq);
        }

        ms.leaveGroup(grupo);
        ms.close();
        System.out.println("Cerrao..");
    }

}
