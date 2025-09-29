public class loro extends Mamifero implements PuedeCaminar {

    public loro(String especio, String color) {
        super(especio, color);
    }

    @Override
    public String toString() {
        return "loro [especie=" + especie + ", color=" + color + "]";
    }

    @Override
    public void caminar() {
        System.out.println("El loro puede caminar");
    }

}
