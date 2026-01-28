package entrega3;

import javax.swing.JOptionPane;

public class ParteB {
    public static void main(String[] args) {

        // pide el numero de ventas y a cuanto cada dia
        // lunes

        String precioLunesTxt = JOptionPane.showInputDialog("Introduce precio de reparacion del lunes ");
        double precioLunes = Double.parseDouble(precioLunesTxt);
        String reparacionesLunesTxt = JOptionPane.showInputDialog("Introduce numero de reparaciones del Lunes");
        int reparacionesLunes = Integer.parseInt(reparacionesLunesTxt);

        // martes

        String precioMartesTxt = JOptionPane.showInputDialog("Introduce precio de reparacion del Martes");
        double precioMartes = Double.parseDouble(precioMartesTxt);
        String reparacionesMartesTxt = JOptionPane.showInputDialog("Introduce numero de reparaciones del Martes");
        int reparacionesMartes = Integer.parseInt(reparacionesMartesTxt);

        // miercoles

        String precioMiercolesTxt = JOptionPane.showInputDialog("Introduce precio de reparacion del Miercoles");
        double cobraMi = Double.parseDouble(precioMiercolesTxt);
        String reparaMiBad = JOptionPane.showInputDialog("Introduce numero de reparaciones del Miercoles");
        int reparaMi = Integer.parseInt(reparaMiBad);

        // Jueves

        String preciojuevesTxt = JOptionPane.showInputDialog("Introduce precio de reparacion del Jueves");
        double cobraJ = Double.parseDouble(preciojuevesTxt);
        String reparaJBad = JOptionPane.showInputDialog("Introduce numero de reparaciones del Jueves");
        int reparaJ = Integer.parseInt(reparaJBad);

        // viernes

        String precioViernesTxt = JOptionPane.showInputDialog("Introduce precio de reparacion del Viernes");
        double cobraV = Double.parseDouble(precioViernesTxt);
        String reparaVBad = JOptionPane.showInputDialog("Introduce numero de reparaciones del Viernes");
        int reparaV = Integer.parseInt(reparaVBad);

        // multiplica de cada dia el precio por la cantidad para obtener el beneficio de
        // cada dia

        float beneficioLunes = (float) precioLunes * reparacionesLunes;

        float beneficioMartes = (float) precioMartes * reparacionesMartes;

        float beneficioMiercoles = (float) cobraMi * reparaMi;

        float beneficioJueves = (float) cobraJ * reparaJ;

        float beneficioViernes = (float) cobraV * reparaV;

        // se suman los beneficios para llegar al del final de la semana

        float beneficioFinal = beneficioLunes + beneficioMartes + beneficioMiercoles + beneficioJueves
                + beneficioViernes;

        // JO para dar los resultados en un texto

        String resumen = """
                Beneficio el Lunes fue = %.1f €
                Beneficio el Martes fue = %.1f €
                Beneficio el Miercoles fue = %.1f €
                Beneficio el Jueves fue = %.1f €
                Beneficio el Vierbes fue = %.1f €
                Beneficio al final de la semana fue = %.1f €
                """.formatted(beneficioLunes, beneficioMartes, beneficioMiercoles,
                beneficioJueves, beneficioViernes, beneficioFinal);

        JOptionPane.showMessageDialog(null, resumen);

        // un if para ver si es mas o menos

        if (beneficioFinal > 1000) {
            // entra aqui si es positiva
            System.out.printf("Es mas de 1000 €");
        } else if (beneficioFinal < 100) {
            // entra aqui si es falsa
            System.out.printf("Es menos de 100 €");
        }

    }
}
