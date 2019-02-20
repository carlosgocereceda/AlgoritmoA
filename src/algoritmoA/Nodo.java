package algoritmoA;

public class Nodo {
	private int tipo; //0 -> casilla normal, 1 -> casilla prohibida, 2-> inicial, 3 -> meta
	private Nodo padre;
	private double distanciaMeta;
	private double distanciaPadre;
	private double distanciaTotal;
	private int x;
	private int y;
	
	public Nodo(Nodo padre, double d, int tipo, int x, int y) {
		this.padre = padre;
		this.distanciaMeta = d;
		this.tipo = tipo;
		this.x = x;
		this.y = y;
	}

	public Nodo getPadre() {
		return padre;
	}

	public void setPadre(Nodo padre) {
		this.padre = padre;
	}

	public double getD() {
		return this.distanciaMeta;
	}
	
	public void setD(double d) {
		this.distanciaMeta = d;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public double getDistanciaPadre() {
		return distanciaPadre;
	}

	public void setDistanciaPadre(double distanciaPadre) {
		this.distanciaPadre = distanciaPadre;
	}

	public double getDistanciaTotal() {
		return distanciaTotal;
	}

	public void setDistanciaTotal(double distanciaTotal) {
		this.distanciaTotal = distanciaTotal;
	}
}
