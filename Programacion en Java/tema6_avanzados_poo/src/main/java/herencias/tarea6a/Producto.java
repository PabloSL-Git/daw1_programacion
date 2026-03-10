package herencias.tarea6a;

public abstract class Producto {

    protected String codigo;
    protected double precio;
    protected double iva;
    protected String descripcion;

    public Producto() {
    }

    public Producto(String codigo, double precio, double iva, String descripcion) {
        this.codigo = codigo;
        this.precio = precio;
        this.iva = iva;
        this.descripcion = descripcion;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getIva() {
        return iva;
    }

    public void setIva(double iva) {
        this.iva = iva;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Producto:" +
                " codigo='" + codigo + '\'' +
                ", precio=" + precio +
                ", iva=" + iva +
                ", descripcion='" + descripcion + '\'';
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj)
            return true;
        if (!(obj instanceof Producto))
            return false;

        Producto p = (Producto) obj;
        return codigo.equals(p.codigo);
    }

    @Override
    public int hashCode() {
        return codigo.hashCode();
    }
}
