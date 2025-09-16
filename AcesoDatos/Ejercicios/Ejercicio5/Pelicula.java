public class Pelicula extends Multimedia {

    protected String actorPrincipal, actrizPrincipal;

    public Pelicula(String titulo, String actor, int duracion, Formato formato, String actorPrincipal,
            String actrizPrincipal){
        super(titulo, actor, duracion, formato);
        this.actorPrincipal = actorPrincipal;
        this.actrizPrincipal = actrizPrincipal;

        if (this.actorPrincipal == null && this.actrizPrincipal.equals(null)) {
            throw new IllegalArgumentException("No pueden ser ambos actores principales null");
        }

    }

    public String getActorPrincipal() {
        return actorPrincipal;
    }

    public void setActorPrincipal(String actorPrincipal) {
        this.actorPrincipal = actorPrincipal;
    }

    public String getActrizPrincipal() {
        return actrizPrincipal;
    }

    public void setActrizPrincipal(String actrizPrincipal) {
        this.actrizPrincipal = actrizPrincipal;
    }

    @Override
    public String toString() {
        return "Pelicula [actorPrincipal=" + actorPrincipal + ", actrizPrincipal=" + actrizPrincipal + ", toString()="
                + super.toString() + "]";
    }



}
