/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tema6;

import java.util.HashSet;
import java.util.List;

/**
 *
 * @author usuario
 */
public class Hotel {

    private String cif;
    private String nombre;
    private HashSet<Habitacion> habitaciones;
    private HashSet<Cliente> clientes;

    public Hotel(String cif, String nombre, HashSet<Habitacion> habitaciones, HashSet<Cliente> clientes) {
        this.cif = cif;
        this.nombre = nombre;
        this.habitaciones = habitaciones;
        this.clientes = clientes;
    }

    public String getCif() {
        return cif;
    }

    public void setCif(String cif) {
        this.cif = cif;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public HashSet<Habitacion> getHabitaciones() {
        return habitaciones;
    }

    public HashSet<Cliente> getClientes() {
        return clientes;
    }

    @Override
    public String toString() {
        return "Hotel{" + "cif=" + cif + ", nombre=" + nombre + ", habitaciones=" + habitaciones + ", clientes=" + clientes + '}';
    }

}
