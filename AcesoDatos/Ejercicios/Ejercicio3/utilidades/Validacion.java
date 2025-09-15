package utilidades;

public final class Validacion {

    public static boolean esEmailValido(String email) {

        if (email.contains("@")) {
            return true;
        }

        return false;
    }

    public static boolean noVacio(String s) {

        if (s.isEmpty()) {
            return true;
        }

        return false;
    }

    private Validacion() {
    }

}
