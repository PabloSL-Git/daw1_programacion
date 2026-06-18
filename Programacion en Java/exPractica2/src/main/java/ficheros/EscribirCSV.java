package ficheros;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import modelos.Persona;

public class EscribirCSV {
    public static void escribir(List<Persona> personas, String ruta) {
        try (FileWriter fw = new FileWriter(ruta)) {
            fw.write("id,nombre,apellido,email,genero,fecha_nacimiento,jubilado,ciudad\n");
            for (Persona p : personas) {
                fw.write(p.getId() + "," + p.getNombre() + "," + p.getApellido()
                    + "," + p.getEmail() + "," + p.getGenero()
                    + "," + p.getFechaNacimiento() + "," + p.isJubilado()
                    + "," + p.getCiudad() + "\n");
            }
        } catch (IOException e) {
            System.out.println("Error al escribir: " + e.getMessage());
        }
    }
}