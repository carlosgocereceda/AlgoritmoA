package presentacion;

import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Botones extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public Botones() {
		//this.setSize(new Dimension(500,500));
		//this.setSize(new Dimension(100,100));
		JLabel jlabel_x = new JLabel("X");
		add(jlabel_x);
		JTextField text = new JTextField("6");
		text.setSize(new Dimension(50,50));
		add(text);
	}

}
