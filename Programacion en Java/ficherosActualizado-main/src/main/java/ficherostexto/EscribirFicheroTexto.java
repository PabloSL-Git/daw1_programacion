package ficherostexto;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Vico
 */
public class EscribirFicheroTexto {

    public static void main(String[] args) {
        // Fichero a crear. Ruta relativa a la carpeta raíz del proyecto
        String idFichero = "array.txt";
        String tmp;
        // Array a escribir
        int matrizNumeros[][] = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}};

        // Estructura try-with-resources. Instancia el objeto con el fichero a escribir
        // y se encarga de cerrar el recurso "flujo" una vez finalizadas las operaciones, para optimizar el uso de memoria

        // FileWriter es un recurso de escritura que se encarga de escribir caracteres de texto 
        // en el fichero indicado por "idFichero". Es el paso previo para crear un BufferedWriter, que mejora el rendimiento de la escritura
        // BufferedWriter es un recurso de escritura que se encarga de escribir en una memoria intermediao antes de escribir en el disco
        // Se usa para mejorar el rendimiento,  ya que reduce el número de escrituras en disco, 
        // porque lo que hay en la memoria intermedia se escribe en disco cuando se llena 
        // o cuando se llama al método flush()

        // Si se utiliza el constructor FileWriter(idFichero, true) entonces se anexa información
        // al final del fichero idFichero, en lugar de sobreescribirlo. Si se omite el segundo argumento o se pone false
        // , entonces se sobreescribe el fichero

        try (BufferedWriter flujo = new BufferedWriter(new FileWriter(idFichero))) {
            for (int[] matrizNumero : matrizNumeros) {
                for (int j = 0; j < matrizNumero.length; j++) {
                    // Obtengo en un String el elemento int de la matriz
                    tmp = String.valueOf(matrizNumero[j]);
                    // Si es el último de la fila no pone la coma
                    if (j == matrizNumero.length - 1) {
                        // Usamos metodo write() para escribir en el buffer
                        flujo.write(tmp);
                    } else {
                        flujo.write(tmp + ",");
                    }
                }
                // Metodo newLine() añade salto de línea después de cada fila
                flujo.newLine();
            }
            // Metodo fluh() guarda cambios en disco 
            flujo.flush();
            System.out.println("Fichero " + idFichero + " creado correctamente.");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}
