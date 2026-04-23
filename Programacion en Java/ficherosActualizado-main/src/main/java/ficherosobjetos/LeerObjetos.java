package ficherosobjetos;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

/**
 *
 * @author Vico
 */
public class LeerObjetos {

    // Método que se encarga de abrir el fichero de ruta "idFichero"
    // y carga los objetos Persona en una lista

    public static ArrayList<Persona> leerPersonas(String idFichero) {

        ArrayList<Persona> personas = new ArrayList<>();
        Persona tmp;
        // Estructura try-with-resources, que se encarga de cerrar el flujo automáticamente al finalizar el bloque
        // Abre el fichero de ruta "idFichero" para lectura
        // El flujo de lectura de objetos se crea a partir del flujo de bytes FileInputStream, 
        // que se encarga de leer el fichero en formato binario. 
        try (FileInputStream fis = new FileInputStream(idFichero)) {

        // A partir del objeto fis se crea otro recurso para leer objetos
        // El flujo de objetos ObjectInputStream se encarga de convertir el formato binario a objetos Java

            try (ObjectInputStream flujo = new ObjectInputStream(fis)) {
                // Devuelve el número estimado de bytes que hay por leer
                // o cero si se ha alcanzado el final del fichero
                while (fis.available() > 0) {
                    // Se hace un casting explícito del objeto devuelto
                    // por readObject()
                    tmp = (Persona) flujo.readObject();
                    // Añade el objeto a la lista
                    personas.add(tmp);
                }

            } catch (ClassNotFoundException cnfe) {
                System.out.println("Clase Persona no encontrada.");
            }
        } catch (FileNotFoundException e) {
            System.out.println("EL fichero a leer no existe.");
        } catch (IOException ex) {
            System.out.println("Error leyendo el fichero.");
        }

        return personas;

    }

    public static void main(String[] args) {

        ArrayList<Persona> personas = leerPersonas("persona.bin");
        personas.forEach(System.out::println);

    }

}
