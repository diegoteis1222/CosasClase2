package AcesoDatos.Ejercicios.Ejercicio2.Modelo;

public class Usuario {

    private String nombre, email;

    static int contadorUsers;

    public Usuario() {
        this.nombre = "Ejemplo";
        this.email = "Pendejo@email.tumadre";
        contadorUsers++;
    }

    public Usuario(String nombre, String email) {
        this.nombre = nombre;
        this.email = email;
        contadorUsers++;
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

    public static int getContadorUsers() {
        return contadorUsers;
    }

    public static void setContadorUsers(int contadorUsers) {
        Usuario.contadorUsers = contadorUsers;
    }

    public String mostrarInfo() {
        return "Usuario [nombre=" + nombre + ", email=" + email + "]";
    }

}
