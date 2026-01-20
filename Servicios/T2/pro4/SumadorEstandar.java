package pro4;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SumadorEstandar {

    public static void main(String[] args) throws Exception {
        int n1 = 1;
        int n2 = 100;
        int nHilos = 4;

        int rango = (n2 - n1 + 1) / nHilos;

        ExecutorService executor = Executors.newFixedThreadPool(nHilos);
        List<Future<Integer>> resultados = new ArrayList<>();

        for (int i = 0; i < nHilos; i++) {
            int inicio = n1 + i * rango;
            int fin = (i == nHilos - 1) ? n2 : inicio + rango - 1;

            Callable<Integer> tarea = () -> {
                int sumaParcial = 0;
                for (int j = inicio; j <= fin; j++) {
                    sumaParcial += j;
                }
                return sumaParcial;
            };
            resultados.add(executor.submit(tarea));
        }

        int sumaTotal = 0;
        for (Future<Integer> resultado : resultados) {
            sumaTotal += resultado.get();
        }

        executor.shutdown();
        System.out.println("La suma total es: " + sumaTotal);

    }

}
