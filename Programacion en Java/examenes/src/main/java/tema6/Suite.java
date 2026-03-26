/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tema6;

/**
 *
 * @author usuario
 */
public final class Suite extends Habitacion implements Reservable, Contratable {

    private boolean jacuzzi;
    private double precio;

    public Suite(boolean jacuzzi, double precio, int numero, int capacidad) {
        super(numero, capacidad);
        this.jacuzzi = jacuzzi;
        this.precio = precio;
    }

    public boolean isJacuzzi() {
        return jacuzzi;
    }

    public void setJacuzzi(boolean jacuzzi) {
        this.jacuzzi = jacuzzi;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + (this.jacuzzi ? 1 : 0);
        return hash;
    }

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
        final Suite other = (Suite) obj;
        return this.jacuzzi == other.jacuzzi;
    }

    @Override
    public String toString() {
        return "Habitacion [numero" + getNumero() + ", capacidad" + getCapacidad() + ", estado" + getEstado()
                + "Suite{" + "jacuzzi=" + jacuzzi + ", precio=" + precio + '}';
    }

    // jacuzzi
    public void llenarJacuzzi() {

        System.out.println("Jacuzzi llenandose");

    }

    // limpiar
    @Override
    public void limpiar() {

        System.out.println("Jacuzzi desinfectado");

    }

// reservar
    @Override
    public void reservar() {

        setEstado(Estado.RESERVADA);
        System.out.println("Cambiado a reservado");

    }

    // desreservar
    @Override
    public void cancelarReserva() {

        setEstado(Estado.LIBRE);
        System.out.println("Cancelado reserva");

    }

    // contratar
    @Override
    public void contratar(Cliente cliente) {

        setEstado(Estado.RESERVADA);

    }
}
