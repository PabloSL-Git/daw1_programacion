package tema2y3;

import javax.swing.JOptionPane;

public class EjercicioPedro {
    public static void main(String[] args) {
        // Pedro Rafael Ortega Núñez

        // variables y constantes
        final double PRECIO_INICIAL = 1.23, PICUAL_GORDA = 0.20, PICUAL_FINA = 0.30, ALORENA_GRUESA = 0.15,
                ALORENA_FINA = 0.3, HOJIBLANCA_GORDA = 0.15, HOJIBLANCA_FINA = 0.5, RONDAS = 10;
        final String TIPO_PICUAL = "picual", TIPO_ALORENA = "aloreña", TIPO_HOJIBLANCA = "hojiblanca",
                TAMAÑO_GRUESA = "gruesa", TAMAÑO_FINA = "fina", SALIR = "salir";
        int kilos = 0;
        double precioTotal = 0, precioTamaño = 0, calculoFinal = 0;
        String respuestaTipoOliva = "", respuestaTamanioOliva = "", respuestaFinal = "";
        // PRECIO+ TIPO + TAMAÑO

        JOptionPane.showMessageDialog(null, "Bienvenido a La asociación de olivareros de Málaga");
        // Salufo
        for (int i = 0; i < RONDAS; i++) {

            do {
                respuestaTipoOliva = JOptionPane.showInputDialog("Que tipo de oliva tienes?").toLowerCase().trim();
                // quito espacion y paso a minuscula para evitar fallos

                if (respuestaTipoOliva.equals(TIPO_PICUAL) || respuestaTipoOliva.equals(TIPO_ALORENA)
                        || respuestaTipoOliva.equals(TIPO_HOJIBLANCA)) {
                    JOptionPane.showMessageDialog(null, "Perfecto");

                } else if (respuestaTipoOliva.equals(SALIR)) {
                    // salida si escribo salir
                    JOptionPane.showMessageDialog(null, "Que tenga un buen día!!");
                    // termino programa
                } else {
                    // mensaje de error
                    JOptionPane.showMessageDialog(null, "Te habras equivocado, no tenemos ese tipo de oliva");

                }

            } while (!(respuestaTipoOliva.equals(TIPO_PICUAL) || respuestaTipoOliva.equals(TIPO_ALORENA)
                    || respuestaTipoOliva.equals(TIPO_HOJIBLANCA) || respuestaTipoOliva.equals(SALIR)));

            if (respuestaTipoOliva.equals(SALIR)) {
                // salgo pongo i a 10 por lo que acaba el for
                i = 10;

            } else {
                // si no sigo con las preguntas

                do {
                    // pregunto por los kilos
                    kilos = Integer.parseInt(JOptionPane.showInputDialog("¿Cuantos kg llevas?"));
                    // tengo kilos y lo paso a int
                    if (kilos < 0) {
                        // mensaje de error kilos negativos
                        JOptionPane.showMessageDialog(null, "Te habras equivocado, no puedes tener kilos negativos");
                    }

                } while (kilos < 0);

                do {
                    // clasifico el tamaño de las ilivas

                    respuestaTamanioOliva = JOptionPane.showInputDialog("Que tamaño de oliva tienes?").toLowerCase()
                            .trim();

                    if (respuestaTamanioOliva.equals(TAMAÑO_GRUESA) || respuestaTamanioOliva.equals(TAMAÑO_FINA)) {
                        JOptionPane.showMessageDialog(null, "Perfecto");

                    } else {
                        // mensaje de error tamaño
                        JOptionPane.showMessageDialog(null, "Te habras equivocado, no tenemos ese tamaño de oliva");

                    }

                } while (!(respuestaTamanioOliva.equals(TAMAÑO_GRUESA) || respuestaTamanioOliva.equals(TAMAÑO_FINA)));

                switch (respuestaTipoOliva) {
                    // depende del tipo va a un case
                    // rellenamos datos del precio segun lo que pide el ejercicio
                    case TIPO_PICUAL:
                        if (respuestaTamanioOliva.equals(TAMAÑO_GRUESA)) {
                            precioTotal = PRECIO_INICIAL + PICUAL_GORDA;
                        } else {
                            precioTotal = PRECIO_INICIAL + PICUAL_FINA;
                        }
                        break;
                    case TIPO_ALORENA:
                        if (respuestaTamanioOliva.equals(TAMAÑO_GRUESA)) {
                            precioTotal = PRECIO_INICIAL - ALORENA_GRUESA;
                        } else {
                            precioTotal = PRECIO_INICIAL - ALORENA_FINA;
                        }
                        break;
                    case TIPO_HOJIBLANCA:
                        if (respuestaTamanioOliva.equals(TAMAÑO_GRUESA)) {
                            precioTotal = PRECIO_INICIAL + HOJIBLANCA_GORDA;
                        } else {
                            precioTotal = PRECIO_INICIAL - HOJIBLANCA_FINA;
                        }
                        break;

                    default:
                        // mensaje de error
                        JOptionPane.showMessageDialog(null, "hay un problema en la seleccion del producto");

                        break;

                }

                calculoFinal = precioTotal * kilos; // precio total por kilos
                // guardamos en varias variables para usarlo luego
                precioTamaño = precioTotal - PRECIO_INICIAL;

                respuestaFinal = """
                        FACTURA:

                        Llevas %d kilos,
                        Tipo de oliva %s,
                        Tamaño de oliva %s,
                        Precio inicial %.3f
                        Precio por tamaño %.3f
                        Precio total %.3f
                        Por lo que se te paga %.3f
                        """.formatted(kilos, respuestaTipoOliva, respuestaTamanioOliva, PRECIO_INICIAL, precioTamaño,
                        precioTotal,
                        calculoFinal);
                // relleno

                JOptionPane.showMessageDialog(null, respuestaFinal);
                // envio

            }

        }

    }

}
