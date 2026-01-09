package funciones.halloween;

import javax.swing.JOptionPane;

import java.util.Random;

public class HalloweenMain {
    public static void main(String[] args) {

        String entrar = "";
        Random random = new Random();
        int entradaNum = 0;
        String entrarPuerta = "";
        boolean escape = false;
        String entrarVentana = "";

        do {

            entradaNum = random.nextInt(2) + 1;
            // 1 puerta
            // 2 ventana

            entrar = HalloweenFunciones.mostrarEntar(entradaNum);

            if (entrar.equalsIgnoreCase("no")) {
                break;
            }

            switch (entradaNum) {
                case 1 -> { // puerta

                    entrarPuerta = HalloweenFunciones.mostrarPuerta();

                    if (entrarPuerta.equalsIgnoreCase("biblioteca")) {
                        escape = HalloweenFunciones.mostrarPuertaBiblioteca();
                    } else {
                        escape = HalloweenFunciones.mostrarPuertaSalon();
                    }
                }

                case 2 -> { // ventana

                    entrarVentana = HalloweenFunciones.mostrarVentana();

                    if (entrarVentana.equalsIgnoreCase("despensa")) {
                        escape = HalloweenFunciones.mostrarVentanaDespensa();
                    } else {
                        escape = HalloweenFunciones.mostrarVentanaPasillo();
                    }

                }
            }

            if (escape == false) {
                JOptionPane.showMessageDialog(null, "Jajajaja ya que has fallado continuaras sufriendo en mi bucle");
            }

        } while (escape == false);

    }
}