package paquetec;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Vaqueria {

    private Set<Vaca> lista;

    public Vaqueria() {
        lista = new HashSet<>();
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
            if (vaca.getId().equals(id)){
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

    @Override
    public String toString() {
        // return " Vacas = " + lista ;
        String aux = "";
        for (Vaca vaca : lista) {
            aux += vaca.getId() + " " + vaca.getFechaNacimiento() + "\n"; 
        }
        return aux;
    }

    
}
