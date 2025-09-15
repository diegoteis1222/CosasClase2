package utilidades;

public class Mensajes {

    public static final String saludo = "Buenas ";

    public static void mostrarSaludo(String nombre) {

        System.out.println(saludo + nombre);
    }

    public static final void formatearMensaje(String mensage) {

        System.out.println("[ " + mensage + " ]");
    }

}
