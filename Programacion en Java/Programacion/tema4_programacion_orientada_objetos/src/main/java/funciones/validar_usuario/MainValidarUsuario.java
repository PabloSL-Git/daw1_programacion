package funciones.validar_usuario;

import javax.swing.JOptionPane;

public class MainValidarUsuario {
    public static void main(String[] args) {

        boolean valido = false;

        String usuario = JOptionPane.showInputDialog("Dame el nombre de ususario");

        valido = NumeroCaracteres(usuario);

        valido = ComenzarLetra(usuario);

        valido = LetraNumeroGuion(usuario);

        valido = TerminarGuion(usuario);

        valido = NoGuionesSeguidos(usuario);

        if (valido){
            JOptionPane.showMessageDialog(null, "Usuario es valido");
        }
        
    }

    public static boolean NumeroCaracteres(String usuario) {
        boolean valido = false;

        while (!valido) {

            if (usuario.length() < 4 || usuario.length() > 15) {

                JOptionPane.showMessageDialog(null, "Usuario deve tener entre 4 y 15 caracteres");

                usuario = JOptionPane.showInputDialog("Dame el nombre de ususario");

            } else {
                valido = true;
            }
        }

        return valido;
    }

    public static boolean ComenzarLetra(String usuario) {
        boolean valido = false;

        while (!valido) {

            char caracter = usuario.charAt(0);

            if (caracter < 65 || caracter > 122) {

                JOptionPane.showMessageDialog(null, "Usuario deve empezar con letra");

                usuario = JOptionPane.showInputDialog("Dame el nombre de ususario");

            } else {
                valido = true;
            }
        }

        return valido;
    }

    public static boolean LetraNumeroGuion(String usuario) {
        boolean valido = false;

        while (!valido) {

            char[] arrayDeChars = usuario.toCharArray();

            while (!valido) {

                for (int i = 0; i < arrayDeChars.length; i++) {

                    if (!(arrayDeChars[i] > 65 && arrayDeChars[i] < 122) && !(arrayDeChars[i] == 5f)
                            && !(arrayDeChars[i] > 30 && arrayDeChars[i] < 39)) {

                        JOptionPane.showMessageDialog(null, "Usuario solo puede tener letras, numeros y guiones bajos");

                        usuario = JOptionPane.showInputDialog("Dame el nombre de ususario");

                    } else {

                    }
                }
            }
        }

        valido = true;

        return valido;
    }

    public static boolean TerminarGuion(String usuario) {
        boolean valido = false;

        while (!valido) {

            int largousuario = usuario.length();
            char caracter = usuario.charAt(largousuario - 1);

            if (caracter == '_') {

                JOptionPane.showMessageDialog(null, "Usuario no puede terminar en guion bajo");

                usuario = JOptionPane.showInputDialog("Dame el nombre de usuario");

            } else {
                valido = true;
            }
        }

        return valido;
    }

    public static boolean NoGuionesSeguidos(String usuario) {
        boolean valido = false;

        while (!valido) {

            boolean dosGuiones = usuario.contains("__");

            if (dosGuiones) {

                JOptionPane.showMessageDialog(null, "Usuario no puede tener dos guiones seguidos");

                usuario = JOptionPane.showInputDialog("Dame el nombre de ususario");

            } else {
                valido = true;
            }
        }

        return valido;
    }
}