package ejercicio2;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDate;
import java.util.Objects;

public class Paciente {

    @JsonProperty("id")
    private int id;

    @JsonProperty("nombre")
    private String nombre;

    @JsonProperty("edad")
    private int edad;

    @JsonProperty("fechaIngreso")
    private LocalDate fechaIngreso;

    @JsonProperty("diagnostico")
    private String diagnostico;

    @JsonProperty("habitacion")
    private int habitacion;

    public Paciente() {
    }

    public Paciente(int id, String nombre, int edad, LocalDate fechaIngreso, String diagnostico, int habitacion) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.fechaIngreso = fechaIngreso;
        this.diagnostico = diagnostico;
        this.habitacion = habitacion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public int getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(int habitacion) {
        this.habitacion = habitacion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Paciente)) {
            return false;
        }
        Paciente p = (Paciente) o;
        return id == p.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Paciente{id=" + id + ", nombre=" + nombre + ", edad=" + edad
                + ", fechaIngreso=" + fechaIngreso + ", diagnostico=" + diagnostico
                + ", habitacion=" + habitacion + "}";
    }
}
