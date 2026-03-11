package herencias.tarea6b;

public enum Especialidad {

    Secundaria("Secundaria", 0.25),
    ProfesorTecnico("PT", 0.23);

    private String nombre;
    private double irpf;

    Especialidad(String nombre, double irpf) {
        this.nombre = nombre;
        this.irpf = irpf;
    }

    Especialidad() {

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getIrpf() {
        return irpf;
    }

    public void setIrpf(double irpf) {
        this.irpf = irpf;
    }

}
