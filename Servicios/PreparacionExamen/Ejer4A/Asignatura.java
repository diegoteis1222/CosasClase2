
import java.io.Serializable;
import java.util.Scanner;

public class Asignatura implements Serializable {

    private String nombre;
    private String curso;
    private double nota;

    public Asignatura(String nombre, String curso) {
        this.nombre = nombre;
        this.curso = curso;
        this.nota = 0.0;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public void establecerNota() {
        Scanner sc = new Scanner(System.in);
        double notaUsuario = 0;

        do {
            System.out.print("dame la nota de " + this.nombre + " para el curso: " + this.curso + " : ");

            notaUsuario = sc.nextDouble();

            if (notaUsuario < 0 || notaUsuario > 10) {
                System.out.println("debe estar entre 0 y 10");
            }

        } while (notaUsuario < 0 || notaUsuario > 10);

        this.nota = notaUsuario;
    }

}
