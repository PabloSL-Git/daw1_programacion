package tarea7b;

import com.opencsv.CSVWriterBuilder;
import com.opencsv.ICSVWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Clase encargada de escribir resultados en ficheros CSV.
 */
public class CsvWriter {

	/**
	 * Escribe un nuevo fichero CSV con VIN y matrícula de los vehículos rojos.
	 *
	 * @param vehiculos lista de vehículos.
	 * @param rutaSalida ruta del fichero de salida.
	 */
	public void escribirVehiculosRojos(List<Vehiculo> vehiculos, String rutaSalida) {
		List<Vehiculo> rojos = vehiculos.stream()
			.filter(v -> v.getVehicleColor() != null && v.getVehicleColor().equalsIgnoreCase("Red"))
			.collect(Collectors.toList());

		try (ICSVWriter writer = new CSVWriterBuilder(new FileWriter(rutaSalida))
			.withSeparator(';')
			.build()) {
			writer.writeNext(new String[] {"vehiculo_vin", "plate"});
			for (Vehiculo vehiculo : rojos) {
				writer.writeNext(new String[] {vehiculo.getVehicleVin(), vehiculo.getVehicleLicensePlate()});
			}
		} catch (IOException e) {
			throw new IllegalStateException("Error escribiendo el fichero de salida: " + rutaSalida, e);
		}
	}
}
