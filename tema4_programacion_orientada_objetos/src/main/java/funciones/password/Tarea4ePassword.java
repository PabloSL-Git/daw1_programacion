package funciones.password;

import java.util.Random;
import java.util.Scanner;
import org.apache.commons.lang3.RandomStringUtils;

public class Tarea4ePassword {
    private static final Scanner tec = new Scanner(System.in);
    private static final RandomStringUtils generador = RandomStringUtils.secure();

    public static void main(String[] args) {
        
        String eleccion = "";

        do {

            System.out.println("Contraseña de telefono es: " + contraTelefono());

            System.out.println("Contraseña de usuario es: " + contraUsuario());

            System.out.println("La tercera opcion dara: " + new String(reandomArray()));

            System.out.println("Si desea terminar escriba terminar");
            eleccion = tec.nextLine();

           

        } while (!(eleccion.equalsIgnoreCase("terminar")));
    }

    public static int contraTelefono() {

        // int contraTelefono = 0;
        
        // contraTelefono = random.nextInt(1111, 10000);

        return Integer.parseInt(generador.nextNumeric(4)); // random de numeros
    }

    public static String contraUsuario() {
        return generador.nextAlphanumeric(8); // numeros random con letas y nmeros
    }

    public static char[] reandomArray() { // random a array
        Random random = new Random();
        char[] caracteres = {'A','B','C','D','E','F','G','H','I','J'};
        int n = 0;
        

        System.out.println("Escribe como de largo quieres el array");
        n = tec.nextInt();
        tec.nextLine();

        char[] numero3 = new char[n];

        for (int i = 0; i < n; i++) {
            numero3[i] = caracteres[random.nextInt(caracteres.length)];
        }

        return numero3;
    }
}