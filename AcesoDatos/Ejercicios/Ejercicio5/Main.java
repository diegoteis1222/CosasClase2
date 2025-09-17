import java.text.Normalizer.Form;

public class Main {

    public static void main(String[] args) {

        // Parte D
        ListaMultimedia lista1 = new ListaMultimedia(10);

        Pelicula scarface = new Pelicula("caraCicatriz", "tipo", 15, Formato.avi, "alguien", null);
        Pelicula terminator = new Pelicula("terminator", "mamado", 20, Formato.avi, "mamado", null);
        Pelicula alien = new Pelicula("alien", "tipa", 12, Formato.avi, null, "tipa");

        lista1.add(scarface);
        lista1.add(terminator);
        lista1.add(alien);

        System.out.println("------- LISTA 1 -------");

        for (int i = 0; i < lista1.size(); i++) {
            System.out.println(lista1.get(i));
        }

        System.out.println();

        // Parte F
        ListaMultimedia lista2 = new ListaMultimedia(20);

        Pelicula scarface2 = new Pelicula("caraCicatriz", "tipo", 15, Formato.avi, "alguien", null);
        Pelicula terminator2 = new Pelicula("terminator", "mamado", 20, Formato.avi, "mamado", null);
        Pelicula alien2 = new Pelicula("alien", "tipa", 12, Formato.avi, null, "tipa");

        lista2.add(scarface2);
        lista2.add(terminator2);
        lista2.add(alien2);

        Disco paco = new Disco("Paco", "paco", 12, Formato.cdAudio, Genero.pop);

        lista2.add(paco);

        System.out.println("------- LISTA 2 -------");

        for (int i = 0; i < lista2.size(); i++) {
            System.out.println(lista2.get(i));
        }

        System.out.println( );
    }
}
