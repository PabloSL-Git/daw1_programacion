/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ficherostexto;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Vico
 */
public class LeerFicheroClaseFiles {

    public static void main(String[] args) {

        List<String> lineas=new ArrayList<>();

        try {
            // El método readAllLines() lee todas las líneas de un fichero y las devuelve como una lista de String
            // Es un método avanzado que utiliza la clase Files del paquete java.nio.file, que proporciona métodos 
            // para trabajar con ficheros y directorios de forma más eficiente y sencilla que las clases tradicionales 
            // como FileReader o BufferedReader
             lineas = Files.readAllLines(Paths.get("RegAlum.csv"), StandardCharsets.UTF_8);
        } catch (IOException ex) {
            System.out.println("Error leyendo el fichero");
        }
        // Imprimo la lista de líneas obtenida del fichero
        for (String linea : lineas) {
            System.out.println(linea);
        }
    }
    
    

}
