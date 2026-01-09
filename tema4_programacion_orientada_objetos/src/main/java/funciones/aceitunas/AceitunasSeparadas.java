package funciones.aceitunas;

import javax.swing.JOptionPane;

public class AceitunasSeparadas {
    public static void main(String[] args) {

        // picual, aloreña y hojiblanca
        // aceituna gruesa o aceituna fina.

        // picual + 20 centimos gruesa
        // - 30 centimos fina

        // aloreña - 15 centimos gruesa
        // - 30 centimos fina

        // hojiblanca + 15 centimos gruesa
        // - 5 centimos fina

        String tipo = "";
        String tamanio = "";
        double kilos = 0;
        double precio = 0;
        String mensajeFinal = "";

        do {

            tipo = AceitunasFunciones.mostrarMenuTipo();

            if (tipo.equalsIgnoreCase("salir")) {
                break;
            }

            tamanio = AceitunasFunciones.mostrarMenuTamanio();

            kilos = AceitunasFunciones.mostrarMenuKilos();

            precio = AceitunasFunciones.mostrarMenuPrecio(tipo, tamanio, kilos);

            mensajeFinal = """
                    Tipo de aceituna %s
                    Tamaño de aceituna %s
                    kilos de aceitunas %.2f
                    Precio final %.2f
                    """.formatted(tipo, tamanio, kilos, precio);

            JOptionPane.showMessageDialog(null, mensajeFinal);

        } while (!tipo.equalsIgnoreCase("salir"));

    }

}
