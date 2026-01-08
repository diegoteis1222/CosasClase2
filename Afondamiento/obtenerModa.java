
public class obtenerModa {

    public static double obtenerMediaDesdeTabla(int[] valores, int[] frecuencias) {
        int sumaProductos = 0;
        int sumaFrecuencias = 0;

        for (int i = 0; i < valores.length; i++) {
            sumaProductos += valores[i] * frecuencias[i];
            sumaFrecuencias += frecuencias[i];
        }

        if (sumaFrecuencias == 0) {
            return 0;
        }

        return (double) sumaProductos / sumaFrecuencias;
    }
}
