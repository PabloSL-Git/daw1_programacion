package estructura_repeticion;

import java.util.Scanner;

public class EstructurasRepeticion {
    public static void main(String[] args) {

        // todas las estructuras tienen tres partes
        // Inicializacion de variable control
        // condicion que usa variable de control
        // actualizacion de la varable de control

        // bucle while

        int variableControl = 1; // inicializacion

        while (variableControl < 10) { // condicion

            variableControl++;

            // ++ es +=1
            // +=2 es vasicamente de dos en dos

            // en la siguiente linea se hace suma una a la variable de control
            // y luego se hace sout

            System.out.println("Iteracion: " + (++variableControl));

            //en la siguiente se hace sout antes de sumar uno a variable

            System.out.println("Iteracion: " + (variableControl++));

            // estas lineas son equivalentes porque la variable de control no incluye a ninguna

        }

        System.out.println("-----------------------------");

        // do while es como el while pero siempre
        // hace una iteracion

        int variableControl2 = 1;
        do {
            System.out.println("Iteracion 2: " + variableControl2);
            variableControl2++;
        } while (variableControl2 <= 10);

        System.out.println("-----------------------------");

        // se usa cuando sabemos cuantas iteraciones se necesita

        for (int variableControl3 = 1; variableControl3 < 10; variableControl3++) {
            System.out.println("Iteracion 3: " + variableControl3);
        }

        // escribe tu nombre hasta que el usuario escriba cero

        Scanner teclado = new Scanner(System.in);
        System.out.println("introduce un numero: ");
        int numero = teclado.nextInt();

        while (numero != 0) {
            System.out.println("Pablo Santamaria");
            System.out.println("Introduce numero: ");
            numero = teclado.nextInt();
        }

        teclado.close();

    }

}
