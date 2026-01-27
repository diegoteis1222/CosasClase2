import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Utiles {

    public static BufferedReader getBufferedReader(String nombreFichero) throws IOException {

        BufferedReader bufferedReader;
        FileReader fileReader;

        fileReader = new FileReader(nombreFichero);
        bufferedReader = new BufferedReader(fileReader);
        return bufferedReader;

    }

    public static PrintWriter getPrintWriter(String nombreFichero) throws IOException {

        PrintWriter printWriter;
        FileWriter fileWriter;

        fileWriter = new FileWriter(nombreFichero);
        printWriter = new PrintWriter(fileWriter);
        return printWriter;
    }

    public static ArrayList<String> getLineasFichero(String nombreFichero) throws IOException {

        ArrayList<String> lineas = new ArrayList<>();
        BufferedReader bfr = getBufferedReader(nombreFichero);
        String linea;

        bfr = getBufferedReader(nombreFichero);

        while ((linea = bfr.readLine()) != null) {
            lineas.add(linea);
        }

        bfr.close();
        return lineas;
    }
}