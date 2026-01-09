package funciones.calculadora;

import java.util.Scanner;
import java.util.InputMismatchException;

public class CalculadoraSeparada {
    public static void main(String[] args) {

        // Calculadora
        

        boolean salir = false; // No quiero salir, se repite hasta
        // que el usuario decida salir = true
        Scanner teclado = new Scanner(System.in);
        int opcionElegida;
        int operando1 = 0, operando2 = 0, resultado;
        double resultadoDivido;

        // Repetir
        do {

            // opcionElegida = 0; // Sirve para reiniciar la opción

            // el ordenador sabe donde coger por el orden de los numeros

            CalculadoraFunciones.mostrarMenu();
            System.out.println("Introduce una opción (1-5): ");

            try {

                opcionElegida = teclado.nextInt();

                switch (opcionElegida) {
                    case 1 -> {

                        System.out.println("Dame primer numero");
                        operando1 = teclado.nextInt();

                        System.out.println("Dame segundo numero");
                        operando2 = teclado.nextInt();

                        System.out.println("Opción sumar");
                        resultado = CalculadoraFunciones.sumar(operando1, operando2);
                        System.out.println("Resultado " + resultado);

                    }
                    case 2 -> {

                        System.out.println("Dame primer numero");
                        operando1 = teclado.nextInt();

                        System.out.println("Dame segundo numero");
                        operando2 = teclado.nextInt();

                        System.out.println("Opción restar");

                        System.out.println("Opción sumar");
                        resultado = CalculadoraFunciones.restar(operando1, operando2);
                        System.out.println("Resultado " + resultado);
                    }
                    case 3 -> {
                        System.out.println("Dame primer numero");
                        operando1 = teclado.nextInt();

                        System.out.println("Dame segundo numero");
                        operando2 = teclado.nextInt();

                        System.out.println("Opción multiplicar");

                        System.out.println("Opción sumar");
                        resultado = CalculadoraFunciones.multiplicar(operando1, operando2);
                        System.out.println("Resultado " + resultado);
                    }
                    case 4 -> {
                        System.out.println("Dame primer numero");
                        operando1 = teclado.nextInt();

                        System.out.println("Dame segundo numero");
                        operando2 = teclado.nextInt();

                        System.out.println("Opción dividir");

                        System.out.println("Opción sumar");
                        resultadoDivido = CalculadoraFunciones.dividir(operando1, operando2);
                        System.out.println("Resultado " + resultadoDivido);
                    }
                    case 5 -> {
                        System.out.println("Has decidido salir...");
                        System.out.println("Hasta pronto.");
                        salir = true; // Me quiero ir
                    }

                    default -> {
                        System.out.println("Te has equivocado de opción");
                    }
                }

            } catch (InputMismatchException ime) {

                // Hago algo

                System.out.println("No has introducido un número. Intenta de nuevo...");
                teclado.nextLine();

            } catch (IllegalArgumentException iae) {
                System.out.println("No se puede dividir por cero");
            }

        } while (!salir); // mientras no quiera salir

        teclado.close();
    }

}