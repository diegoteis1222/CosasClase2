public class Mamifero {

    String especie, color;

    public Mamifero(String especio, String color) {
        this.especie = especio;
        this.color = color;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especio) {
        this.especie = especio;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Mamifero [especio=" + especie + ", color=" + color + "]";
    }

    public void caminar() {
        System.out.println("El mamifero camina, Epico la verdad");
    }

}
