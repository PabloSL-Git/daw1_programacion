package tema2y3;

import java.util.Scanner;

//Pablo Santamaria Loredo

public class Ejercicio1 {
    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        // pide numero y coge en txt

        System.out.println("Dame un número del 1 al 99999 = ");
        String numero1Al99999Txt = teclado.nextLine();
        teclado.nextLine();

        // paso txt a int

        int numero1Al99999 = Integer.parseInt(numero1Al99999Txt);

        // if para filtrar numero

        if (numero1Al99999 >= 1 && numero1Al99999 <= 99999) {

            // pide nombre

            System.out.println("Dame tu nombre = ");
            String nombre = teclado.nextLine();

            // sout on toda informacion

            System.out.println("Hola soy " + nombre + " y el numero es " + numero1Al99999 + " y tengo "
                    + numero1Al99999Txt.length() + " cifras");

        } else {
            System.out.println("Numero fuera del rango");
        }

        // En este programa primero pide el nombre en modo txt para que .length pueda
        // leerlo,
        // luego lo paso a int con el interger,
        // despues le hago un if or else para filtrar numeros fuera de rango.
        // Finalmente dentro del if pregunto el nombre y hago el sout final
        // con toda la informacion

        teclado.close();

    }
}