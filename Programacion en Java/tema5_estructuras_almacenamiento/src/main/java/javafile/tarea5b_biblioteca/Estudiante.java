package javafile.tarea5b_biblioteca;

public class Estudiante {

    // atributos

    private String nombre;
    private String apellidos;
    private final String dni;

    // constructores

    public Estudiante(String nombre, String apellidos, String dni) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
    }

    // getters
    
    public String getNombre() {
        return nombre;
    }
    public String getApellidos() {
        return apellidos;
    }
    public String getDni() {
        return dni;
    }

    // setter

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    // toString

    @Override
    public String toString() {
        return "Estudiante {" +
                "nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", dni='" + dni + '\'' +
                '}';
    }

    // equals y hashCode (por dni)

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Estudiante that = (Estudiante) o;

        if (dni != null) {
            return dni.equals(that.dni);
        } else {
            return that.dni == null;
        }
    }

    @Override
    public int hashCode() {
        if (dni != null) {
            return dni.hashCode();
        } else {
            return 0;
        }
    }

}
