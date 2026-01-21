
public class ejercicio2 {

    public static void main(String[] args) {

        int[] datos = {
            5, 7, 9, 10, 6,
            8, 7, 9, 10, 6,
            5, 8, 9, 7, 6,
            10, 8, 7, 9, 6
        }; 

        double media = biblioteca.obtenerMedia(datos);
        double varianza = biblioteca.obtenerVarianza(datos);

        System.out.println("Media: " + media);
        System.out.println("Varianza: " + varianza);
    }
}
