package javafile.tarea5c_biblioteca;

import java.util.ArrayList;
import java.time.LocalDate;
import java.util.Collections;



public class ListaPrestamos {

    private ArrayList<Prestamo> lista = new ArrayList<>();

    public ListaPrestamos() {
        lista = new ArrayList<>(100);
    }

    // Guardar préstamo
    public void guardar(Prestamo prestamo) {
        lista.add(prestamo);
    }

    // Borrar préstamo por posición
    public void eliminar(int pos) {
        if (pos >= 0 && pos < lista.size()) {
            lista.remove(pos);
        }
    }

    // Borrar préstamo por id
    public void eliminarPorId(int id) {
        Prestamo aux = buscarPorId(id);
        if (aux != null) {
            lista.remove(aux);
        }
    }

    // Modificar el libro de un préstamo
    public void modificarLibro(int id, Libro nuevoLibro) {
        Prestamo prestamo = buscarPorId(id);
        if (prestamo != null) {
            prestamo.setLibro(nuevoLibro);
        }
    }

    // Modificar el estudiante de un préstamo
    public void modificarEstudiante(int id, Estudiante nuevoEstudiante) {
        Prestamo prestamo = buscarPorId(id);
        if (prestamo != null) {
            prestamo.setEstudiante(nuevoEstudiante);
        }
    }

    // Buscar préstamo por id (búsqueda secuencial)
    public Prestamo buscarPorId(int id) {
        for (Prestamo prestamo : lista) {
            if (prestamo.getId() == id) {
                return prestamo;
            }
        }
        return null;
    }

    // Buscar todos los préstamos de un libro
    public ArrayList<Prestamo> buscarPorLibro(String isbn) {
        ArrayList<Prestamo> resultado = new ArrayList<>();
        for (Prestamo prestamo : lista) {
            if (prestamo.getLibro().getIsbn().equals(isbn)) {
                resultado.add(prestamo);
            }
        }
        return resultado;
    }

    // Buscar todos los préstamos de un estudiante
    public ArrayList<Prestamo> buscarPorEstudiante(String dni) {
        ArrayList<Prestamo> resultado = new ArrayList<>();
        for (Prestamo prestamo : lista) {
            if (prestamo.getEstudiante().getDni().equals(dni)) {
                resultado.add(prestamo);
            }
        }
        return resultado;
    }

    // Buscar todos los préstamos vencidos
    public ArrayList<Prestamo> buscarVencidos() {
        ArrayList<Prestamo> resultado = new ArrayList<>();
        LocalDate hoy = LocalDate.now();
        for (Prestamo prestamo : lista) {
            if (prestamo.getFechaDevolucion().isBefore(hoy)) {
                resultado.add(prestamo);
            }
        }
        return resultado;
    }

    // Buscar préstamos que vencen en una fecha determinada
    public ArrayList<Prestamo> buscarPorFechaDevolucion(LocalDate fecha) {
        ArrayList<Prestamo> resultado = new ArrayList<>();
        for (Prestamo prestamo : lista) {
            if (prestamo.getFechaDevolucion().equals(fecha)) {
                resultado.add(prestamo);
            }
        }
        return resultado;
    }

    // Ordenar préstamos por id
    public void ordenarPorId() {
        Collections.sort(lista, (p1, p2) -> Integer.compare(p1.getId(), p2.getId()));
    }

    // Búsqueda binaria de préstamos por id (requiere que esté ordenada)
    public int buscarBinarioPorId(int id) {
        ordenarPorId();
        Prestamo aux = new Prestamo(id);
        return Collections.binarySearch(lista, aux, (p1, p2) -> Integer.compare(p1.getId(), p2.getId()));
    }

    // Ordenar préstamos por fecha de inicio
    public void ordenarPorFechaInicial() {
        Collections.sort(lista, (p1, p2) -> p1.getFechaInicial().compareTo(p2.getFechaInicial()));
    }

    // Ordenar por fecha de devolución
    public void ordenarPorFechaDevolucion() {
        Collections.sort(lista, (p1, p2) -> p1.getFechaDevolucion().compareTo(p2.getFechaDevolucion()));
    }

    // Ordenar por título de libro
    public void ordenarPorTituloLibro() {
        Collections.sort(lista, (p1, p2) -> p1.getLibro().getTitulo().compareTo(p2.getLibro().getTitulo()));
    }

    // Ordenar por nombre de alumno/a
    public void ordenarPorNombreEstudiante() {
        Collections.sort(lista, (p1, p2) -> p1.getEstudiante().getNombre().compareTo(p2.getEstudiante().getNombre()));
    }

    // Otros métodos útiles
    public int cantidad() {
        return lista.size();
    }

    public boolean estaVacia() {
        return lista.isEmpty();
    }

    public Prestamo obtener(int posicion) {
        if (posicion < 0 || posicion > lista.size() - 1) {
            return null;
        }
        return lista.get(posicion);
    }

    public void imprimir() {
        lista.forEach(System.out::println);
    }

}
