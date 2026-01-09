package entrega1;

import javax.swing.JOptionPane;

public class EJ3 {

    public static void main(String[] args) {

        // Calcula el volumen de una esfera, solicitando el radio al usuario.
        // Usa la constante PI y la función pow de la clase Math.

        String textoRadio = JOptionPane.showInputDialog("Introduce el radio de la esfera");
        double radioNumero = Double.parseDouble(textoRadio);
        double volumen = (4.0 / 3.0) * Math.PI * Math.pow(radioNumero, 3);

        String mensaje = """
                Volumen de la esfera:

                Radio: %.2f
                Volumen: %.2f unidades
                """.formatted(radioNumero, volumen);

        JOptionPane.showMessageDialog(null, mensaje);

    }

}
