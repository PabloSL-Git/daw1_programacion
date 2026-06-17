package apistream;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import modelos.Persona;

public class OperacionesStream {

    public static Set<String> correosEnLosAngeles(List<Persona> personas) {
        return personas.stream()
                .filter(p -> p.getCiudad().equals("Los Angeles"))
                .map(p -> p.getEmail())
                .collect(Collectors.toSet());
    }

    public static Map<String, Long> contarPorGenero(List<Persona> personas) {
        return personas.stream()
                .collect(Collectors.groupingBy(p -> p.getGenero(), Collectors.counting()));
    }

    public static Map<String, List<Persona>> agruparPorGenero(List<Persona> personas) {
        return personas.stream()
                .collect(Collectors.groupingBy(p -> p.getGenero()));
    }

    public static List<Persona> jubiladasFemeninasOrdenadasPorFecha(List<Persona> personas) {
        return personas.stream()
                .filter(p -> p.isJubilado())
                .filter(p -> p.getGenero().equals("Female"))
                .sorted(Comparator.comparing(p -> p.getFechaNacimiento()))
                .collect(Collectors.toList());
    }
}
