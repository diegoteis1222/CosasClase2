public class congeladosNitrogeno extends productosCongelados {

    private String metodoCongelacion;
    private int tiempoExposicion;

    public congeladosNitrogeno(String fechaCaducidad, int numeroLote, int temperaturaCongelacion,
            String metodoCongelacion, int tiempoExposicion) {
        super(fechaCaducidad, numeroLote, temperaturaCongelacion);
        this.metodoCongelacion = metodoCongelacion;
        this.tiempoExposicion = tiempoExposicion;
    }

    public String getMetodoCongelacion() {
        return metodoCongelacion;
    }

    public void setMetodoCongelacion(String metodoCongelacion) {
        this.metodoCongelacion = metodoCongelacion;
    }

    public int getTiempoExposicion() {
        return tiempoExposicion;
    }

    public void setTiempoExposicion(int tiempoExposicion) {
        this.tiempoExposicion = tiempoExposicion;
    }

    @Override
    public String toString() {
        return "congeladosNitrogeno [metodoCongelacion=" + metodoCongelacion + ", tiempoExposicion=" + tiempoExposicion
                + ", toString()=" + super.toString() + "]";
    }

}
