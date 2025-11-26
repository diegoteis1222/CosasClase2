import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.*;

public class Conexion {

    private static final String DB_NAME = "northwind";

    private JPanel mainPanel;
    private JTextField txtServer;
    private JTextField txtPort;
    private JTextField txtUser;
    private JPasswordField txtPassword;
    private JButton btnConnect;

    public Conexion() {

        mainPanel = new JPanel();
        mainPanel.setPreferredSize(new Dimension(350, 220));
        mainPanel.setLayout(new GridLayout(6, 2, 10, 10)); 
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); 

        txtServer = new JTextField("localhost");
        txtPort = new JTextField("3306");
        txtUser = new JTextField("root");
        txtPassword = new JPasswordField();
        btnConnect = new JButton("Conectar");

        // Adds
        mainPanel.add(new JLabel("Servidor:"));
        mainPanel.add(txtServer);

        mainPanel.add(new JLabel("Puerto:"));
        mainPanel.add(txtPort);

        mainPanel.add(new JLabel("Usuario:"));
        mainPanel.add(txtUser);

        mainPanel.add(new JLabel("Contraseña:"));
        mainPanel.add(txtPassword);

        mainPanel.add(new JLabel("")); 
        mainPanel.add(btnConnect);

        btnConnect.addActionListener(e -> conectarBD());
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    private void conectarBD() {
        String host = txtServer.getText().trim();
        String portStr = txtPort.getText().trim();
        String user = txtUser.getText().trim();
        String password = new String(txtPassword.getPassword());

        // Validaciones básicas
        if (host.isEmpty() || portStr.isEmpty() || user.isEmpty()) {
            mostrarMensaje("Debes rellenar todos los campos", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int portNum;
        try {
            portNum = Integer.parseInt(portStr);
        } catch (NumberFormatException ex) {
            mostrarMensaje("El puerto debe ser un numero.", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String url = String.format("jdbc:mysql://%s:%d/%s?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC",
                host, portNum, DB_NAME);

        try {
            Connection conn = DriverManager.getConnection(url, user, password);

            if (conn != null) {
                mostrarMensaje("¡Conexión establecida con éxito!", JOptionPane.INFORMATION_MESSAGE);

                GestionProductos frameProductos = new GestionProductos(conn);
                frameProductos.setVisible(true);

                SwingUtilities.getWindowAncestor(mainPanel).dispose();
            }

        } catch (SQLException ex) {
            mostrarMensaje("No se pudo conectar a la BD:\n" + ex.getMessage(), JOptionPane.ERROR_MESSAGE);
        }
    }

    private void mostrarMensaje(String mensaje, int tipoIcono) {
        JOptionPane.showMessageDialog(mainPanel, mensaje, "Estado de Conexión", tipoIcono);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Acceso a Datos - Login");
            frame.setContentPane(new Conexion().getMainPanel());
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack();
            frame.setLocationRelativeTo(null); // Centrar en pantalla
            frame.setVisible(true);
        });
    }
}