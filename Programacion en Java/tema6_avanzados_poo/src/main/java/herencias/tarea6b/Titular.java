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

    @Override
    public String toString() {
        return "Titular [nombre=" + nombre + ", apellidos=" + apellidos + ", fechaJubilacion=" + fechaJubilacion
                + ", nif=" + nif + ", getNumeroSeguridadSocial()=" + getNumeroSeguridadSocial() + ", getEspecialidad()="
                + getEspecialidad() + ", getSalarioBase()=" + getSalarioBase() + ", getComplementoSalarial()="
                + getComplementoSalarial() + "]";
    }

    @Override
    public double calcularIRPF() {
        double total = getSalarioBase() + getComplementoSalarial();
        return total * getEspecialidad().getIrpf();
    }

    // pide prorroga

    public boolean pedirProrroga(int meses) {
        if (fechaJubilacion == null) {
            return false;
        }
        java.time.LocalDate limite = java.time.LocalDate.of(2030, 1, 1);
        java.time.LocalDate nueva = fechaJubilacion.plusMonths(meses);
        if (!nueva.isAfter(limite)) {
            fechaJubilacion = nueva;
            return true;
        }
        return false;
    }

}
