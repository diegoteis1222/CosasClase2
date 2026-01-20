package Ejer1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class HiloServidor extends Thread {

    BufferedReader fEntrada;
    PrintWriter fSalida;
    Socket socket;
    String nombre;

    // Referencia al servidor principal
    Servidor servidor;

    // Constructor recibe el Socket Y el Servidor
    public HiloServidor(Socket socket, Servidor servidor) {
        this.socket = socket;
        this.servidor = servidor;

    }

    @Override
    public void run() {
        try {
            fSalida = new PrintWriter(socket.getOutputStream(), true);
            fEntrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // Leer nombre y decir que se conecto
            nombre = fEntrada.readLine();
            System.out.println("Conectado: " + nombre);

            // Avisar a todos que se ha unido
            servidor.broadcast("--> " + nombre + " se ha unido.");

            // mensaje a enviar
            String inputLine;

            // mientras llegue algo
            while ((inputLine = fEntrada.readLine()) != null) {

                // Si el cliente envía "quit" salimos
                if (inputLine.trim().equalsIgnoreCase("quit")) {
                    break;
                }
                // si no es quit enviamos lo que dijo 
                servidor.broadcast(nombre + ": " + inputLine);
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            // eliminar este cliente del servidor y avisar a todos
            servidor.removeClient(this);
            servidor.broadcast("<-- " + nombre + " ha salido.");

            // cerrar conexión
            closeConnection();
        }
    }

    public void enviar(String msg) {
        if (fSalida != null) {
            fSalida.println(msg);
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
