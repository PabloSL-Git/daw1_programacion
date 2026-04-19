package vistas;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import modelos.ListaPlatos;
import modelos.ModeloTablaPlato;
import modelos.Plato;

public class Principal extends javax.swing.JFrame {

    private ListaPlatos listaPlatos;

    public Principal() {
        listaPlatos = new ListaPlatos();
        initComponents();
        cargarDatosJTable();
    }

    private void cargarDatosJTable() {

        ModeloTablaPlato modelo = new ModeloTablaPlato();
        int numColumnas = modelo.getColumnCount();

        for (Plato plato : listaPlatos.getPlatosConPrecioMayorQue(10.0)) {
            Object[] fila = new Object[numColumnas];
            fila[0] = plato.getIdPlato();
            fila[1] = plato.getNombre();
            fila[2] = plato.getDescripcion();
            fila[3] = plato.getPrecio();
            fila[4] = plato.isEsTemporada();
            modelo.addRow(fila);
        }

        jTable1.setModel(modelo);
    }

    public ListaPlatos getListaPlatos() {
        return listaPlatos;
    }

    public JTable getJTable() {
        return jTable1;
    }

    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        BotonEditar = new javax.swing.JButton();
        BotonActualizar = new javax.swing.JButton();
        BotonSalir = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Platos");

        jScrollPane1.setViewportView(jTable1);

        BotonEditar.setText("Editar");
        BotonEditar.addActionListener(evt -> BotonEditarActionPerformed(evt));

        BotonActualizar.setText("Actualizar");
        BotonActualizar.addActionListener(evt -> BotonActualizarActionPerformed(evt));

        BotonSalir.setText("Salir");
        BotonSalir.addActionListener(evt -> BotonSalirActionPerformed(evt));

        jLabel1.setText("Platos con precio mayor de 10€");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);

        layout.setHorizontalGroup(
                layout.createSequentialGroup()
                        .addGap(23)
                        .addGroup(layout.createParallelGroup()
                                .addComponent(jLabel1)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 450,
                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18)
                        .addGroup(layout.createParallelGroup()
                                .addComponent(BotonEditar)
                                .addComponent(BotonActualizar)
                                .addComponent(BotonSalir))
                        .addContainerGap(30, Short.MAX_VALUE));

        layout.setVerticalGroup(
                layout.createSequentialGroup()
                        .addGap(20)
                        .addComponent(jLabel1)
                        .addGap(20)
                        .addGroup(layout.createParallelGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 220,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                        .addComponent(BotonEditar)
                                        .addGap(10)
                                        .addComponent(BotonActualizar)
                                        .addGap(10)
                                        .addComponent(BotonSalir)))
                        .addContainerGap(20, Short.MAX_VALUE));

        pack();
        setLocationRelativeTo(null);
    }

    private void BotonEditarActionPerformed(java.awt.event.ActionEvent evt) {

        if (jTable1.getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(this, "No has seleccionado ningún registro");
        } else {
            new Editar(this, true).setVisible(true);
            cargarDatosJTable();
        }
    }

    private void BotonActualizarActionPerformed(java.awt.event.ActionEvent evt) {

        int fila = jTable1.getSelectedRow();

        if (fila < 0) {
            JOptionPane.showMessageDialog(this, "No has seleccionado ningún registro");
            return;
        }

        String idPlato = jTable1.getValueAt(fila, 0).toString();

        double precioNuevo;
        try {
            precioNuevo = Double.parseDouble(jTable1.getValueAt(fila, 3).toString());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Precio no válido");
            return;
        }

        Plato plato = listaPlatos.getPlato(idPlato);

        if (plato == null) {
            JOptionPane.showMessageDialog(this, "Plato no encontrado");
            return;
        }

        plato.setPrecio(precioNuevo);

        if (precioNuevo <= 10) {
            JOptionPane.showMessageDialog(this, "El plato desaparecerá de la tabla (precio ≤ 10€)");
        }

        listaPlatos.guardarEnCsv();

        cargarDatosJTable();

        JOptionPane.showMessageDialog(this, "Precio actualizado correctamente");
    }

    private void BotonSalirActionPerformed(java.awt.event.ActionEvent evt) {
        System.exit(0);
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new Principal().setVisible(true));
    }

    // Variables
    private javax.swing.JButton BotonActualizar;
    private javax.swing.JButton BotonEditar;
    private javax.swing.JButton BotonSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
}