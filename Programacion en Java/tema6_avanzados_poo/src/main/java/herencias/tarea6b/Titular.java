package herencias.tarea6b;

import java.time.LocalDate;

public final class Titular extends Profesor {

    private LocalDate fechaJuvilacion;

    public Titular(LocalDate fechaJuvilacion) {
        this.fechaJuvilacion = fechaJuvilacion;
    }

    public Titular() {
    }

    public LocalDate getFechaJuvilacion() {
        return fechaJuvilacion;
    }

    public void setFechaJuvilacion(LocalDate fechaJuvilacion) {
        this.fechaJuvilacion = fechaJuvilacion;
    }

    // pedirProrroga

}
