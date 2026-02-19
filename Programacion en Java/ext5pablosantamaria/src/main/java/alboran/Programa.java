/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package alboran;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author usuario
 */
public class Programa {

    public static void main(String[] args) {

        // Lista vuelos
        List<Vuelo> listaVuelos = new ArrayList<>();

        Vuelo vuelo1 = new Vuelo("1", "Valencia", "Madrid", 50);
        Vuelo vuelo2 = new Vuelo("2", "Londres", "Paris", 60);
        Vuelo vuelo3 = new Vuelo("3", "Nueva York", "Barcelona", 70);
        Vuelo vuelo4 = new Vuelo("4", "Madrid", "Paris", 80);
        Vuelo vuelo5 = new Vuelo("5", "Sevilla", "Madrid", 90);

        listaVuelos.add(vuelo1);
        listaVuelos.add(vuelo2);
        listaVuelos.add(vuelo3);
        listaVuelos.add(vuelo4);
        listaVuelos.add(vuelo5);

        // añadir pasajeros
        vuelo1.añadirPasajero(new Pasajero("1", "456", "Pablo", "pablo@email"));
        vuelo2.añadirPasajero(new Pasajero("2", "334", "Rocio", "rocio@email"));
        vuelo3.añadirPasajero(new Pasajero("3", "567", "Mario", "mario@email"));

        // imprimir lista vuelos

        for (Vuelo s : listaVuelos) {
            System.out.println("");
        }

    }

    // Vuelos unicos
}
