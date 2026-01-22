
import java.util.Arrays;
import java.util.IntSummaryStatistics;

public class ejercicio2 {

    public static void main(String[] args) {

        int[] datos = {4, 0, 7, 2, 9, 1, 5, 8, 3, 6, 2, 0, 9, 4, 7, 1, 5, 8, 3, 2};

        double media = biblioteca.obtenerMedia(datos);
        double varianza = biblioteca.obtenerVarianza(datos);
        double desviacionEstandar = biblioteca.obtenerDesviacionEstandar(datos);
        double mediaStreams = biblioteca.obtenerMediaStreams(datos);
        double varianzaStreams = biblioteca.obtenerVarianzaStreams(datos);

        System.out.println("Media: " + media);
        System.out.println("Varianza: " + varianza);
        System.out.println("Desviación Estándar: " + desviacionEstandar);
        System.out.println("Media con Streams: " + mediaStreams);
        System.out.println("Varianza con Streams: " + varianzaStreams);

        IntSummaryStatistics stats = Arrays.stream(datos).summaryStatistics();

        System.out.println("Estadísticas con Streams:");
        System.out.println("Promedio: " + stats.getAverage());
        System.out.println("Suma: " + stats.getSum());
        System.out.println("Mínimo: " + stats.getMin());
        System.out.println("Máximo: " + stats.getMax());
        System.out.println("Cantidad: " + stats.getCount());

    }
}
