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
	private static Botones botones;

	public static Botones getBotones() {
		if(botones == null) {
			botones = new Botones();
		}
		return botones;
	}
	public Botones() {
		JButton run = new JButton("SIMULAR");
		run.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				ArrayList<ArrayList<Integer>> tablero = new ArrayList<ArrayList<Integer>>();
				int x_meta = 0, y_meta = 0, x_salida = 0, y_salida = 0;
				Tablero.getTablero(0).initializeWayPoints(Tablero.getTablero(0).getMetas());
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
						else if(botones[i][j].getBackground() == Color.black) {
							tablero.get(i).add(4);
						}
						else if(botones[i][j].getBackground() == Color.cyan) {
							TButton wayPoint = new TButton(j,i);
							Tablero.getTablero(0).getWayPoints().set(Integer.parseInt(botones[i][j].getText())-1, wayPoint);
							tablero.get(i).add(3);
							x_meta = j;
							y_meta = i;
						}
					}
				}
				ArrayList<Nodo> solFinales = new ArrayList<Nodo>();
				Tablero.getTablero(0).getWayPoints().add(0, new TButton(x_salida, y_salida));
				for(int i = 0; i < Tablero.getTablero(0).getWayPoints().size()-1; i++) {
					Algoritmo a = new Algoritmo(tablero, botones.length, botones[0].length,
							Tablero.getTablero(0).getWayPoints().get(i+1).getX() ,
							Tablero.getTablero(0).getWayPoints().get(i+1).getY(), 
							Tablero.getTablero(0).getWayPoints().get(i).getX(),
							Tablero.getTablero(0).getWayPoints().get(i).getY());
					ArrayList<Nodo> solucion = a.dibujaSol();
					solFinales.addAll(solucion);
					/*for(int j = 0; j < solucion.size(); j++) {
						botones[solucion.get(i).getY()][solucion.get(i).getX()].setBackground(Color.orange);
					}*/
				}
				for(int i=0; i < solFinales.size(); i++) {
					System.out.println("x " + solFinales.get(i).getX() + " y " + solFinales.get(i).getY());
					botones[solFinales.get(i).getY()][solFinales.get(i).getX()].setBackground(Color.orange);
				}
				//System.out.println(solFinales);
				
				
			}
		});
		add(run);
		JButton reset = new JButton("Reset");
		reset.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Tablero.getTablero(0).setMetas(0);
				Tablero.getTablero(0).setWayPoints(new ArrayList<TButton>());
				Tablero.getTablero(0).setSalidas(0);
				for(int i= 0; i < Tablero.getTablero(0).getBotones().length; i++) {
					for(int j = 0; j < Tablero.getTablero(0).getBotones()[i].length; j++) {
						JButton aux = Tablero.getTablero(0).getBotones()[j][i];
						aux.setText("");
						aux.setBackground(Color.green);
					}
				}
			}
		});
		add(reset);
	}

}
