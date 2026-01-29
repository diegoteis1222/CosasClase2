
import java.util.HashMap;

public class ejercicioWeb {

    public static void main(String[] args) {

        int[] notas = {
            3, 4, 5, 6, 6, 5, 7, 8, 6, 5,
            4, 6, 7, 8, 5, 6, 7, 9, 10, 5,
            6, 4, 5, 7, 6, 8, 4, 9, 6
        };

        HashMap<Integer, Integer> tabla = biblioteca.agruparDatos(notas);

        System.out.println("Sin HashMap:");
        double media = biblioteca.obtenerMedia(notas);
        System.out.println("Media: " + media);

        double mediana = biblioteca.obtenerMediana(notas);
        System.out.println("Mediana: " + mediana);

        int moda = biblioteca.obtenerModa(notas);
        System.out.println("Moda: " + moda);

        double varianza = biblioteca.obtenerVarianza(notas);
        System.out.println("Varianza: " + varianza);

        double desviacion = biblioteca.obtenerDesviacionEstandar(notas);
        System.out.println("Desviación estándar: " + desviacion);

        System.out.println("\nCon HashMap:");
        double mediaHashMap = biblioteca.obtenerMediaDesdeTablaHashMap(tabla);
        System.out.println("Media con HashMap: " + mediaHashMap);

        double medianaHashMap = biblioteca.obtenerMedianaHashMap(tabla);
        System.out.println("Mediana con HashMap: " + medianaHashMap);

        int modaHashMap = biblioteca.obtenerModaHashMap(tabla);
        System.out.println("Moda con HashMap: " + modaHashMap);

        double varianzaHashMap = biblioteca.obtenerVarianzaHashMap(tabla);
        System.out.println("Varianza con HashMap: " + varianzaHashMap);
        
        double desviacionHashMap = biblioteca.obtenerDesviacionEstandarHashMap(tabla);
        System.out.println("Desviación estándar con HashMap: " + desviacionHashMap);
    }
}
