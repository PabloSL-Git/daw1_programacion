package modelos;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.CSVWriter;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class ListaPlatos {

    private final ArrayList<Plato> listaPlatos;

    public ListaPlatos() {
        listaPlatos = new ArrayList<>();
        cargarDesdeCsv();
    }

    private void cargarDesdeCsv() {
        InputStream input = getClass().getResourceAsStream("/modelos/restaurante.csv");
        if (input == null) {
            throw new IllegalStateException("No se encuentra el fichero restaurante.csv");
        }

        try (InputStreamReader reader = new InputStreamReader(input, StandardCharsets.UTF_8);
                CSVReader csvReader = new CSVReaderBuilder(reader).withSkipLines(1).build()) {

            String[] fila;
            while ((fila = csvReader.readNext()) != null) {
                if (fila.length < 5)
                    continue;

                String idPlato = fila[0].trim();
                String nombre = fila[1].trim();
                String descripcion = fila[2].trim();
                double precio = Double.parseDouble(fila[3].trim());
                boolean esTemporada = Boolean.parseBoolean(fila[4].trim());

                listaPlatos.add(new Plato(idPlato, nombre, descripcion, precio, esTemporada));
            }

        } catch (Exception ex) {
            throw new RuntimeException("Error leyendo restaurante.csv", ex);
        }
    }

    public ArrayList<Plato> getListaPlatos() {
        return listaPlatos;
    }

    public ArrayList<Plato> getPlatosConPrecioMayorQue(double precio) {
        return listaPlatos.stream()
                .filter(plato -> plato.getPrecio() > precio)
                .limit(15)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public Plato getPlato(String idPlato) {
        return listaPlatos.stream()
                .filter(plato -> plato.getIdPlato().equalsIgnoreCase(idPlato))
                .findFirst()
                .orElse(null);
    }

    public void guardarEnCsv() {
        try (CSVWriter writer = new CSVWriter(new FileWriter("src/main/java/modelos/restaurante.csv"))) {
            writer.writeNext(new String[]{"idPlato", "nombre", "descripcion", "precio", "esTemporada"});
            for (Plato plato : listaPlatos) {
                writer.writeNext(new String[]{plato.getIdPlato(), plato.getNombre(), plato.getDescripcion(), String.valueOf(plato.getPrecio()), String.valueOf(plato.isEsTemporada())});
            }
        } catch (Exception ex) {
            throw new RuntimeException("Error guardando restaurante.csv", ex);
        }
    }
}