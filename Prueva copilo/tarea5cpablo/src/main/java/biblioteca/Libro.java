package biblioteca;

public class Libro {

    // Atributos
    private String titulo;
    private String autor;
    private int anioPublicacion;
    private final String isbn; // No cambia de valor una vez creado
    private Genero genero;
    private boolean disponible;

    // Constructor parametrizado (validando isbn de 13 dígitos)
    public Libro(String titulo, String autor, int aniPublicacion, String isbn, Genero genero, boolean disponible) {
        // Validar que isbn sea de 13 dígitos
        if (isbn == null || isbn.length() != 13) {
            throw new IllegalArgumentException("El ISBN debe ser un número de 13 dígitos");
        }
        this.titulo = titulo;
        this.autor = autor;
        this.anioPublicacion = aniPublicacion;
        this.isbn = isbn;
        this.genero = genero;
        this.disponible = disponible;
    }

    // Constructor por defecto
    public Libro() {
        this.titulo = "Desconocido";
        this.autor = "Desconocido";
        this.anioPublicacion = 2024;
        this.isbn = "1234567890123"; // 13 dígitos
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

    public int getAnioPublicacion() {
        return anioPublicacion;
    }

    public String getIsbn() {
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

    public void setAnioPublicacion(int aniPublicacion) {
        this.anioPublicacion = aniPublicacion;
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
        return "Libro{" +
                "tit='" + titulo + '\'' +
                ", aut='" + autor + '\'' +
                ", año=" + anioPublicacion +
                ", isbn=" + isbn +
                ", gen=" + genero +
                ", disp=" + disponible +
                '}';
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((isbn == null) ? 0 : isbn.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Libro other = (Libro) obj;
        if (isbn == null) {
            if (other.isbn != null)
                return false;
        } else if (!isbn.equals(other.isbn))
            return false;
        return true;
    }
}
