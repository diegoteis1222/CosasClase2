
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class Lanzador {

    static final int NUM_PROCESOS = 4;
    static final String PREFIJO_FICHEROS = "fich";

    public void lanzarSumador(Integer n1, Integer n2, String fichResultado) {

        String clase = "Sumador.java";
        ProcessBuilder pb;

        try {
            pb = new ProcessBuilder("java", "-cp", "bin", clase, n1.toString(), n2.toString());
            pb.redirectOutput(new File(fichResultado));
            pb.start();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static int getResultadoFichero(String nombreFichero) {
        int resultado = 0;
        try {
            FileInputStream fichero = new FileInputStream(nombreFichero);
            InputStreamReader fir = new InputStreamReader(fichero);
            BufferedReader br = new BufferedReader(fir);

            String linea = br.readLine();
            resultado = Integer.parseInt(linea);
            return resultado;
        } catch (FileNotFoundException e) {
            System.out.println("El fichero " + nombreFichero + " no se puede abrir");
        } catch (IOException e) {
            System.out.println("No hay nada en " + nombreFichero);
        }
        return resultado;
    }

    public static int getSumaTotal(int numFicheros) {
        int sumaTotal = 0;
        for (int i = 1; i <= NUM_PROCESOS; i++) {

            int parcial = getResultadoFichero(PREFIJO_FICHEROS + String.valueOf(i));
            System.out.println("Parcial leido de " + PREFIJO_FICHEROS + String.valueOf(i) + ": " + parcial);
            sumaTotal += parcial;
        }
        return sumaTotal;

    }

    public static void main(String[] args) {

        // lo hice con este comando: java .\Lanzador.java 50 5000
        // de esta forma se lanza con los parametros n1 = 50 y n2 = 5000
        Lanzador l = new Lanzador();

        int n1 = Integer.parseInt(args[0]);
        int n2 = Integer.parseInt(args[1]);
        int salto = (n2 / NUM_PROCESOS) - 1;

        for (int i = 1; i <= NUM_PROCESOS; i++) {
            System.out.println("n1:" + n1);
            int resultadoSumaConSalto = n1 + salto;
            System.out.println("n2:" + resultadoSumaConSalto);
            l.lanzarSumador(n1, n1 + salto, PREFIJO_FICHEROS + String.valueOf(i));
            n1 = n1 + salto + 1;
            System.out.println("Suma lanzada...");
        }

        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            System.getLogger(Lanzador.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }

        int sumaTotal = getSumaTotal(NUM_PROCESOS);
        System.out.println("La suma total es:" + sumaTotal);

        // Viejo test
        l.lanzarSumador(1, 200, "result1.txt");
        l.lanzarSumador(201, 400, "result2.txt");
        System.out.println("Ok");
    }
}
