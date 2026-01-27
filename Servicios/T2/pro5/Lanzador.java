import java.io.FileNotFoundException;
import java.io.IOException;

public class Lanzador {
    public static void main(String[] args) throws FileNotFoundException, IOException {

        String fichEntra = "fichero.txt";
        String letra = "o";
        String fichResultado = "resultado.txt";
        
        ProcesadorFichero.hacerRecuentoVocal(fichEntra, letra, fichResultado);
    }
}