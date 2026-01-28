package estructura_repeticion;

import java.util.Scanner;

public class EjercicioClase {
    public static void main(String[] args) {

        // Calcular el salario semanal de los empleados.
        // Cobran 15 euros la hora si no superan las 35 semanales.
        // Cada hora que supere las 35 se paga como extra, a 22 euros.
        // El programa debe pedir las horas al usuario y mostrar
        // El sueldo final. Una vez termina la ejecución preguntamos
        // si queremos calcular otro salario. Si el usuario escribe
        // Si, sI, SI o si el programa se ejecuta de nuevo, en otro
        // caso termina. Además, si el usuario se equivoca e introduc
        // horas negativas el programa debe pedirlas de nuevo.

        Scanner tec = new Scanner(System.in);

        final int TOPE_SALARIO = 35;
        final int SALARIO_HORA = 15;
        final int SALARIO_HORA_EXTRA = 22;

        int horas;

        // string para demostrar respuestas

        String respuesta, resultado;

        do {
            do {
                System.out.println("Introduce el número de horas trabajadas esta semana: ");
                horas = tec.nextInt();
                if (horas < 0) {
                    // pide oras otra vez
                    System.out.println("Las horas no pueden ser negativas, inténtelo de nuevo");
                }
            } while (horas < 0);

            // calculo salario

            double salario;
            if (horas <= TOPE_SALARIO) {
                salario = horas * SALARIO_HORA;
            } else {
                // calculo si es mas de 35
                int horasNormales = TOPE_SALARIO;
                int horasExtra = horas - TOPE_SALARIO;
                salario = (horasNormales * SALARIO_HORA) + (horasExtra * SALARIO_HORA_EXTRA);
            }

            // mostrar datos

            resultado = """
                    El trabajador
                    debe cobrar esta semana %s
                    """.formatted(salario);
            System.out.println(resultado);

            System.out.println("El salario semanal es " + salario + "euros");

            // pregunta si repetir programa

            System.out.println("¿Deseas calcular otro salario? (Si/No):");
            tec.nextLine();
            respuesta = tec.nextLine();

            // todos los objetos en java se comparan con equals nunca ==
            // equalsIgnoreCase ignora mayusculas y minusculas

        } while (respuesta.equalsIgnoreCase("si"));

        System.out.println("Programa terminado.");

        tec.close();

    }

}
