import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class LanzadorMultiplePropio {

    static final int NUM_HILOS = 5;
    static ExecutorService executor = java.util.concurrent.Executors.newFixedThreadPool(NUM_HILOS);

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

    public static void contarTotalVocales() throws Exception {
        String[] archivos = { "resultadoA.txt", "resultadoE.txt", "resultadoI.txt", "resultadoO.txt",
                "resultadoU.txt" };

        List<Future<String>> futures = new ArrayList<>();

        for (String archivo : archivos) {
            futures.add(executor.submit(new LectorArchivo(archivo)));
        }

        int totalVocales = 0;
        for (Future<String> future : futures) {
            String linea = future.get();
            if (linea != null) {
                String[] partes = linea.split(":");
                if (partes.length == 2) {
                    int count = Integer.parseInt(partes[1].trim());
                    totalVocales += count;
                    System.out.println(linea);
                }
            }
        }

        executor.shutdown();
        System.out.println("\nTotal de vocales: " + totalVocales);
    }

    // Clase interna que implementa Callable
    static class LectorArchivo implements Callable<String> {
        private String archivo;

        public LectorArchivo(String archivo) {
            this.archivo = archivo;
        }

        @Override
        public String call() throws Exception {
            try (Scanner scanner = new Scanner(new java.io.File(archivo))) {
                if (scanner.hasNextLine()) {
                    return scanner.nextLine();
                }
            }
            return null;
        }
    }
}
