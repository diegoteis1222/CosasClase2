class Elevador {

    private int paquetesActuales = 0;
    private int pesoActual = 0;
    private final int MAX_PAQUETES = 4;
    private final int MAX_PESO = 200;

    // Operación Sincronizada para Cargar
    public synchronized void carga_paquete(int id, int peso) throws InterruptedException {
        // Bloquea si está lleno O si el peso sobrepasaría el límite
        while (paquetesActuales >= MAX_PAQUETES || (pesoActual + peso) > MAX_PESO) {
            System.out.println("Hilo " + id + " (" + peso + "kg) ESPERANDO. Estado: " + paquetesActuales + " paq, "
                    + pesoActual + "kg.");
            wait();
        }

        // Cargar paquete
        paquetesActuales++;
        pesoActual += peso;
        System.out.println("-> Hilo " + id + " CARGADO (" + peso + "kg). Elevador: [" + paquetesActuales + " paq, "
                + pesoActual + "kg]");
    }

    // Operación Sincronizada para Descargar
    public synchronized void descarga_paquete(int id, int peso) {
        paquetesActuales--;
        pesoActual -= peso;
        System.out.println(
                "<- Hilo " + id + " DESCARGADO. Elevador: [" + paquetesActuales + " paq, " + pesoActual + "kg]");

        // Desbloquea a los hilos que están esperando
        notifyAll();
    }
}