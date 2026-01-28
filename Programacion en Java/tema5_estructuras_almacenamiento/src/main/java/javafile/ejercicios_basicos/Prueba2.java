package javafile.ejercicios_basicos;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Prueba2 {

    public static void main(String[] args) {

        // 1. Pedir frase
        String frase = JOptionPane.showInputDialog("Introduce una frase:");

        // 2. Mostrar frase y tamaño
        System.out.println("Frase: " + frase);
        System.out.println("Tamaño: " + frase.length());

        // 3. Primera 'a'
        int posA = frase.indexOf('a');
        System.out.println("Primera 'a' en índice: " + posA);

        // 4. Pasar a lista de Character
        ArrayList<Character> listaChars = new ArrayList<>();
        for (int i = 0; i < frase.length(); i++) {
            listaChars.add(frase.charAt(i));
        }

        // 5. Buscar posiciones de 'a'
        ArrayList<Integer> posTodas = buscarCaracter(listaChars, 'a');
        System.out.println("Ocurrencias de 'a' en posiciones: " + posTodas);

        // 6. Reconstruir String
        String reconstruido = generarString(listaChars);
        System.out.println("String generado de la lista: " + reconstruido);
    }

    public static ArrayList<Integer> buscarCaracter(ArrayList<Character> lista, char c) {
        ArrayList<Integer> posiciones = new ArrayList<>();
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i) == c) {
                posiciones.add(i);
            }
        }
        return posiciones;
    }

    public static String generarString(ArrayList<Character> lista) {
        String resultado = "";
        for (Character c : lista) {
            resultado += c;
        }
        return resultado;
    }
}

