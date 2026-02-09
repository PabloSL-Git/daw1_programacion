package set.granja;

import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class MainOrdenado {

    private static VaqueriaOrdenada vaqueria = new VaqueriaOrdenada();

    public static Vaca crearVaca() {
        JOptionPane.showMessageDialog(null, "Dame los datos de la vaca");
        String id = JOptionPane.showInputDialog("Dame id");
        LocalDate fechaNacimiento = LocalDate.parse(JOptionPane.showInputDialog("Dame fecha nacimiento (yyyy-MM-dd)"));
        String descripcion = JOptionPane.showInputDialog("Dame descripcion");
        return new Vaca(id, fechaNacimiento, descripcion);
    }

    public static void main(String[] args) {

        vaqueria.añadirVaca(new Vaca("123456789", LocalDate.of(2010, 12, 3), "Esta gorda"));
        vaqueria.añadirVaca(new Vaca("987654321", LocalDate.of(2015, 12, 3), "Esta delgada"));
        vaqueria.añadirVaca(new Vaca("555555555", LocalDate.of(2012, 6, 10), "Mediana"));

        boolean repetir = true;
        do {
            String menu = """
                    Bienvenido a la vaqueria ordenada. ¿Qué desea hacer?

                    1. Número de vacas
                    2. Añadir vaca
                    3. Comprobar si está vacía
                    4. Comprobar si una vaca está
                    5. Listar todas las vacas
                    6. Dar de baja una vaca
                    0. Salir
                    """;

            int opcion = Integer.parseInt(JOptionPane.showInputDialog(menu));

            switch (opcion) {
                case 0 -> repetir = false;

                case 1 -> JOptionPane.showMessageDialog(null, "Número de vacas: " + vaqueria.numeroDeVacas());

                case 2 -> {
                    Vaca v = crearVaca();
                    vaqueria.añadirVaca(v);
                    JOptionPane.showMessageDialog(null, "Vaca añadida");
                }

                case 3 -> JOptionPane.showMessageDialog(null, vaqueria.estaVacia() ? "Está vacía" : "No está vacía");

                case 4 -> {
                    String id = JOptionPane.showInputDialog("Dame id de la vaca");
                    JOptionPane.showMessageDialog(null, vaqueria.estaLaVacaPorId(id) ? "La vaca está" : "La vaca no está");
                }

                case 5 -> {
                    ArrayList<Vaca> lista = vaqueria.obtenerVacas();
                    if (lista.isEmpty()) JOptionPane.showMessageDialog(null, "No hay vacas");
                    else {
                        String mensaje = "";
                        for (Vaca vaca : lista) mensaje += vaca + "\n";
                        JOptionPane.showMessageDialog(null, mensaje);
                    }
                }

                case 6 -> {
                    String id = JOptionPane.showInputDialog("Dame id de la vaca");
                    boolean eliminado = vaqueria.eliminarPorId(id);
                    JOptionPane.showMessageDialog(null, eliminado ? "Vaca eliminada" : "No se encontró la vaca");
                }

                default -> JOptionPane.showMessageDialog(null, "Opción incorrecta");
            }

        } while (repetir);
    }
}
