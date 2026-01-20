
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import java.util.*;
import javax.swing.*;

public class ClienteBD extends JFrame implements ActionListener, Runnable {

    private static final long serialVersionUID = 1L;
    static JTextField depconsultar = new JTextField(2);
    static JLabel etiqueta = new JLabel("Departamento a consultar:");
    private JScrollPane scrollpanel;
    static JTextArea textareal;
    JButton boton = new JButton("Enviar");
    JButton desconectar = new JButton("Salir");
    boolean repetir = true;
    static Socket socket;

    //streams
    ObjectInputStream inObjeto;
    DataOutputStream salida;

    // constructor
    public ClienteBD(Socket s) {
        super("OPERACIONES CON BD");
        socket = s;
        try {
            // flujo de salida - para enviar cadena
            salida = new DataOutputStream(socket.getOutputStream());
            // flujo de entrada - para recibir objeto
            inObjeto = new ObjectInputStream(socket.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(0);
        }

        setLayout(null);
        etiqueta.setBounds(10, 10, 200, 30);
        add(etiqueta);
        depconsultar.setBounds(210, 10, 50, 30);
        add(depconsultar);

        textareal = new JTextArea();
        scrollpanel = new JScrollPane(textareal);
        scrollpanel.setBounds(10, 50, 400, 300);
        add(scrollpanel);
        boton.setBounds(420, 10, 100, 30);
        add(boton);
        desconectar.setBounds(420, 50, 100, 30);
        add(desconectar);

        textareal.setEditable(false);
        boton.addActionListener(this);
        desconectar.addActionListener(this);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    } // constructor

    // Cuando se pulsa el botón Enviar se envía el departamento tecleado por el stream de salida al
    // hilo servidor:
    // acción cuando pulsamos botones
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == boton) { // ENVIAR DEP
            try {
                salida.writeUTF(depconsultar.getText());
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }//if

        // Cuando se pulsa el botón Salir se cierra el socket y finaliza la ejecución del cliente
        if (e.getSource() == desconectar) { // SALIR
            try {
                socket.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            System.exit(0);
        }//if
    } // actionPerformed

    // En el método run() se realiza un proceso repetitivo donde el cliente recibe del hilo el objeto
    // Departamentos con los datos del departamento solicitado. Si es null se visualiza un mensaje
    // indicando que no existe el departamento, véase Figura 3.22, si no lo es se visualizarán los datos.
    // Primero se pintan los datos del departamento (número, nombre y localidad) y después se llama al
    // método PintarEmpleados() para visualizar los datos de los empleados del departamento:
    // proceso repetitivo
    public void run() {
        String texto = "";
        while (repetir) {
            try {
                Departamento d = null;
                d = (Departamento) inObjeto.readObject(); //recibo un objeto
                textareal.setText("");
                textareal.setForeground(Color.blue);
                if (d == null) {
                    textareal.setForeground(Color.red);
                    PintaMensaje("     <<EL DEPARTAMENTO NO EXISTE>>");
                } else {
                    //datos del departamento
                    texto = "Número Dep: " + d.getDeptNo() + "\n"
                            + " Nombre: " + d.getDnombre() + "\tLocalidad: "
                            + d.getLoc();
                    textareal.append(texto);
                    PintarEmpleados(d); // visualizar empleados
                }//else
            } catch (SocketException s) {
                repetir = false; //se produce al cerrar socket en botón salir
            } catch (IOException e) {
                e.printStackTrace();
                repetir = false;
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                repetir = false;
            }
        }
        //fin while
        try {
            socket.close(); // CERRAR SOCKET
            System.exit(0);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    // PINTA LOS EMPLEADOS EN EL AREA

    private void PintarEmpleados(Departamento d) {
        Set<Empleados> listaemple = d.getEmpleados(); // obtenemos empleados

        textareal.setForeground(Color.blue);
        if (listaemple == null) {
            PintaMensaje("EL DEPARTAMENTO NO TIENE EMPLEADOS");
        } else {
            PintaMensaje("EMPLEADOS DEL DEPARTAMENTO: "
                    + listaemple.size());
            Iterator<Empleados> it = listaemple.iterator();
            while (it.hasNext()) {
                Empleados emple = new Empleados();
                emple = it.next();
                textareal.append("\n" + emple.getEmpNo() + " * "
                        + emple.getApellido() + " * " + emple.getOficio()
                        + " * " + emple.getSalario());
            } //while
            textareal.append("\n=========================================");
        } //else
    } //PintarEmpleados

    // El método PintaMensaje() visualiza en el textarea el mensaje que recibe:
    // PINTA CABECERAS
    void PintaMensaje(String mensaje) {
        textareal.append("\n=========================================");
        textareal.append("\n" + mensaje);
        textareal.append("\n=========================================");
    } //PintaMensaje

    // Por último desde el método main() se realiza la conexión al servidor, se prepara la pantalla y
    // se lanza el hilo cliente:
    // MAIN
    public static void main(String args[]) throws UnknownHostException,
            IOException {
        int puerto = 44441;
        Socket s = new Socket("localhost", puerto); //máquina local
        ClienteBD hiloC = new ClienteBD(s);
        hiloC.setBounds(0, 0, 540, 400);
        hiloC.setVisible(true);
        new Thread(hiloC).start();
    } // fin main
} // Fin del CLIENTE

