package tema4;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Ej2 {
    private static final Scanner tec = new Scanner(System.in);

    public static void main(String[] args) {
        // Hola, para recordar que no funcionaba el JOption
        
        Random random = new Random();

        int[] array1 = new int[20];

        for (int i = 0; i < array1.length; i++) {
            array1[i] = random.nextInt(0, 5);
        }

        System.out.println("Array 1 es: " + Arrays.toString(array1));

        tec.close();

    }

}
