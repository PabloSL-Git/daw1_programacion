package javafile.ejercicios_basicos;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Prueba3 {
    private static final Scanner tec = new Scanner(System.in);

    public static void main(String[] args) {

        Random rand = new Random();

        System.out.print("Introduce el tamaño de las listas: ");
        int tam = tec.nextInt();

        ArrayList<Integer> lista1 = new ArrayList<>();
        ArrayList<Integer> lista2 = new ArrayList<>();

        for (int i = 0; i < tam; i++) {
            lista1.add(rand.nextInt(100) + 1);
            lista2.add(rand.nextInt(100) + 1);
        }

        System.out.println("Lista 1:");
        imprimir(lista1);

        System.out.println("Lista 2:");
        imprimir(lista2);

        ArrayList<Integer> listaMultiplicada = multiplicar(lista1, lista2);

        System.out.println("Lista multiplicada:");
        imprimir(listaMultiplicada);
    }

    public static ArrayList<Integer> multiplicar(ArrayList<Integer> l1, ArrayList<Integer> l2) {
        ArrayList<Integer> resultado = new ArrayList<>();
        for (int i = 0; i < l1.size(); i++) {
            resultado.add(l1.get(i) * l2.get(i));
        }
        return resultado;
    }

    public static void imprimir(ArrayList<Integer> lista) {
        System.out.println(lista);
    }
}