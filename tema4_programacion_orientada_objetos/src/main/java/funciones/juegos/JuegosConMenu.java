package funciones.juegos;

import javax.swing.JOptionPane;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class JuegosConMenu {
    public static void main(String[] args) {
        try (Scanner teclado = new Scanner(System.in)) {

            Random random = new Random();

            int aQueJugar;

            do {

                System.out.println("Quieres jugar a |(1) pares o nones | |(2) piedra, papel o tijera | |(3) salir |");
                aQueJugar = teclado.nextInt();
                teclado.nextLine();

                while (aQueJugar < 1 || aQueJugar > 3) {

                    System.out.println("Número fuera de parámetros. Inténtalo de nuevo.");
                    aQueJugar = teclado.nextInt();
                    teclado.nextLine();
                }
                
                switch (aQueJugar) {
                    case 1 -> { // pares o nones

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

                                } catch (InputMismatchException ime) { // exepcion para evitar introducir letras
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
                    case 2 -> { // piedra, papel o tijera

                        int eleccionMaquina = random.nextInt(3);

                        String manoMaquina = "";
                        String manoUsuario = "";
                        int manoUsuarioNumero = 0;

                        switch (eleccionMaquina) {
                            case 0 -> {
                                manoMaquina = "piedra";

                            }
                            case 1 -> {
                                manoMaquina = "papel";

                            }
                            case 2 -> {
                                manoMaquina = "tijera";

                            }
                        }

                        do { // para pedir si piedra papel o tijera

                            manoUsuario = JOptionPane.showInputDialog("Quieres hacer piedra, papel o tijera");

                            if (manoUsuario.equalsIgnoreCase("piedra")) {
                                manoUsuarioNumero = 0;
                            } else if (manoUsuario.equalsIgnoreCase("papel")) {
                                manoUsuarioNumero = 1;
                            } else if (manoUsuario.equalsIgnoreCase("tijera")) {
                                manoUsuarioNumero = 2;
                            } else {
                                JOptionPane.showMessageDialog(null, "Opción no válida");
                            }

                        } while (!(manoUsuario.equalsIgnoreCase("piedra") || manoUsuario.equalsIgnoreCase("papel")
                                || manoUsuario.equalsIgnoreCase("tijera")));

                        switch (manoUsuarioNumero) { // resultado de operacion
                            case 0 -> { // piedra maquina
                                if (eleccionMaquina == 0) { // piedra
                                    JOptionPane.showMessageDialog(null,
                                            "Maquina saca " + manoMaquina + ", empata con " + manoUsuario);

                                }
                                if (eleccionMaquina == 1) { // papel
                                    JOptionPane.showMessageDialog(null,
                                            "Maquina saca " + manoMaquina + ", gana a " + manoUsuario);

                                }
                                if (eleccionMaquina == 2) { // tijera
                                    JOptionPane.showMessageDialog(null,
                                            "Maquina saca " + manoMaquina + ", pierde contra " + manoUsuario);

                                }

                            }
                            case 1 -> { // papel maquina
                                if (eleccionMaquina == 0) { // piedra
                                    JOptionPane.showMessageDialog(null,
                                            "Maquina saca " + manoMaquina + ", gana a " + manoUsuario);

                                }
                                if (eleccionMaquina == 1) { // papel
                                    JOptionPane.showMessageDialog(null,
                                            "Maquina saca " + manoMaquina + ", empata con " + manoUsuario);

                                }
                                if (eleccionMaquina == 2) { // tijera
                                    JOptionPane.showMessageDialog(null,
                                            "Maquina saca " + manoMaquina + ", pierde contra " + manoUsuario);

                                }
                            }
                            case 2 -> { // tijera maquina
                                if (eleccionMaquina == 0) { // piedra
                                    JOptionPane.showMessageDialog(null,
                                            "Maquina saca " + manoMaquina + ", pierde contra " + manoUsuario);

                                }
                                if (eleccionMaquina == 1) { // papel
                                    JOptionPane.showMessageDialog(null,
                                            "Maquina saca " + manoMaquina + ", gana a " + manoUsuario);

                                }
                                if (eleccionMaquina == 2) { // tijera
                                    JOptionPane.showMessageDialog(null,
                                            "Maquina saca " + manoMaquina + ", gana a " + manoUsuario);

                                }

                            }
                        }

                    }
                    case 3 -> { // Salida
                        System.out.println("a salido");
                        break; // break solo te saca del switch pero vale aqui
                    }
                }

            } while (aQueJugar == 1 || aQueJugar == 2);

        }
    }

}
