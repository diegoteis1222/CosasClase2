
import java.util.HashMap;
import java.util.Map;

public class CalcularModa {

    //forma tipica de presentar variable 
    public static void main(String[] args) {
        // Datos de ejemplo (basados en el ejercicio anterior)
        int[] datos = {0, 1, 1, 2, 0, 3, 1, 2, 1, 1, 0, 2, 4, 1, 2, 1, 0, 2, 3, 1};

        int moda = obtenerModa(datos);
        System.out.println("La moda de los datos es: " + moda);
    }

    public static int obtenerModa(int[] lista) {
        HashMap<Integer, Integer> frecuencias = new HashMap<>();

        // 1. Llenar el mapa con las frecuencias
        for (int x : lista) {
            frecuencias.put(x, frecuencias.getOrDefault(x, 0) + 1);
        }

        // 2. Buscar el valor con la frecuencia máxima
        int moda = lista[0];
        int maxFrecuencia = 0;

        for (Map.Entry<Integer, Integer> entrada : frecuencias.entrySet()) {
            if (entrada.getValue() > maxFrecuencia) {
                maxFrecuencia = entrada.getValue();
                moda = entrada.getKey();
            }
        }

        return moda;
    }
}
