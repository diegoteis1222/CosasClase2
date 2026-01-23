
import java.util.Random;

public class corredor implements Runnable {

    private String nombre;
    private static final String ganador = null;

    public corredor(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void run() {

        int distanciaRecorrida = 0;
        Random random = new Random();

        while (distanciaRecorrida < 100) {
            try {

                Thread.sleep(random.nextInt(400) + 100);
                int avance = random.nextInt(10) + 1;
                distanciaRecorrida += avance;

                System.out.println(nombre + " ha avanzado " + avance + " metros. Distancia total: " + distanciaRecorrida + " metros.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        synchronized (corredor.class) {
            if (ganador == null) {
                System.out.println(nombre + " ha ganado la carrera!");
            }
        }
    }

}
