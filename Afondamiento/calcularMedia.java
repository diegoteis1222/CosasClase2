public class calcularMedia {
    
    int[] valores = {0,1,2,3,4};
    int[] frecuencias = {4,8,5,2,2};

    public static void main(String[] args) {
        calcularMedia cm = new calcularMedia();
        double media = obtenerMediaDesdeTabla(cm.valores, cm.frecuencias);
        System.out.println("La media de los datos es: " + media);
    }
}
