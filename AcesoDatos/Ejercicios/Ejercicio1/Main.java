
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Tengo sueño");

        Coche coche1 = new Coche();
        Coche coche2 = new Coche();
        Coche coche3 = new Coche();

        coche1.setAño(1);
        coche2.setAño(2);
        coche3.setAño(3);

        coche1.setKm(12);

        System.out.println(coche1);
        System.out.println(coche2);
        System.out.println(coche3);

        coche1.conducir(12);

        System.out.println("Tras suma:");
        System.out.println(coche1);

        coche2.setColor("pendejo");

        System.out.println("Tras cambio de color:");
        System.out.println(coche2);

        System.out.println("Creados " + Coche.getNumCoches() + " putos coches");

        sc.close();
    }

}