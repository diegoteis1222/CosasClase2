package ExamenTeoria;

import java.net.InetAddress;
import java.net.MulticastSocket;

public class EjemploInetAddress {

    // Es necesario usar throws Exception para manejar errores de red o usar try-catch 
    public static void main(String[] args) throws Exception {

        // codigo minimo para crear un server y un cliente que se conecten mediante multicast
        
        int puerto = 1234;
        String host = "230.0.0.1";

        MulticastSocket ms = new MulticastSocket(puerto);
        InetAddress grupo = InetAddress.getByName(host);

        ms.joinGroup(grupo);

    }

    /**
     * Constructor: NO TIENE.
     *
     *      *Métodos principales: *InetAddress.getByName(String host) Obtiene la IP
     * a partir de un nombre de dominio
     *
     *      *InetAddress.getLocalHost(): Devuelve la IP de la máquina donde se
     * ejecuta el código.
     *
     *      *InetAddress.getAllByName(String host): Devuelve un array de IPs si un
     * dominio tiene varias.
     *
     *      *Métodos de instancia (una vez creado el objeto):
     *
     *      *getHostName(): Devuelve el nombre del host (si se puede resolver).
     *
     *      *getHostAddress(): Devuelve la dirección IP en formato texto (String,
     * ej: "192.168.1.1").
     */
}
