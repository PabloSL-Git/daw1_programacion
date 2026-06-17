package modelos;

import javax.swing.table.DefaultTableModel;

public class ModeloTablaPlato extends DefaultTableModel {

    public ModeloTablaPlato() {
        String[] columnNames = {"ID", "NOMBRE", "DESCRIPCION", "PRECIO", "TEMPORADA"};
        setColumnIdentifiers(columnNames);
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        // Solo el precio puede editarse directamente en la tabla.
        return column == 3;
    }

    @Override
    public Class<?> getColumnClass(int column) {
        if (column == 3) {
            return Double.class;
        }
        if (column == 4) {
            return Boolean.class;
        }
        return String.class;
    }
}
