import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class Lanzador {
    public static final String SUFIJO_RESULTADO = ".res";
    public static final String SUFIJO_ERRORES = ".err";
    public static final String RESULTADOS_GLOBALES = "resultado_global.txt";

    public static void main(String[] args) throws IOException, InterruptedException {

        String classpath = System.getProperty("java.class.path");

        // Archivos a leer
        String[] ficheros = { "informatica.txt", "gerencia.txt",
                "contabilidad.txt", "comercio.txt", "rrhh.txt" };
        // Los nombres de los ficheros de resultados
        // se generarán y luego se almacenarán aquí
        String[] ficherosResultado;
        // Le damos el tamaño de la cantidad de ficheros a leer
        ficherosResultado = new String[ficheros.length];

        /* Lanzamos los procesos */

        // Creamos los constructores y procesos
        ProcessBuilder[] constructores;
        Process[] procesos;

        // Les damos el tamaño segun la cantidad de ficheros a leer
        constructores = new ProcessBuilder[ficheros.length];
        procesos = new Process[ficheros.length];

        for (int i = 0; i < ficheros.length; i++) { // Recorremos la cantidad de ficheros que hay\

            // Creamos un archivo de resultado y uno de error
            String fichResultado, fichErrores;

            // Les damos el nombre del archivo que estamos leyendo mas su sufijo
            fichResultado = ficheros[i] + SUFIJO_RESULTADO;
            fichErrores = ficheros[i] + SUFIJO_ERRORES;

            // Guardamos el nombre del archivoResultado
            ficherosResultado[i] = fichResultado;
            // Creamos un ProcessBuilder
            constructores[i] = new ProcessBuilder();

            /*
             * Equivalente a:
             * (java -cp CLASSPATH ProcesaFicheros informatica.txt informatica.txt.res)\
             * Generara el fichero con el mismo nombre pero con .res
             */
            // ! ---Solo se ejecutara el comando cuando se le llame con .start()---

            constructores[i].command("java", "-cp", classpath,
                    "ProcesaFicheros", ficheros[i], fichResultado);

            // Redirige el error a un nuevo archivo llamado igual pero .err
            constructores[i].redirectError(new File(fichErrores));

            // ! ---Aqui ejecutamos el comando anterior---
            procesos[i] = constructores[i].start();

        } // fin del for

        // Esperamos a que todos los procesos terminen
        for (Process proceso : procesos) {

            // Bloqueamos el programa hasta que termine
            proceso.waitFor();
        }

        // Calculamos las sumas de cantidades solo de los ficheros de resultado
        long total = Utiles.getSuma(ficherosResultado);

        // Creamos el archivo de resultados globales con la
        // suma de todos los numeros de todos los archivos
        try (PrintWriter pw = Utiles.getPrintWriter(RESULTADOS_GLOBALES)) {
            pw.println(total);
        }
    }// Fin del main
}
