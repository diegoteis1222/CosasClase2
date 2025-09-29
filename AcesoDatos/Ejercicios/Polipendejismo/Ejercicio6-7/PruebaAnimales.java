public class PruebaAnimales {
    public static void main(String[] args) {

        gato gato = new gato("Felix", "Naranja");
        loro loro = new loro("pepe", "Verde");

        System.out.println(gato.toString());
        gato.caminar();
        gato.nadar();

        System.out.println(loro.toString());
        loro.caminar();
    }
}
