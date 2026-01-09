package estructura_repeticion;

import javax.swing.JOptionPane;

public class EJ3CalcularMasaCorporal {
    public static void main(String[] args) {

        // calcularindice masa corporal, introduzca datos en rango.
        // <18,5 bajo peso
        // 18,5 a 25,9 normal
        // 25 a 26,9 sobrepeso 1
        // 27 a 29,9 sobrepeso 2
        // 30 obesidad
        // peso entre 0,1 y 200. estatura entre 0,5 y 2,5
        // despues mostrar resultado, preguntar si quiere ejecutar otra vez
        // si es si repite, dice no salgo, si es ninguna pregunta otra vez

        String respuesta;

        do {
            double numeroPeso, numeroAltura;
            do {

                String numeroPesoTxt = JOptionPane.showInputDialog("Intruduce tu peso en Kilos");
                numeroPeso = Double.parseDouble(numeroPesoTxt);

                if (numeroPeso < 0.1 || numeroPeso > 200) {
                    JOptionPane.showMessageDialog(null, "Peso debe ser entre 0,1 y 200 kilos");
                }

                String numeroAlturaTxt = JOptionPane.showInputDialog("Introduce tu altura en metros");
                numeroAltura = Double.parseDouble(numeroAlturaTxt);

                if (numeroAltura < 0.5 || numeroAltura > 2.5) {
                    JOptionPane.showMessageDialog(null, "Altura debe ser entre 0,5 y 2.5 Metros");
                }

            } while (numeroPeso < 0.1 || numeroPeso > 200 || numeroAltura < 0.5 || numeroAltura > 2.5);

            // calcular masa corporal

            double masaCorporal = numeroPeso / (numeroAltura * numeroAltura);

            // clasificar masas

            String clasificacion = (masaCorporal < 18.5) ? "Bajo peso"
                    : (masaCorporal <= 25.9) ? "Peso normal"
                            : (masaCorporal <= 26.9) ? "Sobrepeso grado 1"
                                    : (masaCorporal <= 29.9) ? "Sobrepeso grado 2" : "Obesidad";

            JOptionPane.showMessageDialog(null,
                    "Tu masa corporal es: " + masaCorporal + " lo que te clasifica como: " + clasificacion);

            // hacer que el si/no

            // opcion 1

            respuesta = JOptionPane.showInputDialog("¿Deseas calcular otro salario? si o no: ");

            if (!respuesta.equalsIgnoreCase("no") && !respuesta.equalsIgnoreCase("si")) {

                JOptionPane.showMessageDialog(null, "Su respuesta debe ser si o no");

                do {
                    respuesta = JOptionPane.showInputDialog("¿Deseas calcular otra masa corporal? si o no: ");
                    JOptionPane.showMessageDialog(null, "Su respuesta debe ser si o no");

                } while (!respuesta.equalsIgnoreCase("no") && !respuesta.equalsIgnoreCase("si"));
            }

            // opcion 2

            do {
                respuesta = JOptionPane.showInputDialog("¿Deseas calcular otra masa corporal? (si o no):");
                if (!respuesta.equalsIgnoreCase("si") && !respuesta.equalsIgnoreCase("no")) {
                    JOptionPane.showMessageDialog(null, "Respuesta inválida. Debe ser 'si' o 'no'.");
                }
            } while (!respuesta.equalsIgnoreCase("si") && !respuesta.equalsIgnoreCase("no"));

        } while (respuesta.equalsIgnoreCase("si"));

        JOptionPane.showMessageDialog(null, "Programa terminado");

    }

}
