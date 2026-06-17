/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package tema6;



import java.util.HashSet;


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

        System.out.println("aaaaaaa" + hotel);
        // 2

    }
}
