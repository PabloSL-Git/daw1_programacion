package funciones.aceitunas;

import javax.swing.JOptionPane;

public class AceitunasFunciones {
    public static String mostrarMenuTipo() {

        String tipo = "";
        boolean valido1 = false;

        while (!valido1) { // Repite hasta que el usuario escriba algo correcto
            String menu = """
                    Dame qué tamaño quieres:
                    - Picual
                    - Aloreña
                    - Hojiblanca
                    - Salir
                    """;

            tipo = JOptionPane.showInputDialog(null, menu);

            if (tipo.equalsIgnoreCase("Picual")) {
                JOptionPane.showMessageDialog(null, "Has elegido tipo Picual");
                valido1 = true;

            } else if (tipo.equalsIgnoreCase("Aloreña")) {
                JOptionPane.showMessageDialog(null, "Has elegido tipo Aloreña");
                valido1 = true;

            } else if (tipo.equalsIgnoreCase("Hojiblanca")) {
                JOptionPane.showMessageDialog(null, "Has elegido tipo Hojiblanca");
                valido1 = true;

            } else if (tipo.equalsIgnoreCase("Salir")) {
                JOptionPane.showMessageDialog(null, "Saliendo del programa");
                valido1 = true;

            } else {
                JOptionPane.showMessageDialog(null, "Opción no válida, intenta de nuevo");
            }
        }

        return tipo;
    }

    public static String mostrarMenuTamanio() {

        String tamanio = "";
        boolean valido2 = false;

        while (!valido2) { // Repite hasta que el usuario escriba algo correcto
            String menu = """
                    Dame qué tamaño quieres:
                    - Fina
                    - Gruesa
                    """;

            tamanio = JOptionPane.showInputDialog(null, menu);

            if (tamanio.equalsIgnoreCase("fina")) {
                JOptionPane.showMessageDialog(null, "Has elegido tamaño fina");
                valido2 = true;

            } else if (tamanio.equalsIgnoreCase("gruesa")) {
                JOptionPane.showMessageDialog(null, "Has elegido tamaño gruesa");
                valido2 = true;

            } else {
                JOptionPane.showMessageDialog(null, "Opción no válida, intenta de nuevo");
            }
        }

        return tamanio;
    }

    public static Double mostrarMenuKilos() {

        double kilos = 0;
        boolean valido3 = false;
        String kilosTxt = "";

        while (!valido3) { // Repite hasta que el usuario escriba algo correcto
            String menu = """
                    Cuantos kilos quieres?
                    """;

            kilosTxt = JOptionPane.showInputDialog(null, menu);
            kilos = Double.parseDouble(kilosTxt);

            if (kilos == 0) {
                JOptionPane.showMessageDialog(null, "Necesita mas de 0 kilos");

            } else if (kilos < 0) {
                JOptionPane.showMessageDialog(null, "No puede ser negativo");

            } else {
                JOptionPane.showMessageDialog(null, "Has elegido " + kilos + " kilos");
                valido3 = true;
            }
        }

        return kilos;
    }

    public static Double mostrarMenuPrecio(String tipo, String tamaño, double kilos) {

        double precio = 0;

        final double PRECIO_ACEITUNA_INICIAL = 1.23;

        final double PRECIO_PICUAL_GRUESA = 0.20;
        final double PRECIO_PICUAL_FINA = 0.30;

        final double PRECIO_ALOREÑA_GRUESA = 0.15;
        final double PRECIO_ALOREÑA_FINA = 0.30;

        final double PRECIO_HOJIBLANCA_GRUESA = 0.15;
        final double PRECIO_HOJIBLANCA_FINA = 0.05;

        if (tipo.equalsIgnoreCase("picual") && tamaño.equalsIgnoreCase("gruesa")) {
            precio = (PRECIO_ACEITUNA_INICIAL + PRECIO_PICUAL_GRUESA) * kilos;
        }
        if (tipo.equalsIgnoreCase("picual") && tamaño.equalsIgnoreCase("fina")) {
            precio = (PRECIO_ACEITUNA_INICIAL - PRECIO_PICUAL_FINA) * kilos;
        }
        if (tipo.equalsIgnoreCase("aloreña") && tamaño.equalsIgnoreCase("gruesa")) {
            precio = (PRECIO_ACEITUNA_INICIAL - PRECIO_ALOREÑA_GRUESA) * kilos;
        }
        if (tipo.equalsIgnoreCase("aloreña") && tamaño.equalsIgnoreCase("fina")) {
            precio = (PRECIO_ACEITUNA_INICIAL - PRECIO_ALOREÑA_FINA) * kilos;
        }
        if (tipo.equalsIgnoreCase("hojiblanca") && tamaño.equalsIgnoreCase("gruesa")) {
            precio = (PRECIO_ACEITUNA_INICIAL + PRECIO_HOJIBLANCA_GRUESA) * kilos;
        }
        if (tipo.equalsIgnoreCase("hojiblanca") && tamaño.equalsIgnoreCase("fina")) {
            precio = (PRECIO_ACEITUNA_INICIAL - PRECIO_HOJIBLANCA_FINA) * kilos;
        }

        return precio;

    }

}
