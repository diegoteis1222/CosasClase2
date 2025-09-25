import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClienteChat {
    
    public static void main(String[] args) throws IOException {
        String host = "localhost";
        int puerto = 6000;

        try {
            Socket cliente = new Socket(host, puerto);
            
            System.out.println("Datos del cliente:");
            System.out.println("Puerto remoto: " + cliente.getPort());
            System.out.println("Host remoto: " + cliente.getInetAddress().getHostName());
            System.out.println("Dirección IP remota: " + cliente.getInetAddress().getHostAddress());

            DataOutputStream out = new DataOutputStream(cliente.getOutputStream());
            out.writeUTF("Quien quisiera tener la dicha que tiene el galloooooo");
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
}
