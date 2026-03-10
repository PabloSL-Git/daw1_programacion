package tienda;

public final class Pantalon extends Ropa implements SeEnvia {

    private String talla;

    public Pantalon() {
    }

    public Pantalon(String codigo, double precio, double iva, String descripcion, String marca, String talla) {
        super(codigo, precio, iva, descripcion, marca);
        this.talla = talla;
    }

    public String getTalla() {
        return talla;
    }

    public void setTalla(String talla) {
        this.talla = talla;
    }

    @Override
    public void enviar(String direccion) {

        System.out.println("Enviando ropa: " + this + " a " + direccion);

    }

    @Override
    public String toString() {
        return super.toString() + " talla=" + talla;
    }
}
