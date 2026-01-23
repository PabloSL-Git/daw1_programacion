package biblioteca;

import javax.swing.JOptionPane;
import java.time.LocalDate;

public class Main {

        private static ListaLibros libros = new ListaLibros();
        private static ListaPrestamos prestamos = new ListaPrestamos();
        private static ListaEstudiantes estudiantes = new ListaEstudiantes();

        public Prestamo crearPrestamo() {

                String idTxt = JOptionPane.showInputDialog("Dame id");
                int id = Integer.parseInt(idTxt);

                String isbn = JOptionPane.showInputDialog("Dame isbn");
                Libro libro = libros.buscarIsbn(isbn);

                String dni = JOptionPane.showInputDialog("Dame dni");
                Estudiante estudiante = estudiantes.buscarPorDni(dni);

                LocalDate fecha = LocalDate.now();

                Prestamo prestamoNuevo = new Prestamo(id, estudiante, libro, fecha);
                prestamos.guardar(prestamoNuevo);

                return prestamoNuevo;
        }

        public static void main(String[] args) {

                // Lista libros

                Libro libro1 = new Libro("Cien años de soledad", "Gabriel García Márquez", 1967,
                                "9788497592207", Genero.NOVELA, true);
                Libro libro2 = new Libro("Harry Popoter", "J.L. Rowing", 1997,
                                "9788478884453", Genero.FICCION, true);
                Libro libro3 = new Libro("La Odisea", "Homero", 2023,
                                "9788497592214", Genero.POESIA, true);

                libros.guardar(libro1);
                libros.guardar(libro2);
                libros.guardar(libro3);

                // Lista estudiantes
                estudiantes.guardar(new Estudiante("Pablo", "Santamaria García", "11111111A"));
                estudiantes.guardar(new Estudiante("Rosi", "Loredo López", "22222222B"));
                estudiantes.guardar(new Estudiante("Marious", "Loredo López", "33333333C"));

                // Lista préstamos
                // ListaPrestamos listaPrestamos = new ListaPrestamos();

                String menu = """
                                Bienbenido a la biblioteca ¿Que desea hacer?

                                1. Ver cantidad de libros
                                2. Ver si no hay ningun libro
                                3. Ver que libro se encuentra en la posicion
                                4. Cambiar un libro por otro
                                5. Añadir libro a catalogo
                                6. Eliminar libro segun su posicion (posicion o isbn)
                                7. Imprime los libros de la lista
                                8. Buscar libro (libro, autor o isbn)
                                9. Ver estudiantes
                                10. Hacer un prestamo
                                11. Ver prestamos
                                (Introduzca el numero de la funcion)
                                """.formatted();
                String menuSeleccionTxt = JOptionPane.showInputDialog(menu);
                int menuSeleccion = Integer.parseInt(menuSeleccionTxt);
                Libro libroNuevo;
                int posicion;
                String posicionTxt;
                String isbn;

                switch (menuSeleccion) {
                        case 1:
                                JOptionPane.showMessageDialog(null, "Cantidad: " + libros.cantidad());
                                break;
                        case 2:
                                boolean vacio = libros.estaVacia();
                                if (vacio) {
                                        JOptionPane.showMessageDialog(null, "Esta vacio");
                                } else {
                                        JOptionPane.showMessageDialog(null, "No esta vacio");
                                }
                                break;
                        case 3:
                                posicionTxt = JOptionPane.showInputDialog("Dame posicion");
                                posicion = Integer.parseInt(posicionTxt);
                                JOptionPane.showMessageDialog(null, "Posicion: " + libros.obtener(posicion));
                                break;
                        case 4:
                                libroNuevo = libros.crearLibro();
                                posicionTxt = JOptionPane.showInputDialog("Dame posicion a ocupar");
                                posicion = Integer.parseInt(posicionTxt);
                                libros.cambiar(posicion, libroNuevo);
                                JOptionPane.showMessageDialog(null, "CambioCompletado");
                                break;
                        case 5:
                                libroNuevo = libros.crearLibro();
                                libros.guardar(libroNuevo);
                                JOptionPane.showMessageDialog(null, "Libro añadido");
                                break;
                        case 6:
                                String seleccionEliminar = JOptionPane
                                                .showInputDialog("Eliminar a traves de posicion o isbn");
                                if (seleccionEliminar.equalsIgnoreCase("posicion")) {
                                        posicionTxt = JOptionPane.showInputDialog("Dame posicion");
                                        posicion = Integer.parseInt(posicionTxt);
                                        libros.eliminar(posicion);
                                } else {
                                        isbn = JOptionPane.showInputDialog("Dame isbn");
                                        libros.eliminar(isbn);
                                }
                                break;
                        case 7:
                                libros.imprimir();
                                break;
                        case 8:
                                String seleccionBusqueda = JOptionPane
                                                .showInputDialog("Buscar a traves de libro, autor o isbn");
                                if (seleccionBusqueda.equalsIgnoreCase("libro")) {
                                        libroNuevo = libros.crearLibro();
                                        JOptionPane.showMessageDialog(null,
                                                        "Libro: " + libros.buscarLibroCompleto(libroNuevo));
                                        libros.buscarLibroCompleto(libroNuevo);
                                }
                                if (seleccionBusqueda.equalsIgnoreCase("autor")) {
                                        String autor = JOptionPane.showInputDialog("Dame autor");
                                        JOptionPane.showMessageDialog(null, "Libro: " + libros.buscarAutor(autor));
                                }
                                if (seleccionBusqueda.equalsIgnoreCase("isbn")) {
                                        isbn = JOptionPane.showInputDialog("Dame isbn");
                                        JOptionPane.showMessageDialog(null, "Libro: " + libros.buscarIsbn(isbn));
                                }
                                break;
                        case 9:
                                estudiantes.imprimir();
                                break;
                        case 10:

                                break;
                        case 11:

                                break;

                }

        }
}
