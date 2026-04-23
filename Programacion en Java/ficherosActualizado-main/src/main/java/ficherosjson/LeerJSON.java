
package ficherosjson;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

/**
 *
 * @author Vico
 */
public class LeerJSON {

    public static void main(String[] args) throws IOException {
        // Crea un mapeador de objetos a JSON
        ObjectMapper mapeador = new ObjectMapper();
        // Permite a mapeador usar fechas según java time
        mapeador.registerModule(new JavaTimeModule());
        // Lee el catálogo de muebles desde el fichero JSON y lo guarda en una lista de objetos de tipo MuebleVO
        ArrayList<Mueble> catalogo = mapeador.readValue(new File("catalogoMuebles.json"),
                    mapeador.getTypeFactory().constructCollectionType(ArrayList.class, Mueble.class));
        
        // Muestra el catálogo de muebles por consola
        System.out.println("---- Catálogo de Muebles ----");
        catalogo.forEach(System.out::println);

        // Lee el catálogo de envíos desde el fichero JSON y lo guarda en una lista de objetos de tipo EnvioMuebles
        ArrayList<EnvioMuebles> envios = mapeador.readValue(new File("catalogoEnvios.json"),
                    mapeador.getTypeFactory().constructCollectionType(ArrayList.class, EnvioMuebles.class));
        System.out.println("\n---- Catálogo de Envíos ----");
        envios.forEach(System.out::println);
    }
    
}
