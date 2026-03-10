package herencias.tarea6a;

public abstract class Ropa extends Producto implements SeEnvia {

    protected String marca;

        public Ropa() {
    }

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
    public void enviar(String direccion) {

        System.out.println("Enviando ropa: " + this + " a " + direccion);

    }

    @Override
    public String toString() {
        return super.toString() + " marca=" + marca;
    }
}
