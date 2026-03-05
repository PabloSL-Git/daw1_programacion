package ejerciciosUT6.Ej12;

public class Persona {

    private String nombre;
    private String apellidos;
    private String nif;

    public Persona(String nombre, String apellidos, String nif) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.nif = nif;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getNif() {
        return nif;
    }

    @Override
    public String toString() {
        return nombre + " " + apellidos + " (" + nif + ")";
    }
}
