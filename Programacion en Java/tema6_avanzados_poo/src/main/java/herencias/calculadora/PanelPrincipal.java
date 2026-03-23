package herencias.calculadora;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class PanelPrincipal extends JPanel implements ActionListener {

	private PanelBotones botonera;
	private JTextArea areaTexto;

	private double num1 = 0;
	private double num2 = 0;
	private int tipoOperacion = -1; // 1:+ 2:- 3:* 4:/

	public PanelPrincipal() {
		initComponents();
	}

	private void initComponents() {

		botonera = new PanelBotones();

		areaTexto = new JTextArea(2, 20);
		areaTexto.setEditable(false);
		areaTexto.setBackground(Color.white);

		this.setLayout(new BorderLayout());
		this.add(areaTexto, BorderLayout.NORTH);
		this.add(botonera, BorderLayout.SOUTH);

		// Añadir listeners a los botones
		for (JButton boton : botonera.getgrupoBotones()) {
			boton.addActionListener(this);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		String texto = ((JButton) e.getSource()).getText();

		// Si es numero
		if (texto.matches("[0-9]")) {
			areaTexto.append(texto);
		}

		// Operaciones
		else if (texto.equals("+")) {
			num1 = Double.parseDouble(areaTexto.getText());
			tipoOperacion = 1;
			areaTexto.setText("");
		}

		else if (texto.equals("-")) {
			num1 = Double.parseDouble(areaTexto.getText());
			tipoOperacion = 2;
			areaTexto.setText("");
		}

		else if (texto.equals("*")) {
			num1 = Double.parseDouble(areaTexto.getText());
			tipoOperacion = 3;
			areaTexto.setText("");
		}

		else if (texto.equals("/")) {
			num1 = Double.parseDouble(areaTexto.getText());
			tipoOperacion = 4;
			areaTexto.setText("");
		}

		// Resultado
		else if (texto.equals("=")) {
			num2 = Double.parseDouble(areaTexto.getText());
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
					resultado = num1 / num2;
					break;
			}

			areaTexto.setText(String.valueOf(resultado));
		}

		// Limpiar
		else if (texto.equals("C")) {
			areaTexto.setText("");
			num1 = 0;
			num2 = 0;
			tipoOperacion = -1;
		}
	}
}