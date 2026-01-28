package teoria;

import javax.swing.JOptionPane;

public class InstitutoJOPtion {

    public static void main(String[] args) {

        final double NUMERO_HORAS_PROFESOR = 18;
        final int NUMERO_HORAS_GRUPOS = 30;

        // Solicitar número de grupos
        String numeroGrupos = JOptionPane.showInputDialog("Introduce el número de grupos");

        // Pasar el string a número
        int numeroGruposNumero = Integer.parseInt(numeroGrupos);
        int numeroTotalHoras = numeroGruposNumero * NUMERO_HORAS_GRUPOS;
        Double numeroProfesores = Math.ceil(numeroTotalHoras / NUMERO_HORAS_PROFESOR);
        System.out.println("Número de grupos necearios " + numeroGrupos);
        JOptionPane.showMessageDialog(null, "El número de profes necesario es " + numeroProfesores);

        // TEXT BLOCK
        String texto = "esto es un texto";
        String bloquetexto = """
                Esto es un texto
                    multilínea, que permite
                mostrar saltos de línea tabulaciones, etc
                y también valores de varialbes
                """;

        String resultadosAlgoritmo = """
                En el IES Mar de Alborán,
                para dar clase a %s grupos se necesitan
                %s profesores.
                """.formatted(numeroGrupos, numeroProfesores);
                
        System.out.println(resultadosAlgoritmo);

        JOptionPane.showMessageDialog(null, resultadosAlgoritmo);

        System.out.println(texto);
        System.out.println(bloquetexto);

    }

}
