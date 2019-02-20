package algoritmoA;

public class Nodo {
	private int tipo; //0 -> casilla normal, 1 -> casilla prohibida, 2-> inicial, 3 -> meta
	private Nodo padre;
	private double d;
	
	public Nodo(Nodo padre, double d, int tipo) {
		this.padre = padre;
		this.d = d;
		this.tipo = tipo;
	}

	public Nodo getPadre() {
		return padre;
	}

	public void setPadre(Nodo padre) {
		this.padre = padre;
	}

	public double getD() {
		return this.d;
	}
	
	public void setD(double d) {
		this.d = d;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
}
