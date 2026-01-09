package entrega1;

import javax.swing.JOptionPane;

public class EJ1 {
    public static void main(String[] args) {

        // Un trabajador cobra un salario por hora de 34.5 euros.
        // Pide al usuario que introduzca el número
        // de horas trabajadas a la semana muestra el salario total.

        final double SALARIO_HORA = 34.5;

        String numeroHorasTrabajo = JOptionPane.showInputDialog("Introduce horas de trabajo");

        double numeroHorasTrabajoNumero = Double.parseDouble(numeroHorasTrabajo);
        double numeroSalario = numeroHorasTrabajoNumero * SALARIO_HORA;

        String mensaje = """
                Trabajador cobrara:

                Horas trabajadas: %.2f
                Salario por hora: %.2f €
                Salario total: %.2f €
                """.formatted(numeroHorasTrabajoNumero, SALARIO_HORA, numeroSalario);

        JOptionPane.showMessageDialog(null, mensaje);
    }

}