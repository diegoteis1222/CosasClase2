package ExamenTeoria;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class EjemploMulticast {

    // FUNCIONAMIENTO MULTICAST
    //Utiliza el protocolo UDP (Datagramas)
    //El Servidor envía paquetes a una IP y un Puerto
    //Los Clientes se deben usar joinGroup a esa misma IP y escuchar en ese Puerto
    //Un solo servidor envía el paquete una vez, y la red se encarga de replicarlo a todos los clientes unidos
    public static void server() throws Exception {
        int puerto = 1234;
        String host = "230.0.0.1";

        // Crear el MulticastSocket en el puerto especificado
        MulticastSocket ms = new MulticastSocket(puerto);

        // Obtener la dirección del grupo multicast
        InetAddress grupo = InetAddress.getByName(host);

        // Unirse al grupo multicast
        ms.joinGroup(grupo);

        while (true) {

            // Esperar 5 segundos antes de enviar la siguiente hora
            Thread.sleep(5000);

            // Crea un array de bytes 
            byte[] buf = new byte[1024];

            // Obtener la hora formateada y convertirla a bytes
            buf = obtenerHora().getBytes();

            // Crear un paquete datagrama con los datos, la dirección del grupo y el puerto
            DatagramPacket dp = new DatagramPacket(buf, buf.length, grupo, puerto);

            // Enviar el paquete al grupo multicast
            ms.send(dp);

        }
    }

    public static void cliente() throws Exception {
        Scanner sc = new Scanner(System.in);

        int puerto = 1234;
        String host = "230.0.0.1";

        // Crear el MulticastSocket en el puerto especificado
        MulticastSocket ms = new MulticastSocket(puerto);

        // Obtener la dirección del grupo multicast
        InetAddress grupo = InetAddress.getByName(host);

        // Unirse al grupo multicast
        ms.joinGroup(grupo);
        String mensaje = "";

        System.out.println("Cliente unido al grupo y recibiendo la pinche hora cada 5 segundos: ");

        while (true) {

            try {
                // Esperar 5 segundos antes de recibir la siguiente hora
                Thread.sleep(5000);

                byte[] buf = new byte[1024];

                // Crear un paquete datagrama con el buffer, la longitud, el grupo y el puerto
                DatagramPacket dp = new DatagramPacket(buf, buf.length, grupo, puerto);

                // Recibir el paquete del grupo multicast
                ms.receive(dp);

                // Convertir los datos recibidos en un mensaje de texto
                mensaje = new String(dp.getData(), 0, dp.getLength());

                System.out.println("recibido: " + mensaje);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static String obtenerHora() {

        LocalDate fecha = LocalDate.now();
        LocalTime horaActual = LocalTime.now();

        DateTimeFormatter formateadorFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter formatteadorHora = DateTimeFormatter.ofPattern("HH:mm:ss");

        String horaFormateada = horaActual.format(formatteadorHora);
        String fechaFormateada = fecha.format(formateadorFecha);

        return "Fecha: " + fechaFormateada + ", Hora actual: " + horaFormateada;
    }
}
