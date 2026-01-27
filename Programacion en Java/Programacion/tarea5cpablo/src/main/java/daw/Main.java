package daw;

import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner tec = new Scanner(System.in);

    public static void main(String[] args) {
        String menu = """
                Ejercicio 1
                Ejercicio 2
                Ejercicio 3
                Ejercicio 4
                Ejercicio 5
                """;

        System.out.println(menu);
        int menuSeleccion = tec.nextInt();
        System.out.println("------------------------");

        switch (menuSeleccion) {
            case 1 -> {
                List<int[]> resultado = Ej1.BuscaNumero();

                if (resultado.isEmpty()) {
                    System.out.println("Número no encontrado");
                } else {
                    for (int[] i : resultado) {
                        System.out.println("Fila: " + i[0] + " Columna: " + i[1]);
                    }
                }
            }
            case 2 -> {
                int[][] matrizSuma = Ej2.SumarMatriz();

                for (int i = 0; i < matrizSuma.length; i++) {
                    for (int j = 0; j < matrizSuma[i].length; j++) {
                        System.out.print(matrizSuma[i][j] + " ");
                    }
                    System.out.println();
                }
            }
            case 3 -> {
                char[][] matrizAvion = Ej3.AsientosAvion();

                System.out.println("   A  B  C  D  E  F");

                for (int i = 0; i < 30; i++) {
                    System.out.print((i + 1) + " ");
                    for (int j = 0; j < 6; j++) {
                        System.out.print(" " + matrizAvion[i][j] + " ");
                    }
                    System.out.println();
                }

            }
        }
    }
}