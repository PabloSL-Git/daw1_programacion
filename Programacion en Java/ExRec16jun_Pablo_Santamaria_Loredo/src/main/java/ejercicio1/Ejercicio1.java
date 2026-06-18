package ejercicio1;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.opencsv.bean.CsvToBeanBuilder;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Ejercicio1 {

    public static void main(String[] args) {

        // A. Leer el fichero CSV y generar una lista de objetos Matricula
        List<Matricula> matriculas = null;
        try {
            matriculas = leerCSV("3_RegResEleSobMat.csv");
        } catch (IOException e) {
            System.out.println("Error al leer el fichero: " + e.getMessage());
        }

        // B. Imprimir la lista por consola usando un foreach
        System.out.println(" Lista de matrículas ");
        matriculas.forEach(m -> System.out.println(m));

        // C. Devolver un Map con el conteo de alumnos por asignatura y prioridad
        Map<String, Map<Integer, Long>> resultado = contarPorAsignaturaYPrioridad(matriculas);

        // D. Mostrar la información del map usando objetos Map.Entry<>
        System.out.println("\n Alumnos por asignatura con prioridad 1, 2 o 3 ");
        for (Map.Entry<String, Map<Integer, Long>> entry : resultado.entrySet()) {
            System.out.println("Asignatura: " + entry.getKey());
            for (Map.Entry<Integer, Long> conteo : entry.getValue().entrySet()) {
                System.out.println("  Prioridad " + conteo.getKey() + ": " + conteo.getValue() + " alumnos");
            }
        }

        // E. Obtener un Set con los nombres de las asignaturas desde el map anterior
        Set<String> nombresAsignaturas = resultado.keySet();

        // E. Mostrar el Set usando un objeto Iterator
        System.out.println("\n Nombres de asignaturas (Iterator) ");
        Iterator<String> iterador = nombresAsignaturas.iterator();
        while (iterador.hasNext()) {
            System.out.println(iterador.next());
        }

        // F. Volcar el map del paso C
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.registerModule(new JavaTimeModule());
            mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
            mapper.writerWithDefaultPrettyPrinter().writeValue(new File("conteo.json"), resultado);
            System.out.println("\nFichero conteo.json generado correctamente.");
        } catch (IOException e) {
            System.out.println("Error al escribir conteo.json: " + e.getMessage());
        }
    }

    // A. Lee el CSV y devuelve una lista de objetos Matricula
    public static List<Matricula> leerCSV(String ruta) throws IOException {
        try (FileReader reader = new FileReader(ruta)) {
            return new CsvToBeanBuilder<Matricula>(reader)
                    .withType(Matricula.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build()
                    .parse();
        }
    }

    // C. Devuelve un TreeMap con cada asignatura y cuántos alumnos la han elegido con prioridad 1, 2 o 3
    public static Map<String, Map<Integer, Long>> contarPorAsignaturaYPrioridad(List<Matricula> matriculas) {

        List<String> asignaturas = Arrays.asList("ANAP", "AYSO", "CDPC", "FR2", "PCYAA", "TICO");

        Map<String, Map<Integer, Long>> resultado = new TreeMap<>();

        for (String asignatura : asignaturas) {

            Map<Integer, Long> conteoPorPrioridad = matriculas.stream()
                    .map(m -> getPrioridad(m, asignatura))
                    .filter(p -> p == 1 || p == 2 || p == 3)
                    .collect(Collectors.groupingBy(p -> p, Collectors.counting()));

            resultado.put(asignatura, conteoPorPrioridad);
        }

        return resultado;
    }

    // Devuelve la prioridad asignada a una asignatura concreta en una matrícula
    private static int getPrioridad(Matricula m, String asignatura) {
        switch (asignatura) {
            case "TICO":
                return m.getTico();
            case "CDPC":
                return m.getCdpc();
            case "AYSO":
                return m.getAyso();
            case "ANAP":
                return m.getAnap();
            case "PCYAA":
                return m.getPcyaa();
            case "FR2":
                return m.getFr2();
            default:
                return -1;
        }
    }
}
