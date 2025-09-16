public class productosRefrigerados extends productos {

    private int codigoOrganismo;

    public productosRefrigerados(String fechaCaducidad, int numeroLote, int codigoOrganismo) {
        super(fechaCaducidad, numeroLote);
        this.codigoOrganismo = codigoOrganismo;
    }

    public int getCodigoOrganismo() {
        return codigoOrganismo;
    }

    public void setCodigoOrganismo(int codigoOrganismo) {
        this.codigoOrganismo = codigoOrganismo;
    }

    @Override
    public String toString() {
        return "productosRefrigerados [codigoOrganismo=" + codigoOrganismo + ", toString()=" + super.toString() + "]";
    }

}
