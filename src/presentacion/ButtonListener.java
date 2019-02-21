package presentacion;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class ButtonListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		Tablero t = Tablero.getTablero(7);
		/*if(((JButton)e.getSource()).getIcon() == salida) {
			((JButton)e.getSource()).setIcon(null);
			//((JButton)e.getSource()).setIcon(cesped);
			System.out.println("hola");
			t.setSalidas(t.getSalidas()-1);
		}*/
		if(t.getSalidas() == 0) {
			//((JButton)e.getSource()).setIcon(salida);
			((JButton)e.getSource()).setBackground(Color.yellow);
			t.setSalidas(t.getSalidas()+1);
		}
		else if(t.getMetas() == 0) {
			//((JButton)e.getSource()).setIcon(meta);
			((JButton)e.getSource()).setBackground(Color.blue);
			t.setMetas(t.getMetas()+1);
		}
		else {
			((JButton)e.getSource()).setIcon(null);
			((JButton)e.getSource()).setBackground(Color.red);
		}
		/*if(((JButton)e.getSource()).get == Color.red) {
			
		}
		((JButton)e.getSource()).setBackground(Color.red);*/
		
	}

}
