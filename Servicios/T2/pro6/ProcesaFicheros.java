import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class ProcesaFicheros {
    public static void main(String[] args) throws IOException {
        String nombreFichero = args[0];
        String nombreFicheroResultado = args[1];
        ArrayList<String> cantidades;
        long total = 0;

        try {
            // Extraemos las cantidades
            cantidades = Utiles.getLineasFichero(nombreFichero);

            // Y las sumamos una por una
            for (String lineaCantidad : cantidades) {
                long cantidad = Long.parseLong(lineaCantidad);
                total = total + cantidad;
            }

            // Almacenamos el total en un fichero
            PrintWriter pw;
            pw = Utiles.getPrintWriter(nombreFicheroResultado);
            pw.println(total);
            pw.close();

        } catch (IOException e) {
            System.err.println("No se pudo procesar el fichero " + nombreFichero);
            System.err.println("Error: " + e.getMessage());
        }
        // fin del main
    }

}