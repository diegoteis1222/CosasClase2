public class Aves {
    
    String especie, color;

    public Aves(String especie, String color) {
        this.especie = especie;
        this.color = color;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Aves [especie=" + especie + ", color=" + color + "]";
    }

    
}
