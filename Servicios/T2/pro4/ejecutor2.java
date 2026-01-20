
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

public class ejecutor2 {

    public static void main(String[] args) throws Exception {
        int[] datos = new int[100];

        ExecutorService executor = java.util.concurrent.Executors.newFixedThreadPool(4);

        for (int i = 0; i < 4; i++) {
            final int inicio = i * 25;
            final int fin = (i == 3) ? 100 : inicio + 25;

            executor.execute(() -> {
                ordenarTrozo(datos, inicio, fin);
                System.out.println("Terminao ");
            });
        }

        executor.shutdown();
        executor.awaitTermination(5, TimeUnit.SECONDS);
    }

}
