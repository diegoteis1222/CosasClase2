public class ItfPrueba {

    public static void main(String[] args) {
        // Uso de polimorfismo: referencias de interfaces
        ItfImpresion positivo = new ItfPositivoImpresion();
        ItfImpresion negativo = new ItfNegativoImpresion();
        ItfImpresion neutro = new IftNeutro();

        // Llamada al método imprimir usando polimorfismo
        System.out.println("=== Método imprimir() ===");
        positivo.imprimir();
        negativo.imprimir();
        neutro.imprimir();

        // Llamada al método imprimirBonito de ItfNeutro
        System.out.println("\n=== Método imprimirBonito() ===");
        if (neutro instanceof ItfImpresion2) {
            ((IftNeutro) neutro).imprimirBonito();
        }
    }
}