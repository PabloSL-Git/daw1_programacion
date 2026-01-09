package estructura_repeticion;

import javax.swing.JOptionPane;

public class Entrega5_A {
    public static void main(String[] args) {

        // A. Imprimir por pantalla las 10 tablas de multiplicar, del 1 al 10.

        for (int i = 1; i <= 10; i++) {
            
            String tabla = "Tabla del " + i + ":\n";

            for (int j = 1; j <= 10; j++) {

                // += le da a tabla 1 una nueva linea

                tabla += i + " x " + j + " = " + (i * j) + "\n";
            }

            JOptionPane.showMessageDialog(null, tabla);
        }
    }
}