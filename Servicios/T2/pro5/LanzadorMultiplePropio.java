import java.io.FileNotFoundException;
import java.io.IOException;

public class LanzadorMultiplePropio {

    // usando processbuilder lanza tantos procesos independientes
    // como necesitas para recorrer un hasmap de todas las letras minusculas
    // generando 5 ficheros de salido

    public static void main(String[] args) throws FileNotFoundException, IOException, Exception {

        if (args.length == 3) {
            ProcesadorFichero.hacerRecuentoVocal(args[0], args[1], args[2]);
        } else {
            lanzarProcesoMultiple("fichero.txt", "a", "resultadoA.txt");
            lanzarProcesoMultiple("fichero.txt", "e", "resultadoE.txt");
            lanzarProcesoMultiple("fichero.txt", "i", "resultadoI.txt");
            lanzarProcesoMultiple("fichero.txt", "o", "resultadoO.txt");
            lanzarProcesoMultiple("fichero.txt", "u", "resultadoU.txt");

            
        }
    }

    public static void lanzarProcesoMultiple(String ficheroEntrada, String letraContar, String ficheroResultado)
            throws IOException {

        String classpath = System.getProperty("java.class.path");
        
        ProcessBuilder pb = new ProcessBuilder(
                "java",
                "-cp",
                classpath,
                "LanzadorMultiplePropio",
                ficheroEntrada,
                letraContar,
                ficheroResultado);

        pb.inheritIO();
        Process proceso = pb.start();

        try {
            proceso.waitFor();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
