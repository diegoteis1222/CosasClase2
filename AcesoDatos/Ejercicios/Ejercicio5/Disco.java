public class Disco extends Multimedia {

    Genero genero;

    public Disco(String titulo, String actor, int duracion, Formato formato, Genero genero) {
        super(titulo, actor, duracion, formato);
        this.genero = genero;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    @Override
    public String toString() {
        return "Disco [genero=" + genero + ", toString()=" + super.toString() + "]";
    }

}
