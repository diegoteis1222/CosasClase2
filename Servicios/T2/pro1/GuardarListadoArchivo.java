
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class GuardarListadoArchivo {

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

        if (!directorio.exists()) {
            directorio.mkdirs();
        }
        pb.directory(directorio);

        File archivoSalida = new File(directorio, "listado.txt");
        pb.redirectOutput(archivoSalida);

        pb.redirectError(ProcessBuilder.Redirect.INHERIT);

        try {
            Process proceso = pb.start();

            int exitCode = proceso.waitFor();
            System.out.println("Proceso terminado con código de salida: " + exitCode);

            if (exitCode == 0) {
                System.out.println("Listado de ficheros:");
            } else {
                System.out.println("Error al listar los ficheros.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
