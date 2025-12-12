package funciones.juegos;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class JuegoParesNones {
    public static void main(String[] args) {
        // pares nones
        // 2 jugadores
        // sepregunta j1 si quiere pare o nones
        // je es contrario
        // cada ronda saca numero al zar entre 1 y 10
        // se decide quien gana esa ronda
        // 3 rondas
        // al final indicar mejor
        // Si hace dos ganadas seguidas termina
        // recomienda usar break

        // añadir exepciones

        try (Scanner teclado = new Scanner(System.in)) {

            Random random = new Random();

            String pareONone = "";
            int rondaPareONone;
            int numeroJugador = 0;
            int numeroSuma;
            int numeroMaquina;

            for (rondaPareONone = 1; rondaPareONone <= 3; rondaPareONone++) { // repite el programa 3 veces

                boolean eleccionValida = false;

                while (!eleccionValida) { // pide al usuario si quiere pare o none
                    System.out.println("¿Quiere el usuario hacer Pares o Nones?");
                    pareONone = teclado.nextLine();

                    if (pareONone.equalsIgnoreCase("pares") || pareONone.equalsIgnoreCase("nones")) {
                        eleccionValida = true; // entrada correcta salir del bucle
                    } else {
                        System.out.println("Entrada no válida. Escriba 'pares' o 'nones'.");
                    }
                }

                System.out.println("Partida " + rondaPareONone + ", usuario quiere " + pareONone);

                numeroMaquina = random.nextInt(10) + 1; // ordenador da un numero del 1 L 10

                boolean numeroValido = false;

                while (!numeroValido) { // pide al ususario un numero del 1 al 10

                    System.out.println("Jugador, dame un número del 1 al 10:");

                    try {

                        numeroJugador = teclado.nextInt();
                        teclado.nextLine();

                        if (numeroJugador >= 1 && numeroJugador <= 10) {
                            numeroValido = true; // número correcto salir del bucle
                        } else {
                            System.out.println("Número fuera de parámetros. Inténtalo de nuevo.");
                        }

                    } catch (InputMismatchException ime) { //exepcion para evitar introducir letras
                        System.out.println("Excepción: debes ingresar un número entero." + ime);
                        teclado.nextLine();
                    }
                }

                numeroSuma = numeroMaquina + numeroJugador;

                if ((numeroMaquina + numeroJugador) % 2 == 0) { // gana par

                    String mensaje = """
                            Numero maquina %d
                            Numero usuario %d
                            Suma es %d
                            Ganador es pares
                            """.formatted(numeroMaquina, numeroJugador, numeroSuma);

                    System.out.println(mensaje);

                } else { // gana impar

                    String mensaje = """
                            Numero maquina %d
                            Numero usuario %d
                            Suma es %d
                            Ganador es nones
                            """.formatted(numeroMaquina, numeroJugador, numeroSuma);

                    System.out.println(mensaje);

                }

            }

        }

    }

}
