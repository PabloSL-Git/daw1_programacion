package ficherosobjetos;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 *
 * @author Vico
 */

public class EscribirObjetos {

    public static void main(String[] args) {

        // Ruta del fichero donde se guardarán los objetos Persona
        String idFichero = "persona.bin";
        
        // Estructura try-with-resources. Inicializa un objeto de tipo ObjectOutputStream
        // en función de un flujo FileOutputStream, identificado por "idFichero"
        try (ObjectOutputStream flujo = new ObjectOutputStream(new FileOutputStream(idFichero))) {
            // El método writeObject() escribe el objeto Persona en el flujo, convirtiéndolo a formato binario
            flujo.writeObject(new Persona("Pepa", "1234", 12));
            flujo.writeObject(new Persona("Juan", "5678", 11));
            flujo.writeObject(new Persona("Luis", "1555554", 13));
            // El método flush() guarda los cambios en disco
            flujo.flush();
        } catch (IOException e) {
            System.out.println("Error gestionando el fichero" + e.getMessage());
        }

    }

}
