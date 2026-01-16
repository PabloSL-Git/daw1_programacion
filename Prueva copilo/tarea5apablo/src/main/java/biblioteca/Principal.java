package biblioteca;

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
                                3. Ver posicion del libro
                                4. Cambiar un libro por otro
                                5. Añadir libro a catalogo
                                6. Eliminar libro segun su posicion (posicion o isbn)
                                7. Imprime los libros de la lista
                                8. Buscar libro (titulo, autor, isbn)
                                (Introduzca el numero de la funcion)
                                """.formatted();
                String menuSeleccionTxt = JOptionPane.showInputDialog(menu);
                int menuSeleccion = Integer.parseInt(menuSeleccionTxt);

                if (menuSeleccion == 1) {
                        catalogo.cantidad();
                        JOptionPane.showMessageDialog(null,  "Cantidad: " +  catalogo.cantidad());
                }

                // switch (menuSeleccion) {
                //     case 1:
                //         JOptionPane.showMessageDialog(null, "Cantidad de libros: " + catalogo.cantidad(), 
                //             "CANTIDAD", JOptionPane.INFORMATION_MESSAGE);
                //         break;

        }

}
