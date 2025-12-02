
import java.util.Date;

public class Empleados implements java.io.Serializable {

    private static final long serialVersionUID = 1L;
    private int empNo;
    private Departamento departamento;
    private String apellido;
    private String oficio;
    private int dir;
    private Date fechaAlt;
    private Float salario;
    private Float comision;

    //constructores
    public Empleados() {
    }

    public Empleados(int empNo, Departamento departamento) {
        this.empNo = empNo;
        this.departamento = departamento;
    }

    public Empleados(int empNo, Departamento departamento,
            String apellido, String oficio, int dir, Date fechaAlt,
            Float salario, Float comision) {
        this.empNo = empNo;
        this.departamento = departamento;
        this.apellido = apellido;
        this.oficio = oficio;
        this.dir = dir;
        this.fechaAlt = fechaAlt;
        this.salario = salario;
        this.comision = comision;
    }

    public int getEmpNo() {
        return this.empNo;
    }

    public void setEmpNo(int empNo) {
        this.empNo = empNo;
    }

    public Departamento getDepartamento() {
        return this.departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public String getApellido() {
        return this.apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getOficio() {
        return this.oficio;
    }

    public void setOficio(String oficio) {
        this.oficio = oficio;
    }

    public int getDir() {
        return this.dir;
    }

    public void setDir(int dir) {
        this.dir = dir;
    }

    public Date getFechaAlt() {
        return this.fechaAlt;
    }

    public void setFechaAlt(Date fechaAlt) {
        this.fechaAlt = fechaAlt;
    }

    public Float getSalario() {
        return this.salario;
    }

    public void setSalario(Float salario) {
        this.salario = salario;
    }

    public Float getComision() {
        return this.comision;
    }

    public void setComision(Float comision) {
        this.comision = comision;
    }
} //..
