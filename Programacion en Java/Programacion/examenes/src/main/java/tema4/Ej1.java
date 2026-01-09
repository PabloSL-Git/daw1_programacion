package tema4;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ej1 {

    private static final Scanner tec = new Scanner(System.in);

    public static void main(String[] args) {
        // Hola, para recordar que no funcionaba el JOption

        // a

        int numeroExepcion = 0;

        numeroExepcion = NumeroExepciones();

        // b

        String[] array1 = LeerPalabras();

        // c

        String[] array1Cambiado = LeerPalabrasMovidas(array1, numeroExepcion);

        for (int i = 0; i < array1Cambiado.length; i++) {
            System.out.println("Posicion " + i + ": " + array1Cambiado[i]);
        }

        tec.close();

    }

    public static int NumeroExepciones() { // A

        int numeroExepcion = 0;
        boolean correcto = false;

        try {

            System.out.println("Dame in numero entero");
            numeroExepcion = tec.nextInt();
            tec.nextLine();

        } catch (InputMismatchException ime) { // lee exepcion
            System.out.println("exepcion al leer numero " + ime);
        }

        while (!correcto) {

            if (numeroExepcion <= 0) {

                System.out.println("Numero debe ser mayor a cero");

                System.out.println("Dame in numero entero");
                numeroExepcion = tec.nextInt();
                tec.nextLine();

            } else {
                correcto = true;
            }
        }

        return numeroExepcion;

    }

    public static String[] LeerPalabras() { // B

        String palabra1 = "";
        String palabra2 = "";
        String palabra3 = "";
        String palabra4 = "";
        String palabra5 = "";
        String[] array1 = new String[5];

        System.out.println("primera palabra:");
        palabra1 = tec.nextLine();
        System.out.println("segunda palabra:");
        palabra2 = tec.nextLine();
        System.out.println("tercera palabra:");
        palabra3 = tec.nextLine();
        System.out.println("cuarta palabra:");
        palabra4 = tec.nextLine();
        System.out.println("quinta palabra:");
        palabra5 = tec.nextLine();

        // dar palabras al array

        array1[0] = palabra1;
        array1[1] = palabra2;
        array1[2] = palabra3;
        array1[3] = palabra4;
        array1[4] = palabra5;

        return array1;
    }

    public static String[] LeerPalabrasMovidas(String[] array1, int numeroExepcion) { // C

        String[] array1Cambiado = new String[5];

        for (int i = 0; i < array1.length; i++) {
            for (int z = 0; z < array1Cambiado.length; z++) {
                array1Cambiado[i] = array1[i];
            }
        }

        for (int i = 0; i < array1Cambiado.length; i++) {
            array1Cambiado[i] = array1[array1.length - 1 - i];
        }

        return array1Cambiado;

    }

}