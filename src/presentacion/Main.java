package presentacion;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {
		//Vista vista = new Vista("Ingenieria del conocimiento");
		JFrame ventana = new JFrame("Ingeniería del conocimiento");
		ventana.setSize(600, 600);
		Tablero tablero = new Tablero(3);
		Botones botones = new Botones();
		botones.setSize(new Dimension(500,500));
		ventana.add(tablero, BorderLayout.CENTER);
		ventana.add(botones, BorderLayout.CENTER);
		
		ventana.setVisible(true);

	}

}
