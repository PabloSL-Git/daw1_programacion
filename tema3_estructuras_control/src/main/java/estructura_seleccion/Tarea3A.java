package estructura_seleccion;

import java.util.Scanner;
import javax.swing.JOptionPane;

public class Tarea3A {
  public static void main(String[] args) {

    Scanner teclado = new Scanner(System.in);

    // Realiza los siguientes ejercicios en el main, dando la solución para cada
    // ejercicio de dos formas:
    // mediante estructuras if (if, if else o if else if, elige la que creas
    // conveniente) y mediante el operador condicional ternario.
    // Incluye un menú de opciones al iniciar el programa para entrar a cada una de
    // las siguientes (del 1 al 5).
    // Si el usuario elige otra opción que no esté entre 1 y 5, el programa informa
    // y termina.

    String mensaje = """
        Introduce qué operación deseas hacer:
          - opcion 1
          - opcion 2
          - opcion 3
          - opcion 4
          - opcion 5
        """;
    String operacionMal = JOptionPane.showInputDialog(null, mensaje);
    int operacion = Integer.parseInt(operacionMal);

    if (operacion < 1 || operacion > 5) {
      JOptionPane.showMessageDialog(null, "Numero de operacion invalido");
    }

    switch (operacion) {
      case 1 -> {

        // Opción 1.- Pide un número y determina si es par o impar.

        String num1Txt = JOptionPane.showInputDialog("Dame un numero para determinar si es par no");
        double num1 = Double.parseDouble(num1Txt);

        if (num1 % 2 == 0) {
          JOptionPane.showMessageDialog(null, "Numero es par");
        } else {
          JOptionPane.showMessageDialog(null, "Numero no es par");
        }

        // opcion 1 ternario

        // if (operacion == 1) {
        // String num1Txt = JOptionPane.showInputDialog("Dame un numero para determinar
        // si es par no");
        // double num1 = Double.parseDouble(num1Txt);
        // String resultado = (num1 % 2 == 0) ? "Numero es par" : "Numero no es par";
        // JOptionPane.showMessageDialog(null, resultado);
        // }

      }
      case 2 -> {

        // Opción 2.- Pide al usuario dos números enteros y determina cuál es el mayor.

        String num1Txt = JOptionPane.showInputDialog("Dame el numero 1 entero");
        int num1 = Integer.parseInt(num1Txt);
        String num2Txt = JOptionPane.showInputDialog("Dame el numero 2 entero");
        int num2 = Integer.parseInt(num2Txt);

        if (num1 > num2) {
          JOptionPane.showMessageDialog(null, "el numero 1 es mayor");
        } else if (num2 > num1) {
          JOptionPane.showMessageDialog(null, "el numero 2 es mayor");
        } else {
          JOptionPane.showMessageDialog(null, "Son iguales");
        }

        // opcion 2 ternario

        // if (operacion == 2) {
        // String num1Txt = JOptionPane.showInputDialog("Dame el numero 1 entero");
        // int num1 = Integer.parseInt(num1Txt);
        // String num2Txt = JOptionPane.showInputDialog("Dame el numero 2 entero");
        // int num2 = Integer.parseInt(num2Txt);
        // String resultado = (num1 > num2) ? "el numero 1 es mayor"
        // : (num2 > num1) ? "el numero 2 es mayor" : "Son iguales";
        // JOptionPane.showMessageDialog(null, resultado);
        // }
      }
      case 3 -> {

        // Opción 3.- Pide un número entre 0 y 100 que representa una calificación,
        // imprimir:
        // “Aprobado” si la nota es mayor o igual a 60.
        // “Suspenso” en caso contrario.

        String num1Txt = JOptionPane.showInputDialog("Dame la califificacion");
        int num1 = Integer.parseInt(num1Txt);

        if (num1 >= 60) {
          JOptionPane.showMessageDialog(null, "Aprobado");
        } else {
          JOptionPane.showMessageDialog(null, "suspenso");
        }

        // version 3 ternario

        // if (operacion == 3) {
        // String num1Txt = JOptionPane.showInputDialog("Dame la califificacion");
        // int num1 = Integer.parseInt(num1Txt);
        // String resultado = (num1 >= 60) ? "Aprobado" : "suspenso";
        // JOptionPane.showMessageDialog(null, resultado);
        // }
      }
      case 4 -> {

        // Opción 4.- Pide un número entero e imprime si el número es positivo, negativo
        // o cero.
        // En este caso debes anidar el operador ternario.

        String num1Txt = JOptionPane.showInputDialog("Dame un numero entero");
        int num1 = Integer.parseInt(num1Txt);

        if (num1 == 0) {
          JOptionPane.showMessageDialog(null, "Numero es 0");
        } else if (num1 > 0) {
          JOptionPane.showMessageDialog(null, "Numero es positivo");
        } else if (num1 < 0) {
          JOptionPane.showMessageDialog(null, "Numero es negativo");
        }

        // opcion 4 ternario

        // if (operacion == 4) {
        // String num1Txt = JOptionPane.showInputDialog("Dame un numero entero");
        // int num1 = Integer.parseInt(num1Txt);
        // String resultado = (num1 == 0) ? "Numero es 0" : (num1 > 0) ? "Numero es
        // positivo" : "Numero es negativo";
        // JOptionPane.showMessageDialog(null, resultado);
        // }
      }
      case 5 -> {

        // Opción 5.- Determinar si un año es bisiesto. Un año es bisiesto si es
        // divisible por 400
        // o es divisible por 4 y no es divisible por 100.

        String num1Txt = JOptionPane.showInputDialog("Dame el año");
        int num1 = Integer.parseInt(num1Txt);
        
        if ((num1 % 400 == 0) || (num1 % 4 == 0 && num1 % 100 != 0)) {
          JOptionPane.showMessageDialog(null, "El año " + num1 + " es bisiesto");
        } else {
          JOptionPane.showMessageDialog(null, "El año " + num1 + " no es bisiesto");
        }

        // opcion 5 ternario

        // if (operacion == 5) {
        // String num1Txt = JOptionPane.showInputDialog("Dame el año");
        // int num1 = Integer.parseInt(num1Txt);
        // String resultado = (num1 % 400 == 0) || (num1 % 4 == 0 && num1 % 100 != 0)
        // ? "El año " + num1 + " es bisiesto"
        // : "El año " + num1 + " no es bisiesto";
        // JOptionPane.showMessageDialog(null, resultado);
        // }

      }

    }

    teclado.close();

  }
}