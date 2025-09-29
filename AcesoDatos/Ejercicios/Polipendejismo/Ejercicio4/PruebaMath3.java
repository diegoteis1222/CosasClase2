public class PruebaMath3 {
    public static void main(String[] args) {

        Math3 math = new Math3();

        int[] numeritos = new int[12];
        for (int i = 0; i < numeritos.length; i++) {

            numeritos[i] = (int) (100 * Math.random() + 1);
        }

        double[] numeritos2 = new double[12];
        for (int i = 0; i < numeritos2.length; i++) {

            numeritos2[i] = (100 * Math.random() + 1);
        }

        System.out.println("Minimo en los ints: " + math.min(numeritos));
        System.out.println("Maximo en los ints: " + math.max(numeritos));
        System.out.println("Minimo en los doubles: " + math.min(numeritos2));
        System.out.println("Maximo en los doubles: " + math.max(numeritos2));

    }
}
