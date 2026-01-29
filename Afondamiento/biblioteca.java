
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

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

    public static double obtenerDesviacionEstandar(int[] datos) {
        return Math.sqrt(obtenerVarianza(datos));
    }

    public static double obtenerMediaStreams(int[] datos) {
        return Arrays.stream(datos)
                .average()
                .orElse(0.0);
    }

    public static double obtenerVarianzaStreams(int[] datos) {
        double media = obtenerMedia(datos);

        return Arrays.stream(datos)
                .mapToDouble(x -> Math.pow(x - media, 2))
                .average()
                .orElse(0.0);
    }

    //metodos nuevos para usar hashmap obviamente sacados de gepeto

    public static double obtenerMediaDesdeTablaHashMap(HashMap<Integer, Integer> tabla) {
        double sumaProductos = 0;
        int sumaFrecuencias = 0;

        for (Map.Entry<Integer, Integer> entry : tabla.entrySet()) {
            sumaProductos += entry.getKey() * entry.getValue();
            sumaFrecuencias += entry.getValue();
        }

        return sumaProductos / sumaFrecuencias;
    }

    public static int obtenerModaHashMap(HashMap<Integer, Integer> tabla) {
        int moda = 0;
        int maxFrecuencia = 0;

        for (Map.Entry<Integer, Integer> entry : tabla.entrySet()) {
            if (entry.getValue() > maxFrecuencia) {
                maxFrecuencia = entry.getValue();
                moda = entry.getKey();
            }
        }

        return moda;
    }

    public static double obtenerMedianaHashMap(HashMap<Integer, Integer> tabla) {
        TreeMap<Integer, Integer> ordenada = new TreeMap<>(tabla);
        int total = ordenada.values().stream().mapToInt(Integer::intValue).sum();
        int mitad = total / 2;
        int contador = 0;
        int mediana1 = 0, mediana2 = 0;
        boolean par = total % 2 == 0;

        for (Map.Entry<Integer, Integer> entry : ordenada.entrySet()) {
            contador += entry.getValue();
            if (!par && contador > mitad) {
                return entry.getKey();
            } else if (par) {
                if (contador >= mitad && mediana1 == 0) {
                    mediana1 = entry.getKey();
                }
                if (contador >= mitad + 1) {
                    mediana2 = entry.getKey();
                    return (mediana1 + mediana2) / 2.0;
                }
            }
        }
        return 0; 
    }

    public static double obtenerVarianzaHashMap(HashMap<Integer, Integer> tabla) {
        double media = obtenerMediaDesdeTablaHashMap(tabla);
        double suma = 0;
        int total = 0;

        for (Map.Entry<Integer, Integer> entry : tabla.entrySet()) {
            int valor = entry.getKey();
            int freq = entry.getValue();
            suma += freq * Math.pow(valor - media, 2);
            total += freq;
        }

        return suma / total;
    }

    public static double obtenerDesviacionEstandarHashMap(HashMap<Integer, Integer> tabla) {
        return Math.sqrt(obtenerVarianzaHashMap(tabla));
    }

}
