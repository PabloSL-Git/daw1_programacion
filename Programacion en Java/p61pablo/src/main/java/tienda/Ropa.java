package tienda;

public abstract class Ropa extends Producto {

    protected String marca;

    public Ropa(String codigo, double precio, double iva, String descripcion, String marca) {
        super(codigo, precio, iva, descripcion);
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
