import apistream.OperacionesStream;
import ficheros.EscribirJSON;
import ficheros.LeerCSV;
import java.io.IOException;
import java.util.List;
import modelos.Persona;

public class Programa {

    public static void main(String[] args) throws IOException {
        List<Persona> personas = LeerCSV.leer("personas.csv");

        System.out.println("Correos en Los Angeles:");
        System.out.println(OperacionesStream.correosEnLosAngeles(personas));

        System.out.println("\nPersonas por genero:");
        System.out.println(OperacionesStream.contarPorGenero(personas));

        System.out.println("\nPersonas agrupadas por genero:");
        System.out.println(OperacionesStream.agruparPorGenero(personas));

        List<Persona> jubiladas = OperacionesStream.jubiladasFemeninasOrdenadasPorFecha(personas);
        System.out.println("\nJubiladas femeninas ordenadas por fecha de nacimiento:");
        jubiladas.forEach(System.out::println);

        EscribirJSON.escribir(jubiladas, "jubiladas.json");
        System.out.println("\nFichero jubiladas.json generado correctamente.");
    }
}
