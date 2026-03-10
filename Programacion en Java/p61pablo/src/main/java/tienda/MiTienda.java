package tienda;

import java.util.*;

public class MiTienda {

    public static void main(String[] args) {

        // 1 Crear lista de productos
        List<Producto> productos = new ArrayList<>();

        // Añadimos dos objetos de cada tipo
        productos.add(new Pantalon("P1", 30, 0.21, "Vaquero", "Levis", "M"));
        productos.add(new Pantalon("P2", 25, 0.21, "Chino", "Zara", "L"));

        productos.add(new LibroPapel("L1", 20, 0.21, "Java", "111", 300));
        productos.add(new LibroPapel("L2", 18, 0.21, "POO", "222", 250));

        productos.add(new LibroDigital("L3", 10, 0.21, "Python", "333", 5000));
        productos.add(new LibroDigital("L4", 12, 0.21, "C++", "444", 4500));

        productos.add(new Musica("M1", 15, 0.21, "Album 1", "Coldplay"));
        productos.add(new Musica("M2", 17, 0.21, "Album 2", "Muse"));

        // 2 Mostrar datos con foreach y toString()
        for (Producto p : productos) {
            System.out.println(p.toString());
        }

        /*
         * ¿Es toString() polimórfico?
         * Sí. Porque cada subclase puede sobrescribir el metodo toString()
         * y cuando lo llamamos desde una referencia de tipo Producto,
         * Java ejecuta el método de la clase real del objeto.
         */

        // 3 Ordenar por precio usando Comparator y lambda
        productos.sort((a, b) -> Double.compare(a.getPrecio(), b.getPrecio()));

        // 4 Mostrar lista ordenada por precio
        System.out.println("\nOrdenados por precio:");
        for (Producto p : productos) {
            System.out.println(p);
        }

        // 5 Ordenar por codigo usando Comparator y lambda
        productos.sort((a, b) -> a.getCodigo().compareTo(b.getCodigo()));

        // 6 Mostrar lista ordenada por codigo
        System.out.println("\nOrdenados por codigo:");
        for (Producto p : productos) {
            System.out.println(p);
        }

        // 7 Busqueda binaria por código
        Producto buscar = new Pantalon("P1", 30, 0.21, "Vaquero", "Levis", "M");

        int pos = Collections.binarySearch(productos, buscar,
                (a, b) -> a.getCodigo().compareTo(b.getCodigo()));

        System.out.println("\nPosicion producto existente: " + pos);

        Producto noExiste = new Pantalon("P99", 10, 0.21, "X", "X", "X");

        int pos2 = Collections.binarySearch(productos, noExiste,
                (a, b) -> a.getCodigo().compareTo(b.getCodigo()));

        System.out.println("Posicion producto inexistente: " + pos2);

        // 8 Guardar todos los libros en una lista
        List<Libro> libros = new ArrayList<>();

        for (Producto p : productos) {

            if (p instanceof Libro) {
                libros.add((Libro) p);
            }

        }

        // 9 Mostrar lista de libros
        System.out.println("\nLista de libros:");

        for (Libro l : libros) {
            System.out.println(l);
        }

        // 10 Ordenar libros por ISBN usando Comparable
        Collections.sort(libros);

        // Mostrar libros ordenados
        System.out.println("\nLibros ordenados por ISBN:");

        for (Libro l : libros) {
            System.out.println(l);
        }

        // 11 Ejecutar enviar() o descargar() segun tipo
        for (Libro l : libros) {

            if (l instanceof SeEnvia) {
                ((SeEnvia) l).enviar("Madrid");
            }

            if (l instanceof SeDescarga) {
                ((SeDescarga) l).descargar();
            }

        }

        // 12 contains() para comprobar si existe un libro
        Libro test = new LibroDigital("L3", 10, 0.21, "Python", "333", 5000);

        System.out.println("\n¿Existe el libro? " + libros.contains(test));

        // 13 Crear lista de objetos que implementen SeEnvia
        List<SeEnvia> envios = new ArrayList<>();

        for (Producto p : productos) {

            if (p instanceof SeEnvia) {
                envios.add((SeEnvia) p);
            }

        }

        // 14 Recorrer lista y llamar al metodo
        System.out.println("\nObjetos que se envían:");

        for (SeEnvia e : envios) {
            e.enviar("Barcelona");
        }

    }
}