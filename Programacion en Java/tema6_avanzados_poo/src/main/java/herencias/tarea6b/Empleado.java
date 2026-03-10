package herencias.tarea6b;

public abstract class Empleado extends Persona {

    private String numeroSeguridadSocial;
    private double salarioBase;

    public Empleado(String nombre, String apellidos, String nif, String numeroSeguridadSocial, double salarioBase) {
        super(nombre, apellidos, nif);
        this.numeroSeguridadSocial = numeroSeguridadSocial;
        this.salarioBase = salarioBase;
    }

    public Empleado() {

    }

    public String getNumeroSeguridadSocial() {
        return numeroSeguridadSocial;
    }

    public void setNumeroSeguridadSocial(String numeroSeguridadSocial) {
        this.numeroSeguridadSocial = numeroSeguridadSocial;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(double salarioBase) {
        this.salarioBase = salarioBase;
    }

    // calcular irpf

}
