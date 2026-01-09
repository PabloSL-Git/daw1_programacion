package array;

import java.util.Random;
import java.util.Arrays;

public class PracticaArray3 {
    public static void main(String[] args) {

        // 7. array 100 numeros aleatorios entre 1 y 30
        // 8. Funcion que devuelve ese array sin duplicados

        int[] numerosCambiados = arrayNoRepetido();

        for (int i = 0; i < numerosCambiados.length; i++) {
            System.out.println("EL numero cambiado de " + (1 + i) + " es " + numerosCambiados[i]);
        }
    }

    public static int[] arrayNoRepetido() {

    int[] numeros = new int[100];
    Random random = new Random();

    // Generar array original
    for (int i = 0; i < numeros.length; i++) {
        numeros[i] = random.nextInt(1, 31);
    }

    // Crear array para guardar únicos
    int[] unicos = new int[100];
    int contador = 0;

    for (int i = 0; i < numeros.length; i++) {

        boolean repetido = false;

        // revisar si ya está en unicos
        for (int j = 0; j < contador; j++) {
            if (numeros[i] == unicos[j]) {
                repetido = true;
                break;
            }
        }

        if (!repetido) {
            unicos[contador] = numeros[i];
            contador++;
        }
    }

    // devolver solo la parte usada
    return Arrays.copyOf(unicos, contador);
}

}
