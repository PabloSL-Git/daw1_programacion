package javafile.tarea5c_biblioteca;

import java.util.ArrayList;

import javax.swing.JOptionPane;



import java.util.Collections;

public class ListaLibros {

    // lista de libros
    private ArrayList<Libro> lista;

    public Libro crearLibro() {
        JOptionPane.showMessageDialog(null, "Dame los datos del libro");
        String titulo = JOptionPane.showInputDialog("Dame titulo");
        String autor = JOptionPane.showInputDialog("Dame autor");
        String añoTxt = JOptionPane.showInputDialog("Dame año");
        int año = Integer.parseInt(añoTxt);
        String isbn = JOptionPane.showInputDialog("Dame isbn");
        String genero = JOptionPane.showInputDialog(
                "Dame genero, debe ser novela, ficcion, poesia o relato");
        Genero generoEnum = Genero.valueOf(genero.trim().toUpperCase());
        Libro libroNuevo = new Libro(titulo, autor, año, isbn, generoEnum, true);
        return libroNuevo;
    }

    public int buscarPorTitulo(String titulo) {
        ordenarPorTitulo();
        Libro aux = new Libro();
        aux.setTitulo(titulo);
        return Collections.binarySearch(lista, aux, (l1, l2) -> l1.getTitulo().compareTo(l2.getTitulo()));
    }

    public void ordenarPorTitulo() {
        Collections.sort(lista, (l1, l2) -> l1.getTitulo().compareTo(l2.getTitulo()));
    }

    public void ordenarPorPublicacion() {
        Collections.sort(lista, (l1, l2) -> l2.getAnioPublicacion() - l1.getAnioPublicacion());
        // Collections.sort(lista, (libroa,
        // librob)->Integer.compare(libroa.getAnioPublicacion(),
        // librob.getAnioPublicacion()));
    }

    public ListaLibros() {
        lista = new ArrayList<>(100);
    }

    public int cantidad() {
        return lista.size();
    }

    public boolean estaVacia() {
        return lista.isEmpty();
    }

    public void guardar(Libro libro) {
        lista.add(libro);
    }

    public void imprimir() {
        lista.forEach(System.out::println);
    }

    public Libro obtener(int posicion) {
        if (posicion < 0 || posicion > lista.size() - 1) {
            return null;
        }
        return lista.get(posicion);
    }

    public void cambiar(int pos, Libro nuevo) {
        if (pos >= 0 && pos < lista.size()) {
            lista.set(pos, nuevo);
        }
    }

    public int buscarLibroCompleto(Libro libro) {
        return lista.indexOf(libro);
    }

    public ArrayList<Libro> buscarAutor(String autor) {
        var listaAux = new ArrayList<Libro>();
        for (Libro libro : lista) {
            if (autor.equalsIgnoreCase(libro.getAutor())) {
                listaAux.add(libro);
            }
        }
        return listaAux;
    }

    public Libro buscarIsbn(String isbn) {
        for (Libro libro : lista) {
            if (libro.getIsbn().equals(isbn)) {
                return libro;
            }
        }
        return null;
    }

    public void eliminar(int pos) {
        if (pos >= 0 && pos < lista.size()) {
            lista.remove(pos);
        }
    }

    public void eliminar(String isbn) {
        Libro aux = buscarIsbn(isbn);
        if (aux != null) {
            lista.remove(aux);
        }
    }

}