package modelo;

public class Mensaje {

    private int id;
    private String remitente, destinatario, texto;

    public Mensaje(int id, String remitente, String destinatario, String texto) {
        this.id = id;
        this.remitente = remitente;
        this.destinatario = destinatario;
        this.texto = texto;
    }

    public int getId() {
        return id;
    }

    public String getRemitente() {
        return remitente;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public String getTexto() {
        return texto;
    }

    @Override
    public String toString() {
        return "#id de " + id + ", remitente " + remitente + " a destinatario " + destinatario + " -> " + texto
                + "]";
    }

    
}
