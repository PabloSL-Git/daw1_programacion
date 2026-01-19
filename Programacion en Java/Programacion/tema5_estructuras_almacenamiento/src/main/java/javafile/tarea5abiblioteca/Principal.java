package javafile.tarea5abiblioteca;

import javax.swing.JOptionPane;

public class Principal {

        public static void main(String[] args) {

                Libro libro1 = new Libro("Cien años de soledad", "Gabriel García Márquez", 1967,
                                9788497592207L, Libro.Genero.NOVELA, true);
                Libro libro2 = new Libro("Harry Popoter", "J.L. Rowing", 1997,
                                9788478884453L, Libro.Genero.FICCION, true);
                Libro libro3 = new Libro("La Odisea", "Homero", 2023,
                                9788497592207L, Libro.Genero.POESIA, true); // ISBN igual a libro1

                // Crear otro libro con el mismo isbn que libro1
                Libro libro4 = new Libro("Don Quijote", "Miguel de Cervantes", 1605,
                                9788497592207L, Libro.Genero.NOVELA, true); // ISBN igual a libro1 y libro3

                // Mostrar libros

                System.out.println("Datos de los libros:");
                System.out.println("Libro 1: " + libro1);
                System.out.println("Libro 2: " + libro2);
                System.out.println("Libro 3: " + libro3);
                System.out.println("Libro 4: " + libro4);

                // prestar

                libro1.prestar();
                System.out.println("Estado después: " + libro1);

                // devolver

                libro1.devolver();
                System.out.println("Estado después: " + libro1);

                // Mostrar hashCode

                System.out.println("HashCode de libro1 (isbn: " + libro1.getIsbn() + "): " + libro1.hashCode());
                System.out.println("HashCode de libro2 (isbn: " + libro2.getIsbn() + "): " + libro2.hashCode());
                System.out.println("HashCode de libro3 (isbn: " + libro3.getIsbn() + "): " + libro3.hashCode());
                System.out.println("HashCode de libro4 (isbn: " + libro4.getIsbn() + "): " + libro4.hashCode());

                // Libros con el mismo isbn (debe devolver true)
                System.out.println("¿libro1.equals(libro3)? " + libro1.equals(libro3) +
                                " (ambos tienen isbn " + libro1.getIsbn() + ")");
                System.out.println("¿libro1.equals(libro4)? " + libro1.equals(libro4) +
                                " (ambos tienen isbn " + libro1.getIsbn() + ")");
                System.out.println("¿libro3.equals(libro4)? " + libro3.equals(libro4) +
                                " (ambos tienen isbn " + libro3.getIsbn() + ")");

                // Libros con isbn distinto (debe devolver false)
                System.out.println("\n¿libro1.equals(libro2)? " + libro1.equals(libro2) +
                                " (isbn diferentes: " + libro1.getIsbn() + " vs " + libro2.getIsbn() + ")");
                System.out.println("¿libro2.equals(libro3)? " + libro2.equals(libro3) +
                                " (isbn diferentes: " + libro2.getIsbn() + " vs " + libro3.getIsbn() + ")");
                System.out.println("¿libro2.equals(libro4)? " + libro2.equals(libro4) +
                                " (isbn diferentes: " + libro2.getIsbn() + " vs " + libro4.getIsbn() + ")");

                // Crear catálogos para pruebas
                CatalogoLibros catalogo = new CatalogoLibros();
                catalogo.guardar(libro1);
                catalogo.guardar(libro2);
                catalogo.guardar(libro3);
                catalogo.guardar(libro4);

                String menu = """
                                Bienbenido a la biblioteca ¿Que de sea hacer?

                                1. Ver cantidad de libros
                                2. Ver si no hay ningun libro
                                3. Ver que libro se encuentra en la posicion
                                4. Cambiar un libro por otro
                                5. Añadir libro a catalogo
                                6. Eliminar libro segun su posicion (posicion o isbn)
                                7. Imprime los libros de la lista
                                8. Buscar libro (libro, autor o isbn)
                                (Introduzca el numero de la funcion)
                                """.formatted();
                String menuSeleccionTxt = JOptionPane.showInputDialog(menu);
                int menuSeleccion = Integer.parseInt(menuSeleccionTxt);
                Libro libroNuevo;
                int posicion;
                String posicionTxt;

                switch (menuSeleccion) {
                        case 1:
                                JOptionPane.showMessageDialog(null, "Cantidad: " + catalogo.cantidad());
                                break;
                        case 2:
                                boolean vacio = catalogo.estaVacia();
                                if (vacio) {
                                        JOptionPane.showMessageDialog(null, "Esta vacio");
                                } else {
                                        JOptionPane.showMessageDialog(null, "No esta vacio");
                                }
                                break;
                        case 3:
                                posicionTxt = JOptionPane.showInputDialog("Dame posicion");
                                posicion = Integer.parseInt(posicionTxt);
                                JOptionPane.showMessageDialog(null, "Posicion: " + catalogo.obtener(posicion));
                                break;
                        case 4:
                                libroNuevo = catalogo.crearLibro();
                                posicionTxt = JOptionPane.showInputDialog("Dame posicion a ocupar");
                                posicion = Integer.parseInt(posicionTxt);
                                catalogo.cambiar(posicion, libroNuevo);
                                JOptionPane.showMessageDialog(null, "CambioCompletado");
                                break;
                        case 5:
                                libroNuevo = catalogo.crearLibro();
                                catalogo.guardar(libroNuevo);
                                JOptionPane.showMessageDialog(null, "Libro añadido");
                                break;
                        case 6:
                                String seleccionEliminar = JOptionPane
                                                .showInputDialog("Eliminar a traves de posicion o isbn");
                                if (seleccionEliminar.equalsIgnoreCase("posicion")) {
                                        posicionTxt = JOptionPane.showInputDialog("Dame posicion");
                                        posicion = Integer.parseInt(posicionTxt);
                                        catalogo.eliminar(posicion);
                                } else {
                                        String isbnTxt = JOptionPane.showInputDialog("Dame isbn");
                                        long isbn = Long.parseLong(isbnTxt);
                                        catalogo.eliminar(isbn);
                                }

                                break;
                        case 7:
                                catalogo.imprimir();
                                break;
                        case 8:
                                String seleccionBusqueda = JOptionPane
                                                .showInputDialog("Eliminar a traves de libro, autor o isbn");
                                if (seleccionBusqueda.equalsIgnoreCase("libro")) {
                                        libroNuevo = catalogo.crearLibro();
                                        JOptionPane.showMessageDialog(null,
                                                        "Libro: " + catalogo.buscarLibroCompleto(libroNuevo));
                                        catalogo.buscarLibroCompleto(libroNuevo);
                                }
                                if (seleccionBusqueda.equalsIgnoreCase("autor")) {
                                        String autor = JOptionPane.showInputDialog("Dame autor");
                                        JOptionPane.showMessageDialog(null, "Libro: " + catalogo.buscarAutor(autor));
                                } 
                                ;
                                if (seleccionBusqueda.equalsIgnoreCase("isbn")){
                                        String isbnTxt = JOptionPane.showInputDialog("Dame isbn");
                                        long isbn = Long.parseLong(isbnTxt);
                                        JOptionPane.showMessageDialog(null, "Libro: " + catalogo.buscarConIsbn(isbn));
                                } 
                                break;

                }

        }
}
