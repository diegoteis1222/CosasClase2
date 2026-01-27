import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

public class ProcesadorFichero {
    
    public static void hacerRecuentoVocal(String fichEntra, String letra, String fichSale) throws FileNotFoundException, IOException {

        char parametro = letra.charAt(0);

        BufferedReader bfr;
        bfr = Utiles.getBufferedReader(fichEntra);
        
        PrintWriter pw;
        pw = Utiles.getPrintWriter(fichSale);
        
        String lineaLeida;
        lineaLeida = bfr.readLine();

        int total = 0;
        while (lineaLeida != null) {
            for (int i = 0; i < lineaLeida.length(); i++) {
             
                char leida = lineaLeida.charAt(i);

                if (leida == parametro) {
                    total++;
                }
                
            }
            lineaLeida = bfr.readLine();
        }

        pw.println("Total de malditas " + letra + ": " + total);

        bfr.close();
        pw.close();
    }
}
