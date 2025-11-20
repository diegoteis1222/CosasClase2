
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import javax.swing.*;

public class ClientChatSwing extends JFrame {

    private JTextField textField;
    private JTextArea textArea;
    private Socket socket;
    private PrintWriter out;
    private BufferedReader in;
    private String nombre;

    public ClientChatSwing() {
        super("Cliente Chat");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Pedir nombre al usuario
        nombre = JOptionPane.showInputDialog(this, "Introduce tu nombre:");
        if (nombre == null || nombre.trim().isEmpty()) {
            nombre = "Anónimo";
        }
        setTitle("Cliente Chat - " + nombre);

        textArea = new JTextArea();
        textArea.setEditable(false);
        add(new JScrollPane(textArea), BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel(new BorderLayout());
        textField = new JTextField();
        JButton btnEnviar = new JButton("Enviar");

        bottomPanel.add(textField, BorderLayout.CENTER);
        bottomPanel.add(btnEnviar, BorderLayout.EAST);
        add(bottomPanel, BorderLayout.SOUTH);

        // Acciones
        ActionListener sendAction = e -> sendMessage();
        textField.addActionListener(sendAction);
        btnEnviar.addActionListener(sendAction);

        setVisible(true);

        connectToServer();
    }

    private void connectToServer() {
        try {
            socket = new Socket("localhost", 4444);
            out = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // Hilo para recibir mensajes
            new Thread(() -> {
                try {
                    String fromServer;
                    while ((fromServer = in.readLine()) != null) {
                        String finalMsg = fromServer;
                        SwingUtilities.invokeLater(() -> textArea.append(finalMsg + "\n"));
                    }
                } catch (IOException e) {
                    SwingUtilities.invokeLater(() -> textArea.append(nombre + "se ha desconectado del servidor.\n"));
                }
            }).start();

            out.println(nombre + " se ha unido al chat.");

        } catch (IOException e) {
            textArea.append("No se pudo conectar al servidor.\n");
        }
    }

    private void sendMessage() {
        String msg = textField.getText();
        if (msg != null && !msg.trim().isEmpty()) {
            if (out != null) {
                if (msg.trim().equalsIgnoreCase("quit")) {
                    out.println("quit");
                    System.exit(0);
                } else {
                    out.println(nombre + ": " + msg);
                }
                textField.setText("");
            }
        }

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ClientChatSwing::new);
    }
}
