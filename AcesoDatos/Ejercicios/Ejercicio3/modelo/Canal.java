package modelo;

public class Canal {

    public static final int MAX_USUARIOS = 8;
    public static final int MAX_MENSAJES = 8;
    public static final String NOMBRE = "CANAL";

    static void prefijo() {
        System.out.println("[ " + NOMBRE + " ]");
    }

    private Canal() {
    }
}
