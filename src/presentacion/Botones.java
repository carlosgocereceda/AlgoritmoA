package presentacion;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import algoritmoA.Algoritmo;
import algoritmoA.Nodo;

public class Botones extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Botones() {
		JButton run = new JButton("SIMULAR");
		run.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				ArrayList<ArrayList<Integer>> tablero = new ArrayList<ArrayList<Integer>>();
				int x_meta = 0, y_meta = 0, x_salida = 0, y_salida = 0;
				JButton[][] botones = Tablero.getTablero(0).getBotones();
				for(int i = 0; i < botones.length; i++) {
					tablero.add(new ArrayList<Integer>());
					for(int j = 0; j < botones[i].length; j++) {
						if(botones[i][j].getBackground() == Color.green) {
							tablero.get(i).add(0);
						}
						else if(botones[i][j].getBackground() == Color.red) {
							tablero.get(i).add(1);
						}
						else if(botones[i][j].getBackground() == Color.yellow) {
							tablero.get(i).add(2);
							x_salida = j;
							y_salida = i;
						}
						else if(botones[i][j].getBackground() == Color.blue) {
							tablero.get(i).add(3);
							x_meta = j;
							y_meta = i;
						}
					}
				}
				Algoritmo a = new Algoritmo(tablero, botones.length, botones[0].length,
						x_meta ,y_meta, x_salida, y_salida);
				ArrayList<Nodo> solucion = a.dibujaSol();
				for(int i = 0; i < solucion.size(); i++) {
					botones[solucion.get(i).getY()][solucion.get(i).getX()].setBackground(Color.orange);
				}
				
			}
		});
		add(run);
		JLabel jlabel_x = new JLabel("X");
		add(jlabel_x);
		JTextField text = new JTextField("6");
		text.setSize(new Dimension(50, 50));
		add(text);
	}

}
