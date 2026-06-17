import apistream.OperacionesStream;
import ficheros.EscribirJSON;
import ficheros.LeerCSV;
import java.io.IOException;
import java.util.List;
import modelos.Persona;

public class Programa {

    public static void main(String[] args) {
        List<Persona> personas = null;
        try {
            personas = LeerCSV.leer("personas.csv");
        } catch (IOException e) {
            System.out.println("Error al leer el fichero: " + e.getMessage());
        }

        System.out.println("Correos en Los Angeles:");
        System.out.println(OperacionesStream.correosEnLosAngeles(personas));

        System.out.println("\nPersonas por genero:");
        System.out.println(OperacionesStream.contarPorGenero(personas));

        System.out.println("\nPersonas agrupadas por genero:");
        System.out.println(OperacionesStream.agruparPorGenero(personas));

        List<Persona> jubiladas = OperacionesStream.jubiladasFemeninasOrdenadasPorFecha(personas);
        System.out.println("\nJubiladas femeninas ordenadas por fecha de nacimiento:");
        jubiladas.forEach(p -> System.out.println(p));

        try {
            EscribirJSON.escribir(jubiladas, "jubiladas.json");
        } catch (IOException e) {
            System.out.println("Error al escribir el fichero: " + e.getMessage());
        }
        System.out.println("\nFichero jubiladas.json generado correctamente.");
    }
}
