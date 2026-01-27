import java.io.File;
import java.io.IOException;

public class LanzadorMultipleLibro {
    // usando processbuilder lanza tantos procesos independientes
    // como necesitas para recorrer un hasmap de todas las letras minusculas
    // del fichero Lorem.txt
    // generando 5 ficheros de salida

    public static void main(String[] args) throws IOException, InterruptedException {
        String ficheroEntrada;
        ficheroEntrada = args[0];
        String classpathUtilidades;
        classpathUtilidades = args[1];
        String classpathProcesadorFichero;
        classpathProcesadorFichero = args[2];

        String[] vocales = { "A", "E", "I", "O", "U" };
        String classPath;
        classPath = classpathProcesadorFichero + ":" +
                classpathUtilidades;
        System.out.println("Usando classpath:" + classPath);

        for (int i = 0; i < vocales.length; i++) {
            String fichErrores = "Errores_" + vocales[i] + ".txt";
            ProcessBuilder pb;
            pb = new ProcessBuilder("java", "ProcesadorFichero.java", ficheroEntrada,
                    vocales[i], vocales[i] + ".txt");

            pb.redirectError(new File(fichErrores));
            pb.start();
        }

        Thread.sleep(3000);

    }
}