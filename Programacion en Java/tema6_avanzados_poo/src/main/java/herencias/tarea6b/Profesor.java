package herencias.tarea6b;

public class Profesor {

    private String especialidad; // enum
    private double complementoSalarial;

    public Profesor(String especialidad, double complementoSalarial) {
        this.especialidad = especialidad;
        this.complementoSalarial = complementoSalarial;
    }

    public Profesor() {
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public double getComplementoSalarial() {
        return complementoSalarial;
    }

    public void setComplementoSalarial(double complementoSalarial) {
        this.complementoSalarial = complementoSalarial;
    }

}
