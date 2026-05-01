package calculadora;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class PanelPrincipal extends JPanel implements ActionListener {

	private PanelBotones panelBotones;
	private JTextArea areaTexto;

	private double num1 = 0;
	private double num2 = 0;
	private int tipoOperacion = 0; // 1 +, 2 -, 3 *, 4 /

	public PanelPrincipal() {
		initComponents();
	}

	private void initComponents() {
		panelBotones = new PanelBotones();

		areaTexto = new JTextArea(6, 60);
		areaTexto.setEditable(false);
		areaTexto.setBackground(Color.white);

		this.setLayout(new BorderLayout());
		this.add(areaTexto, BorderLayout.NORTH);
		this.add(panelBotones, BorderLayout.SOUTH);

		// Añadir listeners a los botones
		for (JButton boton : panelBotones.getgrupoBotones()) {
			boton.addActionListener(this);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String texto = ((JButton) e.getSource()).getText();

		// Si es numero
		if (texto.matches("[0-9]")) {

			// Guardamos directamente num1 o num2 segun si hay operador

			if (tipoOperacion == 0) {
				num1 = Double.parseDouble(texto);
			} else {
				num2 = Double.parseDouble(texto);
			}

			areaTexto.append(texto); // mostramos en pantalla
		}

		// Si es operador
		if (texto.equals("+") || texto.equals("-") || texto.equals("*") || texto.equals("/")) {
			switch (texto) {
				case "+":
					tipoOperacion = 1;
					break;
				case "-":
					tipoOperacion = 2;
					break;
				case "*":
					tipoOperacion = 3;
					break;
				case "/":
					tipoOperacion = 4;
					break;
			}
			areaTexto.append(texto); // mostrar operador junto al primer numero
		}

		// Si es igual, calcula y muestra
		if (texto.equals("=")) {
			double resultado = 0;
			switch (tipoOperacion) {
				case 1:
					resultado = num1 + num2;
					break;
				case 2:
					resultado = num1 - num2;
					break;
				case 3:
					resultado = num1 * num2;
					break;
				case 4:
					if (num2 != 0) {
						resultado = num1 / num2;
					} else {
						areaTexto.setText("Error: división por 0");
						return;
					}
					break;
			}

			areaTexto.setText(String.valueOf(resultado)); // mostrar resultado

			// reinicia proximo

			num1 = resultado;
			num2 = 0;
			tipoOperacion = 0;
		}

		// Limpiar
		else if (texto.equals("C")) {
			areaTexto.setText("");
			num1 = 0;
			num2 = 0;
			tipoOperacion = 0;
		}
	}
}