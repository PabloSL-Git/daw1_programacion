package excepcion;

import java.util.Random;
import javax.swing.JOptionPane;

public class BolasColores {
    public static void main(String[] args) {

        // da descuento aun precio segun
        // color de bola, se repie programa
        // rojo 15%
        // naranja 25%
        // azul 50%
        // negro no descuento

        boolean salir = false;
        Random random = new Random();

        final double BOLA_ROJA = 0.85;
        final double BOLA_NARANJA = 0.75;
        final double BOLA_AZUL = 0.50;

        do {
            double precioCompra = 0;
            int colorBola = 0;
            String precioCompraTxt = "";
            boolean valido = false;

            colorBola = random.nextInt(4) + 1;

            while (!valido) {

                try {

                    precioCompraTxt = JOptionPane.showInputDialog("¿Cuanto vas a gastar en esta compra?");
                    precioCompra = Double.parseDouble(precioCompraTxt);

                    if (precioCompra > 0) {
                        JOptionPane.showMessageDialog(null, "Numero valido");
                        valido = true;

                    } else if (precioCompra <= 0) {
                        JOptionPane.showMessageDialog(null, "Numero deve ser mayor que 0");
                    }
                } catch (NumberFormatException nfe) {
                    JOptionPane.showMessageDialog(null, "Introduce solo numeros");

                }

            }

            if (colorBola == 1) {
                JOptionPane.showMessageDialog(null, "Te toco bola roja a 15%");
            } else if (colorBola == 2) {
                JOptionPane.showMessageDialog(null, "Te toco bola naranja a 25%");
            } else if (colorBola == 3) {
                JOptionPane.showMessageDialog(null, "Te toco bola azul a 50%");
            } else if (colorBola == 4) {
                JOptionPane.showMessageDialog(null, "Te toco bola negra sin descuento");
            }

            switch (colorBola) {
                case 1 -> { // rojo
                    double resultado = precioCompra * BOLA_ROJA;
                    JOptionPane.showMessageDialog(null, "Su coste con descuento es: " + resultado);
                }
                case 2 -> { // naranja
                    double resultado = precioCompra * BOLA_NARANJA;

                    JOptionPane.showMessageDialog(null, "Su coste con descuento es: " + resultado);

                }
                case 3 -> { // azul
                    double resultado = precioCompra * BOLA_AZUL;

                    JOptionPane.showMessageDialog(null, "Su coste con descuento es: " + resultado);

                }
                case 4 -> { // negro

                    JOptionPane.showMessageDialog(null, "La bola negra no ofrece descuento quedandote con:" + precioCompra);

                }

            }

        } while (salir);

    }

}
