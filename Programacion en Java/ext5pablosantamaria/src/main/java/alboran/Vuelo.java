/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package alboran;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author usuario
 */
public class Vuelo implements Comparable<Vuelo> {

    private final String idVuelo;
    private String ciudadOrigen;
    private String ciudadDestino;
    private int minutos;
    private final List<Pasajero> pasajeros = new ArrayList<>();

    // constructor
    public Vuelo(String idVuelo, String ciudadOrigen, String ciudadDestino, int minutos) {

        if (ciudadOrigen == ciudadDestino) {
            throw new Error("Ciudad de origen no puede ser igual a la ciudad de destino");
        }
        if (minutos <= 45) {
            throw new Error("Deben ser mas de 45 minutos");
        }

        this.idVuelo = idVuelo;
        this.ciudadOrigen = ciudadOrigen;
        this.ciudadDestino = ciudadDestino;
        this.minutos = minutos;
    }

    // getter y setter
    public String getIdVuelo() {
        return idVuelo;
    }

    public String getCiudadOrigen() {
        return ciudadOrigen;
    }

    public int getMinutos() {
        return minutos;
    }

    public List<Pasajero> getPasajeros() {
        return pasajeros;
    }

    public List<Pasajero> getLista() {
        return lista;
    }

    public void setCiudadOrigen(String ciudadOrigen) {
        this.ciudadOrigen = ciudadOrigen;
    }

    public void setCiudadDestino(String ciudadDestino) {
        this.ciudadDestino = ciudadDestino;
    }

    public void setMinutos(int minutos) {
        this.minutos = minutos;
    }

    // hascode
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.idVuelo);
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
        final Vuelo other = (Vuelo) obj;
        return Objects.equals(this.idVuelo, other.idVuelo);
    }

    // Añadir pasajero
    private List<Pasajero> lista;

    public boolean añadirPasajero(Pasajero pasajero) {
        return lista.add(pasajero);
    }

    // Quitar pasajero
    public boolean eliminarPasajero(Pasajero pasajero) {
        return lista.remove(pasajero);
    }

    public String getCiudadDestino() {
        return ciudadDestino;
    }

    // comparador 
    @Override
    public int compareTo(Vuelo pasajero) {
        return this.idVuelo.compareTo(idVuelo);
    }

}
