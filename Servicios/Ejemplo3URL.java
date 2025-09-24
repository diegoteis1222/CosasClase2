import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;

public class Ejemplo3URL {
    public static void main(String[] args) throws Exception { // Se aÃ±ade 'throws Exception' para manejar errores de
                                                              // red y de I/O
        String cadena;
        URL url = new URL("http://localhost/index.php");
        URLConnection conexion = url.openConnection();

        System.out.println("Direccion [getURL()]:" + conexion.getURL());

        Date fecha = new Date(conexion.getLastModified());
        System.out.println("Fecha ultima modificacion [getLastModified()]: " + fecha);
        System.out.println("Tipo de Contenido [getContentType()]: " + conexion.getContentType());

        System.out.println("========================================");
        System.out.println("TODOS LOS CAMPOS DE CABECERA CON getHeaderFields(): ");

        // USAMOS UNA ESTRUCTURA Map PARA RECUPERAR CABECERAS
        Map camposcabecera = conexion.getHeaderFields();
        Iterator it = camposcabecera.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry map = (Map.Entry) it.next();
            System.out.println(map.getKey() + " : " + map.getValue());
        }

        System.out.println("========================================");
        System.out.println("CAMPOS 1 Y 4 DE CABECERA.");
        System.out.println("getHeaderField(1)-> " + conexion.getHeaderField(1));
        System.out.println("getHeaderField(4)-> " + conexion.getHeaderField(4));

    }
}