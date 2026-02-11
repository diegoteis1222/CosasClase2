
public class EstadisticaLluvia {

    public static void main(String[] args) {
        // 1. Datos iniciales (los 60 valores de la tabla)
        double[] datos = {
                23.2, 17.6, 15.7, 16.2, 19.9, 3.4,
                4.2, 16.6, 8.8, 23.6, 4.5, 9.5,
                23.8, 17.0, 13.2, 5.8, 12.2, 26.4,
                24.0, 10.1, 14.7, 21.2, 17.7, 7.7,
                2.8, 18.2, 18.0, 23.0, 19.0, 15.0,
                15.2, 18.3, 26.2, 5.1, 14.8, 11.7,
                3.4, 22.1, 17.2, 23.4, 19.8, 19.4,
                22.4, 20.6, 2.2, 9.8, 21.8, 3.9,
                22.8, 20.9, 25.7, 18.9, 20.2, 7.2,
                25.5, 16.0, 21.0, 11.2, 25.4, 22.4
        };

        // 2. Parámetros de la tabla de frecuencias (según el enunciado)
        int n = datos.length; // 60
        int numClases = 7; // k
        double amplitud = 4.0; // w
        double limiteInferiorInicial = 0.0; // Empezamos en 0 como dice el ejercicio

        // 3. Estructuras para la tabla
        int[] fi = new int[numClases]; // Frecuencia absoluta
        double[] ci = new double[numClases]; // Marca de clase
        int[] Fi = new int[numClases]; // Frecuencia acumulada

        // Calcular frecuencias (conteo) y marcas de clase
        for (int i = 0; i < numClases; i++) {
            double Li = limiteInferiorInicial + (i * amplitud);
            double Ls = Li + amplitud;
            ci[i] = (Li + Ls) / 2.0;

            for (double dato : datos) {
                // Si es la última clase, incluimos el límite superior [24, 28]
                if (i == numClases - 1) {
                    if (dato >= Li && dato <= Ls)
                        fi[i]++;
                } else {
                    if (dato >= Li && dato < Ls)
                        fi[i]++;
                }
            }
        }

        // Calcular frecuencia acumulada
        int acumulado = 0;
        for (int i = 0; i < numClases; i++) {
            acumulado += fi[i];
            Fi[i] = acumulado;
        }

        // --- CÁLCULOS ---

        // 4. Media Aritmética
        double sumaCiFi = 0;
        for (int i = 0; i < numClases; i++) {
            sumaCiFi += (ci[i] * fi[i]);
        }
        double media = sumaCiFi / n;

        // 5. Mediana (Me)
        double posicionMe = n / 2.0;
        int claseMe = 0;
        for (int i = 0; i < numClases; i++) {
            if (Fi[i] >= posicionMe) {
                claseMe = i;
                break;
            }
        }
        double LiMe = limiteInferiorInicial + (claseMe * amplitud);
        int FiAnteriorMe = (claseMe == 0) ? 0 : Fi[claseMe - 1];
        double mediana = LiMe + ((posicionMe - FiAnteriorMe) / (double) fi[claseMe]) * amplitud;

        // 6. Moda (Mo) - Basada en la clase de mayor frecuencia
        int maxFi = 0;
        int claseMo = 0;
        for (int i = 0; i < numClases; i++) {
            if (fi[i] > maxFi) {
                maxFi = fi[i];
                claseMo = i;
            }
        }
        // Nota: En este set de datos hay dos modas (clase 5 y 6), tomamos la primera
        // para el cálculo.
        double LiMo = limiteInferiorInicial + (claseMo * amplitud);
        double d1 = (claseMo == 0) ? fi[claseMo] : fi[claseMo] - fi[claseMo - 1];
        double d2 = (claseMo == numClases - 1) ? fi[claseMo] : fi[claseMo] - fi[claseMo + 1];
        double moda = LiMo + (d1 / (d1 + d2)) * amplitud;

        // 7. Dispersión: Varianza y Desviación Típica
        double sumaCi2Fi = 0;
        for (int i = 0; i < numClases; i++) {
            sumaCi2Fi += (Math.pow(ci[i], 2) * fi[i]);
        }
        double varianza = (sumaCi2Fi / n) - Math.pow(media, 2);
        double desviacionTipica = Math.sqrt(varianza);

        // --- MOSTRAR RESULTADOS ---
        System.out.println("TABLA DE FRECUENCIAS:");
        System.out.println("Intervalo\tci\tfi\tFi");
        for (int i = 0; i < numClases; i++) {
            double Li = limiteInferiorInicial + (i * amplitud);
            double Ls = Li + amplitud;
            System.out.printf("[%.1f - %.1f)\t%.1f\t%d\t%d\n", Li, Ls, ci[i], fi[i], Fi[i]);
        }

        System.out.println("\nMEDIDAS DE TENDENCIA CENTRAL:");
        System.out.printf("1. Media: %.2f l/m²\n", media);
        System.out.printf("2. Mediana: %.2f l/m²\n", mediana);
        System.out.printf("3. Moda (aprox): %.2f l/m²\n", moda);

        System.out.println("\nMEDIDAS DE DISPERSIÓN:");
        System.out.printf("1. Varianza: %.2f\n", varianza);
        System.out.printf("2. Desviación Típica: %.2f l/m²\n", desviacionTipica);
        System.out.printf("3. Coeficiente de Variación: %.2f%%\n", (desviacionTipica / media) * 100);
    }
}