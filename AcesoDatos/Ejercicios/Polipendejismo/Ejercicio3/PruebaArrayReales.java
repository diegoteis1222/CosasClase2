public class PruebaArrayReales {
    public static void main(String[] args) {

        ArrayReales array = new ArrayReales();
        array.asignar();
        array.imprimir();
        System.out.println("El minimo es: " + array.minimo());
        System.out.println("El maximo es: " + array.maximo());
        System.out.println("El sumatorio es: " + array.sumatorio());
    }
}
