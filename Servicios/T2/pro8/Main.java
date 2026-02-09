public class Main {
    public static void main(String[] args) {
        Hotel hotel = new Hotel();

        for (int i = 1; i <= 50; i++) {
            new Persona(i, hotel).start();
        }
    }
}
