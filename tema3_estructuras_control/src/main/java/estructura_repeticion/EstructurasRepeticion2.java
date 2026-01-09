package estructura_repeticion;

import java.util.Scanner;

public class EstructurasRepeticion2 {
    public static void main(String[] args) {
        // Cuenta atrás desde 100 a 0
        // y solo imprimimos los impares
        // for (int i = 100; i >= 0; i--) {
        // if (i % 2 != 0) {
        // System.out.println("i: " + i);
        // }
        // }
        // System.out.println("-----------------");
        // for (int i = 99; i >= 0; i -= 2) {
        // System.out.println("i: " + i);
        // }
        // Introducir años hasta que se introduzca
        // un bisiesto
        Scanner teclado = new Scanner(System.in);
        // int year;
        // do {
        // System.out.println("Introduce año: ");
        // year = teclado.nextInt();
        // } while (!((year%400==0)||((year%4==0)&&(year%100!=0))));
        // Tengo una certeza
        // year es bisiesto

        // Sumar los números que introduce el usuario hasta que
        // introduzca el número -1. Mostrar la suma
        int dato, suma = 0;
        do {
            System.out.println("Introduce el número: ");
            dato = teclado.nextInt();
            if (dato != -1) {
                suma += dato;
            }
            // suma += dato;
        } while (dato != -1);
        System.out.println("La suma total es: " + suma);

        System.out.println("Bucle con break -----------");
        do {
            System.out.println("Introduce el número: ");
            dato = teclado.nextInt();
            if (dato == -1) {
                break; // El break corta la ejecución del bucle y sale
            }
            suma += dato;
        } while (true);
        System.out.println("La suma total es: " + suma);

        System.out.println("Bucle con continue ---------");
        do {
            System.out.println("Introduce el número: ");
            dato = teclado.nextInt();
            if (dato == -1) {
                continue; // Se salta una iteración pero no termina
            }
            suma += dato;
        } while (suma != -1);
        System.out.println("La suma es " + suma);


        teclado.close();

    }

}
