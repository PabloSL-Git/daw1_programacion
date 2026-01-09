package teoria;

import java.util.Scanner;

//lectura basica de datos de teclo

public class LecturaBasicaDatos {
    public static void main(String[] args) {

        // lectura con la clase scanner

        Scanner teclado = new Scanner(System.in);
        System.out.println("Dame tu edad: ");

        // inicializa una variable para guardar dato
        // que introduce el usuario conteclado

        int edad = teclado.nextInt();
        System.out.println("tu edad es " + edad);

        // despues de leer numeros con escaner
        // hay que limpiar memoria inmediata si vamos a leer texto

        System.out.println("dame tu nombre ");
        teclado.nextLine();
        String nombre = teclado.nextLine();
        System.out.println("tu nombre es " + nombre);

        System.out.println("Te llamas " + nombre + " y tienes " + edad);

        teclado.close();

    }

}
