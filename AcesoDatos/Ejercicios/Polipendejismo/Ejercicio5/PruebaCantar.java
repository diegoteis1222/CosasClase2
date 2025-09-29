public class PruebaCantar {

    public static void main(String[] args) {

        Canario piolin = new Canario();
        Gallo claudio = new Gallo();
        Persona pavaroti = new Persona();
        Tenor luciano = new Tenor();

        piolin.cantar();
        claudio.cantar();
        pavaroti.cantar();
        luciano.cantar();

    }

    public static void hazCantar(PuedeCantar cantor) {
        cantor.cantar();
    }
}
