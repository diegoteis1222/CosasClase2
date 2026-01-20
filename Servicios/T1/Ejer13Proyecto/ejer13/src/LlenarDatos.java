import com.db4o.ObjectContainer;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class LlenarDatos {

    public static void main(String[] args) {
        // Obtenemos la conexión a la base de datos
        // Esto creará automáticamente el archivo EMPLEDEP.YAP si no existe
        ObjectContainer db = Conexion.getDBConexion();

        try {
            // Comprobamos si ya existen departamentos para no duplicar datos
            if (db.queryByExample(Departamento.class).size() > 0) {
                System.out.println("La base de datos ya contiene datos. No se ha insertado nada.");
                return;
            }

            System.out.println("Insertando datos de prueba...");

            // --- CREACIÓN DEL DEPARTAMENTO 10: CONTABILIDAD ---
            Departamento dep10 = new Departamento(10, "CONTABILIDAD", "SEVILLA", new HashSet<Empleados>());
            
            // Creamos empleados para el Dept 10
            // Constructor: (empNo, departamento, apellido, oficio, dir, fechaAlt, salario, comision)
            Empleados emp1 = new Empleados(7782, dep10, "CEREZO", "DIRECTOR", 7839, new Date(), 2500f, 0f);
            Empleados emp2 = new Empleados(7839, dep10, "REY", "PRESIDENTE", 0, new Date(), 4500f, 0f);
            Empleados emp3 = new Empleados(7934, dep10, "MUÑOZ", "EMPLEADO", 7782, new Date(), 1600f, 0f);

            // Añadimos los empleados al Set del departamento
            dep10.getEmpleados().add(emp1);
            dep10.getEmpleados().add(emp2);
            dep10.getEmpleados().add(emp3);

            // Al guardar el departamento, db4o guarda también los empleados vinculados
            db.store(dep10);

            
            // --- CREACIÓN DEL DEPARTAMENTO 20: INVESTIGACION ---
            Departamento dep20 = new Departamento(20, "INVESTIGACION", "MADRID", new HashSet<Empleados>());
            
            Empleados emp4 = new Empleados(7566, dep20, "JIMENEZ", "DIRECTOR", 7839, new Date(), 2800f, 0f);
            Empleados emp5 = new Empleados(7369, dep20, "SANCHEZ", "EMPLEADO", 7902, new Date(), 1400f, 0f);
            
            dep20.getEmpleados().add(emp4);
            dep20.getEmpleados().add(emp5);
            
            db.store(dep20);
            
            
            // --- CREACIÓN DEL DEPARTAMENTO 30: VENTAS (Vacío) ---
            Departamento dep30 = new Departamento(30, "VENTAS", "BARCELONA", new HashSet<Empleados>());
            db.store(dep30);

            System.out.println("Datos guardados correctamente en EMPLEDEP.YAP");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Es CRUCIAL cerrar la conexión para asegurar que los datos se escriban en el disco
            Conexion.cerrarConexion();
        }
    }
}
