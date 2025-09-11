public class Test {
    public static void main(String[] args) {

        // int[][] myArray = Util.array2D(3, 3);
        // Util.print2DArray(myArray);

        int[][] A = Util.fillFromKeyboard(3, 3);
        Util.print2DArray(A);

        int[][] B = Util.fillFromKeyboard(3, 3);
        Util.print2DArray(B);

        int[][] C = Util.sumMatrices(A, B);
        System.out.println("Suma de A y B:");
        Util.print2DArray(C);
    }
}
