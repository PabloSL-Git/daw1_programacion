/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package alboran;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author pablo
 */
public class Programa {

    public static void main(String[] args) {

        List<Vuelo> vuelos = new ArrayList<>();
        
        Vuelo vuelo1 = new Vuelo(3, "Madrid", "Barcelona", 60);
          Vuelo vuelo2 = new Vuelo(1, "Madrid", "Valencia", 46);
          Vuelo vuelo3 = new Vuelo(2, "Barcelona", "Valencia", 120);
          Vuelo vuelo4 = new Vuelo(0, "Valencia", "Madrid", 80);
          Vuelo vuelo5 = new Vuelo(1, "Barcelona", "Madrid", 75);

          // Añade los vuelos a la lista
          vuelos.add(vuelo1);
          vuelos.add(vuelo2);
          vuelos.add(vuelo3);
          vuelos.add(vuelo4);
          vuelos.add(vuelo5);
          
          // Imprime los vuelos sin pasajeros para verificar su creación
          System.out.println("Vuelos sin pasajeros, hay vuelos con id repetido:\n");
          for (Vuelo vuelo : vuelos) {
               System.out.println(vuelo);
          }
          System.out.println("------------------------------");
        

    }

}
