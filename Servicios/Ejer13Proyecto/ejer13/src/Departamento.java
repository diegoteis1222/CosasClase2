
import java.util.HashSet;
import java.util.Set;

public class Departamento implements java.io.Serializable {

    private static final long serialVersionUID = 1L;
    private int deptNo;
    private String dnombre;
    private String loc;
    private Set<Empleados> empleados = new HashSet<Empleados>(0);

    //constructores
    public Departamento() {
    }

    public Departamento(int deptNo) {
        this.deptNo = deptNo;
    }

    public Departamento(int deptNo, String dnombre, String loc,
            Set<Empleados> empleadoses) {
        this.deptNo = deptNo;
        this.dnombre = dnombre;
        this.loc = loc;
        this.empleados = empleados;
    }

    public int getDeptNo() {
        return this.deptNo;
    }

    public void setDeptNo(int i) {
        this.deptNo = i;
    }

    public String getDnombre() {
        return this.dnombre;
    }

    public void setDnombre(String dnombre) {
        this.dnombre = dnombre;
    }

    public String getLoc() {
        return this.loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    public Set<Empleados> getEmpleados() {
        return this.empleados;
    }

    public void setEmpleados(Set<Empleados> empleados) {
        this.empleados = empleados;
    }
} //..Departamento
