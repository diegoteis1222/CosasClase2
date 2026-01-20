package Ejer1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Servidor {

    // Lista de hilos (clientes)
    private List<HiloServidor> clientes = new ArrayList<>();
    private ServerSocket serverSocket;

    // En caso de necesitar un maximo de conexiones revisar serverchatswing
    public void iniciarServer(int puerto) {
        try {
            serverSocket = new ServerSocket(puerto);
            System.out.println("Servidor iniciado en el puerto: " + puerto);

            // Esto es para que el servidor pueda escribir mensajes
            // No estoy seguro de que entre en el examen, si se borra sigue funcionando bien
            // ---------------------------------------------------------
            Thread hiloConsola = new Thread(() -> {
                try {
                    BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
                    String mensaje;
                    while ((mensaje = teclado.readLine()) != null) {
                        broadcast("Server: " + mensaje);
                    }
                } catch (Exception e) {
                    System.out.println("Error leyendo consola en el servidor: " + e.getMessage());
                }
            });
            hiloConsola.start();
            // ---------------------------------------------------------

            while (true) {
                // aceptamos las conexiones
                Socket socketCliente = serverSocket.accept();

                // creamos el hilo 
                HiloServidor hilo = new HiloServidor(socketCliente, this);

                // añadimos el cliente a la lista con el metodo sincronizado (importante de cojones)
                addClient(hilo);

                // iniciamos el hilo
                hilo.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // METODOS SACADOS DE SERVERCHATSWING
    // para añadir clientes
    public synchronized void addClient(HiloServidor client) {
        clientes.add(client);
        System.out.println("Cliente añadido. Total: " + clientes.size());
    }

    // para eliminar clientes
    public synchronized void removeClient(HiloServidor client) {
        if (clientes.remove(client)) {
            System.out.println("Cliente desconectado. Total: " + clientes.size());
        }
    }

    // para enviar a todos
    public synchronized void broadcast(String msg) {
        System.out.println("Broadcast: " + msg);
        for (HiloServidor client : clientes) {
            client.enviar(msg);
        }
    }

    // MAIN
    public static void main(String[] args) {
        Servidor srv = new Servidor();
        srv.iniciarServer(1234);
    }
}
