package estructura_repeticion;

import javax.swing.JOptionPane;

public class EJ5ClaveMovil {
    public static void main(String[] args) {

        // usando JOption solicita los cuatro pines de clave de un movil
        // para saber si es valido hay varias restricciones
        // los digitos no se pueden repeir
        // los digitos pares deben sumar impar
        // filtrar los figitos (1 a 9)
        // en caso de error solicitar nuevo

        int numero1;
        int numero2;
        int numero3;
        int numero4;
        boolean numerosDiferentes;
        boolean suma1Y3Impar;
        boolean suma2y4Pares;

        do {

            // pedir pin

            do {
                String numero1Txt = JOptionPane.showInputDialog("Inserte primer número de la clave");
                numero1 = Integer.parseInt(numero1Txt);

                if (numero1 < 1 || numero1 > 9) {
                    JOptionPane.showMessageDialog(null, "Número debe ser entre 1 y 9");
                }
            } while (numero1 < 1 || numero1 > 9);

            // Pedir segundo número
            do {
                String numero2Txt = JOptionPane.showInputDialog("Inserte segundo número de la clave");
                numero2 = Integer.parseInt(numero2Txt);

                if (numero2 < 1 || numero2 > 9) {
                    JOptionPane.showMessageDialog(null, "Número debe ser entre 1 y 9");
                }
            } while (numero2 < 1 || numero2 > 9);

            // Pedir tercer número
            do {
                String numero3Txt = JOptionPane.showInputDialog("Inserte tercer número de la clave");
                numero3 = Integer.parseInt(numero3Txt);

                if (numero3 < 1 || numero3 > 9) {
                    JOptionPane.showMessageDialog(null, "Número debe ser entre 1 y 9");
                }
            } while (numero3 < 1 || numero3 > 9);

            // Pedir cuarto número

            do {
                String numero4Txt = JOptionPane.showInputDialog("Inserte cuarto número de la clave");
                numero4 = Integer.parseInt(numero4Txt);

                if (numero4 < 1 || numero4 > 9) {
                    JOptionPane.showMessageDialog(null, "Número debe ser entre 1 y 9");
                }
            } while (numero4 < 1 || numero4 > 9);

            // no repeir numeros

            numerosDiferentes = (numero1 != numero2 && numero1 != numero3 && numero1 != numero4 &&
                    numero2 != numero3 && numero2 != numero4 &&
                    numero3 != numero4);

            // suma de be ser impar

            int suma1 = numero1 + numero3;
            suma1Y3Impar = (suma1 % 2 != 0);

            // suma de be ser par

            int suma2 = numero2 + numero4;
            suma2y4Pares = (suma2 % 2 != 0);

            // un bloque de texto para informar de las condiciones

            String mensaje = """
                    Si alguno de los siguientes es false se repitira
                    Los numeros no son iguales = %s
                    los numeros 1  y 3 al sumarlos no son pares = %s
                    los numeros 2  y 4 al sumarlos son pares = %s
                    """.formatted(numerosDiferentes, suma1Y3Impar, suma2y4Pares);

            JOptionPane.showMessageDialog(null, mensaje);

            // se repitira si es alguno correcto
        } while (numerosDiferentes || suma1Y3Impar || suma2y4Pares);

    }

}
