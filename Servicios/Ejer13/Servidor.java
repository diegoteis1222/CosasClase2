
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener; // Importación necesaria
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

// Asegúrate de tener la clase Conexion en el mismo paquete
// Asegúrate de tener la clase HiloServidor en el mismo paquete
public class Servidor extends JFrame {

    private static final long serialVersionUID = 1L;
    static Integer PUERTO = 44441;
    public static Integer conexiones = 0;
    static ServerSocket servidor;
    static java.util.Date hora;

    // campos de la pantalla
    static public JTextField numconex = new JTextField();
    static JLabel numconexLabel = new JLabel();
    static JTextField puerto = new JTextField();
    static JLabel puertoLabel = new JLabel();
    static public JTextArea area = new JTextArea();
    static JScrollPane scroll = new JScrollPane(area);

    // Constructor
    public Servidor() {
        super("SERVIDOR - CONTROL DE CONEXIONES A BD");
        Container c = getContentPane();

        // Configuración de componentes
        numconexLabel.setText("Nºde conexiones actuales:");
        puertoLabel.setText("Número de puerto:");
        numconexLabel.setBounds(new Rectangle(10, 10, 160, 25));
        numconex.setBounds(new Rectangle(175, 10, 45, 25));
        puertoLabel.setBounds(new Rectangle(235, 10, 200, 25));
        puerto.setBounds(new Rectangle(350, 10, 50, 25));

        area.setBounds(new Rectangle(10, 60, 390, 200));
        scroll.setBounds(new Rectangle(10, 60, 400, 200));
        area.setEditable(false);

        // Añadir al contenedor
        c.add(scroll, null);
        c.add(numconexLabel);
        c.add(numconex);
        numconex.setEditable(false);
        c.add(puertoLabel);
        c.add(puerto);
        puerto.setEditable(false);

        c.setLayout(null);
        area.setForeground(Color.blue);
        area.setText("");
        setSize(450, 300);      //COLOCACIÓN DE LA PANTALLA

        // Centrar pantalla
        Dimension dim = getToolkit().getScreenSize();
        setLocation(dim.width / 2 - getWidth() / 2 + 200,
                (dim.height / 2 - getHeight() / 2) + 200);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // --- CORRECCIÓN: El addWindowListener debe estar DENTRO del constructor ---
        addWindowListener(new WindowListener() {
            public void windowClosing(WindowEvent we) {
                try { // CERRAMOS EL SERVERSOCKET
                    if (servidor != null && !servidor.isClosed()) {
                        servidor.close();
                    }
                    System.out.println("Servidor cerrado .....");
                    // Asegúrate de que la clase Conexion existe y es accesible
                    Conexion.getDBConexion().close();
                    System.exit(0);
                } catch (IOException e) {
                    System.err.println("NO SE PUEDE CERRAR servidor."
                            + e.getMessage());
                    System.exit(0);
                }
            }

            // Implementación vacía de los otros métodos de la interfaz
            public void windowOpened(WindowEvent we) {
            }

            public void windowClosed(WindowEvent we) {
            }

            public void windowIconified(WindowEvent we) {
            }

            public void windowDeiconified(WindowEvent we) {
            }

            public void windowActivated(WindowEvent we) {
            }

            public void windowDeactivated(WindowEvent we) {
            }
        });

    } //.. fin del constructor (AHORA SÍ ESTÁ EN SU SITIO)

    //MAIN
    public static void main(String[] args) throws IOException {
        int idCliente = 0; //cada cliente tendra un id
        servidor = new ServerSocket(PUERTO);
        System.out.println("Servidor Iniciado .....");

        Servidor pantalla = new Servidor();
        pantalla.setVisible(true);

        puerto.setText(PUERTO.toString());
        numconex.setText(conexiones.toString());

        while (true) {
            try {
                Socket cliente = servidor.accept(); //esperando al cliente
                hora = new java.util.Date(System.currentTimeMillis());
                conexiones++;
                idCliente++;
                numconex.setText(conexiones.toString());
                area.append("Conexion ==> " + idCliente);

                InetAddress direccion = cliente.getInetAddress();
                area.append(" Direccion IP " + direccion.toString()
                        + "\n\t Hora: " + hora + "\n");

                // IMPORTANTE: Necesitas la clase HiloServidor para que esto funcione
                HiloServidor hilo = new HiloServidor(cliente, idCliente);
                hilo.start();

            } catch (IOException e) {
                //ocurre cuando cerramos la ventana porque el servidor se cierra
                System.out.println(e.getMessage());
                System.exit(0);
            }
        } //while
    } //main
} //.. Servidor
