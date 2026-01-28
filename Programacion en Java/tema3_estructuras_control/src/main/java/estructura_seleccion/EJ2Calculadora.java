package estructura_seleccion;

import javax.swing.JOptionPane;

public class EJ2Calculadora {
    public static void main(String[] args) {

        // EJ2 calculadora
        // pedir opcion al usuario entre:
        // 1. sumar
        // 2. restar
        // 3. multiplicar
        // 4. dividir (double no da error en 0)
        // si la opcion no es valida el programa informa y termina
        // si opcion es validadeve realizar operacion
        // coorespondiente, mostrar resultado y terminar

        // dar las opciones

        String mensaje = """
                Introduce qué operación deseas hacer:
                  - 1 para sumar
                  - 2 para restar
                  - 3 para multiplicar
                  - 4 para dividir
                """;
        String operacionMal = JOptionPane.showInputDialog(null, mensaje);

        int operacion = Integer.parseInt(operacionMal);

        // predir los numeros para el problema

        // hacder los calculos y una opcion si la opcion elegida es incorrecta

        // lo que va dentro del swith tiene que ser: int, char, string o enum

        // switch no permiten reangos, solo puntos concretos

        if (operacion > 4 || operacion < 1) {
            JOptionPane.showMessageDialog(null, "numero incorrecto para operacion");
        } else {
            String numero1Mal = JOptionPane.showInputDialog("Introduce numero 1");
            double numero1 = Double.parseDouble(numero1Mal);

            String numero2Mal = JOptionPane.showInputDialog("Introduce numero 2");
            double numero2 = Double.parseDouble(numero2Mal);

            switch (operacion) {
                case 1 -> {
                    double resultado = numero1 + numero2;
                    JOptionPane.showMessageDialog(null, "El resultado es: " + resultado);
                }
                case 2 -> {
                    double resultado = numero1 - numero2;
                    JOptionPane.showMessageDialog(null, "El resultado es: " + resultado);
                }
                case 3 -> {
                    double resultado = numero1 * numero2;
                    JOptionPane.showMessageDialog(null, "El resultado es: " + resultado);
                }
                case 4 -> {
                    double resultado = numero1 / numero2;
                    JOptionPane.showMessageDialog(null, "El resultado es: " + resultado);
                }

            }

        }

    }

}
