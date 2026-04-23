
package ficherosjson;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

/**
 *
 * @author Vico
 */
public class EscribirJSON {

    public static void main(String[] args) throws IOException {
        // Crea un mapeador de objetos a JSON
        ObjectMapper mapeador = new ObjectMapper();
        
        // Permite a mapeador usar fechas según java time
        mapeador.registerModule(new JavaTimeModule());
        
        // Formato JSON bien formateado. Si se comenta, el fichero queda minificado
        mapeador.configure(SerializationFeature.INDENT_OUTPUT, true);

        // Escribe en un fichero JSON el catálogo de muebles que se pasa como argumento el método generarCatalogo()
        mapeador.writeValue(new File("catalogoMuebles.json"), generarCatalogo());
                
        // Escribe en un fichero JSON el catálogo de envíos que se pasa como argumento el método generarEnvios()
        mapeador.writeValue(new File("catalogoEnvios.json"), generarEnvios());
    }
    
    // Genera una lista con muebles
    public static ArrayList<Mueble> generarCatalogo(){
        ArrayList<Mueble> lista = new ArrayList<>();

        lista.add(new Mueble("C4", "Mesa comedor", 1, 2, 3, LocalDate.now()));
        lista.add(new Mueble("C5", "Mesa cocina", 3, 1, 2.2, LocalDate.now()));
        lista.add(new Mueble("C6", "Mesa terraza", 3, 3, 3, LocalDate.now()));
        lista.add(new Mueble("S1", "Silla madera", 0.5, 2, 3.3, LocalDate.now()));
        lista.add(new Mueble("S2", "Silla plástico", 0.5, 1.2, 3.3, LocalDate.now()));
        lista.add(new Mueble("S3", "Silla oficina", 2.5, 2, 1, LocalDate.now()));
        
        return lista;
    }
    
    // Genera una lista de envíos
    public static ArrayList<EnvioMuebles> generarEnvios(){
        ArrayList<EnvioMuebles> tmp = new ArrayList<>();
        
        tmp.add(new EnvioMuebles(1,"C/Lucena", "Pepe Flores", generarCatalogo()));
        tmp.add(new EnvioMuebles(2,"C/Estepona", "Luisa Márquez", generarCatalogo()));
        tmp.add(new EnvioMuebles(3,"C/Granada", "María López", generarCatalogo()));
        tmp.add(new EnvioMuebles(4,"C/Jaén", "Lucas Fernández", generarCatalogo()));
        tmp.add(new EnvioMuebles(5,"C/Sevilla", "Antonio Paz", generarCatalogo()));
        
        return tmp;
    }
}
