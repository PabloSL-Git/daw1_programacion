package herencias;

public class Ropa {

    String marca;

    public Ropa(String marca) {
        this.marca = marca;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    @Override
    public String toString() {
        return "Ropa [marca=" + marca + "]";
    }

}
