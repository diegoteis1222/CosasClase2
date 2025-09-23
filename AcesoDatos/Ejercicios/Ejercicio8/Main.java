public class Main {
    public static void main(String[] args) {

        Asalariado empleado1 = new Asalariado("manuel", 12233445, 28, 1200);
        Asalariado empleado2 = new EmpleadoProduccion("juan", 234234234, 30, 1200, "noche");

        System.out.println("**************************************");

        System.out.println("Sueldo empleado1: ");
        System.out.println(empleado1.getSalarioBase());

        System.out.println("Sueldo empleado2: ");
        System.out.println(empleado2.getSalarioBase());

        Asalariado empleadoX;

        empleadoX = empleado1;
        empleado1 = empleado2;

        System.out.println("**************************************");

        System.out.println("Sueldo empleado1: ");
        System.out.println(empleado1.getSalarioBase());

        System.out.println("Sueldo empleado2: ");
        System.out.println(empleado2.getSalarioBase());

        System.out.println("**************************************");

        Asalariado empleado3 = new EmpleadoDistribucion("Antonio", 748297253, 35, 1200, "Caceres");

        empleado1 = empleadoX;

        System.out.println("Empleado1: ");
        System.out.println(empleado1.getNombre());
        System.out.println(empleado1.getSalarioBase() + "\n");

        System.out.println("Empleado2: ");
        System.out.println(empleado2.getNombre());
        System.out.println(empleado2.getSalarioBase());
        System.out.println(((EmpleadoProduccion) empleado2).getTurno() + "\n");

        System.out.println("Empleado3: ");
        System.out.println(empleado3.getNombre());
        System.out.println(empleado3.getSalarioBase());
        System.out.println(((EmpleadoDistribucion) empleado3).getRegion() + "\n");

        Asalariado[] array_sal = new Asalariado[3];
        array_sal[0] = empleado1;
        array_sal[1] = empleado2;
        array_sal[2] = empleado3;

        System.out.println("**************************************");

        for (int i = 0; i < array_sal.length; i++) {
            System.out.println("Sueldo de " + array_sal[i].getNombre() + " es: " + array_sal[i].getSalarioBase());
        }
    }
}
