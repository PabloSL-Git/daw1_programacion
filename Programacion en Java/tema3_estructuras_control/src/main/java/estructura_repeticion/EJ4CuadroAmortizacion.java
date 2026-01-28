package estructura_repeticion;

import javax.swing.JOptionPane;

public class EJ4CuadroAmortizacion {
    public static void main(String[] args) {

        // calcular el cuadro de amortizacion de la compra de una vivienda
        // el programa solicita el precio de la vivienda y el numero de meses para pagar
        // los pagos mensuales se realizan aportando la mitad de lo que quede por pagar
        // del mes
        // anterior, hasta que se llegue al ultimo mes que se paga lo que quede de deuda

        String precioViviendaTxt = JOptionPane.showInputDialog("Inserte precio vivienda");
        Double precioVivenda = Double.parseDouble(precioViviendaTxt);

        String mesesPagarTxt = JOptionPane.showInputDialog("Inserte meses para pagar");
        int mesesPagar = Integer.parseInt(mesesPagarTxt);

        // lo siguiente repite en uno los meses ++ indicando uno en uno
        // el igual a 1 indica que empieza en 1

        for (int mes = 1; mes <= mesesPagar; mes++) {
            double pago;

            if (mes == mesesPagar) {

                // Último mes, se paga toda la deuda restante

                pago = precioVivenda;

            } else {

                // Pagar la mitad de la deuda restante

                pago = precioVivenda / 2;

            }
            precioVivenda -= pago; // Restar el pago de la deuda

            // %d para enteros (como mes).
            // %f para números con decimales (como pago y precioVivenda).

            String mensaje = """
                    Mes %d
                    Pago: %.2f €
                    Deuda restante: %.2f €
                    """.formatted(mes, pago, precioVivenda);

            JOptionPane.showMessageDialog(null, mensaje);

            // printf cuano se guiere usar formato %.2f
            
        }

    }

}
