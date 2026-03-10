package herencias.tienda;

public final class Musica extends Producto {

    private String grupo;

        public Musica() {
    }

    public Musica(String codigo, double precio, double iva, String descripcion, String grupo) {
        super(codigo, precio, iva, descripcion);
        this.grupo = grupo;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    @Override
    public String toString() {
        return super.toString() + " grupo=" + grupo;
    }
}
