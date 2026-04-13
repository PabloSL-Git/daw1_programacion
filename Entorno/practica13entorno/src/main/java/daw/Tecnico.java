package daw;

public class Tecnico extends Empleado{

    private int categoria;

    public Tecnico(String dni, String nombre, String apellidos, double sueldoBase, int categoria) {
        super(dni, nombre, apellidos, sueldoBase);
        this.categoria = categoria;
    }

    // get sueldo heredado

    public double getSueldo() {
    return getSueldoBase() + (this.categoria * 100); 
}

}
