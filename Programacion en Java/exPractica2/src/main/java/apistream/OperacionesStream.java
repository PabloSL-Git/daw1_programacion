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
                .map(Persona::getEmail)
                .collect(Collectors.toSet());
    }

    public static Map<String, Long> contarPorGenero(List<Persona> personas) {
        return personas.stream()
                .collect(Collectors.groupingBy(Persona::getGenero, Collectors.counting()));
    }

    public static Map<String, List<Persona>> agruparPorGenero(List<Persona> personas) {
        return personas.stream()
                .collect(Collectors.groupingBy(Persona::getGenero));
    }

    public static List<Persona> jubiladasFemeninasOrdenadasPorFecha(List<Persona> personas) {
        return personas.stream()
                .filter(Persona::isJubilado)
                .filter(p -> p.getGenero().equals("Female"))
                .sorted(Comparator.comparing(Persona::getFechaNacimiento))
                .collect(Collectors.toList());
    }
}
