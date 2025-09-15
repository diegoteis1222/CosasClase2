package servicio;

import modelo.Canal;
import modelo.Usuario;

public class ResgistroUsuarios {

    public static Usuario[] usuarios = new Usuario[Canal.MAX_USUARIOS];

    static int contador = 0;

    public static void altaUsuario(Usuario u) {

        while (usuarios.length < Canal.MAX_USUARIOS && !buscarPorEmail(u.getEmail())) {
            usuarios[contador] = u;
            contador++;
        }
    }

    public static boolean buscarPorEmail(String email) {

        for (int i = 0; i < usuarios.length; i++) {
            if (usuarios[i].getEmail().equals(email)) {
                return true;
            }
        }

        return false;
    }

    public static void listar() {

        for (int i = 0; i > contador; i++) {
            System.out.println(usuarios[i]);
        }
    }

    public static int getTotalUsuarios() {
        return usuarios.length;
    }
}
