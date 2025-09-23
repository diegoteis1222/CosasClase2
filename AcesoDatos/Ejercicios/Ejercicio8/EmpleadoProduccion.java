public class EmpleadoProduccion extends Asalariado {

    private String turno;

    public EmpleadoProduccion(String nombre, long dni, int diasVacaciones, double salarioBase, String turno) {
        super(nombre, dni, diasVacaciones, salarioBase);
        this.turno = turno;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    @Override
    public double getSalarioBase() {

        return super.getSalarioBase() + (super.getSalarioBase() * 0.15);
    }

}
