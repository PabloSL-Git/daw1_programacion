package ficheros;

import java.nio.file.Path;
import java.util.List;

/**
 * Clase principal que ejecuta la lectura y escritura de CSV.
 */
public class App {

	public static void main(String[] args) {
		String rutaCsv = Path.of("vehiculos.csv").toAbsolutePath().toString();
		String rutaSalida = Path.of("resultado.csv").toAbsolutePath().toString();

		CsvReader lector = new CsvReader();
		List<Vehiculo> vehiculos = lector.leerVehiculos(rutaCsv);

		System.out.println("Vehículos leídos: " + vehiculos.size());
		for (Vehiculo vehiculo : vehiculos) {
			System.out.println(vehiculo);
		}

		CsvWriter escritor = new CsvWriter();
		escritor.escribirVehiculosRojos(vehiculos, rutaSalida);

		System.out.println("Fichero generado: " + rutaSalida);
	}
}
