public class IftNeutro implements ItfImpresion, ItfImpresion2 {

    @Override
    public void imprimir() {
        System.out.println("Las olas del mar");

    }

    @Override
    public void imprimirBonito() {
        System.out.println("--- Las olas del mar ---");
    }

}
