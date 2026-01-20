
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

//ACCESO A BD db4o
public class AccesoDatos {

    static ObjectContainer db;

    // Constructor
    public AccesoDatos() {
        db = Conexion.getDBConexion();
    }

    // Dispone del método procesarCadena() que recibe en un String el departamento a consultar.
    // Lo pasa a entero. Usa el método queryByExample() para obtener el departamento deseado, si lo
    // encuentra devolverá un objeto Departamentos y si no existe devolverá null:
    // Se procesa la cadena que manda el hilo con el dep a localizar
    synchronized Departamento procesarCadena(String str) {
        int i;
        Departamento d = null;
        try {
            i = Integer.parseInt(str);
        } catch (NumberFormatException n) {
            System.out.println("<<DEPARTAMENTO: " + str + " "
                    + "INCORRECTO>> ");
            return d;
        }

        // Creamos un objeto prototipo para buscar por QBE (Query By Example)
        // Se pasan nulls en los campos que no interesan para la búsqueda
        Departamento dep = new Departamento(i, null, null, null);
        ObjectSet<Departamento> result = db.queryByExample(dep);

        if (result.size() == 0) {
            System.out.println("<<DEPARTAMENTO: " + i + " NO EXISTE>> ");
        } else {
            d = result.next();
        }
        return d; // devuelve un objeto Departamentos
    } //procarCadena
} //..fin AccesoDatos
