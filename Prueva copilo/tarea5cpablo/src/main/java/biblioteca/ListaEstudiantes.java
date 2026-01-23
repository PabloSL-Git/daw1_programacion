package biblioteca;

import java.util.ArrayList;
import java.util.Collections;

public class ListaEstudiantes {

    private final ArrayList<Estudiante> lista;  

    public int buscarPorNombre(String nombre){
        ordenarPorNombre();
        Estudiante aux = new Estudiante(nombre, "", "");
        return Collections.binarySearch(lista, aux, (e1, e2) -> e1.getNombre().compareTo(e2.getNombre()));
    }

    public void ordenarPorNombre(){
        Collections.sort(lista, (e1, e2) -> e1.getNombre().compareTo(e2.getNombre()));
    }

    public void ordenarPorApellidos(){
        Collections.sort(lista, (e1, e2) -> e1.getApellidos().compareTo(e2.getApellidos()));
    }

    public ListaEstudiantes() {
        lista = new ArrayList<>(100);
    }

    public int cantidad(){
        return lista.size();
    }

    public boolean estaVacia(){
        return lista.isEmpty();
    }

    public void añadir(Estudiante estudiante){
        lista.add(estudiante);
    }

    public void guardar(Estudiante estudiante){
        lista.add(estudiante);
    }

    public void imprimir(){
        lista.forEach(System.out::println);
    }

    public Estudiante obtener(int posicion){
        if (posicion < 0 || posicion > lista.size() - 1){
            return null;
        }
        return lista.get(posicion);
    }

    public void cambiar(int pos, Estudiante nuevo){
        if (pos >= 0 && pos < lista.size()){
            lista.set(pos, nuevo);
        }
    }

    public int buscar(Estudiante estudiante){
        return lista.indexOf(estudiante);
    }

    public ArrayList<Estudiante> buscarPorApellidos(String apellidos){
        var listaAux = new ArrayList<Estudiante>();
        for (Estudiante estudiante : lista) {
            if (apellidos.equalsIgnoreCase(estudiante.getApellidos())){
                listaAux.add(estudiante);
            }
        }
        return listaAux;
    }

    public Estudiante buscarPorDni(String dni){
        for (Estudiante estudiante : lista) {
            if (estudiante.getDni().equals(dni)){
                return estudiante;
            }
        }
        return null;
    }

    public void eliminar(int pos){
        if (pos >= 0 && pos < lista.size()){
            lista.remove(pos);
        }
    }

    public void eliminar(String dni){
        Estudiante aux = buscarPorDni(dni);
        if (aux != null){
            lista.remove(aux);
        }
    }
}
