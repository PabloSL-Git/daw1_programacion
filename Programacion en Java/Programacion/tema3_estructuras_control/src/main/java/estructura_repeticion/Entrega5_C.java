package estructura_repeticion;

import java.util.Scanner;

public class Entrega5_C {
    public static void main(String[] args) {

        // C. Hacer un programa que lea una serie de números enteros,
        // precedida del número total de enteros a leer.
        // El programa debe calcular el total de números pares,
        // el total de números impares, y el promedio de todos los números.

        Scanner teclado = new Scanner(System.in);

        System.out.print("¿Cuántos números quieres introducir?: ");
        int total = teclado.nextInt();

        int contador = 0;
        int pares = 0;
        int impares = 0;
        int suma = 0;

        while (contador < total) {
            System.out.print("Introduce un número entero: ");
            int num = teclado.nextInt();

            if (num % 2 == 0) {
                pares++;
            } else {
                impares++;
            }

            suma += num;
            contador++;
        }

        double promedio = (double) suma / total;

        System.out.println("Total de pares: " + pares);
        System.out.println("Total de impares: " + impares);
        System.out.println("Promedio: " + promedio);

        teclado.close();

    }

}
