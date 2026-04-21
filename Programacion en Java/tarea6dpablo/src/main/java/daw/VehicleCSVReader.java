package daw;

import com.opencsv.CSVReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class VehicleCSVReader {

    public static List<Vehiculo> leerVehiculo(String path) {
        List<Vehiculo> vehicles = new ArrayList<>();

        try (CSVReader reader = new CSVReader(new FileReader(path))) {
            String[] line;
            reader.readNext(); // saltar cabecera

            while ((line = reader.readNext()) != null) {
                Vehiculo v = new Vehiculo(
                        line[0],
                        line[1],
                        Integer.parseInt(line[2]),
                        line[3],
                        line[4],
                        line[5]
                );
                vehicles.add(v);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return vehicles;
    }
}