package biblioteca;

import java.util.ArrayList;

public class CarteraEstudiantes {

    // arraylist
    private ArrayList<Estudiante> estudiantes;

    // Constructor
    public CarteraEstudiantes() {
        this.estudiantes = new ArrayList<>();
    }

    // metodos
    public void añadir(Estudiante estudiante) {
        estudiantes.add(estudiante);
    }

    // borrar
    public void eliminar(int posicion) {
        estudiantes.remove(posicion);
    }

    // obtener cantidad de estudiantes
    public int cantidad() {
        return estudiantes.size();
    }

    // verificar si está vacía
    public boolean estaVacia() {
        return estudiantes.isEmpty();
    }

    // obtener estudiante en posición
    public Estudiante obtener(int posicion) {
        return estudiantes.get(posicion);
    }

    // buscar estudiante por dni (devuelve el objeto)
    public Estudiante buscarEstudiante(String dni) {
        for (Estudiante estudiante : estudiantes) {
            if (estudiante.getDni().equals(dni)) {
                return estudiante;
            }
        }
        return null;
    }

    // eliminar por dni
    public boolean eliminarPorDni(String dni) {
        Estudiante estudiante = buscarEstudiante(dni);
        if (estudiante != null) {
            estudiantes.remove(estudiante);
            return true;
        }
        return false;
    }

    // imprimir lista
    public void imprimir() {
        if (estaVacia()) {
            System.out.println("La cartera de estudiantes está vacía.");
            return;
        }
        System.out.println("Cartera de Estudiantes");
        for (int i = 0; i < estudiantes.size(); i++) {
            System.out.println("[" + i + "] " + estudiantes.get(i));
        }
    }

    public static void main(String[] args) {

        
    }

}
