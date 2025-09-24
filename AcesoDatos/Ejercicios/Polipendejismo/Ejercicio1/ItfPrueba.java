public class ItfPrueba {
    public static void main(String[] args) {
        float[] Notas = { 3, 6, 8, 10, 2, 5, 7, 9, 10 };
        CCentroDeEstudios MiAula = new CCentroDeEstudios();
        System.out.println("Aprobados: " + MiAula.NumeroDeAprobados(Notas));
        System.out.println("Suspensos: " + MiAula.NumeroDeSuspensos(Notas));
        System.out.println("Media: " + MiAula.NotaMedia(Notas));
        System.out.println("Varianza: " + MiAula.Varianza(Notas));
        System.out.println("Matriculas de Honor: " + MiAula.MatriculaHonor(Notas));
    }
}
