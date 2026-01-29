package daw;

import java.util.Scanner;

public class Ej3 {
    private static final Scanner tec = new Scanner(System.in);

    public static char[][] AsientosAvion() {

        // matriz ivion

        char[][] matrizAvion = new char[30][6];
        for (int i = 0; i < matrizAvion.length; i++) {
            for (int j = 0; j < matrizAvion[i].length; j++) {
                matrizAvion[i][j] = 'L';
            }
        }

        // elegir reserva o libera

        System.out.println("Quieres reservar o liberar un asiento?");
        String accionAsiento = tec.nextLine();

        int[] coordenadaAsiento = CoordenadaAsiento();
        int fila = coordenadaAsiento[0];
        int columna = coordenadaAsiento[1];

        if (accionAsiento.equalsIgnoreCase("reservar")) {
            matrizAvion[fila][columna] = 'R';
        }

        if (accionAsiento.equalsIgnoreCase("liberar")) {
            matrizAvion[fila][columna] = 'L';
        }

        return matrizAvion;
    }

    public static int[] CoordenadaAsiento() {

        int[] coordenadaAsiento = new int[2];

        System.out.println("Dame columna (A a F):");
        String columnaAsiento = tec.nextLine().toUpperCase();

        System.out.println("Dame fila (1 a 30):");
        int filaAsiento = Integer.parseInt(tec.nextLine());

        // Convertir a indices de la matriz
        coordenadaAsiento[0] = filaAsiento - 1; // fila
        coordenadaAsiento[1] = columnaAsiento.charAt(0) - 'A'; // columna

        return coordenadaAsiento;
    }
}
