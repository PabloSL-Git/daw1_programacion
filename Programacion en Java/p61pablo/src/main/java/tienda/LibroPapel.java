package tienda;

public final class LibroPapel {

    private int numPaginas;

    public LibroPapel(int numPaginas) {
        this.numPaginas = numPaginas;
    }

    public int getNumPaginas() {
        return numPaginas;
    }

    public void setNumPaginas(int numPaginas) {
        this.numPaginas = numPaginas;
    }

    @Override
    public String toString() {
        return "LibroPapel [numPaginas=" + numPaginas + "]";
    }

}
