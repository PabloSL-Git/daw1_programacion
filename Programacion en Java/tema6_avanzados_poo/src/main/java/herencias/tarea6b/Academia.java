package herencias.tarea6b;

import java.util.List;

public class Academia {

    private String nombre;
    private List<Empleado> empleado;
    private List<Alumno> alumno;
    private Direccion direccion;

    public Academia() {

    }

    public Academia(String nombre, List<Empleado> empleado, List<Alumno> alumno, Direccion direccion) {
        this.nombre = nombre;
        this.empleado = empleado;
        this.alumno = alumno;
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Empleado> getEmpleado() {
        return empleado;
    }

    public void setEmpleado(List<Empleado> empleado) {
        this.empleado = empleado;
    }

    public List<Alumno> getAlumno() {
        return alumno;
    }

    public void setAlumno(List<Alumno> alumno) {
        this.alumno = alumno;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    // contraempleado
    // matriculaalumno
}
