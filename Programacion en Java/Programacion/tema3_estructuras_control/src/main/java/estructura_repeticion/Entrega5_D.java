package estructura_repeticion;

import java.util.Scanner;

public class Entrega5_D {
    public static void main(String[] args) {

        // D. Pedir un día, un mes y un año.
        // Si la fecha introducida es incorrecta, solicitar de nuevo los datos.
        // Hay que tener en cuenta los años bisiestos.
        // Por ejemplo, 32 de enero 1998 es una fecha incorrecta,
        // 31 septiembre de 1996 es incorrecta, 29 febrero de 2025 es incorrecta, etc.

        Scanner teclado = new Scanner(System.in);

        int dia = 0, mes = 0, anio = 0;
        boolean fechaCorrecta = false;

        while (!fechaCorrecta) {
            System.out.print("Introduce el día: ");
            dia = teclado.nextInt();
            System.out.print("Introduce el mes: ");
            mes = teclado.nextInt();
            System.out.print("Introduce el año: ");
            anio = teclado.nextInt();

            int diasMes = 0;

            // Determinar días del mes
            if (mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12) {
                diasMes = 31;
            } else if (mes == 4 || mes == 6 || mes == 9 || mes == 11) {
                diasMes = 30;
            } else if (mes == 2) {
                // Comprobamos si es bisiesto
                if ((anio % 4 == 0 && anio % 100 != 0) || (anio % 400 == 0)) {
                    diasMes = 29;
                } else {
                    diasMes = 28;
                }
            }

            if (mes >= 1 && mes <= 12 && dia >= 1 && dia <= diasMes) {
                fechaCorrecta = true;
                System.out.println("Fecha correcta: " + dia + "/" + mes + "/" + anio);
            } else {
                System.out.println("Fecha incorrecta. Intenta de nuevo.\n");
            }
        }

        teclado.close();

    }

}
