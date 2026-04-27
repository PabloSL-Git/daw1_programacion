package daw;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        ObjectMapper mapper = new ObjectMapper();

        try {
            // Leer desde resources
            InputStream is = Main.class.getClassLoader()
                    .getResourceAsStream("precipatacionesBadajoz.json");

            // Convertir a array
            Precipitacion[] array = mapper.readValue(is, Precipitacion[].class);

            // Pasar a lista
            List<Precipitacion> lista = Arrays.asList(array);

            // Mostrar
            for (Precipitacion p : lista) {
                System.out.println(
                        p.getEstacionMeteorologica() + " - " +
                                p.getPrecipitacion() + " mm - " +
                                p.getFecha());
            }

        } catch (Exception e) {
            throw new RuntimeException("Erroro al leer json", e);
        }
    }
}