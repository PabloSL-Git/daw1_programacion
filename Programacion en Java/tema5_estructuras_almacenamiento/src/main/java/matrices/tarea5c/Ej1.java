package matrices.tarea5c;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Ej1 {
    private static final Scanner tec = new Scanner(System.in);

    public static List<int[]> BuscaNumero() {
        System.out.println("Que numero buscas (del 1 al 10)");
        int numeroBuscar = tec.nextInt();

        System.out.println("------------------------");

        int[][] matriz = new int[4][4];

        // eneseña y crea matriz

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j] = new Random().nextInt(1, 10);
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }

        // crea lista para coordenadas para que sea mas facil pasarla

        List<int[]> coordenadas = new ArrayList<>();

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (matriz[i][j] == numeroBuscar) {
                    coordenadas.add(new int[] { i, j });
                }
            }
        }
        return coordenadas;

    }
}