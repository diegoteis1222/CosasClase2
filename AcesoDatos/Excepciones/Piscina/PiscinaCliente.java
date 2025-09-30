import java.util.Random;

public class PiscinaCliente {

    public static void operacionesPiscina(Piscina p) {
        Random rand = new Random();

        for (int i = 1; i <= 3; i++) {
            try {
                // Llenar con valor aleatorio
                int cantidadLlenar = rand.nextInt(100);
                System.out.println("Intentando llenar con: " + cantidadLlenar);
                p.llenar(cantidadLlenar);
                System.out.println("Nivel después de llenar: " + p.getNivel());

                // Vaciar con valor aleatorio
                int cantidadVaciar = rand.nextInt(100);
                System.out.println("Intentando vaciar con: " + cantidadVaciar);
                p.vaciar(cantidadVaciar);
                System.out.println("Nivel después de vaciar: " + p.getNivel());

            } catch (Exception e) {
                System.out.println("Excepción capturada: " + e.getMessage());
                System.out.println("Nivel actual de la piscina: " + p.getNivel());
            }
            System.out.println("--------------------------------");
        }
    }

    public static void main(String[] args) {
        Piscina p = new Piscina(150); // nivel máximo = 150
        operacionesPiscina(p);
    }
}
