package servicios;

import modelos.Vehiculo;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class VehiculoService {

    public static ArrayList<Vehiculo> leerVehiculos(String rutaFichero) throws IOException {

        ObjectMapper mapper = new ObjectMapper();

        return mapper.readValue(
                new File(rutaFichero),
                mapper.getTypeFactory().constructCollectionType(ArrayList.class, Vehiculo.class)
        );
    }
}