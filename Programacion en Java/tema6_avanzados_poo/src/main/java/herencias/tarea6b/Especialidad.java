package herencias.tarea6b;

public enum Especialidad {

    Secundaria("Secundaria", 0.25),
    ProfesorTecnico("PT", 0.23);

    private final String nombre;
    private final double irpf;

    Especialidad(String nombre, double irpf) {
        this.nombre = nombre;
        this.irpf = irpf;
    }

    public String getNombre() {
        return nombre;
    }

    public double getIrpf() {
        return irpf;
    }

}
