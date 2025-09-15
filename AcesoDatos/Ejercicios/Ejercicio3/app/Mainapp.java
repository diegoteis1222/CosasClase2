package app;

import modelo.Usuario;
import servicio.RegistroMensajes;
import servicio.ResgistroUsuarios;

public class Mainapp {

    public static void main(String[] args) {

        Usuario paco = new Usuario("Paco", "paco@email.es");
        Usuario javi = new Usuario("Javi", "javi.email.es");

        paco.mostrarInfo();
        javi.mostrarInfo();

        RegistroMensajes.enviar(javi.getNombre(), paco.getNombre(), "AAAAAAAAAAAAAAAAAAAAH");

        System.out.println("Total de usurios creados: " + Usuario.getContadorUsuarios());
        System.out.println("Total de usuarios registrados: " + ResgistroUsuarios.getTotalUsuarios());
        System.out.println("Todal de mensajes enviados: " + RegistroMensajes.getTotalMensajes());

    }
}
