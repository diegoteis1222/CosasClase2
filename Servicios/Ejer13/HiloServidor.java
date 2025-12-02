
import java.awt.*;
import java.io.*;
import java.net.*;
import javax.swing.*;

class HiloServidor extends Thread {

    Socket socket;
    int identificador;
    static JLabel texto = new JLabel();
    ObjectOutputStream outObjeto;
    DataInputStream entrada;

    //Constructor
    public HiloServidor(Socket s, int idCliente) throws IOException {
        socket = s;
        identificador = idCliente;
        entrada = new DataInputStream(socket.getInputStream());
        outObjeto = new ObjectOutputStream(socket.getOutputStream());
    }

    // En el método run() se lee del stream el departamento que el cliente desea consultar
    public void run() {
        try {
            AccesoDatos adat = new AccesoDatos();
            while (true) {
                String depar = entrada.readUTF(); //leer stream
                Departamento dep = adat.procesarCadena(depar.trim());
                // Se envia el objeto al cliente
                outObjeto.writeObject(dep);
            }
        } catch (IOException e) {
            // cuando un cliente Cierra la conexión
            Servidor.conexiones--;
            Servidor.numconex.setText(Servidor.conexiones.toString());
            texto.setText("<<LIBERADA LA CONEXION: "
                    + identificador + " >>\n");
            texto.setForeground(Color.red);
            Servidor.area.append(texto.getText());
            try {
                entrada.close();
                outObjeto.close();
                socket.close();
            } catch (IOException ee) {
                ee.printStackTrace();
            }
        }
    } // de run()
} //..fin HiloServidor
