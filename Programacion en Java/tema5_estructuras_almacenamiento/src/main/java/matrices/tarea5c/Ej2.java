package matrices.tarea5c;

import java.util.Random;

public class Ej2 {
    public static int[][] SumarMatriz() {

        // crea enseña matrizes

        int[][] matriz1 = new int[4][4];
        for (int i = 0; i < matriz1.length; i++) {
            for (int j = 0; j < matriz1[i].length; j++) {
                matriz1[i][j] = new Random().nextInt(1, 10);
                System.out.print(matriz1[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("------------------------");

        // crea enseña matrizes

        int[][] matriz2 = new int[4][4];
        for (int i = 0; i < matriz2.length; i++) {
            for (int j = 0; j < matriz2[i].length; j++) {
                matriz2[i][j] = new Random().nextInt(1, 10);
                System.out.print(matriz2[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("------------------------");

        // suma

        int[][] matrizSuma = new int[4][4];
        for (int i = 0; i < matriz1.length; i++) {
            for (int j = 0; j < matriz2[i].length; j++) {
                matrizSuma[i][j] = matriz1[i][j] + matriz2[i][j];
            }
        }
        return matrizSuma;
    }
}
