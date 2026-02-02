package matrices.tarea5c;

import java.util.Scanner;

public class Ej5 {
    private static final Scanner tec = new Scanner(System.in);
    public static void main(String[] args) {

        System.out.print("Introduce la localidad: ");
        String localidad = tec.nextLine();
        System.out.print("Introduce el año: ");
        int año = tec.nextInt();

        Temperaturas temperatura = new Temperaturas(localidad, año);

        int opcion;
        do {
            System.out.println("""
                    --- Menu ---
                    1. Guardar temperatura
                    2. Borrar temperatura
                    3. Mostrar todas las temperaturas
                    4. Mostrar temperaturas de un mes
                    5. Mostrar temperaturas de un día
                    0. Salir
                    """);
            System.out.print("Elige una opcion: ");
            opcion = tec.nextInt();

            switch (opcion) {
                case 1 -> {
                    System.out.print("Mes (1-12): ");
                    int mes = tec.nextInt();
                    System.out.print("Dia: ");
                    int dia = tec.nextInt();
                    System.out.print("Temperatura: ");
                    double temp = tec.nextDouble();
                    temperatura.guardarTemperatura(mes, dia, temp);
                }
                case 2 -> {
                    System.out.print("Mes (1-12): ");
                    int mes = tec.nextInt();
                    System.out.print("Dia: ");
                    int dia = tec.nextInt();
                    temperatura.borrarTemperatura(mes, dia);
                }
                case 3 -> temperatura.mostrarTemperaturas();
                case 4 -> {
                    System.out.print("Mes (1-12): ");
                    int mes = tec.nextInt();
                    temperatura.mostrarTemperaturaMes(mes);
                }
                case 5 -> {
                    System.out.print("Dia: ");
                    int dia = tec.nextInt();
                    temperatura.mostrarTemperaturaDia(dia);
                }
                case 0 -> System.out.println("Saliendo...");
                default -> System.out.println("Opcion no valida.");
            }

        } while (opcion != 0);
    }
}

