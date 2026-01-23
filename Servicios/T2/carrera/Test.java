
public class Test {

    public static void main(String[] args) {
        Thread corredor1 = new Thread(new corredor("Corredor 1"));
        Thread corredor2 = new Thread(new corredor("Corredor 2"));
        Thread corredor3 = new Thread(new corredor("Corredor 3"));

        corredor1.start();
        corredor2.start();
        corredor3.start();
    }
}
