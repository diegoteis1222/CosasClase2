
import java.awt.*;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import javax.swing.*;

public class ServerChatSwing extends JFrame {

    private JTextArea textArea;
    private JLabel lblActuales;
    private JLabel lblMaximas;
    private int actuales = 0;
    private final int MAXIMO = 10;
    private ServerSocket serverSocket;
    private ArrayList<HiloServidorChatSwing> clientes = new ArrayList<>();
    private boolean running = true;

    public ServerChatSwing() {
        super("Servidor Chat");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Panel superior para contadores
        JPanel topPanel = new JPanel(new FlowLayout());
        lblActuales = new JLabel("Conexiones actuales: 0");
        lblMaximas = new JLabel("Conexiones máximas: " + MAXIMO);
        // Añadir un poco de espacio entre etiquetas
        lblActuales.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 20));

        topPanel.add(lblActuales);
        topPanel.add(lblMaximas);
        add(topPanel, BorderLayout.NORTH);

        // Área de texto central
        textArea = new JTextArea();
        textArea.setEditable(false);
        add(new JScrollPane(textArea), BorderLayout.CENTER);

        // Botón salir
        JButton btnSalir = new JButton("Salir");
        btnSalir.addActionListener(e -> stopServer());
        add(btnSalir, BorderLayout.SOUTH);

        setVisible(true);

        // Iniciar hilo del servidor
        new Thread(this::startServer).start();
    }

    private void startServer() {
        try {
            serverSocket = new ServerSocket(4444);
            log("Servidor iniciado en puerto 4444");

            while (running) {
                Socket socket = serverSocket.accept();

                if (actuales < MAXIMO) {
                    log("Cliente conectado: " + socket.getInetAddress());
                    HiloServidorChatSwing hilo = new HiloServidorChatSwing(socket, this);
                    clientes.add(hilo);
                    hilo.start();
                    updateCounters(1);
                } else {
                    log("LLegaste al maximo makina.");
                    socket.close();
                }
            }
        } catch (IOException e) {
            if (running) {
                log("Error en el servidor: " + e.getMessage());
            }
        }
    }

    public synchronized void broadcast(String msg) {
        log(msg);
        for (HiloServidorChatSwing client : clientes) {
            client.enviar(msg);
        }
    }

    public synchronized void removeClient(HiloServidorChatSwing client) {
        if (clientes.remove(client)) {
            updateCounters(-1);
            log("Cliente desconectado.");
        }
    }

    private void updateCounters(int n) {
        actuales += n;
        SwingUtilities.invokeLater(() -> lblActuales.setText("Conexiones actuales: " + actuales));
    }

    private void log(String msg) {
        SwingUtilities.invokeLater(() -> textArea.append(msg + "\n"));
    }

    private void stopServer() {
        running = false;
        try {
            if (serverSocket != null) {
                serverSocket.close();
            }
            for (HiloServidorChatSwing client : clientes) {
                client.closeConnection();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.exit(0);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ServerChatSwing::new);
    }
}
