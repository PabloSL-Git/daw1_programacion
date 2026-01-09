package funciones.juegos;

import javax.swing.JOptionPane;
import java.util.Random;

public class JuegoPiedraPapelTijera {
    public static void main(String[] args) {
        
        Random random = new Random();

        // piedra paepl tijera con la maquina
        // usar JOption
        // una ronda
        // usar exepciones

        // para que me de un numero entre 0 y 3

        int eleccionMaquina = random.nextInt(3);

        String manoMaquina = "";
        String manoUsuario = "";
        int manoUsuarioNumero = 0;

        switch (eleccionMaquina) {
            case 0 -> {
                manoMaquina = "piedra";

            }
            case 1 -> {
                manoMaquina = "papel";

            }
            case 2 -> {
                manoMaquina = "tijera";

            }
        }

        do { // para pedir si piedra papel o tijera

            manoUsuario = JOptionPane.showInputDialog("Quieres hacer piedra, papel o tijera");

            if (manoUsuario.equalsIgnoreCase("piedra")) {
                manoUsuarioNumero = 0;
            } else if (manoUsuario.equalsIgnoreCase("papel")) {
                manoUsuarioNumero = 1;
            } else if (manoUsuario.equalsIgnoreCase("tijera")) {
                manoUsuarioNumero = 2;
            } else {
                JOptionPane.showMessageDialog(null, "Opción no válida");
            }
        } while (!(manoUsuario.equalsIgnoreCase("piedra") || manoUsuario.equalsIgnoreCase("papel")
                || manoUsuario.equalsIgnoreCase("tijera")));

        switch (manoUsuarioNumero) { // resultado de operacion
            case 0 -> { // piedra maquina
                if (eleccionMaquina == 0) { // piedra
                    JOptionPane.showMessageDialog(null, "Maquina saca " + manoMaquina + ", empata con " + manoUsuario);

                }
                if (eleccionMaquina == 1) { // papel
                    JOptionPane.showMessageDialog(null, "Maquina saca " + manoMaquina + ", gana a " + manoUsuario);

                }
                if (eleccionMaquina == 2) { // tijera
                    JOptionPane.showMessageDialog(null,
                            "Maquina saca " + manoMaquina + ", pierde contra " + manoUsuario);

                }

            }
            case 1 -> { // papel maquina
                if (eleccionMaquina == 0) { // piedra
                    JOptionPane.showMessageDialog(null, "Maquina saca " + manoMaquina + ", gana a " + manoUsuario);

                }
                if (eleccionMaquina == 1) { // papel
                    JOptionPane.showMessageDialog(null, "Maquina saca " + manoMaquina + ", empata con " + manoUsuario);

                }
                if (eleccionMaquina == 2) { // tijera
                    JOptionPane.showMessageDialog(null,
                            "Maquina saca " + manoMaquina + ", pierde contra " + manoUsuario);

                }
            }
            case 2 -> { // tijera maquina
                if (eleccionMaquina == 0) { // piedra
                    JOptionPane.showMessageDialog(null,
                            "Maquina saca " + manoMaquina + ", pierde contra " + manoUsuario);

                }
                if (eleccionMaquina == 1) { // papel
                    JOptionPane.showMessageDialog(null, "Maquina saca " + manoMaquina + ", gana a " + manoUsuario);

                }
                if (eleccionMaquina == 2) { // tijera
                    JOptionPane.showMessageDialog(null, "Maquina saca " + manoMaquina + ", gana a " + manoUsuario);

                }

            }
        }

    }
}
