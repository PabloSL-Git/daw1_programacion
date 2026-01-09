package objeto.tarea4h;

import java.time.LocalDate;

public class Animal {

    private LocalDate fechaNacimientoAnimal;
    private String nombreAnimal;
    private String tipoAnimal;
    private double pesoAnimal;
    private String estadoAnimal;

    // Constructor

    public Animal() {
        this.fechaNacimientoAnimal = LocalDate.of(2015, 1, 1);
        this.nombreAnimal = "Copo";
        this.tipoAnimal = "gato";
        this.pesoAnimal = 2000;
        this.estadoAnimal = "reposando";
    }

    // ARRAYS con valores permitidos
    private static final String[] TIPOS_ANIMAL = {
            "gato", "perro", "lagarto", "cobaya", "periquito"
    };

    private static final String[] ESTADOS_ANIMAL = {
            "comiendo", "durmiendo", "reposando", "jugando"
    };

    // Constructor parametrizado

    public Animal(String nombreAnimal, LocalDate fechaNacimientoAnimal, String tipoAnimal, double pesoAnimal,
            String estadoAnimal) {

        if (fechaNacimientoAnimal.isBefore(LocalDate.of(2000, 1, 1))
                || fechaNacimientoAnimal.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException(
                    "La fecha de nacimiento no puedes ser antes del año 2000 ni posterior a hoy");
        }
        if (pesoAnimal < 0 || pesoAnimal > 100000) { // gramos
            throw new IllegalArgumentException("El peso debe estar entre 0 y 100000 gramos");
        }
        if (!esValido(tipoAnimal, TIPOS_ANIMAL)) {
            throw new IllegalArgumentException(
                    "Animal debe ser uno de los siguientes: gato, perro, lagarto, cobaya, periquito");
        }
        if (!esValido(estadoAnimal, ESTADOS_ANIMAL)) {
            throw new IllegalArgumentException(
                    "Animal solo puede estar comiendo, durmiendo, reposando o jugando");
        }

        this.fechaNacimientoAnimal = fechaNacimientoAnimal;
        this.tipoAnimal = tipoAnimal;
        this.pesoAnimal = pesoAnimal;
        this.nombreAnimal = nombreAnimal;
        this.estadoAnimal = estadoAnimal;
    }

    // Método para validar usando arrays
    private boolean esValido(String valor, String[] lista) {
        for (String v : lista) {
            if (v.equalsIgnoreCase(valor)) {
                return true;
            }
        }
        return false;
    }

    // Constructor copia

    public Animal(Animal otroAnimal) {
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

    public String getTipoAnimal() {
        return tipoAnimal;
    }

    public void setTipoAnimal(String tipoAnimal) {
        this.tipoAnimal = tipoAnimal;
    }

    public double getPesoAnimal() {
        return pesoAnimal;
    }

    public void setPesoAnimal(double pesoAnimal) {
        this.pesoAnimal = pesoAnimal;
    }

    public String getEstadoAnimal() {
        return estadoAnimal;
    }

    public void setEstadoAnimal(String estadoAnimal) {
        this.estadoAnimal = estadoAnimal;
    }

    // toString

    public String toString() {
        return "Nombre: " + nombreAnimal + ", Tipo: " + tipoAnimal + ", Peso: " + pesoAnimal + ", Fecha nacimiento: "
                + fechaNacimientoAnimal + ", Estado actual: " + estadoAnimal;
    }

    // comer

    public void comer(double cantidadGramos) {
        this.estadoAnimal = "comiendo";
        cantidadGramos = Math.abs(cantidadGramos);
        this.pesoAnimal += cantidadGramos;
    }

    // Dormir

    public void dormir() {
        this.estadoAnimal = "durmiendo";
    }

    // Despertar

    public void despertar() {
        this.estadoAnimal = "jugando";
    }

    // Descansar

    public void descansar() {
        this.estadoAnimal = "reposando";
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

    public static Animal AnimalClonar(Animal animal) {

        if (animal == null) {
            throw new NullPointerException("Debe haber alguna mascota para clonar");
        }

        return new Animal(animal);
    }

}