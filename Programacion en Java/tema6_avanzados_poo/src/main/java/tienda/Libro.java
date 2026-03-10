package tienda;

public abstract class Libro extends Producto implements Comparable<Libro> {

    protected String isbn;

    public Libro() {
    }

    public Libro(String codigo, double precio, double iva, String descripcion, String isbn) {
        super(codigo, precio, iva, descripcion);
        this.isbn = isbn;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @Override
    public int compareTo(Libro l) {
        return this.isbn.compareTo(l.isbn);
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) return true;
        if (!(obj instanceof Libro)) return false;

        Libro l = (Libro) obj;
        return isbn.equals(l.isbn);
    }

    @Override
    public int hashCode() {
        return isbn.hashCode();
    }

    @Override
    public String toString() {
        return super.toString() + " isbn=" + isbn;
    }
}