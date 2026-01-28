package javafile.tarea5a_biblioteca;

public class Libro {

    // Enum para el género con descripción
    public enum Genero {
        NOVELA("Novela - Narración ficticia extensa"),
        FICCION("Ficción - Obra de imaginación"),
        POESIA("Poesía - Expresión artística con verso"),
        RELATO("Relato - Narración breve de hechos");

        private String descripcion;

        Genero(String descripcion) {
            this.descripcion = descripcion;
        }

        public String getDescripcion() {
            return descripcion;
        }
    }

    // Atributos
    private String titulo;
    private String autor;
    private int aniPublicacion;
    private final long isbn; // No cambia de valor una vez creado
    private Genero genero;
    private boolean disponible;

    // Constructor parametrizado (validando isbn de 13 dígitos)
    public Libro(String titulo, String autor, int aniPublicacion, long isbn, Genero genero, boolean disponible) {
        // Validar que isbn sea de 13 dígitos
        if (String.valueOf(isbn).length() != 13 || isbn < 0) {
            throw new IllegalArgumentException("El ISBN debe ser un número de 13 dígitos");
        }
        this.titulo = titulo;
        this.autor = autor;
        this.aniPublicacion = aniPublicacion;
        this.isbn = isbn;
        this.genero = genero;
        this.disponible = disponible;
    }

    // Constructor por defecto
    public Libro() {
        this.titulo = "Desconocido";
        this.autor = "Desconocido";
        this.aniPublicacion = 2024;
        this.isbn = 1234567890123L; // 13 dígitos
        this.genero = Genero.NOVELA;
        this.disponible = true;
    }

    // Getters
    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getAniPublicacion() {
        return aniPublicacion;
    }

    public long getIsbn() {
        return isbn;
    }

    public Genero getGenero() {
        return genero;
    }

    public boolean isDisponible() {
        return disponible;
    }

    // Setters (excepto isbn y disponible)
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setAniPublicacion(int aniPublicacion) {
        this.aniPublicacion = aniPublicacion;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    // Método prestar: verifica disponibilidad y cambia el estado
    public void prestar() {
        if (disponible) {
            disponible = false;
            System.out.println("✓ s Libro '" + titulo + "' prestado correctamente.");
        } else {
            System.out.println("✗ El libro '" + titulo + "' no está disponible para préstamo.");
        }
    }

    // Método devolver: hace lo contrario a prestar
    public void devolver() {
        if (!disponible) {
            disponible = true;
            System.out.println("✓ Libro '" + titulo + "' devuelto correctamente.");
        } else {
            System.out.println("✗ El libro '" + titulo + "' ya estaba disponible.");
        }
    }

    // toString
    @Override
    public String toString() {
        return "Libro {\n" +
                "  título='" + titulo + "'\n" +
                "  autor='" + autor + "'\n" +
                "  año=" + aniPublicacion + "\n" +
                "  isbn=" + isbn + "\n" +
                "  género=" + genero.getDescripcion() + "\n" +
                "  disponible=" + disponible + "\n" +
                "}";
    }

    // equals (usando isbn)
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Libro libro = (Libro) obj;
        return isbn == libro.isbn;
    }

    // hashCode (usando isbn)
    @Override
    public int hashCode() {
        return Long.hashCode(isbn);
    }
}
