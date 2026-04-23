package ficherostexto;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Vico
 *
 */
public class LeerFicherosTexto {

    public static void main(String[] args) {

        // Fichero a leer con datos de ejemplo
        String idFichero = "RegAlum.csv";

        // Variables para guardar los datos que se van leyendo
        String[] tokens; // Array de String para guardar los campos de cada línea del fichero
        String linea;

        System.out.println("Leyendo el fichero: " + idFichero); // Para depuración, muestra el nombre del fichero que se va a leer

        // Estructura try-with-resources. Permite cerrar los recursos una vez  finalizadas  las operaciones con el archivo
        // Se usa BufferedReader para mejorar el rendimiento de la lectura, ya que lee
        // en memoria bloques de caracteres,  en lugar de leer carácter a carácter como hace FileReader, 
        // lo que reduce el  número de accesos al disco
        // Para crar un BufferedReader se necesita un recurso de lectura de caracteres, que en este caso es un FileReader, 
        // que se encarga de leer el fichero indicado por "idFichero" en formato de texto
        try (BufferedReader datosFichero = new BufferedReader(new FileReader(idFichero))) {
            // Leemos el fichero línea a línea, mientras no se alcance el final del mismo,
            // que se indica con null al llamar al método readLine() del flujo
            while ((linea = datosFichero.readLine()) != null) {

                // El método split() de la clase String se encarga de separar la línea en trozos en
                // función del carácter separador de campos del fichero CSV
                // y devuelve un array de String con los campos de la línea
                // Se guarda en el array de String cada elemento de la
                // línea en función del carácter separador de campos del fichero CSV, en este caso el punto y coma (;)
                tokens = linea.split(";");
                // Para depuración, muestra los campos de cada línea separados por tabuladores
                for (String string : tokens) {
                    System.out.print(string + "\t");
                }
                System.out.println(); // Salto de línea después de mostrar los campos de cada línea del fichero
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println("Error al leer el fichero.");
        }
    }
}
