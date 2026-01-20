package biblioteca;

import java.util.ArrayList;

public class CarteraEstudiantes {

    // arraylist

    private ArrayList<Estudiante> estudiantes;

    public CarteraEstudiantes() {
        

    }

    // metodos
    public void añadir(Estudiante estudiante) {
        estudiantes.add(estudiante);
    }

    // borrar
    public void eliminar(int posicion) {
        estudiantes.remove(posicion);
    }

    // buscar por dni

    public int buscarPorDni(String dni) {
        for (int i = 0; i < estudiantes.size(); i++) {
            if (estudiantes.get(i).getDni().equals(dni)) {
                return i;
            }
        }
        return -1;
    }

    // imprimir lista

    public void imprimir() {
        System.out.println("Cartera de Estudiantes");
        for (int i = 0; i < estudiantes.size(); i++) {
            System.out.println("Posicion " + i + ": " + estudiantes.get(i));
        }
    }

    public static void main(String[] args) {

        
    }

}
