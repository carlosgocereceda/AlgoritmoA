package presentacion;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {
		//Vista vista = new Vista("Ingenieria del conocimiento");
		JFrame ventana = new JFrame("Ingeniería del conocimiento");
		ventana.setSize(600, 600);
		Tablero tablero = Tablero.getTablero(7);
		Botones botones = new Botones();
		botones.setSize(new Dimension(20,20));
		ventana.add(tablero, BorderLayout.CENTER);
		ventana.add(botones, BorderLayout.SOUTH);
		
		ventana.setVisible(true);
		/*
		ArrayList<ArrayList<Integer>> tablero = new ArrayList<ArrayList<Integer>>();
		for(int i = 0; i < 6; i++) {
			tablero.add(new ArrayList<Integer>());
			for(int j = 0; j < 7; j++) {
				tablero.get(i).add(0);
			}
		}
		tablero.get(1).set(1, 2);
		tablero.get(0).set(2, 1);
		tablero.get(1).set(3, 1);
		tablero.get(2).set(3, 1);
		tablero.get(2).set(5, 3);
		Algoritmo a = new Algoritmo(tablero, 6,7, 5,2, 1,1);
		System.out.println("PAUSA");
		*/
	}

}
