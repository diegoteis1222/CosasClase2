public class gato extends Mamifero implements PuedeNadar, PuedeCaminar {
    
    public gato(String especio, String color) {
        super(especio, color);
    }

    @Override
    public String toString() {
        return "gato [especie=" + especie + ", color=" + color + "]";
    }

    @Override
    public void nadar() {
        System.out.println("El gato puede nadar");
    }

    @Override
    public void caminar() {
        System.out.println("El gato puede caminar");
    }
}
