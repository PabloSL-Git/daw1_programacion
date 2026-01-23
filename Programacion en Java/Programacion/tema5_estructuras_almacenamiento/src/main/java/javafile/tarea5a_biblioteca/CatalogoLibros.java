package javafile.tarea5a_biblioteca;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import java.util.Collections;
import java.util.Comparator;

public class CatalogoLibros {

    // lista de libros
    private ArrayList<Libro> catalogo;

    public CatalogoLibros() {
        this.catalogo = new ArrayList<>(100);
    }

    public Libro crearLibro() {
        JOptionPane.showMessageDialog(null, "Dame los datos del libro");
        String titulo = JOptionPane.showInputDialog("Dame titulo");
        String autor = JOptionPane.showInputDialog("Dame autor");
        String añoTxt = JOptionPane.showInputDialog("Dame año");
        int año = Integer.parseInt(añoTxt);
        String isbnTxt = JOptionPane.showInputDialog("Dame isbn");
        long isbn = Long.parseLong(isbnTxt);
        String genero = JOptionPane.showInputDialog(
                "Dame genero, debe ser novela, ficcion, poesia o relato");
        Libro.Genero generoEnum = Libro.Genero.valueOf(genero.trim().toUpperCase());
        Libro libroNuevo = new Libro(titulo, autor, año, isbn, generoEnum, true);
        return libroNuevo;
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

    public boolean eliminar(long isbn) {
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


    // investigar de aqui a abajo
    // IMPORTANTE

    public int buscarLibroCompleto(Libro libro) {
        return catalogo.indexOf(libro);
    }

    public List<Libro> buscarAutor(String autor) {
        List<Libro> resultado = new ArrayList<>();
        for (Libro libro : catalogo) {
            if (libro.getAutor().equalsIgnoreCase(autor)) {
                resultado.add(libro);
            }
        }
        return resultado;
    }

    public Libro buscarConIsbn(long isbn) {
        for (Libro libro : catalogo) {
            if (libro.getIsbn() == isbn) {
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

}