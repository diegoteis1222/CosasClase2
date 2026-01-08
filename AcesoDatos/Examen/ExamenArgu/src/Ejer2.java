
import java.io.BufferedReader;
import java.io.FileReader;

public class Ejer2 {

    public static void main(String[] args) {

        String nombreMasCaro = "";
        double masCaro = 0;

        try {
            BufferedReader reader = new BufferedReader(new FileReader("productos.txt"));
            String productoEntero = reader.readLine();

            while (productoEntero != null) {

                // hicimos algo parecido con pepe
                String[] completo = productoEntero.split(",");

                String nombre = completo[0];
                int precio = Integer.parseInt(completo[1].trim());

                if (precio > masCaro) {
                    masCaro = precio;
                    nombreMasCaro = nombre;
                }
            }
            System.out.println("El producto mas caro es: " + nombreMasCaro + " costando " + masCaro + " dineros");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
