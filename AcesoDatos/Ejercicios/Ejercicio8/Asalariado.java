public class Asalariado {

    private String nombre;
    private long dni;
    private int diasVacaciones;
    private double salarioBase;

    public Asalariado(String nombre, long dni, int diasVacaciones, double salarioBase) {
        this.nombre = nombre;
        this.dni = dni;
        this.diasVacaciones = diasVacaciones;
        this.salarioBase = salarioBase;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public long getDni() {
        return dni;
    }

    public void setDni(long dni) {
        this.dni = dni;
    }

    public int getDiasVacaciones() {
        return diasVacaciones;
    }

    public void setDiasVacaciones(int diasVacaciones) {
        this.diasVacaciones = diasVacaciones;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

}
