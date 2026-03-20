/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw;

/**
 *
 * @author usuario
 */
public abstract class Habitacion implements Comparable<Habitacion> {

    private int numero;
    private int capacidad;
    private Estado estado;

    public Habitacion(int numero, int capacidad) {

        this.numero = numero;
        this.capacidad = capacidad;
        this.estado = Estado.LIBRE;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + this.numero;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Habitacion other = (Habitacion) obj;
        return this.numero == other.numero;
    }

    @Override
    public String toString() {
        return "Habitacion{" + "numero=" + numero + ", capacidad=" + capacidad + ", estado=" + estado + '}';
    }

    @Override
    public int compareTo(Habitacion h) {
        return Integer.compare(this.numero, h.numero);
    }
    
    // limpiar

    abstract void limpiar();
}
