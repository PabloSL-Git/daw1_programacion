package map.paqueteb;

import java.util.Scanner;

public class Main {
    private static Loteria loteria = new Loteria();
    private static final Scanner tec = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Decimos: ");
        loteria.imprimirDecimos();
        System.out.println("-----------------------");
        System.out.println("Dame tu decimo, procura insertar todos los ceros");
        String decimo = tec.nextLine();
        System.out.println("Premio: " + loteria.consultarPremio(decimo));
    }
}
