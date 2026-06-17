/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package alboran;

import java.util.Set;
import java.util.HashSet;

/**
 *
 * @author pablo
 */
public class Vuelo implements Comparable<Vuelo> {

    private final int codigoVuelo;
    private String ciudadOrigen;
    private String ciudadDestino;
    private int minutos;
    private final Set<Pasajero> pasajeros;

    public Vuelo(int codigoVuelo, String ciudadOrigen, String ciudadDestino, int minutos) {
        if (ciudadOrigen.equals(ciudadDestino)) {
            throw new IllegalArgumentException("La ciudad de origen y destino deben ser diferentes");
        }

        if (minutos <= 45) {
            throw new IllegalArgumentException("La duración debe ser mayor que 45 minutos");
        }

        this.codigoVuelo = codigoVuelo;
        this.ciudadOrigen = ciudadOrigen;
        this.ciudadDestino = ciudadDestino;
        this.minutos = minutos;
        this.pasajeros = new HashSet<>();
    }

    public int getCodigoVuelo() {
        return codigoVuelo;
    }

    public String getCiudadOrigen() {
        return ciudadOrigen;
    }

    public void setCiudadOrigen(String ciudadOrigen) {
        if (ciudadOrigen.equals(this.ciudadDestino)) {
            throw new IllegalArgumentException("La ciudad de origen y destino deben ser diferentes");
        }
        this.ciudadOrigen = ciudadOrigen;
    }

    public String getCiudadDestino() {
        return ciudadDestino;
    }

    public void setCiudadDestino(String ciudadDestino) {
        if (ciudadDestino.equals(this.ciudadOrigen)) {
            throw new IllegalArgumentException("La ciudad de origen y destino deben ser diferentes");
        }
        this.ciudadDestino = ciudadDestino;
    }

    public int getMinutos() {
        return minutos;
    }

    public void setMinutos(int minutos) {
        this.minutos = minutos;
    }

    // Añadir pasajero al vuelo
    public boolean addPasajero(Pasajero pasajero) {
        return pasajeros.add(pasajero);
    }

    // Eliminar pasajero del vuelo
    public boolean removePasajero(Pasajero pasajero) {
        return pasajeros.remove(pasajero);
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + this.codigoVuelo;
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
        final Vuelo other = (Vuelo) obj;
        return this.codigoVuelo == other.codigoVuelo;
    }

    @Override
    public int compareTo(Vuelo o) {
        return Integer.compare(this.codigoVuelo, o.codigoVuelo);
    }

    @Override
    public String toString() {
        return "Vuelo{" + "codigoVuelo=" + codigoVuelo + ", ciudadOrigen=" + ciudadOrigen + ", ciudadDestino=" + ciudadDestino + ", minutos=" + minutos + ", pasajeros=" + pasajeros + '}';
    }

}
