package matrices;

import java.util.Random;

public class Ejemplo {
    public static void main(String[] args) {
        int[][] matriz = new int[4][6];
        // Primer [] es filas, Segundo [] es columnas.

        // Recorrido clásico
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.println(" " + matriz[i][j]);
            }
        }

        // Rellenar con números aleatorios y mostrar bien
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j] = new Random().nextInt(0, 100);
                System.out.print(" " + matriz[i][j]);
            }
            System.out.println();
        }

        System.out.println(" Con foreach -----");
        for (int[] fila : matriz) {
            for (int elemento : fila) {
                System.out.print(" " + elemento);
            }
            System.out.println();
        }
    }
}
