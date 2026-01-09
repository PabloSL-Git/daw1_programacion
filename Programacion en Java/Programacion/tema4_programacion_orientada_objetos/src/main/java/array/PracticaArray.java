package array;

import java.util.Scanner;

public class PracticaArray {

    private static final Scanner tec = new Scanner(System.in);

    public static void main(String[] args) {
        /*
         * Sumar los elementos de un array y mostrar resultado
         * 
         * Media aritmética de los números de un array
         * 
         * Contar números de veces que aparece un numero de un array
         * 
         * Funcion recibe array de char y devuelve en que posicion 
         * se encuentra el char como parametro o -1 si no esta
         */

        int[] array1 = { 15, 6, 3, 7, 15, 8 };

        // suma

        int suma = 0;
        for (int i = 0; i < array1.length; i++) {
            suma += array1[i];
        }
        System.out.println("La suma de los elementos es: " + suma);

        // media

        double media = suma / array1.length;
        System.out.println("La media aritmética es: " + media);

        // contar numeros repetidos

        int contador = 0;

        System.out.println("Que numero quieres buscar");
        int buscador = tec.nextInt();

        for (int i = 0; i < array1.length; i++) {
            if (array1[i] == buscador){
                contador++;
            }

        }

        System.out.println("Se repite = " + contador);

        // posicion de array con letra

        char[] array2 = { 'a', 'b', 'i', 'r', 'p', 'j' };

        System.out.println("array 2 es " + array2.length + " letras de largo");

        System.out.println("Que letra buscas");
        String buscaString = tec.nextLine();
        char busca = buscaString.charAt(0);


        for (int e = 0; e < array1.length; e++) {
            if (busca == array2[e]){
                System.out.println("numero esta en posicion " + e);

            } else {
                e = -1;

                System.out.println("numero esta en posicion " + e);
            }
        }



        tec.close();

    }

}
