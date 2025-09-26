public class Mamifero {

    String especio, color;

    public Mamifero(String especio, String color) {
        this.especio = especio;
        this.color = color;
    }

    public String getEspecio() {
        return especio;
    }

    public void setEspecio(String especio) {
        this.especio = especio;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Mamifero [especio=" + especio + ", color=" + color + "]";
    }

    public void caminar() {
        System.out.println("El mamifero camina, Epico la verdad");
    }

}
