/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package alboran;

import java.util.Objects;

/**
 *
 * @author usuario
 */
public class Pasajero implements Comparable<Pasajero> {

    private final String id;
    private final String NIF;
    private String nombre;
    private String email;

    // constructor
    public Pasajero(String id, String NIF, String nombre, String email) {
        this.id = id;
        this.NIF = NIF;
        this.nombre = nombre;
        this.email = email;
    }

    // getter y setter
    public String getId() {
        return id;
    }

    public String getNIF() {
        return NIF;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // tostring
    @Override
    public String toString() {
        return "Pasajero{" + "id=" + id + ", NIF=" + NIF + ", nombre=" + nombre + ", email=" + email + '}';
    }

    // hashcode
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + Objects.hashCode(this.id);
        return hash;
    }

    // equals
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
        final Pasajero other = (Pasajero) obj;
        return Objects.equals(this.id, other.id);
    }

    // Comparador
    @Override
    public int compareTo(Pasajero pasajero) {
        return this.id.compareTo(id);
    }

}
