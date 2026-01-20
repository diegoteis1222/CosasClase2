
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class ClienteMulsticast {

    public static void main(String[] args) throws Exception {

        int port = 12345;

        MulticastSocket ms = new MulticastSocket(port);

        InetAddress grupo = InetAddress.getByName("255.0.0.1");
        ms.joinGroup(grupo);

        String msg = "";

        while (!msg.trim().equalsIgnoreCase("salir")) {
            byte[] buf = new byte[1024];

            DatagramPacket paquete = new DatagramPacket(buf, buf.length, grupo, port);
            ms.receive(paquete);

            msg = new String(paquete.getData());

            System.out.println("Mensaje recivido");

        }

        ms.leaveGroup(grupo);
        ms.close();
        System.out.println("Cerrao..");
    }
}
