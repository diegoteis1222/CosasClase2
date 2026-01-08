
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
import javax.swing.JFileChooser;

public class Ejer1 {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int[] array = new int[10];

        System.out.println("Dame 10 numeros positivos (maximo 100): ");

        for (int i = 0; i < 10; i++) {
            System.out.println("Numero " + (i + 1));
            int num = sc.nextInt();

            if (!filtroPositivo(num)) {
                System.out.println("El numero no es positivo, tonto");
                i--;
            } else if (!filtroMaximo(num)) {
                System.out.println("El numero es mayor de 100, pringao");
                i--;
            } else {
                array[i] = num;
            }
        }

        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }

        System.out.println("Dame la ruta del archivo donde quieres guardar los numeros: ");
        sc.nextLine();
        String ruta = sc.nextLine();
        sc.close();

        try {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setSelectedFile(new File(ruta));

            BufferedWriter writer = new BufferedWriter(new FileWriter(fileChooser.getSelectedFile(), true));

            for (int i = 0; i < array.length; i++) {
                writer.write(array[i] + ", ");
            }

            writer.write("\n");
            writer.close();

            System.out.println("Numeros añadidos correctamente");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static boolean filtroPositivo(int n) {

        if (n >= 0) {
            return true;
        }

        return false;
    }

    public static boolean filtroMaximo(int n) {

        if (n <= 100) {
            return true;
        }

        return false;
    }
}
