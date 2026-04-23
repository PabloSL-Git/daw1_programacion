/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ficherostexto;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

/**
 *
 * @author Vico
 */
public class EscribirFicherosClaseFiles {

    public static void main(String[] args) {

        String texto = """
                       Lorem ipsum dolor sit amet, consectetur adipiscing elit, 
                       sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. 
                       Ut enim ad minim veniam, quis nostrud exercitation ullamco 
                       laboris nisi ut aliquip ex ea commodo consequat. 
                       Duis aute irure dolor in reprehenderit in voluptate velit 
                       esse cillum dolore eu fugiat nulla pariatur. 
                       Excepteur sint occaecat cupidatat non proident, 
                       sunt in culpa qui officia deserunt mollit anim id est laborum
                       """;
        // Escribe el string en un fichero
        escribirString(texto);
        
        // Obtengo la lista de líneas que hay en el String
        List<String> lineas = texto.lines().toList();
        // Imprimo la lista
        lineas.forEach(System.out::println);
        // Escribo en un fichero la lista de líneas, cada elemento de la lista en una línea del fichero
        escribirListaString(lineas);
        
    }

    // Escribe un String a un fichero, sobreescribiendo si existe
    // Método avanzado, que utiliza la clase Files del paquete java.nio.file, que proporciona métodos para trabajar 
    // con ficheros y directorios de forma más eficiente y sencilla que las clases tradicionales 
    // como FileWriter o BufferedWriter
    public static void escribirString(String datos) {

        try {
            // Paths.get("escribirString.txt") obtiene un objeto de tipo Path con la ruta del fichero a escribir
            // Los objetos tipo Path representan rutas de ficheros o directorios, y se utilizan para realizar operaciones sobre ellos
            // datos.getBytes(StandardCharsets.UTF_8) convierte el String a un array de bytes con codificación UTF-8
            // StandardOpenOption.CREATE crea el fichero si no existe, y 
            // StandardOpenOption.TRUNCATE_EXISTING sobreescribe el fichero si ya existe
            // El método write() escribe el array de bytes en el fichero indicado por la ruta del objeto Path
            Files.write(Paths.get("escribirString.txt"), datos.getBytes(StandardCharsets.UTF_8),
                    StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
        } catch (IOException ex) {
            System.out.println("Error creando el fichero");
        }
    }

    // Método para escribir una lista de String, sobreescribiendo si el fichero existe
    public static void escribirListaString(List<String> lista) {
        
        try {
            // Este ejemplo es similar al anterior pero el método write() recibe una lista de String, 
            // que se escribe en el fichero con un salto de línea entre cada elemento
            // Internamente el método write() convierte cada String a un array de bytes con codificación UTF-8, 
            // y luego lo escribe en el fichero (por eso no hay llamada al método getBytes() como en el ejemplo anterior)
            Files.write(Paths.get("escribirLineas.txt"), lista, StandardCharsets.UTF_8,
                    StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
        } catch (IOException ex) {
            System.out.println("Error creando el fichero");
        }
    }
}
