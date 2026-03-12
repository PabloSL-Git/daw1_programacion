package herencias.tarea6b;

import java.util.List;
import java.util.Set;

public class Academia {

    private String nombre;
    private List<Empleado> empleado;
    private Set<Alumno> alumno;
    private Direccion direccion;

    public Academia() {

    }

    public Academia(String nombre, List<Empleado> empleado, Set<Alumno> alumno, Direccion direccion) {
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

    public Set<Alumno> getAlumno() {
        return alumno;
    }

    public void setAlumno(Set<Alumno> alumno) {
        this.alumno = alumno;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    // Añade un empleado a la lista de la academia

    public void contratarEmpleado(Empleado e) {
        if (e == null) {
            return;
        }
        if (empleado == null) {
            empleado = new java.util.ArrayList<>();
        }
        empleado.add(e);
    }

    // Matricula a un alumno en el conjunto; el set evita duplicados según equals().

    public void matricularAlumno(Alumno a) {
        if (a == null) {
            return;
        }
        if (alumno == null) {
            alumno = new java.util.HashSet<>();
        }
        alumno.add(a);
    }
}
