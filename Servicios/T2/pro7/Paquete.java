class Paquete implements Runnable {
    private int id;
    private Elevador elevador;
    private int peso;

    public Paquete(int id, Elevador elevador) {
        this.id = id;
        this.elevador = elevador;
        // Peso aleatorio entre 50 y 90
        this.peso = (int) (Math.random() * (90 - 50 + 1) + 50);
    }

    @Override
    public void run() {
        try {
            elevador.carga_paquete(id, peso);

            // Simula el tiempo que el paquete está dentro del elevador
            Thread.sleep((long) (Math.random() * 2000));

            elevador.descarga_paquete(id, peso);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}