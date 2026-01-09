package array;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class practicaArray5 {
    private static final Scanner tec = new Scanner(System.in);

    public static void main(String[] args) {

        // invertir array
        
        int[] array1 = GenerarArray();

        // Copiar array1 manualmente  <-- cambio
        int[] copia = new int[array1.length];          // <-- cambio
        for (int i = 0; i < array1.length; i++) {      // <-- cambio
            copia[i] = array1[i];                      // <-- cambio
        }

        // Invertir la copia (ahora sí contiene datos) <-- cambio
        int[] copiaInvertida = InvertirArray(copia);   // <-- cambio

        System.out.println("Array dado la vuelta es: " + Arrays.toString(copiaInvertida));

        tec.close();
    }

    public static int[] GenerarArray() {

        int[] array1 = new int[5];
        Random random = new Random();  // <-- cambio (antes se creaba dentro del for)

        for (int i = 0; i < array1.length; i++) {
            array1[i] = random.nextInt(10);
        }

        System.out.println("Array 1 es: " + Arrays.toString(array1));
        return array1;
    }

    public static int[] InvertirArray(int[] copia) {

        int[] copiaInvertida = new int[copia.length];

        // parte que invierte  <-- cambio (estaba vacío)
        for (int i = 0; i < copia.length; i++) {                 // <-- cambio
            copiaInvertida[i] = copia[copia.length - 1 - i];     // <-- cambio
        }

        return copiaInvertida;
    }

}
