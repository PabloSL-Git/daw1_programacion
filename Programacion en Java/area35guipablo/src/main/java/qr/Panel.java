/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qr;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
// NUEVO-------------------------
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

/**
 *
 * @author jfervic933
 */
public class Panel extends JPanel {

    // Tamaño del panel. Constantes
    public static final int ANCHO_PANEL = 600;
    public static final int ALTO_PANEL = 200;

    // Atributos del panel
    private JButton btnGenerar, btnCerrar;
    private JLabel lblUrl, lblFichero;
    private JTextField tfUrl, tfFichero;
    // NUEVO----------------------------
    private JLabel lblExtension;
    private JComboBox<String> cbExtension;
    // RADIO-------------------------------------
    private JRadioButton rbPng, rbJpg;
    private ButtonGroup grupoExtensiones;

    // Constructor
    public Panel() {
        // Establece el layout del panel
        this.setLayout(new FlowLayout());
        // Establece el color del fondo del panel
        this.setBackground(Color.gray);
        // Establece el tamaño del panel
        this.setSize(ANCHO_PANEL, ALTO_PANEL);
        inicializarComponentes();
    }

    private void inicializarComponentes() {

        // Añade URL Label
        lblUrl = new JLabel("Introduce el texto: ");
        this.add(lblUrl);

        // Añade área de texto para la URL
        // Ancho de unos 40 caracteres aprox
        tfUrl = new JTextField(40);
        this.add(tfUrl);

        // Añade Fichero Label
        lblFichero = new JLabel("Nombre del fichero: ");
        this.add(lblFichero);

        // Añade área de texto para el nombre del fichero
        tfFichero = new JTextField(40);
        this.add(tfFichero);

        // Añade el botón generar
        btnGenerar = new JButton("Generar código QR");
        this.add(btnGenerar);
        // Comportamiento del botón generar
        btnGenerar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                // Si el contenido de los textField no está vacío
                if (!tfUrl.getText().isEmpty() && !tfFichero.getText().isEmpty()) {
                    // Genera el fichero con la imagen del QR
                    // El fichero se genera en la raíz del proyecto

                    // ANTIGUO--------------------------------------------

                    // QR.escribirQR(tfUrl.getText(), tfFichero.getText(), "png");
                    // new VentanaResultado(tfFichero.getText());

                    // NUEVO---------------------------------

                    // Obtener extensión seleccionada
                    String extension = (String) cbExtension.getSelectedItem();

                    // Construir nombre completo del fichero
                    String nombreCompleto = tfFichero.getText() + "." + extension;

                    // Generar QR con la extensión elegida
                    QR.escribirQR(tfUrl.getText(), nombreCompleto, extension);

                    // Mostrar resultado
                    new VentanaResultado(nombreCompleto);

                    // RADIO---------------------------------

                    // Determinar la extensión seleccionada
                    if (rbPng.isSelected()) {
                        extension = "png";
                    } else {
                        extension = "jpg";
                    }

                    // Construir el nombre completo del fichero con la extensión
                    nombreCompleto = tfFichero.getText() + "." + extension;

                    // Generar el QR con la extensión correspondiente
                    QR.escribirQR(tfUrl.getText(), nombreCompleto, extension);

                    // Mostrar la imagen generada en la ventana
                    new VentanaResultado(nombreCompleto);
                } else {
                    JOptionPane.showMessageDialog(null, "No puede haber campos vacíos.");
                }
            }
        });
        // Añade botón cerrar
        btnCerrar = new JButton("Salir");
        this.add(btnCerrar);
        // Comportamiento del botón Cerrar
        btnCerrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                System.exit(0);
            }
        });

        // NUEVO--------------------------

        // Label para extensión
        lblExtension = new JLabel("Extensión del fichero:");
        this.add(lblExtension);

        // ComboBox con opciones
        cbExtension = new JComboBox<>();
        cbExtension.addItem("png");
        cbExtension.addItem("jpg");
        this.add(cbExtension);

        //RADIO-----------------------------------

        // Crear botones de tipo radio
        rbPng = new JRadioButton("png");
        rbJpg = new JRadioButton("jpg");

        // Agruparlos para que solo uno pueda seleccionarse
        grupoExtensiones = new ButtonGroup();
        grupoExtensiones.add(rbPng);
        grupoExtensiones.add(rbJpg);

        // Seleccionar png por defecto
        rbPng.setSelected(true);

        // Añadir al panel
        this.add(rbPng);
        this.add(rbJpg);
    }

}
