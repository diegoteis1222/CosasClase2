package com.example;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Main extends JFrame implements ActionListener {

    private Container contenedor;
    private JTextField servidorField, puertoField, usuarioField;
    private JPasswordField contrasenaField;
    private JLabel servidorLabel, puertoLabel, usuarioLabel, contrasenaLabel;
    private JButton conectar;

    public Main() {
        setTitle("Conexion");
        setSize(400, 360);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        inicio();
    }

    public void inicio() {
        contenedor = getContentPane();
        contenedor.setLayout(null);

        servidorLabel = new JLabel("Servidor:");
        servidorLabel.setBounds(40, 30, 100, 25);
        contenedor.add(servidorLabel);

        servidorField = new JTextField();
        servidorField.setBounds(140, 30, 200, 25);
        contenedor.add(servidorField);

        puertoLabel = new JLabel("Puerto:");
        puertoLabel.setBounds(40, 75, 100, 25);
        contenedor.add(puertoLabel);

        puertoField = new JTextField();
        puertoField.setBounds(140, 75, 200, 25);
        contenedor.add(puertoField);

        usuarioLabel = new JLabel("Usuario:");
        usuarioLabel.setBounds(40, 120, 100, 25);
        contenedor.add(usuarioLabel);

        usuarioField = new JTextField();
        usuarioField.setBounds(140, 120, 200, 25);
        contenedor.add(usuarioField);

        contrasenaLabel = new JLabel("Contraseña:");
        contrasenaLabel.setBounds(40, 165, 100, 25);
        contenedor.add(contrasenaLabel);

        contrasenaField = new JPasswordField();
        contrasenaField.setBounds(140, 165, 200, 25);
        contenedor.add(contrasenaField);

        conectar = new JButton("Conectar");
        conectar.setBounds(140, 215, 120, 30);
        conectar.addActionListener(this);
        contenedor.add(conectar);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == conectar) {
            String servidor = servidorField.getText().trim();
            String puertoStr = puertoField.getText().trim();
            String usuario = usuarioField.getText().trim();
            String contrasena = new String(contrasenaField.getPassword());
            String contrasenaUsada = contrasena.isEmpty() ? " " : contrasena;

            if (servidor.isEmpty() || puertoStr.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Pon el servidor y el puerto.", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            int puerto;

            try {
                puerto = Integer.parseInt(puertoStr);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Puerto sin piernas (inválido)", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            try (Socket socket = new Socket()) {
                socket.connect(new InetSocketAddress(servidor, puerto), 2000);
                try (OutputStream os = socket.getOutputStream()) {
                    os.write(contrasenaUsada.getBytes());
                    os.flush();
                }
                String mensaje = String.format("Conectado correctamente a %s:%d como %s.",
                        servidor, puerto, usuario.isEmpty() ? "<sin usuario>" : usuario,
                        contrasena.isEmpty() ? "espacio" : "no vacía");
                JOptionPane.showMessageDialog(this, mensaje, "Conexión exitosa",
                        JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException ioex) {
                String mensaje = String.format("No se pudo conectar a %s:%d\n%s",
                        servidor, puerto, ioex.getMessage());
                JOptionPane.showMessageDialog(this, mensaje, "Error de conexión",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            Main ventana = new Main();
            ventana.setVisible(true);
        });
    }
}
