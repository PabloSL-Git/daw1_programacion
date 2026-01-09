package ejercicios;

import java.util.Scanner;

public class Ejercicio1 {
    public static void main(String[] args) {

        // ejercicio 1. Leer con teclado 4 numeros, hacer media y mostrar

        Scanner teclado = new Scanner(System.in);
        double num1 = teclado.nextDouble();
        teclado.nextLine();
        double num2 = teclado.nextDouble();
        teclado.nextLine();
        double num3 = teclado.nextDouble();
        teclado.nextLine();
        double num4 = teclado.nextDouble();
        teclado.nextLine();
        double num5 = teclado.nextDouble();

        double media = (num1 + num2 + num3 + num4 + num5) / 5;

        // hay que usar el lowerCamelCase para nombrar variables
        // usar formato documento

        System.out.println("Resultado media es = " + media);

        // var swapping

        var aux = num2;
        num2 = num1;
        num1 = aux;

        System.out.println("ahoar num es = " + num1 + "y num2 es = " + num2);

        teclado.close();

        // %.2f para añadir mas decimales
        // \n sirve para saltar linea

    }

}
