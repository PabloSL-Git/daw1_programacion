package estructura_repeticion;

import java.util.Scanner;

public class Entrega5_B {
    public static void main(String[] args) {

        // B. Pirámide de números. Genera un pirámide de números como esta.
        // 1
        // 22
        // 333
        // 4444
        // 55555
        // 666666
        // ...
        // La pirámide tendrá tantos pisos como decida el usuario, de 1 a 10.

        Scanner teclado = new Scanner(System.in);
        int pisos = 0;

        while (pisos < 1 || pisos > 10) {
            System.out.print("Introduce el número de pisos (1-10): ");
            pisos = teclado.nextInt();
        }

        int i = 1;
        while (i <= pisos) {
            int j = 1;
            while (j <= i) {
                System.out.print(i);
                j++;
            }
            System.out.println();
            i++;
        }

        teclado.close();

    }

}
