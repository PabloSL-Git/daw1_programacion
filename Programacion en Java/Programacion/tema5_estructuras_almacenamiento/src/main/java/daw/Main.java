package daw;

import java.util.Random;
import java.util.Scanner;

public class Main {
    private static final Scanner tec = new Scanner(System.in);

    public static void main(String[] args) {
        int[][] matriz = new int[4][4];

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j] = new Random().nextInt(1, 10);
                System.out.print(" " + matriz[i][j]);
            }
            System.out.println();
        }

        System.out.println("Que numero buscas (del 1 al 10)");
        int numeroBuscar = tec.nextInt();

        int fila = -1;
        int columna = -1;

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (matriz[i][j] == numeroBuscar) {
                    fila = i;
                    columna = j;
                }
            }
        }

        if (fila != -1) {
            System.out.println("Fila: " + fila + "\nColumna: " + columna);
        } else {
            System.out.println("El numero no se encuentra en la matriz");
        }
    }

}