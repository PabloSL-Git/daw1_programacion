package ejercicio2;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Metodos2 {

    // a. cuenta pacientes mayores de 65
    public static long contarMayores65(List<Paciente> pacientes) {
        return pacientes.stream()
                .filter(p -> p.getEdad() > 65)
                .count();
    }

// b. devuelve lista de nombres con primera letra en mayuscula
    public static List<String> nombresMayuscula(List<Paciente> pacientes) {
        return pacientes.stream()
                .map(p -> {
                    String nombre = p.getNombre();
                    return nombre.substring(0, 1).toUpperCase() + nombre.substring(1).toLowerCase();
                })
                .collect(Collectors.toList());
    }

    // c. calcula edad promedio, devuelve 0.0 si no hay pacientes
    public static double edadPromedio(List<Paciente> pacientes) {
        return pacientes.stream()
                .mapToInt(p -> p.getEdad())
                .average()
                .orElse(0.0);
    }

    // d. devuelve el paciente con mayor edad
    // public static List<Paciente> pacienteMasAnciano(List<Paciente> pacientes) {
    //     return pacientes.stream()
    //             .max(Comparator.comparing(p -> p.getEdad()));
    // }
    
    // e. comprueba si todos los pacientes son mayores de 18
    public static boolean todosMayoresDeEdad(List<Paciente> pacientes) {
        return pacientes.stream()
                .allMatch(p -> p.getEdad() >= 18);
    }

    // e. comprueba si al menos uno esta en habitacion 500-599
    public static boolean algunoEnPlanta5(List<Paciente> pacientes) {
        return pacientes.stream()
                .anyMatch(p -> p.getHabitacion() >= 500 && p.getHabitacion() <= 599);
    }

    // f. agrupa pacientes por diagnostico
    public static Map<String, List<Paciente>> agruparPorDiagnostico(List<Paciente> pacientes) {
        return pacientes.stream()
                .collect(Collectors.groupingBy(p -> p.getDiagnostico()));
    }

    // g. devuelve nombres de los tres pacientes mas jovenes ordenados de menor a mayor edad
    public static List<String> tresMasJovenes(List<Paciente> pacientes) {
        return pacientes.stream()
                .sorted(Comparator.comparing(p -> p.getEdad()))
                .limit(3)
                .map(p -> p.getNombre())
                .collect(Collectors.toList());
    }
}
