package prueba;

import javax.swing.JFrame;

public class TestFrame {

	public static void main(String[] args) {

		// Construimos la ventana
		JFrame ventanaPrincipal = new JFrame("Aplicación");

		// Establecemos posición y tamaño
		ventanaPrincipal.setBounds(250, 250, 800, 600);

		// Hacemos visible la ventana
		ventanaPrincipal.setVisible(true);

		// Acción por defecto al pulsar el botón de cierre
		ventanaPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
