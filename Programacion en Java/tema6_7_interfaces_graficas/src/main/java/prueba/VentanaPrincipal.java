package prueba;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;

public class VentanaPrincipal extends JFrame {

    public VentanaPrincipal() {
        initComponents();
    }

    private void initComponents() {

        // Configuracion
        this.setTitle("cuadrado");
        this.setSize(600, 600);
        this.setLocationRelativeTo(null);

        // layout
        this.setLayout(new BorderLayout());

        // paneles en cada zona
        this.add(new MiPanel(Color.YELLOW), BorderLayout.NORTH);
        this.add(new MiPanel(Color.RED), BorderLayout.SOUTH);
        this.add(new MiPanel(Color.GRAY), BorderLayout.CENTER);
        this.add(new MiPanel(Color.GREEN), BorderLayout.WEST);
        this.add(new MiPanel(Color.CYAN), BorderLayout.EAST);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new VentanaPrincipal().setVisible(true);
    }
}
