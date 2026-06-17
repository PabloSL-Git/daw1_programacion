package ficheros;

import com.opencsv.bean.CsvToBeanBuilder;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import modelos.Persona;

public class LeerCSV {

    public static List<Persona> leer(String ruta) throws IOException {
        try (FileReader reader = new FileReader(ruta)) {
            return new CsvToBeanBuilder<Persona>(reader)
                    .withType(Persona.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build()
                    .parse();
        }
    }
}
