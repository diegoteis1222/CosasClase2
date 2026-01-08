
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ListarFicheros {

    public static void main(String[] args) {
        List<String> comando = new ArrayList<>();

        String os = System.getProperty("os.name").toLowerCase();

        if (os.contains("win")) {
            comando.add("cmd.exe");
            comando.add("/c");
            comando.add("dir");
        } else {
            comando.add("ls");
        }

        ProcessBuilder pb = new ProcessBuilder(comando);

        File directorio = new File("miDire");

        if (directorio.exists() && directorio.isDirectory()) {
            pb.directory(directorio);
        } else {
            System.out.println("El directorio no existe o no es un directorio válido.");
            return;
        }

        pb.redirectErrorStream(true);

        try {
            Process proceso = pb.start();

            try (BufferedReader reader = new BufferedReader(new InputStreamReader(proceso.getInputStream()))) {
                String linea;

                System.out.println("Listado de ficheros:");
                while ((linea = reader.readLine()) != null) {
                    System.out.println(linea);
                }
            }

            int exitCode = proceso.waitFor();
            System.out.println("Proceso terminado con código de salida: " + exitCode);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
