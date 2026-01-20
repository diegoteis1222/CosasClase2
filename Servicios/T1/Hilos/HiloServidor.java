
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class HiloServidor extends Thread {

    BufferedReader fEntrada;
    PrintWriter fSalida;
    Socket socket = null;

    public HiloServidor(Socket s) {
        socket = s;

        try {
            fSalida = new PrintWriter(socket.getOutputStream(), true);
            fEntrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        } catch (Exception e) {
            System.out.println("Error al crear flujos: " + e.getMessage());
        }
    }

    public void run() {
        try {
            String cadena = "";

            while (!cadena.trim().equals("quit")) {
                System.out.println("Comunico con: " + socket.toString());
                cadena = fEntrada.readLine();

                if ("quit".equalsIgnoreCase(cadena.trim())) {
                    System.out.println("El cliente quiere salir.");
                    break;
                }
                fSalida.println(cadena.trim().toUpperCase());

                if (isNumeric(cadena)) {
                    int numero = Integer.parseInt(cadena);

                    if (primo(numero)) {
                        System.out.println("El numero: " + numero + " es primo");
                    } else {
                        System.out.println("El numero: " + numero + " no es primo");
                    }

                    int invertido = inversor(numero);

                    if (primo(invertido)) {
                        System.out.println("En reverso es: " + invertido + " y es primo");
                    } else {
                        System.out.println("En reverso es: " + invertido + " y no es primo");
                    }
                }

            }
            System.out.println("Fin con: " + socket.toString());
            fSalida.close();
            fEntrada.close();
            socket.close();
        } catch (Exception e) {
            System.out.println("Error en la comunicación: " + e.getMessage());
        }
    }

    // Source - https://stackoverflow.com/a
    // Posted by CraigTP, modified by community. See post 'Timeline' for change history
    // Retrieved 2025-11-12, License - CC BY-SA 4.0
    public static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    // estos dos son del año pasado
    public static boolean primo(int n) {

        boolean primo = true;
        int i = 2;

        while (i < n && primo) {

            if (n % i == 0) {
                primo = false;
            }
            i++;
        }
        return primo;
    }

    public static int inversor(int n) {
        int mov = 0;

        while (n > 0) {
            int num = n % 10;
            mov = mov * 10 + num;
            n = n / 10;
        }
        return mov;
    }

}
