public class Multimedia {

    protected String titulo, actor;
    protected int duracion;
    protected Formato formato;

    public Multimedia() {

    }

    public Multimedia(String titulo, String actor, int duracion, Formato formato) {
        this.titulo = titulo;
        this.actor = actor;
        this.duracion = duracion;
        this.formato = formato;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String aitor) {
        this.actor = aitor;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public Formato getFormato() {
        return formato;
    }

    public void setFormato(Formato formato) {
        this.formato = formato;
    }

    @Override
    public String toString() {
        return "Multimedia [titulo=" + titulo + ", aitor=" + actor + ", duracion=" + duracion + ", formato=" + formato
                + "]";
    }

    public boolean esIgual(Multimedia m){        
        return m.titulo.equals(m.actor);
    }

}
