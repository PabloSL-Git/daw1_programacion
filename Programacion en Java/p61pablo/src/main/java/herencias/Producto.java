package herencias;

public class Producto {
    String codigo;
    double precio;
    double iva;
    String descripcion;

    public Producto(String codigo, double precio, double iva, String descripcion) {
        this.codigo = codigo;
        this.precio = precio;
        this.iva = iva;
        this.descripcion = descripcion;
    }

    public String getCodigo() {
        return codigo;
    }

    public double getPrecio() {
        return precio;
    }

    public double getIva() {
        return iva;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setIva(double iva) {
        this.iva = iva;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Producto [codigo=" + codigo + ", precio=" +
                precio + ", iva=" + iva + ", descripcion=" + descripcion
                + "]";
    }

}
