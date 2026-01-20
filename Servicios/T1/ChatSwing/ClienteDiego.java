
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ClienteDiego extends JFrame implements ActionListener {

    private static final long serialVersionUID = 1L;
    Socket socket = null;

    // streams
    DataInputStream fentrada; // para leer mensajes de todos
    DataOutputStream fsalida; // para escribir sus mensajes

    String nombre;
    static JTextField mensaje = new JTextField();
    private JScrollPane scrollpanel;
    static JTextArea textarea1;
    JButton boton = new JButton("Enviar");
    JButton desconectar = new JButton("Salir");
    boolean repetir = true;

    // En el constructor se prepara la pantalla. Se recibe el socket creado y el nombre del cliente de chat:
    // constructor
    public ClienteDiego(Socket s, String nombre) {
        super(" CONEXIÓN DEL CLIENTE CHAT: " + nombre);
        setLayout(null);

        mensaje.setBounds(10, 10, 400, 30);
        add(mensaje);

        textarea1 = new JTextArea();
        scrollpanel = new JScrollPane(textarea1);
        scrollpanel.setBounds(10, 50, 400, 300);
        add(scrollpanel);

        boton.setBounds(420, 10, 100, 30);
        add(boton);

        desconectar.setBounds(420, 50, 100, 30);
        add(desconectar);

        textarea1.setEditable(false);
        boton.addActionListener(this);
        desconectar.addActionListener(this);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        socket = s;
        this.nombre = nombre;

        try {
            fentrada = new DataInputStream(socket.getInputStream());
            fsalida = new DataOutputStream(socket.getOutputStream());
            String texto = " > Entra en el Chat ... " + nombre;
            fsalida.writeUTF(texto); // escribe mensaje de entrada
        } catch (IOException e) {
            System.out.println("ERROR DE E/S");
            e.printStackTrace();
            System.exit(0);
        }
    } // fin constructor

    // acción cuando pulsamos botones
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == boton) { // SE PULSA botón ENVIAR
            String texto = nombre + "> " + mensaje.getText();
            try {
                mensaje.setText(""); // limpio area de mensaje
                fsalida.writeUTF(texto);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }

        // Si se pulsa el botón Salir se envia primero un mensaje indicando que el usuario abandona el chat
        // y a continuación un asterisco indicando que el usuario va a salir del chat
        if (e.getSource() == desconectar) { // SE PULSA botón SALIR
            String texto = " > Abandona el Chat ... " + nombre;
            try {
                fsalida.writeUTF(texto);
                fsalida.writeUTF("*");
                repetir = false; // para salir del bucle
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }

    // Método ejecutar
    public void ejecutar() {
        String texto = "";
        while (repetir) {
            try {
                texto = fentrada.readUTF(); // leer mensajes
                textarea1.setText(texto);   // visualizarlos
            } catch (IOException e) {
                // este error sale cuando el servidor se cierra
                JOptionPane.showMessageDialog(
                        null, "IMPOSIBLE CONECTAR CON EL SERVIDOR\n" + e.getMessage(),
                        "<<MENSAJE DE ERROR:2>>", JOptionPane.ERROR_MESSAGE);
                repetir = false; // salir del bucle
            }
        } // while

        try {
            socket.close(); // cerrar socket
            System.exit(0);
        } catch (IOException e) {
            e.printStackTrace();
        }
    } // ejecutar

    // En la función main() se pide el nombre de usuario, se realiza la conexión al servidor,
    // se crea un objeto ClientThread, se muestra la pantalla y se ejecuta el método ejecutar():
    public static void main(String args[]) {
        int puerto = 9000;
        String nombre = JOptionPane.showInputDialog("Introduce tu nombre o nick:");
        Socket s = null;

        try {
            // server es de otra maquina
            //
            // Si quisieras conectarte a otra IP, cambia "localhost" por la IP, ej: "192.168.0.194"
            s = new Socket("10.101.3.36", puerto);

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,
                    "IMPOSIBLE CONECTAR CON EL SERVIDOR\n" + e.getMessage(),
                    "<<MENSAJE DE ERROR:1>>", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }

        if (!nombre.trim().equals("")) { // hay que escribir algo
            ClienteDiego cliente = new ClienteDiego(s, nombre);
            cliente.setBounds(0, 0, 540, 400);
            cliente.setVisible(true);
            cliente.ejecutar();
        } else {
            System.out.println("El nombre está vacío....");
        }
    } // main

} // Fin ClientThread
