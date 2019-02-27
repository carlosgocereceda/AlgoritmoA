package presentacion;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Tablero extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int metas = 0;
	private int salidas = 0;
	private static Tablero tablero;
	private JButton[][] botones;
	private ArrayList<TButton> wayPoints;

	public static Tablero getTablero(int capacidad) {
		if(tablero == null) {
			tablero = new Tablero(capacidad);
		}
		return tablero;
	}

	public Tablero(int capacidad) {
		botones = new JButton[capacidad][capacidad];
		setLayout(new GridLayout(capacidad, capacidad));
		this.setSize(new Dimension(500,500));
		setWayPoints(new ArrayList<TButton>());

		//ImageIcon icono = new ImageIcon("cesped.jpg");
		for (int i = 0; i < botones.length; i++) {
			for (int j = 0; j < botones[i].length; j++) {
				botones[i][j] = new JButton();
				//botones[i][j].setIcon(icono);
				botones[i][j].setBackground(Color.green);
				botones[i][j].setSize(new Dimension(50,50));
				botones[i][j].setName(""+i+" " + j);
				botones[i][j].addActionListener(new ButtonListener());
				add(botones[i][j]);
			}
			

		}
	}
	

	public int getMetas() {
		return metas;
	}

	public void setMetas(int metas) {
		this.metas = metas;
	}

	public int getSalidas() {
		return salidas;
	}

	public void setSalidas(int salidas) {
		this.salidas = salidas;
	}
	public JButton[][] getBotones() {
		return botones;
	}

	public void setBotones(JButton[][] botones) {
		this.botones = botones;
	}
	public void initializeWayPoints(int size) {
		for(int i = 0; i < size; i++) {
			this.wayPoints.add(null);
		}
	}

	public ArrayList<TButton> getWayPoints() {
		return wayPoints;
	}

	public void setWayPoints(ArrayList<TButton> wayPoints) {
		this.wayPoints = wayPoints;
	}
}
