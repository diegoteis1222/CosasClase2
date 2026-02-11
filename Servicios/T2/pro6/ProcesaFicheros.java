import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class ProcesaFicheros {
    public static void main(String[] args) throws IOException {

        // Scanner
        Scanner sc = new Scanner(System.in);

        System.out.print("Introduce un numero para sumar solo sus inferiores: ");
        long parametro = sc.nextLong();

        // args es el primer argumento que recibe el programa
        // En "java MiPrograma archivo.txt" args[0] es archivo.txt
        String nombreFichero = args[0];

        // En "java MiPrograma archivo.txt resultado.txt" args[1] es resultado.txt
        String nombreFicheroResultado = args[1];

        // ArrayList para guardar las cantidades
        ArrayList<String> cantidades;
        // Para sumar el total
        long total = 0;

        try {
            // Extraemos las cantidades
            cantidades = Utiles.getLineasFichero(nombreFichero);

            for (String lineaCantidad : cantidades) { // Por cada linea en el Array de lineas
                // Convertimos la linea a número
                long cantidad = Long.parseLong(lineaCantidad);

                // Vamos sumando la cantidad solo si es inferior al número dado
                if (cantidad < parametro) {
                    total = total + cantidad;
                }

            } // Fin del For

            // Creamos el printWriter
            PrintWriter pw;
            // Creamos un archivo para escribir el resultado
            pw = Utiles.getPrintWriter(nombreFicheroResultado);
            // Escribimos el total en el archivo
            pw.println(total);
            // Cerramos el printWriter
            pw.close();

        } catch (IOException e) {
            System.err.println("No se pudo procesar el fichero " + nombreFichero);
            System.err.println("Error: " + e.getMessage());
        } // Fin del try

        // Lo cierro porque quiero no por gepeto
        sc.close();

    } // fin del main

}