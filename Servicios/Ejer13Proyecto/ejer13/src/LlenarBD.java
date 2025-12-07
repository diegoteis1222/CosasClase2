
import com.db4o.ObjectContainer;
import java.util.HashSet;
import java.util.Date;

public class LlenarBD {

    public static void main(String[] args) {
        // 1. Abrimos la conexión (esto crea el archivo EMPLEDEP.YAP si no existe)
        ObjectContainer db = Conexion.getDBConexion();

        try {
            // --- Crear Departamento 10: CONTABILIDAD ---
            Departamento dep10 = new Departamento(10, "CONTABILIDAD", "SEVILLA", new HashSet<Empleados>());

            // Crear un empleado para el dep 10
            Empleados emp1 = new Empleados(7369, dep10, "SANCHEZ", "EMPLEADO", 7902, new Date(), 1040.0f, 0f);
            // Añadir el empleado al set del departamento (importante para la relación)
            dep10.getEmpleados().add(emp1);

            // --- Crear Departamento 20: INVESTIGACION ---
            Departamento dep20 = new Departamento(20, "INVESTIGACION", "MADRID", new HashSet<Empleados>());

            Empleados emp2 = new Empleados(7499, dep20, "ARROYO", "VENDEDOR", 7698, new Date(), 1500.0f, 300.0f);
            Empleados emp3 = new Empleados(7521, dep20, "SALA", "VENDEDOR", 7698, new Date(), 1625.0f, 500.0f);

            dep20.getEmpleados().add(emp2);
            dep20.getEmpleados().add(emp3);

            // --- Crear Departamento 30: VENTAS ---
            Departamento dep30 = new Departamento(30, "VENTAS", "BARCELONA", new HashSet<Empleados>());

            // 2. Guardar en la base de datos (db4o guarda en cascada si está configurado, 
            // pero por seguridad guardamos los departamentos que contienen a los empleados)
            db.store(dep10);
            db.store(dep20);
            db.store(dep30);

            System.out.println("Base de datos EMPLEDEP.YAP generada con datos de prueba.");

        } finally {
            // 3. Cerrar la conexión para liberar el archivo
            db.close();
        }
    }
}
