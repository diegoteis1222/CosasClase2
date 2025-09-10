
import java.util.Scanner;

public class Coche {

    Scanner sc = new Scanner(System.in);

    private String marca, modelo, color;
    private int año;
    private double km;
    private static int numCoches = 0;

    public Coche() {
        this.marca = "Pendejo";
        this.modelo = "coche";
        this.color = "rojo";
        this.año = 2;
        this.km = 3;
        numCoches++;
    }

    public Coche(String marca, String modelo, String color, int año, double km) {
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.año = año;
        this.km = km;
        numCoches++;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public double getKm() {
        return km;
    }

    public void setKm(double km) {
        this.km = km;
    }

    public static int getNumCoches() {
        return numCoches;
    }

    public static void setNumCoches(int numCoches) {
        Coche.numCoches = numCoches;
    }

    @Override
    public String toString() {
        return "Coche [marca=" + marca + ", modelo=" + modelo + ", color=" + color + ", año=" + año + ", km=" + km
                + "]";
    }

    public void conducir(double km) {
        double actuales = getKm();
        setKm(km + actuales);
    }

}
