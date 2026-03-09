package herencias;

public class LibroDigital {

    int numBytes;

    public LibroDigital(int numBytes) {
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

    

}
