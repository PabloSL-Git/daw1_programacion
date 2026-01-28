package entrega1;

import javax.swing.JOptionPane;

public class EJ4 {

  public static void main(String[] args) {

    // Sabiendo que un euro, al cambio está a 1,17 dólares,
    // realiza una calculadora dólares a euros,
    // solicitando el número de dólares que se quieren cambiar.

    final double CAMBIO = 1.17; // 1 euro = 1.17 dólares

    String numeroDolares = JOptionPane.showInputDialog("Introduce la cantidad de dólares:");
    double numeroDolaresNumero = Double.parseDouble(numeroDolares);

    double numeroEuros = numeroDolaresNumero / CAMBIO;

    String mensaje = """
        Dolares a euros:

        Dólares: %.2f
        Cambio: 1 euro = %.2f dólares
        Equivalente en euros: %.2f
        """.formatted(numeroDolaresNumero, CAMBIO, numeroEuros);

    JOptionPane.showMessageDialog(null, mensaje);

  }

}
