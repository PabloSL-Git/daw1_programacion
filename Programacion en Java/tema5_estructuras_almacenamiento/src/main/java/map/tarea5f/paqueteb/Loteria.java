package map.tarea5f.paqueteb;

import java.util.Random;
import java.util.TreeMap;

public class Loteria {

    private TreeMap<String, Integer> decimos;

    public Loteria() {
        decimos = new TreeMap<>();
        generarDecimos();
    }

    private void generarDecimos() {
        Random random = new Random();

        while (decimos.size() < 1000) {
            int numero = random.nextInt(100000); // decimos
            String decimo = String.format("%05d", numero); // ceros delante
            int premio = random.nextInt(100000); // premio inventado

            decimos.put(decimo, premio);
        }
    }

    // Que premio
    public Integer consultarPremio(String decimo) {
        return decimos.get(decimo);
    }

    // Imprimir lista completa
    public void imprimirDecimos() {
        for (String decimo : decimos.keySet()) {
            System.out.println("Decimo: " + decimo + " Premio: " + decimos.get(decimo));
        }
    }

}
