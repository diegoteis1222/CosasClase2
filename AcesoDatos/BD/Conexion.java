
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.*;

public class Conexion {

    private JTextField port;
    private JTextField user;
    private JTextField server;
    private JPasswordField password;
    private JPanel panel1;
    private JButton connectButton;

    // --- CAMBIO 1: Nombre correcto de la BD ---
    private final String DB_NAME_FIJA = "northwind";

    public Conexion() {
        panel1 = new JPanel();
        panel1.setPreferredSize(new Dimension(400, 250));
        panel1.setLayout(new GridLayout(6, 2, 5, 5));

        // Valores por defecto
        server = new JTextField("localhost");
        port = new JTextField("3306");
        user = new JTextField("root");
        password = new JPasswordField();
        connectButton = new JButton("Connect");

        panel1.add(new JLabel("Server:"));
        panel1.add(server);
        panel1.add(new JLabel("Port:"));
        panel1.add(port);
        panel1.add(new JLabel("User:"));
        panel1.add(user);
        panel1.add(new JLabel("Password:"));
        panel1.add(password);
        panel1.add(new JLabel(""));
        panel1.add(connectButton);

        connectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                conectar();
            }
        });
    }

    private void conectar() {
        String host = server.getText().trim();
        String puertoStr = port.getText().trim();
        String usuario = user.getText().trim();
        String pass = new String(password.getPassword());

        //Validaciones
        if (host.isEmpty() || puertoStr.isEmpty() || usuario.isEmpty()) {
            JOptionPane.showMessageDialog(panel1, "Todos los campos (Server, Port, User) son obligatorios.", "Error de Validación", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int puertoNum;
        try {
            puertoNum = Integer.parseInt(puertoStr);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(panel1, "El puerto debe ser un número.", "Error de Validación", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String url = "jdbc:mysql://" + host + ":" + puertoNum + "/" + DB_NAME_FIJA + "?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";

        try {
            Connection conn = DriverManager.getConnection(url, usuario, pass);

            if (conn != null) {
                JOptionPane.showMessageDialog(panel1, "¡Conexión establecida con éxito!", "Estado Conexión", JOptionPane.INFORMATION_MESSAGE);

                GestionProductos frameProductos = new GestionProductos(conn);
                frameProductos.setVisible(true);

                SwingUtilities.getWindowAncestor(panel1).dispose();
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(panel1,
                    "No se pudo conectar a la BD: " + ex.getMessage(),
                    "Error de Conexión",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Acceso a Datos - Login");
        frame.setContentPane(new Conexion().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
