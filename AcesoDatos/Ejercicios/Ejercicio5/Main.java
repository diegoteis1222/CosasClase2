public class Main {

    public static void main(String[] args) {

        ListaMultimedia lista1 = new ListaMultimedia(10);

        Pelicula scarface = new Pelicula("caraCicatriz", "tipo", 15, Formato.avi, "alguien", null);
        Pelicula terminator = new Pelicula("terminator", "mamado", 20, Formato.avi, "mamado", null);
        Pelicula alien = new Pelicula("alien", "tipa", 12, Formato.avi, null, "tipa");

        lista1.add(scarface);
        lista1.add(terminator);
        lista1.add(alien);

        for (int i = 0; i < lista1.size(); i++) {
            System.out.println(lista1.get(i));
        }
    }
}
