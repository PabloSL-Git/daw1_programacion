package ternario;

import java.util.Scanner;

public class OperadorTerniario {
    public static void main(String[] args) {

 Scanner tec = new Scanner(System.in);

        // Saber si una letra es una vocal
        System.out.println("Introduce una letra ");
        String letraTxt = tec.next();
        System.out.println("La palabra es: " + letraTxt);
        System.out.println("El tamaño de la palabra es " + letraTxt.length());

        // Cogemos la primera letra del String
        char letra = letraTxt.charAt(0);
        

        // Saber si es vocal
        String esVocal;
        if (letra == 'a' || letra == 'e' || letra == 'i'
        || letra == 'o' || letra == 'u'){
            esVocal = "sí";
        } else {
            esVocal = "no";
        }

        System.out.println("La letra es " + letra + " vocal?: " + esVocal);


        System.out.println("Introduce tu edad: ");
        int edad = tec.nextInt();
        tec.nextLine();
        System.out.println("Introduce tu nombre: ");
        String nombre = tec.nextLine();

        String resultado;

        // Versión 1
        if (edad >= 18) {
            System.out.println("Hola " + nombre + " puedes votar ");
            // resultado = "Puedes votar";
        } else {
            System.out.println("Hola " + nombre + " no puedes votar ");
            // resultado = "No puedes votar";
        }

        // Versión 2
        if (edad >= 18) {
            resultado = "puedes votar";
        } else {
            resultado = "no puedes votar";
        }

        System.out.println("Hola " + nombre + " " + resultado);

        // Versión 3 con operador ternario

        resultado = (edad >= 18) ? "puedes votar" : "no puedes votar";
        System.out.println("Hola " + nombre + " " + resultado);

        // saber si letra es consonante

        System.out.println("introduce unas letras");
        String letraTxt2 = tec.next();
        System.out.println("la plabra es: " + letraTxt);
        System.out.println("el tamaño de la palbra es: " + letraTxt.length());

        // cogemos la primera letra

        char letra3 = letraTxt2.charAt(0);
        System.out.println("la letra es " + letra3);

        // saber si es bocal

        String esVocal2;

        esVocal2 = (letra3 == 'a' || letra3 == 'e' || letra3 == 'i' || letra3 == 'o' || letra3 == 
        'u') ?"si":"no";

            //pedir 3 numeros

            System.out.println("dame num1");
            int num1 = tec.nextInt();
            System.out.println("dame num2");
            int num2 = tec.nextInt();
            System.out.println("dame num3");
            int num3 = tec.nextInt();

            //saber mayor de los tres

            int mayor;
            if (num1 > num2 && num1 > num3){
                mayor = num1;
            } else if (num2 > num1 && num2 > num3){
                mayor = num2;
            } else {
                mayor = num3;
            }

            //version ternario

            mayor = (num1 > num2 && num1 > num3) ?num1:
            (num2 > num1 && num2 > num3) ?num2:num3;

            System.out.println(mayor + " y " + esVocal2);

         tec.close();
    }

}
