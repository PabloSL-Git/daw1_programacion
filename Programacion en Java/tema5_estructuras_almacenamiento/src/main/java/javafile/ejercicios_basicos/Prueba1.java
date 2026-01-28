/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt 
to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit 
this template
 */
package javafile.ejercicios_basicos;
import java.util.ArrayList;
    
/**
 *
 * @author usuario
 */
public class Prueba1 {

    public static void main(String[] args) {
        
         // Crear lista vacía
        
        ArrayList<Integer> numeros = new ArrayList<>();

        // Añadir elementos
        numeros.add(35);
        numeros.add(47);
        numeros.add(10);
        numeros.add(20);

        // Imprimir de cuatro formas
        System.out.println("System.out.println: " + numeros);

        System.out.print("Bucle clásico: ");
        for (int i = 0; i < numeros.size(); i++) {
            System.out.print(numeros.get(i) + " ");
        }
        System.out.println();

        System.out.print("Foreach: ");
        for (int n : numeros) {
            System.out.print(n + " ");
        }
        System.out.println();

        System.out.print("Método forEach lista: ");
        numeros.forEach(n -> System.out.print(n + " "));
        System.out.println();

        // Suma pares
        int sumaPares = 0;
        int impares = 0;
        int mayor = numeros.get(0);
        int menor = numeros.get(0);

        for (int n : numeros) {
            if (n % 2 == 0) {
                sumaPares += n;
            }
            if (n % 2 != 0) {
                impares++;
            }

            if (n > mayor) {
                mayor = n;
            }
            if (n < menor) {
                menor = n;
            }
        }

        System.out.println("Suma pares: " + sumaPares);
        System.out.println("Cantidad impares: " + impares);
        System.out.println("Mayor: " + mayor);
        System.out.println("Menor: " + menor);
        System.out.println("Tamaño lista: " + numeros.size());

        // Borrar según posición
        numeros.remove(2);

        // Borrar por valor (todos)
        numeros.removeIf(x -> x == 47);

        // Modificar posición 1 con 8
        numeros.set(1, 8);

        System.out.println("Lista final: " + numeros);

        // Convertir a array int[]
        int[] arr = numeros.stream().mapToInt(Integer::intValue).toArray();

        System.out.println("Array generado:");
        for (int n : arr) {
            System.out.print(n + " ");
        }
    }
}
