package herencias.tarea6b;

public class Academia {

    private String nombre;
    private Empleado empleado;
    private Alumno alumno;
    private Direccion direccion;

    public Academia() {

    }

    public Academia(String nombre, Empleado empleado, Alumno alumno, Direccion direccion) {
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

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    



    // contraempleado
    //matriculaalumno
}
