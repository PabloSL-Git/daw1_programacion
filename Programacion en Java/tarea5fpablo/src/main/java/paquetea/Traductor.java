package paquetea;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class Traductor {
    // TreeMap mantiene las claves ordenadas alfabeticamente
    private TreeMap<String, String> diccionario;

    public Traductor() {
        diccionario = new TreeMap<>();
    }

    // Añadir traduccion
    public void añadirEntrada(String palabraExtranjera, String palabraEspanol) {
        diccionario.put(palabraExtranjera, palabraEspanol);
    }

    // Eliminar traduccion
    public void eliminarEntrada(String palabraExtranjera) {
        diccionario.remove(palabraExtranjera);
    }

    // Modificar traduccion 
    public void modificarEntrada(String palabraExtranjera, String nuevaTraduccion) {
        if (diccionario.containsKey(palabraExtranjera)) {
            diccionario.put(palabraExtranjera, nuevaTraduccion);
        }
    }

    // Traducir palabra
    public String traducir(String palabraExtranjera) {
        return diccionario.getOrDefault(palabraExtranjera, "Traducción no encontrada");
    }

    // Palabras extranjeras
    public List<String> obtenerPalabrasExtranjeras() {
        return new ArrayList<>(diccionario.keySet());
    }

    // Palabras en español
    public List<String> obtenerPalabrasEspanol() {
        return new ArrayList<>(diccionario.values());
    }
}