package funciones.juegos;


import java.util.Random;
import java.util.Scanner;

public class JuegoMenuSeparado {
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

                        JuegosFunciones.juego1(teclado, random);

                    }
                    case 2 -> { // piedra, papel o tijera

                        JuegosFunciones.juego2(teclado, random);

                    }
                    case 3 -> { // salir
                        System.out.println("a salido");
                        break; // break solo te saca del switch pero vale aqui
                    }
                }

            } while (aQueJugar == 1 || aQueJugar == 2);

        }
    }

}
