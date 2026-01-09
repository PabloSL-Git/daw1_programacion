package estructura_seleccion;

import javax.swing.JOptionPane;

public class EJ1TributarHacienda {

    public static void main(String[] args) {

        // EJ1 leer edad de una persona e indicar
        // si es menor de edad. En caso de mayor de edad
        // si tiene 18 indicar que no tiene que tribuatr a hacienda
        // si tiene 25 indicar que tiene que contribuir 10% irpf
        // si tiene 36 14%, 55 22%, 65 no tributa (no rango, numeros puntuales)

        // pedir edad y pasar a numero

        String numeroEdadMal = JOptionPane.showInputDialog("Introduce una edad");
        int numeroEdad = Integer.parseInt(numeroEdadMal);

        // unos if para cada edad

        if (numeroEdad < 0) {
            JOptionPane.showMessageDialog(null, "Numero no valido");
        }

        if (numeroEdad >= 18) {
            JOptionPane.showMessageDialog(null, "Es mayor de edad");
        } else {
            JOptionPane.showMessageDialog(null, "Es menor de edad");
        }

        if (numeroEdad == 18) {
            JOptionPane.showMessageDialog(null, "No tiene que tributar a hacienda");
        }
        if (numeroEdad == 25) {
            JOptionPane.showMessageDialog(null, "Tiene que contribuir 10% irpf");
        }
        if (numeroEdad == 36) {
            JOptionPane.showMessageDialog(null, "Tiene que contribuir 14% irpf");
        }
        if (numeroEdad == 55) {
            JOptionPane.showMessageDialog(null, "Tiene que contribuir 22% irpf");
        }
        if (numeroEdad == 65) {
            JOptionPane.showMessageDialog(null, "No tiene que tributar a hacienda");
        }

    }

}
