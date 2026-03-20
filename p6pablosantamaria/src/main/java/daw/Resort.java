/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package daw;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 *
 * @author usuario
 */
public class Resort {

    public static void main(String[] args) {

        // 1
        // lista clientes
        HashSet<Cliente> clientes = new HashSet<>();
        clientes.add(new Cliente("1234", 200));
        clientes.add(new Cliente("4321", 400));

        // lista habitaciones
        HashSet<Habitacion> habitaciones = new HashSet<>();
        habitaciones.add(new Estandar(true, 200, 1, 3));
        habitaciones.add(new Estandar(true, 200, 1, 3));
        habitaciones.add(new Suite(true, 600, 1, 4));
        habitaciones.add(new Suite(true, 600, 1, 4));
        habitaciones.add(new SuitePresidencial(true, 1, 3));
        habitaciones.add(new SuitePresidencial(true, 1, 3));

        // hotel
        Hotel hotel = new Hotel("564", "Elba", habitaciones, clientes);

        System.out.println("aaaaaaa");
        // 2
        
    public Map gastoPorCliente(Hotel) {
        Map<String, Integer> m = new HashMap<>();

        for (Map.Entry<String, Integer> e : m.entrySet()) {
            e.getKey();
            e.getValue();
        }
    }

}
}
