package tienda;

public final class LibroDigital extends Libro implements SeDescarga {

    private int numBytes;

    public LibroDigital(String codigo, double precio, double iva, String descripcion, String isbn, long numBytes) {
        super(codigo, precio, iva, descripcion, isbn);
        this.numBytes = numBytes;
    }

    public int getNumBytes() {
        return numBytes;
    }

    public void setNumBytes(int numBytes) {
        this.numBytes = numBytes;
    }

    @Override
    public String toString() {
        return "LibroDigital [numBytes=" + numBytes + "]";
    }

    @Override
    public void descargar() {
        System.out.println("http://tudominio/" + this.hashCode());
    }

}
