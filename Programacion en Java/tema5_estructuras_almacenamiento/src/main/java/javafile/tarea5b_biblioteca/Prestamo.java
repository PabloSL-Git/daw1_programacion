package javafile.tarea5b_biblioteca;

import java.time.LocalDate;

public class Prestamo {

    // atributos
    private Estudiante estudiante;
    private Libro libro;
    private LocalDate fechaPrestamo;
    private LocalDate fechaDevolucion;

    // constructores

    public Prestamo(Estudiante estudiante, Libro libro, LocalDate fechaPrestamo) {
        this.estudiante = estudiante;
        this.libro = libro;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = this.fechaPrestamo.plusDays(15);
    }

    // getters
    public Estudiante getEstudiante() {
        return estudiante;
    }

    public Libro getLibro() {
        return libro;
    }

    public LocalDate getFechaPrestamo() {
        return fechaPrestamo;
    }

    public LocalDate getFechaDevolucion() {
        return fechaDevolucion;
    }

    // setters
    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public void setFechaPrestamo(LocalDate fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = this.fechaPrestamo.plusDays(15);
    }

    // toString
    @Override
    public String toString() {
        return "Prestamo{" +
                "estudiante=" + estudiante +
                ", libro=" + libro +
                ", fechaPrestamo=" + fechaPrestamo +
                ", fechaDevolucion=" + fechaDevolucion +
                '}';
    }

    // equals y hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        Prestamo prestamo = (Prestamo) o;

        if (estudiante != null ? !estudiante.equals(prestamo.estudiante) : prestamo.estudiante != null)
            return false;
        return libro != null ? libro.equals(prestamo.libro) : prestamo.libro == null;
    }

    @Override
    public int hashCode() {
        int result = estudiante != null ? estudiante.hashCode() : 0;
        result = 31 * result + (libro != null ? libro.hashCode() : 0);
        return result;
    }

}
