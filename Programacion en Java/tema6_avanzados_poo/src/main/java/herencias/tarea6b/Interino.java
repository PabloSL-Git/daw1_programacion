package herencias.tarea6b;

import java.time.LocalDate;

public class Interino extends Profesor {

    private LocalDate fechaInicion;
    private LocalDate fechaCese;

    public Interino() {

    }

    public Interino(String nombre, String apellidos, String nif, String numeroSeguridadSocial, double salarioBase,
            Especialidad especialidad, double complementoSalarial, LocalDate fechaInicion, LocalDate fechaCese) {
        super(nombre, apellidos, nif, numeroSeguridadSocial, salarioBase, especialidad, complementoSalarial);
        this.fechaInicion = fechaInicion;
        this.fechaCese = fechaCese;
    }

    public LocalDate getFechaInicion() {
        return fechaInicion;
    }

    public void setFechaInicion(LocalDate fechaInicion) {
        this.fechaInicion = fechaInicion;
    }

    public LocalDate getFechaCese() {
        return fechaCese;
    }

    public void setFechaCese(LocalDate fechaCese) {
        this.fechaCese = fechaCese;
    }

    // to string

    // calcular dias

}
