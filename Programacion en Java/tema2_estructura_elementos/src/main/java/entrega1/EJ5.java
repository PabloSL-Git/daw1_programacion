package entrega1;

import javax.swing.JOptionPane;

public class EJ5 {

    public static void main(String[] args) {

        // Realiza un programa que calcule la distancia entre dos puntos en un plano
        // cartesiano.
        // Para ello solicita los datos de tipo int (x,y) de cada
        // punto y realiza el cálculos de la distancia entre ambos con la ayuda del
        // Teorema de Pitágoras.
        // Usando variables booleanas, muestra el resultado de evaluar si todas
        // las dimensiones introducidas por el usuario están entre -10 y 10.

        // Pedir coordenadas X e Y del primer punto

        String datoX1 = JOptionPane.showInputDialog("Introduce el dato x del primer punto:");
        String datoY1 = JOptionPane.showInputDialog("Introduce el dato y    del primer punto:");

        // Pedir coordenadas X e Y del segundo punto

        String datoX2 = JOptionPane.showInputDialog("Introduce la coordenada X del segundo punto:");
        String datoY2 = JOptionPane.showInputDialog("Introduce la coordenada Y del segundo punto:");

        // Convertir a int

        int x1 = Integer.parseInt(datoX1);
        int y1 = Integer.parseInt(datoY1);
        int x2 = Integer.parseInt(datoX2);
        int y2 = Integer.parseInt(datoY2);

        // Calcular distancia usando Pitágoras

        double distancia = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));

        boolean dentroRango = (x1 >= -10 && x1 <= 10) &&
                (y1 >= -10 && y1 <= 10) &&
                (x2 >= -10 && x2 <= 10) &&
                (y2 >= -10 && y2 <= 10);


        String mensaje = String.format("La distancia entre los puntos es: %.2f"
                                     + "¿Todas las coordenadas están entre -10 y 10? %s",
                                     distancia, dentroRango ? "Sí" : "No");

        JOptionPane.showMessageDialog(null, mensaje);

    }

}
