package biblioteca;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;

public class CatalogoLibros {

    // lista de libros
    private ArrayList<Libro> catalogo;

    public CatalogoLibros() {
        this.catalogo = new ArrayList<>(100);
    }

    public int cantidad() {
        return catalogo.size();
    }

    public boolean estaVacia() {
        return catalogo.isEmpty();
    }

    public Libro obtener(int posicion) {
        return catalogo.get(posicion);
    }

    public void cambiar(int posicion, Libro nuevo) {
        catalogo.set(posicion, nuevo);
    }

    public void guardar(Libro libro) {
        catalogo.add(libro);
    }

    public void eliminar(int posicion) {
        catalogo.remove(posicion);
    }

    public boolean eliminar(String isbn) {
        Libro libro = buscarConIsbn(isbn);
        if (libro != null) {
            catalogo.remove(libro);
            return true;
        }
        return false;
    }

    public void imprimir() {
        if (estaVacia()) {
            System.out.println("El catalogo esta vacio.");
            return;
        }

        System.out.println("Catalogo");
        for (int i = 0; i < catalogo.size(); i++) {
            System.out.println("Posicion " + i + ": " + catalogo.get(i));
        }
    }

    public int buscar(Libro libro) {
        return catalogo.indexOf(libro);
    }

    public List<Libro> buscar(String autor) {
        List<Libro> resultado = new ArrayList<>();
        for (Libro libro : catalogo) {
            if (libro.getAutor().equalsIgnoreCase(autor)) {
                resultado.add(libro);
            }
        }
        return resultado;
    }

    public Libro buscarConIsbn(String isbn) {
        for (Libro libro : catalogo) {
            if (String.valueOf(libro.getIsbn()).equals(isbn)) {
                return libro;
            }
        }
        return null;
    }

    public void ordenarPorTitulo() {
        Collections.sort(catalogo, new Comparator<Libro>() {
            @Override
            public int compare(Libro l1, Libro l2) {
                return l1.getTitulo().compareTo(l2.getTitulo());
            }
        });
        System.out.println("Catalogo ordenado por titulo.");
    }

    public void ordenarPorAutor() {
        Collections.sort(catalogo, new Comparator<Libro>() {
            @Override
            public int compare(Libro l1, Libro l2) {
                return l1.getAutor().compareTo(l2.getAutor());
            }
        });
        System.out.println("Catalogo ordenado por autor.");
    }

    public int buscarPorTitulo(String titulo) {
        Libro libroABuscar = new Libro(titulo, "", 0, 1234567890123L, Libro.Genero.NOVELA, true);
        int posicion = Collections.binarySearch(catalogo, libroABuscar, new Comparator<Libro>() {
            @Override
            public int compare(Libro l1, Libro l2) {
                return l1.getTitulo().compareTo(l2.getTitulo());
            }
        });
        return posicion;
    }

    public int buscarPorAutor(String autor) {
        Libro libroABuscar = new Libro("", autor, 0, 1234567890123L, Libro.Genero.NOVELA, true);
        int posicion = Collections.binarySearch(catalogo, libroABuscar, new Comparator<Libro>() {
            @Override
            public int compare(Libro l1, Libro l2) {
                return l1.getAutor().compareTo(l2.getAutor());
            }
        });
        return posicion;
    }

}