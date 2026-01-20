import java.io.Serializable;
import java.util.ArrayList;

public class Producto implements Serializable{

    final static int IVA = 21;

    String nombre;
    int unidades;
    double precioUnidad;

    static String[] productos = {
            "Leche",
            "Huevos",
            "Pan de molde",
            "Manzanas",
            "Plátanos",
            "Atún en lata",
            "Patatas",
            "Cebollas",
            "Ajo",
            "Jabón de manos",
            "Papel higiénico",
            "Detergente para ropa",
            "Pasta de dientes",
            "Guisantes congelados",
            "Pizza congelada",
            "Galletas",
            "Harina de trigo",
            "Lentejas"
    };

    public static double inventaPrecio() {
        double min = 0.68;
        double max = 4.25;

        return min + (Math.random() * (max - min));
    }

    public static String inventaProducto() {
        int max = productos.length - 1;

        return productos[(int) (Math.random() * max)];
    }

    public static int inventaUnidades() {
        int min = 1;
        int max = 8;

        return (int) (min + (Math.random() * (max - min)));
    }

    public Producto() {
        this.nombre = inventaProducto();
        this.unidades = inventaUnidades();
        this.precioUnidad = inventaPrecio();
    }

    @Override
    public String toString() {
        return "Producto [nombre=" + nombre + ", unidades=" + unidades + ", precioUnidad=" + precioUnidad + "]";
    }

    public static ArrayList<Producto> generaCarrito() {
        int numero = (int) (1 + (Math.random() * (6 - 1)));
        ArrayList<Producto> generado = new ArrayList<Producto>();

        for (int i = 0; i < numero; i++) {
            generado.add(new Producto());
        }

        muestraCarrito(generado);
        return generado;
    }

    public static void muestraCarrito(ArrayList<Producto> productos) {
        for (Producto p : productos) {
            System.out.println(p);
        }
    }

    public static String generarTicket(ArrayList<Producto> productos) {
        double total = 0d;

        for (Producto p : productos) {
            total += (p.precioUnidad * p.unidades);
        }

        double iva = total * IVA / 100;
        double pvp = total + iva;

        return "total compra: " + total + "\n iva (21%): " + iva + "\n total final: " + pvp;
    }

}
