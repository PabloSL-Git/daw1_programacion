package ficheros;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.nio.file.Path;
import java.util.List;
import modelos.Persona;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author usuario
 */
public class LeerCSV {

    String rutaCsv = Path.of("Personas.csv.csv").toAbsolutePath().toString();
    String rutaSalida = Path.of("Personas.csv.csv").toAbsolutePath().toString();

    public List<Persona> leerCSV(String rutaCsv) {
        try (Reader reader = new FileReader(rutaCsv)) {
            CsvToBean<Persona> csvToBean = new CsvToBeanBuilder<Persona>(reader)
                    .withType(Persona.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();
            return csvToBean.parse();
        } catch (Exception e) {
            throw new IllegalStateException("Error leyendo el fichero CSV.", e);
        }
    }
}
