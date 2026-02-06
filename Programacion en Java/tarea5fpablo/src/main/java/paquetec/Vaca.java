package paquetec;

import java.time.LocalDate;

public class Vaca implements Comparable<Vaca> {

    private final String id;
    private LocalDate fechaNacimiento;
    private String descripcion;

    public Vaca(String id, LocalDate fechaNacimiento, String descripcion) {
        this.id = id;
        this.fechaNacimiento = fechaNacimiento;
        this.descripcion = descripcion;
    }

    public String getId() {
        return id;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Vaca [id=" + id + ", fechaNacimiento=" + fechaNacimiento + ", descripcion=" + descripcion + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
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
        Vaca other = (Vaca) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    @Override
    public int compareTo(Vaca vaca) {
        return this.id.compareTo(vaca.id);
    }


}
