import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

public class ejecutor2 {

    static final int POSICIONES = 1000000;
    static final int NUM_HILOS = 4;

    public static void main(String[] args) throws Exception {
        int[] datos = new int[POSICIONES];

        Random rand = new Random();
        int salto = POSICIONES / NUM_HILOS;

        for (int i = 0; i < datos.length; i++) {
            datos[i] = rand.nextInt();
        }

        System.out.println("Array original:");
        System.out.println(Arrays.toString(datos));

        ExecutorService executor = java.util.concurrent.Executors.newFixedThreadPool(NUM_HILOS);

        for (int i = 0; i < NUM_HILOS; i++) {
            final int inicio = i * salto;
            final int fin = (i == NUM_HILOS - 1) ? POSICIONES : inicio + salto;

            executor.execute(() -> ordenarTrozo(datos, inicio, fin));
        }

        executor.shutdown();
        executor.awaitTermination(5, TimeUnit.SECONDS);

        int[] resultado = fusionarSubarrays(datos, salto, NUM_HILOS);

        System.out.println("Array completamente ordenado:");
        System.out.println(Arrays.toString(resultado));
    }

    public static void ordenarTrozo(int[] array, int inicio, int fin) {
        if (inicio < 0) inicio = 0;
        if (fin > array.length) fin = array.length;
        if (inicio >= fin) return;

        for (int i = fin - 1; i > inicio; i--) {
            for (int j = inicio; j < i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    public static int[] fusionarSubarrays(int[] array, int salto, int numHilos) {
        int[] resultado = Arrays.copyOf(array, array.length);

        for (int i = 1; i < numHilos; i++) {
            int inicio = 0;
            int medio = i * salto;
            int fin = (i == numHilos - 1) ? array.length : (i + 1) * salto;

            resultado = fusionar(resultado, inicio, medio, fin);
        }

        return resultado;
    }

    public static int[] fusionar(int[] array, int inicio, int medio, int fin) {
        int[] temp = new int[fin - inicio];
        int i = inicio, j = medio, k = 0;

        while (i < medio && j < fin) {
            if (array[i] <= array[j]) {
                temp[k++] = array[i++];
            } else {
                temp[k++] = array[j++];
            }
        }

        while (i < medio) temp[k++] = array[i++];
        while (j < fin) temp[k++] = array[j++];

        System.arraycopy(temp, 0, array, inicio, temp.length);
        return array;
    }
}
