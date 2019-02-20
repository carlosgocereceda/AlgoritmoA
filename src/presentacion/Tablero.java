package presentacion;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Tablero extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Tablero(int capacidad) {
		JButton[][] botones;
		botones = new JButton[capacidad][capacidad];

		// SE CREA UN OYENTE DE ACCIONES Y SE LE PASA EL
		// PANEL COMO ARGUMENTO
		Action oyenteAcciones = new Action(this);
		setLayout(new GridLayout(capacidad, capacidad));
		this.setSize(new Dimension(500,500));

		for (int i = 0; i < botones.length; i++) {
			for (int j = 0; j < botones[i].length; j++) {
				botones[i][j] = new JButton();
				botones[i][j].setSize(new Dimension(50,50));
				botones[i][j].setName(""+i+" " + j);
				botones[i][j].addActionListener(oyenteAcciones);
				add(botones[i][j]);
			}
			

		}
	}
}
