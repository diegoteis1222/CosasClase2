
import java.io.Serializable;

public class Cuakero implements Serializable {

    // Atributos
    private String nombre;
    private int edad;
    private String colorPlumas;

    // Constructor
    public Cuakero(String nombre, int edad, String colorPlumas) {
        this.nombre = nombre;
        this.edad = edad;
        this.colorPlumas = colorPlumas;
    }

    // Métodos getters y setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getColorPlumas() {
        return colorPlumas;
    }

    public void setColorPlumas(String colorPlumas) {
        this.colorPlumas = colorPlumas;
    }

    // Método para que el cuakero haga cuak
    public void cuak() {
        System.out.println(nombre + " dice: Cuak cuak!");
    }

    // Método para mostrar información del cuakero
    public void mostrarInfo() {
        System.out.println("Cuakero: " + nombre);
        System.out.println("Edad: " + edad + " años");
        System.out.println("Color de plumas: " + colorPlumas);
    }
}
