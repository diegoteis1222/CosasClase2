package TestInetAdress;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class TestInetAddress {
    public static void main(String[] args) {
        InetAddress dir = null;
        System.out.println("=== EJEMPLOS DE USO DE InetAddress ===");

        try {
            // LOCALHOST
            System.out.println("=== SALIDA PARA LOCALHOST: ");
            dir = InetAddress.getByName("localhost");
            pruebaMetodos(dir);

            // URL www.google.es
            System.out.println("=== SALIDA PARA UNA URL: ");
            dir = InetAddress.getByName("www.google.es");
            pruebaMetodos(dir);

            // URL www.cebem.net
            System.out.println("=== SALIDA PARA UNA URL: ");
            dir = InetAddress.getByName("www.cebem.net");
            pruebaMetodos(dir);

            // Array de direcciones IP para google.es
            System.out.println("\tDIRECCIONES IP PARA: " + dir.getHostName());
            InetAddress[] direcciones = InetAddress.getAllByName(dir.getHostName());
            for (int i = 0; i < direcciones.length; i++) {
                System.out.println("\t\t" + direcciones[i].toString());
            }

        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

    private static void pruebaMetodos(InetAddress dir) {
        try {
            InetAddress dir2 = InetAddress.getLocalHost();
            System.out.println("\tMetodo getLocalHost(): " + dir2);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        // Métodos de InetAddress
        System.out.println("\tMetodo getHostName(): " + dir.getHostName());
        System.out.println("\tMetodo getHostAddress(): " + dir.getHostAddress());
        System.out.println("\tMetodo toString(): " + dir.toString());
        System.out.println("\tMetodo getCanonicalHostName(): " + dir.getCanonicalHostName());
    }
}