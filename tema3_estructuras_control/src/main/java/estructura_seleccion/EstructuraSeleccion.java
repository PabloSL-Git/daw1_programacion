package estructura_seleccion;

import java.util.Scanner;

public class EstructuraSeleccion {
    public static void main(String[] args) {

        // leer un numero que represente el mes
        // si el mes es correcto, el programa de be indiacar
        // el numero del mes correspondiente
        // si el mes no es correcto indicarlo al usuario

        Scanner teclado = new Scanner(System.in);

        System.out.println("introduce numero del mes = ");
        int numeroMes = teclado.nextInt();

        if ((numeroMes >= 0) && (numeroMes <= 12)) {
            System.out.println("numero es correcto");
            if (numeroMes == 1) {
                System.out.println("Enero");
            }
            if (numeroMes == 2) {
                System.out.println("Febrero");
            }
            if (numeroMes == 3) {
                System.out.println("Marzo");
            }
            if (numeroMes == 4) {
                System.out.println("Abril");
            }
            if (numeroMes == 5) {
                System.out.println("Mayo");
            }
            if (numeroMes == 6) {
                System.out.println("Junio");
            }
            if (numeroMes == 7) {
                System.out.println("Julio");
            }
            if (numeroMes == 8) {
                System.out.println("Agosto");
            }
            if (numeroMes == 9) {
                System.out.println("Septiembre");
            }
            if (numeroMes == 10) {
                System.out.println("Octubre");
            }
            if (numeroMes == 11) {
                System.out.println("Nobiembre");
            }
            if (numeroMes == 12) {
                System.out.println("Diciembre");
            }
        } else {
            System.out.println("numero incorrecto");
        }

        teclado.close();

        // otra opcion es switch

        // Indicar numero de dias en mes
        // indico los de 31 dias
        // lo siguiente no esta completado

        if (numeroMes == 1 || numeroMes == 3 || numeroMes == 5) {
            System.out.println("tiene 31 dias");
        } else if (numeroMes == 2) {
            System.out.println("tiene 28 o 29");
        } else {
            System.out.println("tiene 30 dias");
        }

    }
}
