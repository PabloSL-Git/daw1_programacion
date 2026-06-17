package ficheros;

import com.opencsv.bean.CsvToBeanBuilder;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import modelos.Persona;

public class LeerJSON {

    public static List<Persona> leer(String ruta) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        return mapper.readValue(
            new File(ruta),
            mapper.getTypeFactory().constructCollectionType(List.class, Persona.class)
        );
    }
}