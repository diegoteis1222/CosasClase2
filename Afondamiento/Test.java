public class Test {
    public static void main(String[] args) {

        // int[][] myArray = Util.array2D(3, 3);
        // Util.print2DArray(myArray);

        int[][] A = Util.fillFromKeyboard(3, 3);
        Util.print2DArray(A);

        int[][] B = Util.fillFromKeyboard(3, 4);
        Util.print2DArray(B);

        System.out.println(Util.esSimetrica(A));
        System.out.println(Util.esSimetrica(B));

    }
}
