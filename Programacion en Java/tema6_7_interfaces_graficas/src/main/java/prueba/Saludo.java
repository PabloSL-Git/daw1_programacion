package prueba;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

// Se implementa la interfaz
public class Saludo extends JPanel implements ActionListener {

    public static void main(String[] args) {

        // este para que no coja otro main

        JFrame ventana = new JFrame("Saludo");

        ventana.setSize(400, 200);
        ventana.setLocationRelativeTo(null);

        ventana.add(new Saludo());

        ventana.setVisible(true);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private JButton botonSaludar, botonDespedir;
    private JTextArea texto;

    public Saludo() {
        initComponents();

    }

    private void initComponents() {

        botonSaludar = new JButton("Saludar");
        botonDespedir = new JButton("Despedir");

        texto = new JTextArea(1, 25);

        texto.setBackground(Color.ORANGE);

        this.setLayout(new FlowLayout());

        this.add(botonSaludar);
        this.add(botonDespedir);
        this.add(texto);

        // Se le indica al objeto boton que escuche eventos tipo click
        // y se pasa como argumento una referencia de tipo ActionListener
        // En este caso se pasa this que es el panel sobre el
        // que está el botón y que implementa la interfaz ActionListener

        botonSaludar.addActionListener(this);
        botonDespedir.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == botonSaludar) {
            texto.setText("Hola amigos!!");
        } else if (ae.getSource() == botonDespedir) {
            texto.setText("Adios amigos!!");
        }
    }

}
