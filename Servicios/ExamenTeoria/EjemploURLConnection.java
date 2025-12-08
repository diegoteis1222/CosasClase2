
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class EjemploURLConnection {

    public static void main(String[] args) throws Exception {

        URL url = new URL("http://localhost/index.php");

        // Creacion del objeto y apertura de la conexion mediante la url
        // esto es como descolgar el telefono, dejas escuchando
        URLConnection conexion = url.openConnection();

        // pone en pantalla la url
        System.out.println("Direccion [getURL()]:" + conexion.getURL());

        // Obtiene la fecha y la muestra por pantalla
        Date fecha = new Date(conexion.getLastModified());
        System.out.println("Fecha ultima modificacion [getLastModified()]: " + fecha);

        // Obtiene el tipo de archivo que hay en la url(si es un html, imagen, etc.) y lo muestra por pantalla
        System.out.println("Tipo de Contenido [getContentType()]: " + conexion.getContentType());

        System.out.println("========================================");
        System.out.println("TODOS LOS CAMPOS DE CABECERA CON getHeaderFields(): ");

        // getHeaderFields() devuelve un Map donde:
        // - Key (Clave): Nombre de la cabecera 
        // - Value (Valor): Una lista de Strings con los valores de esa cabecera.
        Map<String, List<String>> camposcabecera = conexion.getHeaderFields();

        // Se crea un iterador para recorrer el mapa de cabeceras
        Iterator<Map.Entry<String, List<String>>> it = camposcabecera.entrySet().iterator();

        // Bucle while para imprimir cada par Clave : Valor
        while (it.hasNext()) {
            Map.Entry<String, List<String>> map = it.next();
            System.out.println(map.getKey() + " : " + map.getValue());
        }

        System.out.println("========================================");
        System.out.println("CAMPOS 1 Y 4 DE CABECERA.");

        // getHeaderField(int n) permite obtener el valor de la cabecera en la posición n.
        System.out.println("getHeaderField(1)-> " + conexion.getHeaderField(1));
        System.out.println("getHeaderField(4)-> " + conexion.getHeaderField(4));
    }
}
