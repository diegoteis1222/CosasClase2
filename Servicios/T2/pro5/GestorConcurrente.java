
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class GestorConcurrente {

    public static void main(String[] args) {
        String ficheroEntrada = "fichero.txt";
        String[] vocales = { "a", "e", "i", "o", "u" };

        ExecutorService executor = Executors.newFixedThreadPool(vocales.length);
        Map<String, Future<Integer>> futuros = new LinkedHashMap<>();

        System.out.println("Asignando tareas al Executor....");

        for (String v : vocales) {
            lanzadorCallable tarea = new lanzadorCallable(v, ficheroEntrada);
            futuros.put(v, executor.submit(tarea));
        }

        executor.shutdown();

        int granTotal = 0;

        System.out.println("Recogiendo de los hilos:");

        try {
            for (String v : futuros.keySet()) {
                int resultadoParcial = futuros.get(v).get();
                granTotal += resultadoParcial;
            }
        } catch (InterruptedException | ExecutionException e) {
            System.out.println("Error " + e.getMessage());
        }

        System.out.println("Total: " + granTotal);
    }
}
