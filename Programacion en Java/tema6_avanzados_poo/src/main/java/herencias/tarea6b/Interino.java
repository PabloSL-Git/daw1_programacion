package herencias.tarea6b;

import java.time.LocalDate;

public class Interino extends Profesor {

    private LocalDate fechaInicio;
    private LocalDate fechaCese;

    public Interino() {

    }

    public Interino(String nombre, String apellidos, String nif, String numeroSeguridadSocial, double salarioBase,
            Especialidad especialidad, double complementoSalarial) {
        super(nombre, apellidos, nif, numeroSeguridadSocial, salarioBase, especialidad, complementoSalarial);
         this.fechaInicio = LocalDate.now();                   
        this.fechaCese = fechaInicio.plusMonths(6);           
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicion) {
        this.fechaInicio = fechaInicion;
    }

    public LocalDate getFechaCese() {
        return fechaCese;
    }

    public void setFechaCese(LocalDate fechaCese) {
        this.fechaCese = fechaCese;
    }

    @Override
    public String toString() {
        return "Interino [nombre=" + nombre + ", apellidos=" + apellidos + ", fechaInicion=" + fechaInicio + ", nif="
                + nif + ", fechaCese=" + fechaCese + ", getNumeroSeguridadSocial()=" + getNumeroSeguridadSocial()
                + ", getEspecialidad()=" + getEspecialidad() + ", getSalarioBase()=" + getSalarioBase()
                + ", getComplementoSalarial()=" + getComplementoSalarial() + "]";
    }

    public double calcularDiasTrabajados(){


        return calculo;
    }

}
