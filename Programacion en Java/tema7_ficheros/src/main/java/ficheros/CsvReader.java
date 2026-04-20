package ficheros;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.List;

/**
 * Clase encargada de leer vehículos desde un fichero CSV.
 */
public class CsvReader {

	/**
	 * Lee una lista de vehículos desde el fichero CSV indicado.
	 *
	 * @param rutaCsv ruta del fichero CSV.
	 * @return lista de vehículos leídos.
	 */
	public List<Vehiculo> leerVehiculos(String rutaCsv) {
		try (Reader reader = new FileReader(rutaCsv)) {
			CsvToBean<Vehiculo> csvToBean = new CsvToBeanBuilder<Vehiculo>(reader)
				.withType(Vehiculo.class)
				.withIgnoreLeadingWhiteSpace(true)
				.build();
			return csvToBean.parse();
		} catch (FileNotFoundException e) {
			throw new IllegalStateException("No se encontró el fichero: " + rutaCsv, e);
		} catch (Exception e) {
			throw new IllegalStateException("Error leyendo el fichero CSV.", e);
		}
	}
}
