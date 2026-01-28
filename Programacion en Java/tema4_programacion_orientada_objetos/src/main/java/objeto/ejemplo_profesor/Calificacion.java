package objeto.ejemplo_profesor;

public enum Calificacion {

    // Definición de los objetos del enum
    INSUFICIENTE(3),
    SUFICIENTE(5),
    BIEN(6),
    NOTABLE_BAJO(7),
    NOTABLE_ALTO(8),
    SOBRESALIENTE(10);

    // Atributo del enum (final)
    private final int nota;
    

    private Calificacion(int nota) {
        this.nota = nota;
    }

    public int getNota() {
        return nota;
    }
    
}
