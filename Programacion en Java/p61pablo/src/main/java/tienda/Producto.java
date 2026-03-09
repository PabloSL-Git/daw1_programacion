package tienda;

public abstract class Producto {

    protected String codigo;
    protected double precio;
    protected double iva;
    protected String descripcion;

    public Producto(String codigo, double precio, double iva, String descripcion) {
        this.codigo = codigo;
        this.precio = precio;
        this.iva = iva;
        this.descripcion = descripcion;
    }

    // getters y setters

    @Override
    public String toString() {
        return codigo + " " + descripcion;
    }

    @Override
    public boolean equals(Object obj){
        if(this == obj) return true;
        if(!(obj instanceof Producto)) return false;

        Producto p = (Producto) obj;
        return codigo.equals(p.codigo);
    }

    @Override
    public int hashCode(){
        return codigo.hashCode();
    }
}