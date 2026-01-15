
import java.util.HashMap;

public class biblioteca {

    public static double obtenerMediaDesdeTabla(int[] valores, int[] frecuencias) {
        double sumaProductos = 0;
        int sumaFrecuencias = 0;

        for (int i = 0; i < valores.length; i++) {
            sumaProductos += valores[i] * frecuencias[i];
            sumaFrecuencias += frecuencias[i];
        }

        return sumaProductos / sumaFrecuencias;
    }

    public static double obtenerMediana(int[] datos) {
        int n = datos.length;
        java.util.Arrays.sort(datos);
        if (n % 2 == 0) {
            return (datos[n / 2 - 1] + datos[n / 2]) / 2.0;
        } else {
            return datos[n / 2];
        }
    }

    public static HashMap<Integer, Integer> agruparDatos(int[] datos) {
        HashMap<Integer, Integer> frecuencia = new HashMap<>();
        for (int dato : datos) {
            frecuencia.put(dato, frecuencia.getOrDefault(dato, 0) + 1);
        }
        return frecuencia;
    }

    public static double obtenerMedia(int[] datos) {
        double suma = 0;
        for (int dato : datos) {
            suma += dato;
        }
        return suma / datos.length;
    }

    public static int obtenerModa(int[] datos) {
        HashMap<Integer, Integer> frecuencia = agruparDatos(datos);
        int moda = datos[0];
        int maxFrecuencia = 0;

        for (HashMap.Entry<Integer, Integer> entry : frecuencia.entrySet()) {
            if (entry.getValue() > maxFrecuencia) {
                maxFrecuencia = entry.getValue();
                moda = entry.getKey();
            }
        }

        return moda;
    }

    public static double obtenerVarianza(int[] datos) {
        double media = obtenerMedia(datos);
        double sumaCuadrados = 0;

        for (int dato : datos) {
            sumaCuadrados += Math.pow(dato - media, 2);
        }

        return sumaCuadrados / datos.length;
    }
}
