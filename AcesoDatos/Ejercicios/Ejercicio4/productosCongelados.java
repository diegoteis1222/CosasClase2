public class productosCongelados extends productos {

    private int temperaturaCongelacion;

    public productosCongelados(String fechaCaducidad, int numeroLote, int temperaturaCongelacion) {
        super(fechaCaducidad, numeroLote);
        this.temperaturaCongelacion = temperaturaCongelacion;
    }

    public int getTemperaturaCongelacion() {
        return temperaturaCongelacion;
    }

    public void setTemperaturaCongelacion(int temperaturaCongelacion) {
        this.temperaturaCongelacion = temperaturaCongelacion;
    }

    @Override
    public String toString() {
        return "productosCongelados [temperaturaCongelacion=" + temperaturaCongelacion + ", toString()="
                + super.toString() + "]";
    }

}
