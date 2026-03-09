package tienda;

public final class Pantalon {

    private double talla;

    public Pantalon(double talla) {
        this.talla = talla;
    }

    public double getTalla() {
        return talla;
    }

    public void setTalla(double talla) {
        this.talla = talla;
    }

    @Override
    public String toString() {
        return "Pantalon [talla=" + talla + "]";
    }

}
