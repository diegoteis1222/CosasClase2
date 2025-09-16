public class congeladosAire extends productosCongelados {

    private String InformacionComposicion;

    public congeladosAire(String fechaCaducidad, int numeroLote, int temperaturaCongelacion,
            String informacionComposicion) {
        super(fechaCaducidad, numeroLote, temperaturaCongelacion);
        InformacionComposicion = informacionComposicion;
    }

    public String getInformacionComposicion() {
        return InformacionComposicion;
    }

    public void setInformacionComposicion(String informacionComposicion) {
        InformacionComposicion = informacionComposicion;
    }

    @Override
    public String toString() {
        return "congeladosAire [InformacionComposicion=" + InformacionComposicion + ", toString()=" + super.toString()
                + "]";
    }

}
