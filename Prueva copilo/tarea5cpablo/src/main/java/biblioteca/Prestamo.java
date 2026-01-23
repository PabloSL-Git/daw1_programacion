package biblioteca;

import java.time.LocalDate;

public class Prestamo {

    private final int id;
    // Composición de clases
    // Clases contenidas: Estudiante, Libro, LocalDate
    // Clase continente: Prestamo
    private Estudiante estudiante;
    private Libro libro;
    private LocalDate fechaInicial;
    private LocalDate fechaDevolucion;

    public Prestamo(int id, Estudiante estudiante, Libro libro, LocalDate fechaInicial) {
        this.id = id;
        this.estudiante = estudiante;
        this.libro = libro;
        this.fechaInicial = fechaInicial;
        // fecha devolución 15 días posterior a la fecha inicial
        this.fechaDevolucion = fechaInicial.plusDays(15);
    }
    // // Sobrecarga de contructores
    // public Prestamo(int id, Estudiante estudiante, Libro libro) {
    //     this.id = id;
    //     this.estudiante = estudiante;
    //     this.libro = libro;
    //     this.fechaInicial = LocalDate.now();
    //     // fecha devolución 15 días posterior a la fecha inicial
    //     this.fechaDevolucion = fechaInicial.plusDays(15);
    // }
   
    // Crea un constructor por defecto con la fecha actual del sistema como fecha inicial
    // e id a cero
    public Prestamo() {
        this.id = 0;
        // Si no indico nada los atributos Estudiante, Libro, LocalDate son null
        this.fechaInicial = LocalDate.now();
        this.fechaDevolucion = fechaInicial.plusDays(15);
    }

    public Prestamo(int id){
        this.id = id;
    }

    public int getId() {
        return id;
    }
    public Estudiante getEstudiante() {
        return estudiante;
    }
    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }
    public Libro getLibro() {
        return libro;
    }
    public void setLibro(Libro libro) {
        this.libro = libro;
    }
    public LocalDate getFechaInicial() {
        return fechaInicial;
    }
    public void setFechaInicial(LocalDate fechaInicial) {
        this.fechaInicial = fechaInicial;
        this.fechaDevolucion = fechaInicial.plusDays(15);
    }
    public LocalDate getFechaDevolucion() {
        return fechaDevolucion;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
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
        Prestamo other = (Prestamo) obj;
        if (id != other.id)
            return false;
        return true;
    }
    @Override
    public String toString() {
        return "[id=" + id + "\n" + 
        "estudiante= " + estudiante.getDni() + "\n" +
        "libro= " + libro.getIsbn() + "\n" +
        "fechaInicial= " + fechaInicial + "\n" + 
        "fechaDevolucion=" + fechaDevolucion + "]";
    }
    
    public String toString2(){
        return "[id=" + id + " estudiante= " + estudiante.getDni(); 
    }

}
