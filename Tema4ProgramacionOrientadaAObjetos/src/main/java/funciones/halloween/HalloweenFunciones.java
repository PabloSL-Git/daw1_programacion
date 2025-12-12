package funciones.halloween;


import java.util.Random;

import javax.swing.JOptionPane;

public class HalloweenFunciones {
    public static String mostrarEntar(int entradaNum) { // inicio

        String entrar = "";
        boolean valido = false;
        String entrada = "";

        if (entradaNum == 1) {
            entrada = "puerta";
        } else if (entradaNum == 2) {
            entrada = "ventana";
        }

        while (!valido) {

            String menu = """
                    UuuUUuuuUu
                    Bienbenido a la casa del terror.
                    Te atrave usted a entrar?
                    Si o no?
                    """;
            entrar = JOptionPane.showInputDialog(menu);

            if (entrar.equalsIgnoreCase("si")) {
                JOptionPane.showMessageDialog(null, "A, un valiente, entra pues por la " + entrada);
                valido = true;

            } else if (entrar.equalsIgnoreCase("no")) {
                JOptionPane.showMessageDialog(null, "¿Como que no? Vuelve aqui cobarde!");
                valido = true;
            } else {
                JOptionPane.showMessageDialog(null, "No te entiendo ¿si o no?");
            }
        }

        return entrar;
    }

    public static String mostrarPuerta() { // puerta

        String entrarPuerta = "";
        boolean valido = false;

        while (!valido) {

            String menu = """
                    UuuUUuuuUu
                    Has entrado en mi recibidor tenebroso
                    ¿Iras a la biblioteca o al salon?
                    """;
            entrarPuerta = JOptionPane.showInputDialog(menu);

            if (entrarPuerta.equalsIgnoreCase("biblioteca")) {
                JOptionPane.showMessageDialog(null, "Entra, entra en mi biblioteca sangrante");
                valido = true;

            } else if (entrarPuerta.equalsIgnoreCase("salon")) {
                JOptionPane.showMessageDialog(null, "Entra, entra en mi salon ardiente");
                valido = true;
            } else {
                JOptionPane.showMessageDialog(null, "No te entiendo ¿biblioteca o salon?");
            }
        }

        return entrarPuerta;
    }

    public static String mostrarVentana() { // ventana

        String entrarVentana = "";
        boolean valido = false;

        while (!valido) {

            String menu = """
                    UuuUUuuuUu
                    Has entrado en mi cocina pudrienta
                    ¿Iras a la despensa o al pasillo?
                    """;
            entrarVentana = JOptionPane.showInputDialog(menu);

            if (entrarVentana.equalsIgnoreCase("despensa")) {
                JOptionPane.showMessageDialog(null, "Entra, entra en mi despensa de las pesadillas");
                valido = true;

            } else if (entrarVentana.equalsIgnoreCase("pasillo")) {
                JOptionPane.showMessageDialog(null, "Entra, entra en mi pasillo sin fin");
                valido = true;
            } else {
                JOptionPane.showMessageDialog(null, "No te entiendo ¿despensa o pasillo?");
            }
        }

        return entrarVentana;
    }

    public static boolean mostrarPuertaBiblioteca() { // puerta biblioteca
        boolean escape = false;
        Random random = new Random();
        int escaparPuertaBibliotecaNum = 0;

        escaparPuertaBibliotecaNum = random.nextInt(2) + 1;
        // 1 ecapar
        // 2 juego

        switch (escaparPuertaBibliotecaNum) {
            case 1 -> { // escapa sin juego
                JOptionPane.showMessageDialog(null, "Mecachis escapo sin siquiera verme");
                escape = true;
            }

            case 2 -> { // juego

                escape = HalloweenFunciones.juegoMortal();
            }

        }

        return escape;
    }

    public static boolean mostrarPuertaSalon() { // puerta salon
        boolean escape = false;
        Random random = new Random();
        int escaparPuertaSalonNum = 0;

        escaparPuertaSalonNum = random.nextInt(2) + 1;
        // 1 ecapar
        // 2 juego

        switch (escaparPuertaSalonNum) {
            case 1 -> { // escapa sin juego
                JOptionPane.showMessageDialog(null, "Mecachis escapo sin siquiera verme");
                escape = true;
            }

            case 2 -> { // juego
                escape = HalloweenFunciones.juegoMortal();
            }

        }

        return escape;
    }

    public static boolean mostrarVentanaDespensa() { // ventana despensa
        boolean escape = false;
        Random random = new Random();
        int escaparPuertaSalonNum = 0;

        escaparPuertaSalonNum = random.nextInt(2) + 1;
        // 1 ecapar
        // 2 juego

        switch (escaparPuertaSalonNum) {
            case 1 -> { // escapa sin juego
                JOptionPane.showMessageDialog(null, "Mecachis escapo sin siquiera verme");
                escape = true;
            }

            case 2 -> { // juego
                escape = HalloweenFunciones.juegoMortal();
            }

        }

        return escape;
    }

    public static boolean mostrarVentanaPasillo() { // ventana pasillo
        boolean escape = false;
        Random random = new Random();
        int escaparPuertaSalonNum = 0;

        escaparPuertaSalonNum = random.nextInt(2) + 1;
        // 1 ecapar
        // 2 juego

        switch (escaparPuertaSalonNum) {
            case 1 -> { // escapa sin juego
                JOptionPane.showMessageDialog(null, "Mecachis escapo sin siquiera verme");
                escape = true;
            }

            case 2 -> { // juego
                escape = HalloweenFunciones.juegoMortal();
            }

        }

        return escape;
    }

    public static boolean juegoMortal() { // juego

        boolean escape = false;
        Random random = new Random();
        int juegoDeMuerte = 0;
        String numeroAdivinoTxt = "";
        int numeroAdivino = 0;
        int numDeIntentos = 0;

        juegoDeMuerte = random.nextInt(20) + 1; // numero a adivinar

        do {

            numeroAdivinoTxt = JOptionPane.showInputDialog(
                    "Preparate para el Juego de tu vida, adivina un numero de 1 al 20");
            numeroAdivino = Integer.parseInt(numeroAdivinoTxt);

            numDeIntentos++;

            if (numeroAdivino == juegoDeMuerte) {
                JOptionPane.showMessageDialog(null, "Nooooo me has vencido!!");
                escape = true;

            } else if (numDeIntentos > 3) {
                JOptionPane.showMessageDialog(null, "Jajajaja ya que has fallado continuaras sufriendo en mi bucle");
                break;
            } else {
                JOptionPane.showMessageDialog(null, "Jajajaja mal!!");
            }

        } while (!escape);

        return escape;

    }

}
