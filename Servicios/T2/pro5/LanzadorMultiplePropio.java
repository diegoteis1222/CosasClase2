import java.io.FileNotFoundException;
import java.io.IOException;

public class LanzadorMultiplePropio {

    // usando processbuilder lanza tantos procesos independientes
    // como necesitas para recorrer un hasmap de todas las letras minusculas
    // generando 5 ficheros de salido

    public static void main(String[] args) throws FileNotFoundException, IOException {

        lanzarProcesoMultiple("fichero.txt", "a", "resultadoA.txt");
        lanzarProcesoMultiple("fichero.txt", "e", "resultadoE.txt");
        lanzarProcesoMultiple("fichero.txt", "i", "resultadoI.txt");
        lanzarProcesoMultiple("fichero.txt", "o", "resultadoO.txt");
        lanzarProcesoMultiple("fichero.txt", "u", "resultadoU.txt");
    }

    public static void lanzarProcesoMultiple(String ficheroEntrada, String letraContar, String ficheroResultado)
            throws FileNotFoundException, IOException {

        String fichEntra = ficheroEntrada;
        String letra = letraContar;
        String fichResultado = ficheroResultado;

        ProcesadorFichero.hacerRecuentoVocal(fichEntra, letra, fichResultado);
    }
}
