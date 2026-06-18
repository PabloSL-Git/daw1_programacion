/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio2;

import static ejercicio2.Metodos2.agruparPorDiagnostico;
import static ejercicio2.Metodos2.algunoEnPlanta5;
import static ejercicio2.Metodos2.contarMayores65;
import static ejercicio2.Metodos2.edadPromedio;
import static ejercicio2.LectorJson.leerJSON;
import static ejercicio2.Metodos2.nombresMayuscula;
import static ejercicio2.Metodos2.todosMayoresDeEdad;
import static ejercicio2.Metodos2.tresMasJovenes;
import static ejercicio2.LectorJson.devolverLista;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 *
 * @author usuario
 */
public class Principal {

    public static void main(String[] args) {

        System.out.println("\n-----------A-----------");

        Set<Paciente> pacientes = null;
        try {
            pacientes = leerJSON("3_pacientes_hospital.json");
        } catch (IOException e) {
            System.out.println("Error al leer el fichero: " + e.getMessage());
        }

        List<Paciente> lista = pacientes.stream().collect(Collectors.toList());

        System.out.println("\n-----------B-----------");

        System.out.println("-----------a-----------");

        System.out.println("Mayores de 65: " + contarMayores65(lista));

        System.out.println("\n-----------b-----------");

        System.out.println("Nombres en mayuscula:");
        nombresMayuscula(lista).forEach(n -> System.out.println(n));

        System.out.println("\n-----------c-----------");

        System.out.println("Edad promedio: " + edadPromedio(lista));

        System.out.println("\n-----------d-----------");

        //   List<Paciente> anciano = pacienteMasAnciano(lista);
        //    if (anciano.isPresent()) {
        //       System.out.println("Paciente mas anciano: " + anciano.get());
        //  }
        System.out.println("\n-----------e-----------");

        System.out.println("Todos mayores de edad: " + todosMayoresDeEdad(lista));

        System.out.println("\n-----------e-----------");

        System.out.println("Alguno en planta 5: " + algunoEnPlanta5(lista));

        System.out.println("\n-----------f-----------");

        System.out.println("Pacientes por diagnostico:");
        agruparPorDiagnostico(lista).forEach((diagnostico, ps) -> {
            System.out.println(diagnostico + ": " + ps.size() + " pacientes");

        });

        System.out.println("\n-----------g-----------");

        System.out.println("Tres pacientes mas jovenes:");
        tresMasJovenes(lista).forEach(n -> System.out.println(n));
    }

}
