package map.paquetec;

import java.util.HashMap;

public class VaqueriaMap {

    private HashMap<String, Vaqueria> lista;

    public VaqueriaMap() {
        lista = new HashMap<>();
    }

    // Añadir vaqueria
    public void añadirVaqueria(String id, Vaqueria vaqueria) {
        lista.put(id, vaqueria);
    }

    // Buscar por id
    public Vaqueria buscarVaqueria(String id) {
        return lista.get(id);
    }

    // Imprimir lista completa
    public void imprimirLista() {
        for (HashMap.Entry<String, Vaqueria> entry : lista.entrySet()) {

            System.out.println("ID: " + entry.getKey() + " | Vaqueria: \n" + entry.getValue());
        }
    }
}
