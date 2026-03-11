package herencias.tarea6b;

import java.time.LocalDate;

public final class Titular extends Profesor {

    private LocalDate fechaJubilacion;

    public Titular(String nombre, String apellidos, String nif, String numeroSeguridadSocial, double salarioBase,
            Especialidad especialidad, double complementoSalarial, LocalDate fechaJubilacion) {
        super(nombre, apellidos, nif, numeroSeguridadSocial, salarioBase, especialidad, complementoSalarial);
        this.fechaJubilacion = fechaJubilacion;
    }

    public Titular() {
    }

    public LocalDate getfechaJubilacion() {
        return fechaJubilacion;
    }

    public void setfechaJubilacion(LocalDate fechaJubilacion) {
        this.fechaJubilacion = fechaJubilacion;
    }

    // to string

    // pedirProrroga

}
