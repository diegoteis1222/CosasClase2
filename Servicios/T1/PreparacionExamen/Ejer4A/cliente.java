
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class cliente {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        ArrayList<Asignatura> asignaturas = new ArrayList<Asignatura>();

        asignaturas.add(new Asignatura("Programacion", "1DAM"));
        asignaturas.add(new Asignatura("Bases de Datos", "1DAM"));
        asignaturas.add(new Asignatura("Lenguaje de Marcas", "1DAM"));
        asignaturas.add(new Asignatura("Sistemas Informaticos", "1DAM"));
        asignaturas.add(new Asignatura("Entornos de Desarrollo", "1DAM"));
        asignaturas.add(new Asignatura("FOL", "1DAM"));

        asignaturas.add(new Asignatura("Acceso a Datos", "2DAM"));
        asignaturas.add(new Asignatura("Android", "2DAM"));
        asignaturas.add(new Asignatura("Desarrollo Web", "2DAM"));
        asignaturas.add(new Asignatura("Programacion de Servicios y Procesos", "2DAM"));
        asignaturas.add(new Asignatura("IPE", "2DAM"));
        asignaturas.add(new Asignatura("Afondamento", "2DAM"));

        String dir = "localhost";
        int puerto = 6600;
    
        Socket socket = new Socket(dir, puerto);
        System.out.println("Conectado al servidor");

        System.out.println("Pon las notas a las asignaturas:");
        for (Asignatura asignatura : asignaturas) {
            asignatura.establecerNota();
        }

        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        out.writeObject(asignaturas);
        System.out.println("Array enviado al servidor.");

        ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
        String resultado = (String) ois.readObject();
        System.out.println("Tus medias son: " + resultado);

        out.close();
        ois.close();
        socket.close();
        sc.close();

        System.out.println("Conexión cerrada.");

    }
}
