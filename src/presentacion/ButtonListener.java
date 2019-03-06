package presentacion;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
		else {
			if(((JButton)e.getSource()).getBackground() == Color.green) {
				((JButton)e.getSource()).setBackground(Color.red);
			}
			else if(((JButton)e.getSource()).getBackground() == Color.red) {
				((JButton)e.getSource()).setBackground(Color.black);
			}
			else if(((JButton)e.getSource()).getBackground() == Color.black) {
				((JButton)e.getSource()).setBackground(Color.cyan);
				t.setMetas(t.getMetas()+1);
				((JButton)e.getSource()).setText(String.valueOf(t.getMetas()));
			}
			else if(((JButton)e.getSource()).getBackground() == Color.cyan) {
				((JButton)e.getSource()).setBackground(Color.green);
				int metaCambiada = Integer.parseInt(((JButton)e.getSource()).getText());
				System.out.println(metaCambiada);
				for(int i =0 ; i < t.getBotones().length; i++) {
					for(int j = 0; j < t.getBotones()[i].length; j++) {
						if(t.getBotones()[j][i].getText() != "") {
							int aux = Integer.parseInt(t.getBotones()[j][i].getText());
							if(aux > metaCambiada) {
								t.getBotones()[j][i].setText(String.valueOf(aux -1));
							}
						}
					}
				}
				
				t.setMetas(t.getMetas()-1);
				((JButton)e.getSource()).setText("");
			}
		}		
	}

}
