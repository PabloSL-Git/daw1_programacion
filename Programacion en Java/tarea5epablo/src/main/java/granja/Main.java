package granja;

import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Main {

    private static Vaqueria vaqueria = new Vaqueria();

    public static Vaca crearVaca() {
        JOptionPane.showMessageDialog(null, "Dame los datos de la vaca");

        String id = JOptionPane.showInputDialog("Dame id");

        String fechaNacimientoTxt = JOptionPane.showInputDialog("Dame fecha Nacimiento");
        LocalDate fechaNacimiento = LocalDate.parse(fechaNacimientoTxt);

        String descripcion = JOptionPane.showInputDialog("Dame descripcion");

        Vaca vacaNueva = new Vaca(id, fechaNacimiento, descripcion);
        return vacaNueva;
    }

    public static void main(String[] args) {

        vaqueria.añadirVaca(new Vaca("555555555", LocalDate.of(2012, 6, 10), "Mediana"));
        vaqueria.añadirVaca(new Vaca("987654321", LocalDate.of(2015, 12, 3), "Esta delgada"));
        vaqueria.añadirVaca(new Vaca("123456789", LocalDate.of(2010, 12, 3), "Esta gorda"));

        boolean repetir = true;
        do {

            String menu = """
                    Bienbenido a la vaqueria ¿Que desea hacer?

                    1. Saber el número de vacas que hay.
                    2. Añadir un animal a la vaquería.
                    3. Saber si la vaquería tiene vacas.
                    4. Saber si un animal está en la vaquería.
                    5. Sacar todos los animales, en forma de ArrayList.
                    6. Dar de baja una vaca de la vaquería.
                    0. Salir
                    (Introduzca el numero de la funcion)
                    """.formatted();
            String menuSeleccionTxt = JOptionPane.showInputDialog(menu);
            int menuSeleccion = Integer.parseInt(menuSeleccionTxt);

            switch (menuSeleccion) {
                case 0 -> {
                    repetir = false;
                }
                case 1 -> {
                    JOptionPane.showMessageDialog(null, "Numero vacas: " + vaqueria.numeroDeVacas());
                }
                case 2 -> {
                    Vaca vacanueva = crearVaca();
                    vaqueria.añadirVaca(vacanueva);
                    JOptionPane.showMessageDialog(null, "Vaca añadida");
                }
                case 3 -> {
                    if (vaqueria.estaVacia()) {
                        JOptionPane.showMessageDialog(null, "Esta Vacia");
                    } else {
                        JOptionPane.showMessageDialog(null, "No esta Vacia");
                    }
                }
                case 4 -> {
                    String id = JOptionPane.showInputDialog("Dame id de la vaca");
                    Vaca vacaBuscada = new Vaca(id, null, null);

                    boolean esta = vaqueria.estaLaVaca(vacaBuscada);

                    if (esta) {
                        JOptionPane.showMessageDialog(null, "La vaca esta");
                    } else {
                        JOptionPane.showMessageDialog(null, "La vaca no esta");
                    }
                }
                case 5 -> {
                    ArrayList<Vaca> todasLasVacas = vaqueria.obtenerVacas();
                    if (todasLasVacas.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "No hay vacas en la vaqueria");
                    } else {
                        String mensaje = "";
                        for (Vaca vaca : todasLasVacas) {
                            mensaje += vaca + "\n"; // usa toString de Vaca
                        }
                        JOptionPane.showMessageDialog(null, mensaje);
                    }
                }
                case 6 -> {
                    String id = JOptionPane.showInputDialog("Dame id de la vaca");
                    vaqueria.eliminarPorId(id);
                }
                default -> {
                    JOptionPane.showMessageDialog(null, "Seleccion incorrecta");
                }
            }
        } while (repetir);
    }
}
