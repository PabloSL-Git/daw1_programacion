package matrices.tarea5c;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Ej4 {

    public static List<int[]> Buscador0() {
        boolean repetir = true;
        do {

            int[][] matriz = new int[10][10];

            for (int i = 0; i < matriz.length; i++) {
                for (int j = 0; j < matriz[i].length; j++) {
                    matriz[i][j] = new Random().nextInt(2);
                }
            }

            for (int i = 1; i < 9; i++) {
                for (int j = 1; j < 9; j++) {

                    // Si encontramos un 0
                    if (matriz[i][j] == 0) {

                        boolean rodeado = matriz[i - 1][j] == 1 &&
                                matriz[i + 1][j] == 1 &&
                                matriz[i][j - 1] == 1 &&
                                matriz[i][j + 1] == 1 &&
                                matriz[i - 1][j - 1] == 1 &&
                                matriz[i - 1][j + 1] == 1 &&
                                matriz[i + 1][j - 1] == 1 &&
                                matriz[i + 1][j + 1] == 1;

                        if (rodeado) {
                            // Imprimir matriz
                            matriz[i][j] = 3;

                            for (int x = 0; x < matriz.length; x++) {
                                for (int y = 0; y < matriz[x].length; y++) {
                                    System.out.print(matriz[x][y] + " ");
                                }
                                System.out.println();
                            }

                            repetir = false;
                            List<int[]> coordenadas = new ArrayList<>();
                            coordenadas.add(new int[] { i, j });
                            return coordenadas;
                        }

                    }
                }
            }
        } while (repetir);
        return new ArrayList<>();
    }

}
