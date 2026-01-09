package entrega2;

import javax.swing.JOptionPane;
import java.util.Scanner;

public class Expresiones {
   public static void main(String[] args) {

      Scanner teclado = new Scanner(System.in);
      System.out.print("introduce el num1 = ");
      int num1 = teclado.nextInt();
      teclado.close();

      String num2Bad = JOptionPane.showInputDialog("Introduce el num2");
      int num2 = Integer.parseInt(num2Bad);

// quiere saber si es positivo o cero
      if (num1>=0){
         //entra aqui si es positiva
         System.out.println("soy positivo o cero num1");
      } else {
         // entra aqui si es falsa
         System.out.println("soy negativo num1");
      }

      String mensaje = """
            El numero 1 es %d
            El numero 2 es %d
            """.formatted(num1, num2);

      JOptionPane.showMessageDialog(null, mensaje);

      // a) num1 es mayor que num2 y num1 menos 10 es menor que num2-1.

      boolean a = (num1 > num2) && (num1 - 10) < (num2 - 1);

      // b) num1 es par o num2 es par
      // si un numero al dividir por 2 no deja resto, entonces es par

      boolean b = (num1 % 2 == 0) || (num2 % 2   == 0);

      // c) num2 es impar y num1 es par

      boolean c = (num1 % 2 == 0) && (num2 % 2 != 0);

      // d) Al resto de dividir num1 entre 3 se le suma 1.
      // comprobar que el resultado es igual a 3

      boolean d = ((num1 % 3) + 1) == 3;

      // e) 10 es menor o igual que 2 multiplicado por num1 y 3 es menor que 4
      // o 8 no es mayor que 7 y num2 multiplicado por 2 es menor o igual que 4 por 2
      // menos 1

      boolean e = (10 <= (2 * num1) && 3 < 4) || (8 < 7) & (num2 * 2) <= (4 * 2 - 1);

      // f) el resultado de negar la expresión: num2 es mayor que num1
      // y dos por num1 menor o igual a num2

      boolean f = !(num2 > num1) && (2 * num1 <= num2);

      // g) num2/2<num1 y num1++/2>num2

      // ++ es una vriable post-incremento, se usa tal que asi:
      // int a = 5;
      // int b = a++; // post-incremento
      // System.out.println("a = " + a); // 6
      // System.out.println("b = " + b); // 5

      boolean g = (num2 / 2 < num1) && (num1++ / 2 > num2);

      // h) num1 está entre 15 y 20

      boolean h = (15 < num1) && (num1 < 20);

      // i) num1 está entre 15 y 20 o num2 es distinto de 7

      boolean i = ((15 < num1) && (num1 < 20)) || (num2 != 7);

      // j) num2 no es 100

      boolean j = (num2 != 100);

      // k) num2 no está entre 50 y 100

      boolean k = !(50 < num2) && (num2 < 100);

      String mensaje2 = """
            a) es mayor que num2 y num1 menos 10 es menor que num2-1.: %s
            b) num1 es par o num2 es par: %s
            c) num2 es impar y num1 es par: %s
            d) Al resto de dividir num1 entre 3 se le suma 1.
               Comprobar que el resultado es igual a 3: %s
            e) 10 es menor o igual que 2 multiplicado por num1 y 3 es menor que 4
               o 8 no es mayor que 7 y num2 multiplicado por 2 es menor
               o igual que 4 por 2 menos 1: %s
            f) el resultado de negar la expresión: num2 es mayor que num1
               y dos por num1 menor o igual a num2: %s
            g) (num2 dividido entre 2 es menor que num1) y (num1 dividido entre 2 es mayor que num2,
               incrementando num1 después de la comparación): %s
            h) num1 entre 15 y 20: %s
            i) num1 está entre 15 y 20 o num2 es distinto de 7: %s
            j) num2 no es 100: %s
            k) num2 no está entre 50 y 100: %s
            """.formatted(a, b, c, d, e, f, g, h, i, j, k);

      JOptionPane.showMessageDialog(null, mensaje2);

   }
}