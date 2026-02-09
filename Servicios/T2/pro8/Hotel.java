public class Hotel {
    private int camasLibres = 30;

    public synchronized void entrar(int idPersona) throws InterruptedException {
        while (camasLibres == 0) {
            System.out.println("Persona " + idPersona + " esperando, no hay camas libres.");
            wait();
        }
        camasLibres--;
        System.out.println("Persona " + idPersona + " entra. Camas libres: " + camasLibres);
    }

    public synchronized void salir(int idPersona) {
        camasLibres++;
        System.out.println("Persona " + idPersona + " sale. Camas libres: " + camasLibres);
        notifyAll(); // avisar a los que esperan
    }
}
