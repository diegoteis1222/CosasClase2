
import java.util.Scanner;

public class ejercicio {

    public static void main(String[] args) {

        // chatgptada historica
        Scanner sc = new Scanner(System.in);

        // Primera ecuación
        System.out.print("a: ");
        double a = sc.nextDouble();
        System.out.print("b: ");
        double b = sc.nextDouble();
        System.out.print("c: ");
        double c = sc.nextDouble();
        System.out.print("d: ");
        double d = sc.nextDouble();

        // Segunda ecuación
        System.out.print("e: ");
        double e = sc.nextDouble();
        System.out.print("f: ");
        double f = sc.nextDouble();
        System.out.print("g: ");
        double g = sc.nextDouble();
        System.out.print("h: ");
        double h = sc.nextDouble();

        // Tercera ecuación
        System.out.print("i: ");
        double i = sc.nextDouble();
        System.out.print("j: ");
        double j = sc.nextDouble();
        System.out.print("k: ");
        double k = sc.nextDouble();
        System.out.print("l: ");
        double l = sc.nextDouble();

        double D = determinante(a, b, c, e, f, g, i, j, k);

        if (D == 0) {
            System.out.println("El sistema no tiene solución única.");
        } else {
            double Dx = determinante(d, b, c, h, f, g, l, j, k);
            double Dy = determinante(a, d, c, e, h, g, i, l, k);
            double Dz = determinante(a, b, d, e, f, h, i, j, l);

            System.out.println("Soluciones:");
            System.out.println("x = " + Dx / D);
            System.out.println("y = " + Dy / D);
            System.out.println("z = " + Dz / D);
        }

        sc.close();
    }

    public static double determinante(
            double a, double b, double c,
            double d, double e, double f,
            double g, double h, double i) {

        return a * (e * i - f * h)
                - b * (d * i - f * g)
                + c * (d * h - e * g);
    }
}
