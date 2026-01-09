package excepcion;

import java.util.InputMismatchException;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Exepciones {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        // con JOption

        int dato;

        try {

            dato = Integer.parseInt(JOptionPane.showInputDialog("inroduce entero "));
            System.out.println(dato);

        } catch (NumberFormatException nfe) {
            JOptionPane.showMessageDialog(null, "exepcion al leer numero");

        }

        // con scanner

        int a = 100;
        int b = 0;
        int c;

        // opcion a, comprobar que b no se a 0

        if (b != 0) {

            c = a / b;

            System.out.println("resultado = " + c);
        }

        // opcion b, gestionar la exepcion

        // todo lo que haya dentro del try se intenta
        // ejecutar. si falla entonces se ejecuta lo
        // que haya en el catch

        try {

            c = a / b;
            System.out.println("resultado = " + c);

        } catch (ArithmeticException ae) {
            System.out.println("exepcion");
            System.out.println("error es " + ae);
        }

        // la exepcion InputMisMatch
        // cuado tenemos que poner numeros con scanner
        // pero no pulsamos numeros

        System.out.println("Introduce un numero");
        int numero1 = teclado.nextInt();

        try {
            System.out.println("numero es = " + numero1);
        } catch (InputMismatchException ime) {
            System.out.println("Excepción: debes ingresar un número entero.");
            System.out.println("Error es: " + ime);
        }

        // entre 10 y 100 numero valido

        boolean salir = true;

        do {
            System.out.println("introduce numero");
            try {
                numero1 = teclado.nextInt();
                salir = false;

                // tambien se podria poner
                // if numero1 > 10 && numero1 < 100
                // break
            } catch (InputMismatchException imme) {
                teclado.nextLine();
                System.out.println("cuidado no es numero");
            }
        } while (salir || !(numero1 > 10 && numero1 < 100));

        teclado.close();

        // ArrayIndexOutOfBoundsException (cuando se intenta acceder
        //  a un índice que no existe en el array) y InputMismatchException 
        // (cuando la entrada del usuario no coincide con el tipo de dato esperado por el programa)

        //numberformat algo no numero

        //ilegalargument 

    }
}
