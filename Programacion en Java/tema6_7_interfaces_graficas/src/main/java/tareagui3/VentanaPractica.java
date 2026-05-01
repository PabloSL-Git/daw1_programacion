package tareagui3;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class VentanaPractica extends JFrame implements ActionListener, MouseListener {

    private JLabel etiqueta1, etiqueta2;
    private JButton botonAleatorio, botonRaton;

    public VentanaPractica() {
        this.setLayout(new FlowLayout());

        configurarVentana();
        inicializarComponentes();
        eventosBotones();
        eventosRaton();
    }

    private void configurarVentana() {
        this.setSize(400, 200);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void inicializarComponentes() {

        etiqueta1 = new JLabel("etiqueta1");
        etiqueta2 = new JLabel("etiqueta2");

        botonAleatorio = new JButton("Aleatorio");
        botonRaton = new JButton("Raton");

        // orden pedido
        this.add(botonAleatorio);
        this.add(etiqueta1);
        this.add(botonRaton);
        this.add(etiqueta2);
    }

    private void eventosBotones() {
        botonAleatorio.addActionListener(this);
        botonRaton.addActionListener(this);
    }

    private void eventosRaton() {
        botonRaton.addMouseListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == botonAleatorio) {
            int num = (int) (Math.random() * 11);
            etiqueta1.setText(String.valueOf(num));
        }

        if (e.getSource() == botonRaton) {
            pedirTexto();
        }
    }

    private void pedirTexto() {
        String texto = JOptionPane.showInputDialog("Introduce texto");

        if (texto != null) {
            etiqueta2.setText(texto);
        }
    }

    // MouseListener

    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getSource() == botonRaton) {
            botonRaton.setBackground(Color.GREEN);
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource() == botonRaton) {
            botonRaton.setBackground(Color.GRAY);
        }
    }

    // obligatorios pero vacíos
    public void mouseClicked(MouseEvent e) {
    }

    public void mousePressed(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {
    }

    public static void main(String[] args) {
        new VentanaPractica().setVisible(true);
    }
}