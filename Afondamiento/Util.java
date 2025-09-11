public class Util {

    // Cre un arrray 2D
    public static int[][] array2D(int rows, int cols) {
        return new int[rows][cols];
    }

    // Imprime un array 2D
    public static void print2DArray(int[][] array) {
        for (int[] row : array) {
            for (int elem : row) {
                System.out.print(elem + " ");
            }
            System.out.println();
        }
    }

    public static int[][] fillFromKeyboard(int rows, int cols) {
        java.util.Scanner sc = new java.util.Scanner(System.in);
        int[][] array = new int[rows][cols];
        System.out.println("Enter " + (rows * cols) + " integers:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                array[i][j] = sc.nextInt();
            }
        }
        return array;
    }

    public static int[][] sumMatrices(int[][] A, int[][] B) {
        int rows = A.length;
        int cols = A[0].length;
        int[][] C = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                C[i][j] = A[i][j] + B[i][j];
            }
        }
        return C;
    }
}
