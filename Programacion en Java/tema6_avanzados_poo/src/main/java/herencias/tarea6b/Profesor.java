package herencias.tarea6b;

public class Profesor extends Empleado {

    private Especialidad especialidad;
    private double complementoSalarial;

    public Profesor(String nombre, String apellidos, String nif, String numeroSeguridadSocial, double salarioBase,
            Especialidad especialidad, double complementoSalarial) {
        super(nombre, apellidos, nif, numeroSeguridadSocial, salarioBase);
        this.especialidad = especialidad;
        this.complementoSalarial = complementoSalarial;
    }

    public Profesor() {
    }

    public Especialidad getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(Especialidad especialidad) {
        this.especialidad = especialidad;
    }

    public double getComplementoSalarial() {
        return complementoSalarial;
    }

    public void setComplementoSalarial(double complementoSalarial) {
        this.complementoSalarial = complementoSalarial;
    }

    // calcula el irpf
    public double calcularIRPF() {
        double base = getSalarioBase();
        return base * getEspecialidad().getIrpf();
    }

}
