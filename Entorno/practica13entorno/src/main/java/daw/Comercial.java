package daw;

public class Comercial extends Empleado {

    private double ventas;

    public Comercial(String dni, String nombre, String apellidos, double sueldoBase, double ventas) {
        super(dni, nombre, apellidos, sueldoBase);
        this.ventas = ventas;
    }

    public void setVentas(double ventas) {
        this.ventas = ventas;
    }

    // get sueldo heredado

    public double getSueldo() {

        return getSueldoBase() + (this.ventas * 0.10);
    }

}
