package AcesoDatos.Ejercicios.Ejercicio2.app;

import AcesoDatos.Ejercicios.Ejercicio2.Modelo.Usuario;
import AcesoDatos.Ejercicios.Ejercicio2.Utilidades.Mensajes;

public class MainApp {

    public static void main(String[] args) {

        Usuario user1 = new Usuario();
        Usuario user2 = new Usuario("paco", "paco@email.es");

        user1.mostrarInfo();
        user2.mostrarInfo();

        Mensajes.mostrarSaludo("Paco");
        Mensajes.formatearMensaje("hola");

        System.out.println(Usuario.getContadorUsers());

    }
}
