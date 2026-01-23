package biblioteca;

/**
 * Enum que representa los géneros literarios disponibles.
 * Cada género tiene una descripción asociada.
 */
public enum Genero {
    NOVELA("Novela"),
    FICCION("Ficción"),
    POESIA("Poesía"),
    RELATO("Relato");

    private final String descripcion;

    /**
     * Constructor del enum.
     * @param descripcion La descripción del género.
     */
    private Genero(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Obtiene la descripción del género.
     * @return La descripción.
     */
    public String getDescripcion() {
        return descripcion;
    }
}