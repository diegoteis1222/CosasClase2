import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

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

            contarTotalVocales();
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

    public static void contarTotalVocales() throws IOException {
        String[] archivos = {"resultadoA.txt", "resultadoE.txt", "resultadoI.txt", "resultadoO.txt", "resultadoU.txt"};
        int totalVocales = 0;
        
        System.out.println("\n=== RESUMEN DE CONTEO DE VOCALES ===\n");
        
        for (String archivo : archivos) {
            Scanner scanner = new Scanner(new java.io.File(archivo));
            
            if (scanner.hasNextLine()) {
                String linea = scanner.nextLine();
                String[] partes = linea.split(":");
                if (partes.length == 2) {
                    int count = Integer.parseInt(partes[1].trim());
                    totalVocales += count;
                    System.out.println(linea);
                }
            }
            
            scanner.close();
        }

        System.out.println("\nTotal de vocales: " + totalVocales);
    }
}
