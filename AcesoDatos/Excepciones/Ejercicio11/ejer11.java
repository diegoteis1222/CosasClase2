import java.util.Scanner;

public class ejer11 {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        System.out.println("Dame el primer numero: ");
        int numerador = sc.nextInt();

        System.out.println("Dame el segundo numero: ");
        int denominador = sc.nextInt();

        if (numerador > 100) {
            throw new Exception("El numerador no puede ser mayor de 100");
        }

        if (denominador < -5) {
            throw new Exception("El denominador no puede ser menor de -5");
        }

        if (denominador == 0) {
            throw new Exception("El denominador no puede ser 0");

        }
        System.out.println("El resultado es " + numerador / denominador);

    }
}
