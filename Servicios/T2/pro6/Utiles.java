import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Utiles {

    /**
     * @param listaNombresFichero Lista de nombres de archivos a procesar
     * @return la suma del primer numero de cada archivo
     */
    public static long getSuma(String[] listaNombresFichero) {

        // Para la suma
        long suma = 0;
        // Para almacenar las líneas del archivo
        ArrayList<String> lineas;
        // Para la línea que contiene la cantidad
        String lineaCantidad;
        // Para la cantidad convertida a número
        long cantidad;

        for (String nombreFichero : listaNombresFichero) { // Por cada archivo en la lista de archivos
            try {
                // Recuperamos todas las lineas
                lineas = getLineasFichero(nombreFichero);
                // Pero solo nos interesa la primera
                lineaCantidad = lineas.get(0);
                // Convertimos la linea a número
                cantidad = Long.parseLong(lineaCantidad);
                // Y se incrementa la suma total
                suma = suma + cantidad;
            } catch (IOException e) {
                System.err.println("Fallo al procesar el fichero "
                        + nombreFichero);
            } // fin del catch
        } // fin del for

        // Devolvemos la suma
        return suma;
    }

    /**
     * @param nombreFichero Archivo a leer linea por linea
     * @return Un ArrayList con las líneas del archivo
     * @throws IOException Si ocurre un error al leer el archivo
     */
    public static ArrayList<String> getLineasFichero(String nombreFichero) throws IOException {

        // ArrayList para almacenar las lineas
        ArrayList<String> lineas = new ArrayList<>();

        // Creamos un BufferedReader para el fichero
        BufferedReader bfr = getBufferedReader(nombreFichero);

        // Leemos líneas del fichero
        // Podemos usar readLine() porque es un BufferedReader
        String linea = bfr.readLine();

        while (linea != null) { // mientras haya lineas
            // las añadimos al array
            lineas.add(linea);
            // Leemos la siguiente línea
            linea = bfr.readLine();
        }
        // Fin del bucle que lee líneas
        return lineas;
    }

    /**
     * @param nombreFichero Archivo a leer
     * @return Un BufferedReader para leer el archivo linea por linea
     * @throws FileNotFoundException Si no existe el fichero
     */
    public static BufferedReader getBufferedReader(String nombreFichero) throws FileNotFoundException {

        // Creamos un file reader (sirve para leer caracteres)
        FileReader lector;
        // Le pasamos el archivo
        lector = new FileReader(nombreFichero);

        // Creamos un BufferedReader
        // Añade una memoria intermedia y permite usar metodos como readLine
        BufferedReader bufferedReader;
        // Envolvemos el FileReader en el BufferedReader
        bufferedReader = new BufferedReader(lector);

        // Devolvemos el BufferedReader
        return bufferedReader;
    }

    /**
     * @param nombreFichero Archivo donde escribir
     * @return Un PrintWriter para escribir en el archivo
     * @throws IOException Si ocurre un error al abrir el archivo
     */
    public static PrintWriter getPrintWriter(String nombreFichero) throws IOException {

        // Creamos un PrintWriter para escribir en el archivo
        // Permitre usar los metodos print()
        PrintWriter printWriter;

        // Creamos un fileWriter para abrir el archivo
        // Si no existe lo crea y si existe lo sobrescribe
        FileWriter fileWriter;

        // Abrimos el archivo para escritura
        fileWriter = new FileWriter(nombreFichero);
        // Escribimos en el archivo
        printWriter = new PrintWriter(fileWriter);

        // Devolvemos el PrintWriter
        return printWriter;
    }
}
