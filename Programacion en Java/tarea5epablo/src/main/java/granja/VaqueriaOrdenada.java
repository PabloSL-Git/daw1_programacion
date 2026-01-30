package granja;

import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

public class VaqueriaOrdenada {

    private Set<Vaca> lista;

    public VaqueriaOrdenada() {
        lista = new TreeSet<>(); // TreeSet ordena automáticamente por compareTo
    }

    // Numero de vacas
    public int numeroDeVacas() {
        return lista.size();
    }

    // Añadir vaca
    public boolean añadirVaca(Vaca vaca) {
        return lista.add(vaca);
    }

    // Saber si hay vacas
    public boolean estaVacia() {
        return lista.isEmpty();
    }

    // Saber si una vaca esta
    public boolean estaLaVaca(Vaca vaca) {
        return lista.contains(vaca);
    }

    // Saber si una vaca esta por id
    public boolean estaLaVacaPorId(String id) {
        for (Vaca vaca : lista) {
            if (vaca.getId().equals(id)) {
                return true;
            }
        }
        return false;
    }

    // Buscar y devolver vaca por id
    public Vaca buscarPorId(String id) {
        for (Vaca vaca : lista) {
            if (vaca.getId().equals(id)) {
                return vaca;
            }
        }
        return null;
    }

    // Sacar todas las vacas en ArrayList
    public ArrayList<Vaca> obtenerVacas() {
        return new ArrayList<>(lista);
    }

    // Eliminar una vaca por objeto
    public boolean eliminarVaca(Vaca vaca) {
        return lista.remove(vaca);
    }

    // Eliminar una vaca por id
    public boolean eliminarPorId(String id) {
        Vaca vaca = buscarPorId(id);
        if (vaca != null) {
            return lista.remove(vaca);
        }
        return false;
    }
}
