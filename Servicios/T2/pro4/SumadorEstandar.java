
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SumadorEstandar {

    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Sumador epicardo por Argu");

        System.out.print("Dame el primer piche valor: ");
        int n1 = scanner.nextInt();
        System.out.print("Dame el segundo piche valor: ");
        BigInteger n2 = scanner.nextBigInteger();
        System.out.print("Dame el numero de pinches hilos: ");
        int nHilos = scanner.nextInt();

        BigInteger rango = n2.subtract(BigInteger.valueOf(n1)).add(BigInteger.ONE).divide(BigInteger.valueOf(nHilos));
        ExecutorService executor = Executors.newFixedThreadPool(nHilos);
        List<Future<BigInteger>> resultados = new ArrayList<>();

        for (int i = 0; i < nHilos; i++) {
            BigInteger inicio = BigInteger.valueOf(n1).add(rango.multiply(BigInteger.valueOf(i)));
            BigInteger fin = (i == nHilos - 1) ? n2 : inicio.add(rango).subtract(BigInteger.ONE);

            Callable<BigInteger> tarea = () -> {
                BigInteger sumaParcial = BigInteger.ZERO;
                for (BigInteger j = inicio; j.compareTo(fin) <= 0; j = j.add(BigInteger.ONE)) {
                    sumaParcial = sumaParcial.add(j);
                }
                return sumaParcial;
            };
            resultados.add(executor.submit(tarea));
        }

        BigInteger sumaTotal = BigInteger.ZERO;
        for (Future<BigInteger> resultado : resultados) {
            sumaTotal = sumaTotal.add(resultado.get());
        }

        executor.shutdown();
        System.out.println("La suma total es: " + sumaTotal);

    }

}
