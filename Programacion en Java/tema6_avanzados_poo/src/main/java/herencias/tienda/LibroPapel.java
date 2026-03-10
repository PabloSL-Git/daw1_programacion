package herencias.tienda;

public final class LibroPapel extends Libro implements SeEnvia {

    private int numPaginas;

    public LibroPapel() {
    }

    public LibroPapel(String codigo, double precio, double iva, String descripcion, String isbn, int numPaginas) {
        super(codigo, precio, iva, descripcion, isbn);
        this.numPaginas = numPaginas;
    }

    public int getNumPaginas() {
        return numPaginas;
    }

    public void setNumPaginas(int numPaginas) {
        this.numPaginas = numPaginas;
    }

    @Override
    public void enviar(String direccion) {

        System.out.println("Enviando libro: " + this + " a " + direccion);

    }

    @Override
    public String toString() {
        return super.toString() + " paginas=" + numPaginas;
    }
}
