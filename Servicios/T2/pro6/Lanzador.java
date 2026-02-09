import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class Lanzador {
    public static final String SUFIJO_RESULTADO = ".res";
    public static final String SUFIJO_ERRORES = ".err";
    public static final String RESULTADOS_GLOBALES = "resultado_global.txt";

    public static void main(String[] args) throws IOException, InterruptedException {
        String classpath = System.getProperty("java.class.path");
        String[] ficheros = { "informatica.txt", "gerencia.txt",
                "contabilidad.txt", "comercio.txt", "rrhh.txt" };
        // Los nombres de los ficheros de resultados
        // se generarán y luego se almacenarán aquí
        String[] ficherosResultado;

        ficherosResultado = new String[ficheros.length];
        /* Lanzamos los procesos */
        ProcessBuilder[] constructores;
        Process[] procesos;
        constructores = new ProcessBuilder[ficheros.length];
        procesos = new Process[ficheros.length];
        for (int i = 0; i < ficheros.length; i++) {
            String fichResultado, fichErrores;
            fichResultado = ficheros[i] + SUFIJO_RESULTADO;
            fichErrores = ficheros[i] + SUFIJO_ERRORES;
            ficherosResultado[i] = fichResultado;
            constructores[i] = new ProcessBuilder();
            constructores[i].command("java", "-cp", classpath,
                    "ProcesaFicheros", ficheros[i],
                    fichResultado);
            // El fichero de errores se generará, aunque
            // puede que vacío
            constructores[i].redirectError(new File(fichErrores));
            procesos[i] = constructores[i].start();
            // fin del for que recorre los ficheros
        }
        
        // Esperamos a que todos los procesos terminen
        for (Process proceso : procesos) {
            proceso.waitFor();
        }
        
        // Calculamos las sumas de cantidades
        long total = Utiles.getSuma(ficherosResultado);
        // Y las almacenamos
        try (PrintWriter pw = Utiles.getPrintWriter(RESULTADOS_GLOBALES)) {
            pw.println(total);
        }

        // Fin del main
    }
}
