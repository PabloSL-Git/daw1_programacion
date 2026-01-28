package objeto.tarea4i;

import java.time.LocalDate;

public class AnimalEnum {

    private LocalDate fechaNacimientoAnimal;
    private String nombreAnimal;
    private TipoAnimal tipoAnimal;
    private double pesoAnimal;
    private EstadoAnimal estadoAnimal;

    // Constructor

    public AnimalEnum() {
        this.fechaNacimientoAnimal = LocalDate.of(2015, 1, 1);
        this.nombreAnimal = "Copo";
        this.tipoAnimal = TipoAnimal.GATO;
        this.pesoAnimal = 2000;
        this.estadoAnimal = EstadoAnimal.REPOSANDO;
    }

    // Constructor parametrizado

    public AnimalEnum(String nombreAnimal, LocalDate fechaNacimientoAnimal, TipoAnimal tipoAnimal, double pesoAnimal,
            EstadoAnimal estadoAnimal) {

        if (fechaNacimientoAnimal.isBefore(LocalDate.of(2000, 1, 1))
                || fechaNacimientoAnimal.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException(
                    "La fecha de nacimiento no puedes ser antes del año 2000 ni posterior a hoy");
        }
        if (pesoAnimal < 0 || pesoAnimal > 100000) { // gramos
            throw new IllegalArgumentException("El peso debe estar entre 0 y 100000 gramos");
        }

        this.fechaNacimientoAnimal = fechaNacimientoAnimal;
        this.tipoAnimal = tipoAnimal;
        this.pesoAnimal = pesoAnimal;
        this.nombreAnimal = nombreAnimal;
        this.estadoAnimal = EstadoAnimal.REPOSANDO; 
    }

    // Constructor copia

    public AnimalEnum(AnimalEnum otroAnimal) {
        this.nombreAnimal = otroAnimal.nombreAnimal;
        this.fechaNacimientoAnimal = otroAnimal.fechaNacimientoAnimal;
        this.tipoAnimal = otroAnimal.tipoAnimal;
        this.pesoAnimal = otroAnimal.pesoAnimal;
        this.estadoAnimal = otroAnimal.estadoAnimal;
    }

    // Getter y Setter

    public LocalDate getFechaNacimientoAnimal() {
        return fechaNacimientoAnimal;
    }

    public void setFechaNacimientoAnimal(LocalDate fechaNacimientoAnimal) {
        this.fechaNacimientoAnimal = fechaNacimientoAnimal;
    }

    public String getNombreAnimal() {
        return nombreAnimal;
    }

    public void setNombreAnimal(String nombreAnimal) {
        this.nombreAnimal = nombreAnimal;
    }

    public TipoAnimal getTipoAnimal() {
        return tipoAnimal;
    }

    public void setTipoAnimal(TipoAnimal tipoAnimal) {
        this.tipoAnimal = tipoAnimal;
    }

    public double getPesoAnimal() {
        return pesoAnimal;
    }

    public void setPesoAnimal(double pesoAnimal) {
        this.pesoAnimal = pesoAnimal;
    }

    public EstadoAnimal getEstadoAnimal() {
        return estadoAnimal;
    }

    public void setEstadoAnimal(EstadoAnimal estadoAnimal) {
        this.estadoAnimal = estadoAnimal;
    }

    // toString

    public String toString() {
        return "Nombre: " + nombreAnimal + ", Tipo: " + tipoAnimal + ", Peso: " + pesoAnimal + ", Fecha nacimiento: "
                + fechaNacimientoAnimal + ", Estado actual: " + estadoAnimal;
    }

    // comer

    public void comer(double cantidadGramos) {
        this.estadoAnimal = EstadoAnimal.COMIENDO;
        cantidadGramos = Math.abs(cantidadGramos);
        this.pesoAnimal += cantidadGramos;
    }

    // Dormir

    public void dormir() {
        this.estadoAnimal = EstadoAnimal.DURMIENDO;
    }

    // Despertar

    public void despertar() {
        this.estadoAnimal = EstadoAnimal.JUGANDO;
    }

    // Descansar

    public void descansar() {
        this.estadoAnimal = EstadoAnimal.REPOSANDO;
    }

    // Jugar

    public void jugar(int cantidadMinutos) {

        cantidadMinutos = Math.abs(cantidadMinutos);

        if (cantidadMinutos > 180) {
            throw new IllegalArgumentException("Animal no puede jugar mas de 180 minutos");
        }

        if (cantidadMinutos < 30) {
            this.pesoAnimal = pesoAnimal * 0.9;

        } else if (cantidadMinutos >= 30) {
            this.pesoAnimal = pesoAnimal * 0.8;
        }
    }

    // Clonar Animal

    public static AnimalEnum AnimalClonar(AnimalEnum animal) {

        if (animal == null) {
            throw new NullPointerException("Debe haber alguna mascota para clonar");
        }

        return new AnimalEnum(animal);
    }

}