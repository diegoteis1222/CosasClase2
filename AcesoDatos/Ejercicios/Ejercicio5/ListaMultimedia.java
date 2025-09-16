public class ListaMultimedia {

    protected Multimedia[] lista;
    protected int contador;

    public ListaMultimedia(int max) {
        lista = new Multimedia[max];
        contador = 0;
    }

    public int size() {
        return contador;
    }

    public boolean add(Multimedia m) {

        if (contador < lista.length) {
            lista[contador] = m;
            contador++;
            return true;
        }
        return false;
    }

    public Multimedia get(int index) {
        if (index >= 0 && index < contador) {
            return lista[index];
        } else {
            throw new IndexOutOfBoundsException("ese no esta");
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < contador; i++) {
            sb.append(lista[i].toString()).append("\n");
        }
        return sb.toString();
    }
}
