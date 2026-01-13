package javafile.ejercicios_basicos;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Prueba4 {
    private static final Scanner tec = new Scanner(System.in);

    public static void main(String[] args) {

        ArrayList<String> pines = new ArrayList<>();

        // Generar 50 pines sin repetir
        while (pines.size() < 50) {
            String pin = generarPin();
            if (!pines.contains(pin)) {
                pines.add(pin);
            }
        }

        // Mostrar lista
        System.out.println("Lista de PINs generados:");
        System.out.println(pines);

        // Pedir pin al usuario
        System.out.print("Introduce un PIN para buscar: ");
        String pinUsuario = tec.nextLine();

        // Buscar
        int posicion = buscarPin(pines, pinUsuario);

        // Resultado
        if (posicion == -1) {
            System.out.println("El PIN NO está en la lista.");
        } else {
            System.out.println("El PIN está en la posición: " + (posicion+1));
        }
    }

    public static String generarPin() {
        Random rand = new Random();
        String pin = "";
        for (int i = 0; i < 4; i++) {
            pin += rand.nextInt(10); // número de 0 a 9
        }
        return pin;
    }

    public static int buscarPin(ArrayList<String> lista, String pin) {
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).equals(pin)) {
                return i;
            }
        }
        return -1;
    }

}
