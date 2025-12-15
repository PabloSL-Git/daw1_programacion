package objeto.tarea4h;

public class Persona {

    private String nombrePersona;
    private int edadPersona;

    // Constructor

    public Persona() {

        this.nombrePersona = "RoboCopo";
        this.edadPersona = 5;
    }

    // Constructor parametrizado

    public Persona(String nombrePersona, int edadPersona) {
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

    public void llamar(Animal pet) {
        // pet.setEstadoAnimal("despierto");
        pet.despertar();
    }

    // Alimentar

    public void alimentar (Animal pet, double cantidadGramos){
        pet.comer(cantidadGramos);
    }

    // Jugar

    public void jugar(Animal pet, int cantidadMinutos) {
        pet.jugar(cantidadMinutos);
    }


}
