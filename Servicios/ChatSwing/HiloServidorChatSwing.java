
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class HiloServidorChatSwing extends Thread {
    private Socket socket;
    private ServerChatSwing server;
    private PrintWriter out;
    private BufferedReader in;

    public HiloServidorChatSwing(Socket socket, ServerChatSwing server) {
        this.socket = socket;
        this.server = server;
    }

    @Override
    public void run() {
        try {
            out = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                // Si el cliente envía "quit", terminamos
                if (inputLine.trim().equalsIgnoreCase("quit")) {
                    break;
                }
                server.broadcast(inputLine);
            }
        } catch (IOException e) {
            // Error al leer o conexión cerrada abruptamente
        } finally {
            closeConnection();
            server.removeClient(this);
        }
    }

    public void enviar(String msg) {
        if (out != null) {
            out.println(msg);
        }
    }

    public void closeConnection() {
        try {
            if (socket != null && !socket.isClosed()) {
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
