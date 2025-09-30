import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Introduce la capacidad de la piscina (en litros): ");
        int capacidad = sc.nextInt();

        Piscina p = new Piscina(capacidad);

        try {
            System.out.println("Llenando 50 litros...");
            p.llenar(50);
            System.out.println("Nivel actual: " + p.getNivel());

            System.out.println("Llenando 1000 litros...");
            p.llenar(1000); // Posible excepción
            System.out.println("Nivel actual: " + p.getNivel());
        } catch (Exception e) {
            System.out.println("Excepción capturada: " + e.getMessage());
        }

        try {
            System.out.println("Vaciando 70 litros...");
            p.vaciar(70); // Posible excepción
            System.out.println("Nivel actual: " + p.getNivel());
        } catch (Exception e) {
            System.out.println("Excepción capturada: " + e.getMessage());
        }

        sc.close();
    }
}
