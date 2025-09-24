public interface CentroDeEstudios {
    byte NumeroDePisos = 5;
    byte NumeroDeAulas = 25;
    byte NumeroDeDespachos = 10;

    // resto de datos constantes
    short NumeroDeAprobados(float[] Notas);

    short NumeroDeSuspensos(float[] Notas);

    float NotaMedia(float[] Notas);

    float Varianza(float[] Notas);

    int MatriculaHonor(float[] Notas);
    // resto de metodos
}