/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw;

/**
 *
 * @author usuario
 */
public final class Estandar extends Habitacion implements Reservable, Contratable {

    private boolean minibar;
    private double precio;

    public Estandar(boolean minibar, double precio, int numero, int capacidad) {
        super(numero, capacidad);
        this.minibar = minibar;
        this.precio = precio;
    }

    public boolean isMinibar() {
        return minibar;
    }

    public void setMinibar(boolean minibar) {
        this.minibar = minibar;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + (this.minibar ? 1 : 0);
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
        final Estandar other = (Estandar) obj;
        return this.minibar == other.minibar;
    }

    @Override
    public String toString() {
        return "Habitacion [numero" + getNumero() + ", capacidad" + getCapacidad() + ", estado" + getEstado()
                + "Estandar{" + "minibar=" + minibar + ", precio=" + precio + '}';
    }

    // limpiar
    @Override
    public void limpiar() {

        System.out.println("Minibar rellenado");

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
