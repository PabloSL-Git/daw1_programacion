package ficherosobjetos;

import java.io.Serializable;

/**
 *
 * @author Vico
 */

// Es necesario que la clase de los objetos que se guarden/lean en archivos binarios implemente la interfaz Serializable
// Este tipo de archivos se usan para trabajar con objetos Java sin necesidad de convertirlos a texto, 
// como ocurre con los archivos JSON, CSV o XML. Se usa cuando no hay interoperabilidad con otros sistemas 
// o lenguajes de programación, ya que este formato binario es específico de Java.

public class Persona implements Serializable {

    // Este atributo indica si hay cambios de versión en la clase
    private static final long serialVersionUID = 1L;

    private String nombre;
    private String dni;
    private int edad;
    
    
    public Persona(String nombre, String dni, int edad) {
        this.nombre = nombre;
        this.dni = dni;
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Persona [nombre=" + nombre + ", dni=" + dni + ", edad=" + edad + "]";
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
}
