package herencias.ejerciciosUT6.Ej7;

// Clase abstracta
// Es una clase plantilla (no voy a hacer new Trabajador)
// Puede o no tener métodos abstractos
public abstract class Trabajador {

    private String nombre;
    private String nif;
    private double sueldoBase;

    public Trabajador(String nombre, String nif, double sueldoBase) {
        this.nombre = nombre;
        this.nif = nif;
        this.sueldoBase = sueldoBase;
    }

    public Trabajador(){

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public double getSueldoBase() {
        return sueldoBase;
    }

    public void setSueldoBase(double sueldoBase) {
        this.sueldoBase = sueldoBase;
    }

    @Override
    public String toString() {
        return "Trabajador [nombre=" + nombre + ", nif=" + nif + ", sueldoBase=" + sueldoBase + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nif == null) ? 0 : nif.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Trabajador other = (Trabajador) obj;
        if (nif == null) {
            if (other.nif != null)
                return false;
        } else if (!nif.equals(other.nif))
            return false;
        return true;
    }

    // Método abstracto
    // Cada clase hija está obligada a implementarlo
    // según las restricciones del sistema
    // Cuando se añade un método abstracto la clase debe
    // ser abstracta
    public abstract double cotizar();
         
}
