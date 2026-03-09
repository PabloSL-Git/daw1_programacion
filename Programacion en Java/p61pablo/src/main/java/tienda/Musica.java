package tienda;

public final class Musica {

    private String grupo;

    public Musica(String grupo) {
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
        return "Musica [grupo=" + grupo + "]";
    }

}
