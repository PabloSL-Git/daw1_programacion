package ejercicios;

import java.util.Scanner;

public class ejercicio3 {

    public static void main(String[] args) {

        // la vamos a pedir al usuario el numero de grupos que tiene un instituto
        // grupos que tienen instituto
        // cada grupo tiene 30 horas de clase semanales
        // cada profesor maximo 18 horas clase semana
        // calcular profesores necesarios
        // usar math ceil, floor, round

        Scanner teclado = new Scanner(System.in);

        System.out.println("introduce numero de grupos que tiene el instituto = ");
        int grupos = teclado.nextInt();
        System.out.println(" has introducido " + grupos);

        int horasNecesarias = grupos * 30;
        System.out.println("horas a cubir es = " + horasNecesarias);

        // int / int me dara int incluso con double
        // para eviralo se puede forzar uno a ser double con ,0 o (double)
        // para no tener numeros sueltos seria conveniente hacer constantes
        // no puede cambiar de valor, par hacer usar final
        // se escribe de esa forma por convenio

        final int NUMERO_DE_HORAS_CADA_PROFESOR = 18;

        double profesores = Math.ceil(horasNecesarias / NUMERO_DE_HORAS_CADA_PROFESOR);
        System.out.println("Seran necesarios " + (int) profesores + " profesores ");

        teclado.close();

    }

}
