package entrega1;

import javax.swing.JOptionPane;

public class EJ2 {

    public static void main(String[] args) {

        // Solicita el precio de un producto sin IVA y calcula el total con IVA (21%).

        final double IVA = 0.21;

        String numeroPrecioProducto = JOptionPane.showInputDialog("Introduce precio del producto");
        double numeroPrecioProductoNumero = Double.parseDouble(numeroPrecioProducto);

        double numeroPrecioConIVA = numeroPrecioProductoNumero * (1 + IVA);

        String mensaje = """
                Precio con IVA:

                Precio sin IVA: %.2f €
                IVA aplicado: %.0f %%
                Precio total con IVA: %.2f €
                """.formatted(numeroPrecioProductoNumero, IVA * 100, numeroPrecioConIVA);

        JOptionPane.showMessageDialog(null, mensaje);
    }

}
