public class ProductoMatrices {

    public static void main(String[] args) {

        int[][] A = Util.fillFromKeyboard(2, 3);
        Util.print2DArray(A);

        int[][] B = Util.fillFromKeyboard(3, 2);
        Util.print2DArray(B);

        int[][] C = Util.multiplyMatrices(A, B);
        System.out.println("Producto de A y B:");
        Util.print2DArray(C);

        /**
         * Mtriz 1 Mtriz 2
         * 1 2 3 4 5
         * 4 5 2 6 3
         * 2 1
         */

        /**
         * (1*4) + (2*6) + (3*2) = 4 + 12 + 6 = 22
         * (1*5) + (2*3) + (3*1) = 5 + 6 + 3 = 14
         * (4*4) + (5*6) + (2*2) = 16 + 30 + 4 = 50
         * (4*5) + (5*3) + (2*1) = 20 + 15 + 2 = 37
         */

        /**
         * Resultado
         * 22 14
         * 50 37
         */

        // pepe, no te voy a mentir, me daba muchisima pereza y se lo pedí a la IA, yo
        // solo lo leí, entendí y deje bonico
    }
}
