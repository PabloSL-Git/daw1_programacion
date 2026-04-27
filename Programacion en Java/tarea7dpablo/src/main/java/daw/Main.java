package daw;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        ObjectMapper mapper = new ObjectMapper();

        try {

            // Leer desde resources
            InputStream is = Main.class.getClassLoader()
                    .getResourceAsStream("precipitacionesBadajoz.json");

            if (is == null) {
                throw new RuntimeException("No se ha encontrado el fichero JSON en resources");
            }

            // Convertir JSON a array de objetos
            Precipitacion[] array = mapper.readValue(is, Precipitacion[].class);

            // Pasar array a lista
            List<Precipitacion> lista = Arrays.asList(array);

            // Mostrar lista por consola
            for (Precipitacion p : lista) {
                System.out.println(
                        p.getEstacionMeteorologica() + " - " +
                                p.getPrecipitacion() + " mm - " +
                                p.getFecha());
            }

            // Crear mapa estación a precipitación
            Map<String, Float> mapa = new HashMap<>();

            for (Precipitacion p : lista) {
                mapa.put(p.getEstacionMeteorologica(), p.getPrecipitacion());
            }

            // Mostrar el map por consola
            for (Map.Entry<String, Float> entry : mapa.entrySet()) {
                System.out.println(entry.getKey() + " -> " + entry.getValue());
            }

            // Guardar el map en un fichero JSON
            mapper.writeValue(
                    new java.io.File("mapaPrecipitaciones.json"),
                    mapa);

            System.out.println("Mapa guardado en JSON correctamente");

            // Registro con mayor precipitación
            Precipitacion max = lista.stream()
                    .max((p1, p2) -> Float.compare(p1.getPrecipitacion(), p2.getPrecipitacion()))
                    .orElseThrow(() -> new RuntimeException("Lista vacía"));

            // Mostrar mayor precipitacion
            System.out.println("MAYOR PRECIPITACION");
            System.out.println(
                    max.getEstacionMeteorologica() + " - " +
                            max.getPrecipitacion() + " mm - " +
                            max.getFecha());

            // mostrar estaciones (entre 10 y 20 octubre)
            long contador = lista.stream()
                    .filter(p -> p.getFecha().get(1) == 10) // octubre
                    .filter(p -> p.getFecha().get(2) >= 10 && p.getFecha().get(2) <= 20)
                    .map(Precipitacion::getEstacionMeteorologica)
                    .distinct()
                    .count();

            System.out.println("ESTACIONES ENTRE 10 Y 20 DE OCTUBRE");
            System.out.println(contador);

            // mostrar media precipitaciones
            double media = lista.stream()
                    .filter(p -> p.getFecha().get(1) == 10) // octubre
                    .filter(p -> p.getFecha().get(2) >= 10 && p.getFecha().get(2) <= 20)
                    .mapToDouble(Precipitacion::getPrecipitacion)
                    .average()
                    .orElse(0);

            System.out.println("MEDIA PRECIPITACIONES (10-20 OCTUBRE)");
            System.out.println(media);

        } catch (Exception e) {
            throw new RuntimeException("Error al leer json", e);
        }

    }
}