package objeto.tarea4i;

public class PersonaEnum {

    private String nombrePersona;
    private int edadPersona;

    // Constructor

    public PersonaEnum() {

        this.nombrePersona = "RoboCopo";
        this.edadPersona = 5;
    }

    // Constructor parametrizado

    public PersonaEnum(String nombrePersona, int edadPersona) {
        this.nombrePersona = nombrePersona;
        this.edadPersona = edadPersona;
    }

    // Getter y Setter

    public String getNombrePersona() {
        return nombrePersona;
    }

    public void setNombrePersona(String nombrePersona) {
        this.nombrePersona = nombrePersona;
    }

    public int getEdadPersona() {
        return edadPersona;
    }

    public void setEdadPersona(int edadPersona) {
        this.edadPersona = edadPersona;
    }

    // toString

    public String toString() {
        return "Nombre: " + nombrePersona + ", Edad: " + edadPersona;
    }

    // Llamar

    public void llamar(AnimalEnum animal) {
        // pet.setEstadoAnimal("despierto");
        animal.despertar();
    }

    // Alimentar

    public void alimentar (AnimalEnum animal, double cantidadGramos){
        animal.comer(cantidadGramos);
    }

    // Jugar

    public void jugar(AnimalEnum animal, int cantidadMinutos) {
        animal.jugar(cantidadMinutos);
    }


}
