package herencias;

public class LibroPapel {

    int numPaginas;

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
