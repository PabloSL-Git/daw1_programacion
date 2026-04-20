package tienda;

import javax.swing.*;
import java.awt.*;

/**
 * Ventana principal de la aplicación TechStore.
 *
 * Contiene: - Panel izquierdo: formulario de entrada de datos del producto. -
 * Panel derecho: área de log con el registro de operaciones.
 *
 * Componentes Swing utilizados: JFrame, JDialog, JLabel, JButton, JRadioButton,
 * JTextField, JTextArea
 */
public class TiendaAppCorregido extends JFrame {

    private java.util.ArrayList<Producto> listaProductos = new java.util.ArrayList<>(); // lista productos

    // ── Componentes del formulario ───────────────────────────────────────────
    private JTextField txtNombre;
    private JTextField txtPrecio;

    private JRadioButton rbElectronica;
    private JRadioButton rbInformatica;
    private JRadioButton rbAudioVideo;
    private ButtonGroup grupoCategorias;

    private JTextArea txtDescripcion;

    // ── Área de log ──────────────────────────────────────────────────────────
    private JTextArea txtLog;

    // ── Constructor ──────────────────────────────────────────────────────────
    public TiendaAppCorregido() {
        super("TechStore — Gestión de Productos");

        configurarVentana();
        construirUI();
    }

    // ── Configuración básica del JFrame ──────────────────────────────────────
    private void configurarVentana() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(750, 560));
        setBounds(150, 150, 750, 560);                  //añadido localizacion
        setResizable(false);
    }

    //
    private void construirUI() {
        // Panel raíz: divide la ventana en izquierda (formulario) y derecha (log)
        JPanel panelRaiz = new JPanel(new GridLayout(1, 2, 10, 0));
        panelRaiz.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        panelRaiz.add(crearPanelFormulario());
        panelRaiz.add(crearPanelLog());

        setContentPane(panelRaiz);
        pack();
    }

    private JPanel crearPanelFormulario() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createTitledBorder("Datos del producto"));

        // ── Nombre ──────────────────────────────────────────────────────────
        panel.add(crearFila(new JLabel("Nombre del producto:"),
                txtNombre = new JTextField(20)));

        panel.add(Box.createVerticalStrut(6));

        // ── Precio ──────────────────────────────────────────────────────────
        panel.add(crearFila(new JLabel("Precio (€):"),
                txtPrecio = new JTextField(10)));

        panel.add(Box.createVerticalStrut(6));

        // ── Categoría (JRadioButton) ─────────────────────────────────────────
        panel.add(crearPanelCategorias());

        panel.add(Box.createVerticalStrut(6));

        // ── Descripción (JTextArea) ──────────────────────────────────────────
        panel.add(crearPanelDescripcion());

        panel.add(Box.createVerticalStrut(10));

        // ── Botones de acción ────────────────────────────────────────────────
        panel.add(crearPanelBotones());

        // Espacio flexible al final para no estirar los componentes
        panel.add(Box.createVerticalGlue());

        return panel;
    }

    private JPanel crearFila(JLabel etiqueta, JTextField campo) {
        JPanel fila = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 0));
        etiqueta.setPreferredSize(new Dimension(150, 25));
        fila.add(etiqueta);
        fila.add(campo);
        return fila;
    }

    private JPanel crearPanelCategorias() { // cambiado audio y video
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 0));
        panel.add(new JLabel("Categoría:"));

        rbElectronica = new JRadioButton("Electrónica");
        rbInformatica = new JRadioButton("Informática");
        rbAudioVideo = new JRadioButton("Audio y Video");

        grupoCategorias = new ButtonGroup();
        grupoCategorias.add(rbElectronica);
        grupoCategorias.add(rbInformatica);
        grupoCategorias.add(rbAudioVideo);

        panel.add(rbElectronica);
        panel.add(rbInformatica);
        panel.add(rbAudioVideo);

        rbAudioVideo.setSelected(true); // por defecto

        return panel;
    }

    private JPanel crearPanelDescripcion() {
        JPanel panel = new JPanel(new BorderLayout(5, 5));
        panel.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 5));

        JLabel lblDesc = new JLabel("Descripción:");
        panel.add(lblDesc, BorderLayout.NORTH); // cambiado a north

        txtDescripcion = new JTextArea(4, 20);
        txtDescripcion.setEditable(true);        // cambiado aytrue
        txtDescripcion.setLineWrap(true);       // ajuste de línea
        txtDescripcion.setWrapStyleWord(true);  // cortar por palabras
        panel.add(new JScrollPane(txtDescripcion), BorderLayout.CENTER);

        return panel;
    }

    private JPanel crearPanelBotones() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 0));

        JButton btnAñadir = new JButton("Añadir Producto"); // añade boton 
        JButton btnLimpiar = new JButton("Limpiar");
        JButton btnSalir = new JButton("Salir");

        btnAñadir.addActionListener(e -> accionAñadir()); // cambia accion
        btnLimpiar.addActionListener(e -> accionLimpiar());
        btnSalir.addActionListener(e -> accionSalir());

        panel.add(btnAñadir); // poner en panel
        panel.add(btnLimpiar);
        panel.add(btnSalir);

        return panel;
    }

    private JPanel crearPanelLog() {
        JPanel panel = new JPanel(new BorderLayout(0, 5));
        panel.setBorder(BorderFactory.createTitledBorder("Registro de operaciones"));

        txtLog = new JTextArea();
        txtLog.setEditable(false);
        txtLog.setFont(new Font("Monospaced", Font.PLAIN, 12));
        txtLog.setLineWrap(true);
        txtLog.setWrapStyleWord(true);

        panel.add(new JScrollPane(txtLog), BorderLayout.CENTER);

        return panel;
    }

    private void accionLimpiar() {
        txtNombre.setText("");
        txtPrecio.setText("");
        txtDescripcion.setText("");
        grupoCategorias.clearSelection();
        txtNombre.requestFocus();
    }

    private void accionSalir() {
        int respuesta = JOptionPane.showConfirmDialog(
                this,
                "¿Seguro que deseas salir de TechStore?",
                "Confirmar salida",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);

        if (respuesta == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }

    private void accionAñadir() {

        String nombre = txtNombre.getText().trim();
        String precioTexto = txtPrecio.getText().trim().replace(",", ".");

        if (nombre.isEmpty()) {
            txtLog.setText("El nombre no puede estar vacío");
            return;
        }

        if (precioTexto.isEmpty()) {
            txtLog.setText("El precio no puede estar vacío");
            return;
        }

        double precio;

        try {
            precio = Double.parseDouble(precioTexto);
        } catch (NumberFormatException e) {
            txtLog.setText("El precio debe ser un número válido");
            return;
        }

        String categoria = "";
        if (rbElectronica.isSelected()) {
            categoria = "Electrónica";
        } else if (rbInformatica.isSelected()) {
            categoria = "Informática";
        } else {
            categoria = "Audio y Video";
        }

        mostrarDialogoConfirmacion(nombre, precio, categoria, txtDescripcion.getText());
    }

    private void mostrarDialogoConfirmacion(String nombre, double precio, String categoria, String descripcion) { // dialog

        JDialog dialogo = new JDialog(this, "Confirmar nuevo producto", true);
        dialogo.setSize(350, 250);
        dialogo.setLocationRelativeTo(this);
        dialogo.setLayout(new BorderLayout(10, 10));

        JLabel titulo = new JLabel("Revisa los datos antes de confirmar:");
        dialogo.add(titulo, BorderLayout.NORTH);

        JPanel panelDatos = new JPanel();
        panelDatos.setBorder(BorderFactory.createTitledBorder("Datos del producto"));
        panelDatos.setLayout(new GridLayout(4, 2));

        panelDatos.add(new JLabel("Nombre:"));
        panelDatos.add(new JLabel(nombre));

        panelDatos.add(new JLabel("Precio (€):"));
        panelDatos.add(new JLabel(String.valueOf(precio)));

        panelDatos.add(new JLabel("Categoría:"));
        panelDatos.add(new JLabel(categoria));

        panelDatos.add(new JLabel("Descripción:"));
        panelDatos.add(new JLabel(descripcion));

        dialogo.add(panelDatos, BorderLayout.CENTER);

        JPanel panelBotones = new JPanel();

        JButton btnConfirmar = new JButton("Confirmar");
        JButton btnCancelar = new JButton("Cancelar");

        panelBotones.add(btnConfirmar);
        panelBotones.add(btnCancelar);

        dialogo.add(panelBotones, BorderLayout.SOUTH);

        // ACCIONES
        btnConfirmar.addActionListener(e -> {
            Producto p = new Producto(nombre, precio, categoria, descripcion);
            listaProductos.add(p);

            System.out.println(listaProductos);

            txtLog.setText("Producto añadido: " + nombre + " - " + java.time.LocalDateTime.now());

            accionLimpiar();
            rbAudioVideo.setSelected(true);

            dialogo.dispose();
        });

        btnCancelar.addActionListener(e -> {
            txtLog.setText("Operación cancelada por el usuario");
            dialogo.dispose();
        });

        dialogo.setVisible(true);
    }

}

class Producto { // objeto

    String nombre;
    double precio;
    String categoria;
    String descripcion;

    public Producto(String nombre, double precio, String categoria, String descripcion) {
        this.nombre = nombre;
        this.precio = precio;
        this.categoria = categoria;
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return nombre + " - " + precio + "€ - " + categoria;
    }
}
