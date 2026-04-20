package modelos;

public class Plato {

    private String idPlato;
    private String nombre;
    private String descripcion;
    private double precio;
    private boolean esTemporada;

    public Plato(String idPlato, String nombre, String descripcion, double precio, boolean esTemporada) {
        this.idPlato = idPlato;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.esTemporada = esTemporada;
    }

    public String getIdPlato() {
        return idPlato;
    }

    public void setIdPlato(String idPlato) {
        this.idPlato = idPlato;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public boolean isEsTemporada() {
        return esTemporada;
    }

    public void setEsTemporada(boolean esTemporada) {
        this.esTemporada = esTemporada;
    }

    @Override
    public String toString() {
        return "Plato{" + "idPlato=" + idPlato + ", nombre=" + nombre + ", descripcion=" + descripcion + ", precio=" + precio + ", esTemporada=" + esTemporada + '}';
    }
}
