package modelo;

public class Usuario {

    private String nombre, email;
    static int contadorUsuarios;

    public Usuario(String nombre, String email) {
        this.nombre = nombre;
        this.email = email;
        contadorUsuarios++;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public static int getContadorUsuarios() {
        return contadorUsuarios;
    }

    public static void setContadorUsuarios(int contadorUsuarios) {
        Usuario.contadorUsuarios = contadorUsuarios;
    }

    public String mostrarInfo() {
        return "Usuario [nombre=" + nombre + ", email=" + email + "]";
    }

    

}
