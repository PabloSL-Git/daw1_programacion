package tienda;

public final class LibroDigital extends Libro implements SeDescarga {

    private long numBytes;

    public LibroDigital() {
    }

    public LibroDigital(String codigo, double precio, double iva, String descripcion, String isbn, long numBytes) {
        super(codigo, precio, iva, descripcion, isbn);
        this.numBytes = numBytes;
    }

    public long getNumBytes() {
        return numBytes;
    }

    public void setNumBytes(long numBytes) {
        this.numBytes = numBytes;
    }

    @Override
    public void descargar() {

        System.out.println("http://tudominio/" + this.hashCode());

    }

    @Override
    public String toString() {
        return super.toString() + " bytes=" + numBytes;
    }
}
