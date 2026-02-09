public class Persona extends Thread {
    private int id;
    private Hotel hotel;

    public Persona(int id, Hotel hotel) {
        this.id = id;
        this.hotel = hotel;
    }

    @Override
    public void run() {
        try {
            hotel.entrar(id);

            // Simular estancia en el hotel
            Thread.sleep((long) (Math.random() * 4000 + 1000));

            hotel.salir(id);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
