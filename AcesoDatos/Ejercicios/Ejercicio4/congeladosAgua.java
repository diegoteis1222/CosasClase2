public class congeladosAgua extends productosCongelados {

    private String informacionComposicion;

    public congeladosAgua(String fechaCaducidad, int numeroLote, int temperaturaCongelacion,
            String informacionComposicion) {
        super(fechaCaducidad, numeroLote, temperaturaCongelacion);
        this.informacionComposicion = informacionComposicion;
    }

    public String getInformacionComposicion() {
        return informacionComposicion;
    }

    public void setInformacionComposicion(String informacionComposicion) {
        this.informacionComposicion = informacionComposicion;
    }

    @Override
    public String toString() {
        return "congeladosAgua [informacionComposicion=" + informacionComposicion + ", toString()=" + super.toString()
                + "]";
    }

}
