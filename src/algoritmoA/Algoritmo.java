package algoritmoA;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Algoritmo {
	
	private ArrayList<ArrayList<Nodo>> nodos;
	private PriorityQueue<Nodo> abierta = new PriorityQueue<Nodo>();
	private ArrayList<Nodo> cerrada = new ArrayList<Nodo>();
	private int x_meta;
	private int y_meta;
	private int x_salida;
	private int y_salida;

	public Algoritmo(ArrayList<ArrayList<Integer>> tablero, int filas, int columnas,
			int x_meta, int y_meta, int x_salida, int y_salida) {
		this.x_meta = x_meta;
		this.y_meta = y_meta;
		this.x_salida = x_salida;
		this.setY_salida(y_salida);
		this.nodos = new ArrayList<ArrayList<Nodo>>();
		transforma(tablero, filas, columnas);
		Comparator<Nodo> comparadorNodos = new Comparator<Nodo>() {

			@Override
			public int compare(Nodo nodo1, Nodo nodo2) {
				if(nodo1.getDistanciaTotal() < nodo2.getDistanciaTotal()) {
					return -1;
				}
				else {
					return 1;
				}
			}
			
		};
		this.abierta = new PriorityQueue<Nodo>(comparadorNodos);
		/*for(int i = 0; i < nodos.size(); i++) {
			for(int j =0; j < nodos.get(i).size(); j++) {
				abierta.add(nodos.get(i).get(j));
			}
		}
		while (!abierta.isEmpty()) {
            System.out.println(abierta.remove().getD());
        }*/
		
		this.abierta.add(nodos.get(y_salida).get(x_salida));
		nodos.get(y_salida).get(x_salida).setD(calculaDistancia(x_salida, y_salida));
		boolean meta = false;
		while(!abierta.isEmpty() && !meta) {
			Nodo nodo_expandir = abierta.remove();
			ArrayList<Nodo> res_exp = expandir(nodo_expandir.getX(), nodo_expandir.getY());
			for(int i = 0; i < res_exp.size(); i++) {
				if(!abierta.contains(res_exp.get(i)) && !cerrada.contains(res_exp.get(i))) {
					res_exp.get(i).setPadre(nodo_expandir);
					res_exp.get(i).setD(calculaDistancia(res_exp.get(i).getX(), res_exp.get(i).getY()));
					res_exp.get(i).setDistanciaTotal(calculaDistanciaOrigen(res_exp.get(i)) + 
							res_exp.get(i).getD());
					abierta.add(res_exp.get(i));
				}
			}
			cerrada.add(nodo_expandir);
			if(cerrada.contains(nodos.get(y_meta).get(x_meta))){
				meta = true;
			}
			//System.out.println("pausa");
		}
		dibuja();
		System.out.println("Lista De Cerrados");
		for(int i= 0; i < cerrada.size(); i++) {
			System.out.println("x: " + cerrada.get(i).getX() + " y: " + cerrada.get(i).getY());
		}
		System.out.println("---------------------------");
		dibujaSol();
		
	}
	public ArrayList<Nodo> dibujaSol() {
		ArrayList<Nodo> sol = new ArrayList<Nodo>();
		Nodo aux = nodos.get(y_meta).get(x_meta).getPadre();
		while(aux.getPadre() != null) {
			System.out.println("x: " + aux.getX() + " y: " + aux.getY());
			sol.add(aux);
			aux = aux.getPadre();
		}
		//sol.remove(sol.size()-1);
		System.out.println("x: " + aux.getX() + " y: " + aux.getY());
		return sol;
		
	}
	private double calculaDistanciaOrigen(Nodo nodo) {
		double total = 0.0;
		while(nodo.getPadre() != null) {
			total = total + nodo.getDistanciaPadre();
			nodo = nodo.getPadre();
		}
		return total;
	}
	private ArrayList<Nodo> expandir(int x, int y){
		ArrayList<Nodo> res = new ArrayList<Nodo>();
		if(y-1 >= 0 && nodos.get(y-1).get(x).getTipo() != 1) {
			//arriba, no es una casilla prohibida y no está en cerrada
			nodos.get(y-1).get(x).setDistanciaPadre(1);
			res.add(nodos.get(y-1).get(x));
		}
		if(y+1 < nodos.size() && nodos.get(y+1).get(x).getTipo() != 1) {
			//abajo
			nodos.get(y+1).get(x).setDistanciaPadre(1);
			res.add(nodos.get(y+1).get(x));
		}
		if(x-1 >= 0 && nodos.get(y).get(x-1).getTipo() != 1) {
			//izquierda
			nodos.get(y).get(x-1).setDistanciaPadre(1);
			res.add(nodos.get(y).get(x-1));
		}
		if(x+1 < nodos.get(x).size() && nodos.get(y).get(x+1).getTipo() != 1) {
			//derecha
			nodos.get(y).get(x+1).setDistanciaPadre(1);
			res.add(nodos.get(y).get(x+1));
		}
		if(x+1 < nodos.get(x).size() && y-1 >= 0 && nodos.get(y-1).get(x+1).getTipo() != 1) {
			//noreste
			nodos.get(y-1).get(x+1).setDistanciaPadre(Math.sqrt(2.0));
			res.add(nodos.get(y-1).get(x+1));
		}
		if(x+1 < nodos.get(x).size() && y+1 < nodos.size() && nodos.get(y+1).get(x+1).getTipo() != 1) {
			//sureste
			nodos.get(y+1).get(x+1).setDistanciaPadre(Math.sqrt(2.0));
			res.add(nodos.get(y+1).get(x+1));
		}
		if(x-1 >= 0 && y+1 < nodos.size() && nodos.get(y+1).get(x-1).getTipo() != 1) {
			//suroeste
			nodos.get(y+1).get(x-1).setDistanciaPadre(Math.sqrt(2.0));
			res.add(nodos.get(y+1).get(x-1));
		}
		if(x-1 >= 0 && y-1 >= 0 && nodos.get(y-1).get(x-1).getTipo() != 1) {
			//noroeste
			nodos.get(y-1).get(x-1).setDistanciaPadre(Math.sqrt(2.0));
			res.add(nodos.get(y-1).get(x-1));
		}
		return res;
	}
	private void transforma(ArrayList<ArrayList<Integer>> tablero, int filas, int columnas) {
		for(int i = 0; i < filas; i++) {
			//tablero.add(new ArrayList<Integer>());
			nodos.add(new ArrayList<Nodo>());
			for(int j = 0; j < columnas; j++) {
				switch (tablero.get(i).get(j)) {
					case 0: nodos.get(i).add(new Nodo(null, 0.0, 0, j, i)); break;
					case 1: nodos.get(i).add(new Nodo(null, 0.0, 1, j, i)); break;
					case 2: nodos.get(i).add(new Nodo(null, 0.0, 2, j, i)); break;
					case 3: nodos.get(i).add(new Nodo(null, 0.0, 3, j, i)); break;
					default: nodos.get(i).add(new Nodo(null, 0.0 , 0, j, i)); break;
				}
				
			}
		}
	}
	private void dibuja() {
		System.out.println("----------------------------------");
		for(int i = 0; i < nodos.size(); i ++) {
			String aux = "";
			for(int j = 0; j < nodos.get(i).size(); j++) {
				aux += nodos.get(i).get(j).getTipo() + " ";
			}
			System.out.println(aux);
		}
		System.out.println("----------------------------------");
		for(int i = 0; i < nodos.size(); i ++) {
			String aux = "";
			for(int j = 0; j < nodos.get(i).size(); j++) {
				aux += nodos.get(i).get(j).getD() + " ";
			}
			System.out.println(aux);
		}
	}
	private double calculaDistancia(int x_origen, int y_origen) {
		return Math.sqrt(Math.pow(x_origen - this.x_meta, 2) + Math.pow(y_origen - this.y_meta, 2));
	}
	public PriorityQueue<Nodo> getAbierta() {
		return abierta;
	}
	public void setAbierta(PriorityQueue<Nodo> abierta) {
		this.abierta = abierta;
	}
	public int getX_meta() {
		return x_meta;
	}
	public void setX_meta(int x_meta) {
		this.x_meta = x_meta;
	}
	public int getY_meta() {
		return y_meta;
	}
	public void setY_meta(int y_meta) {
		this.y_meta = y_meta;
	}
	public int getX_salida() {
		return x_salida;
	}
	public void setX_salida(int x_salida) {
		this.x_salida = x_salida;
	}
	public int getY_salida() {
		return y_salida;
	}
	public void setY_salida(int y_salida) {
		this.y_salida = y_salida;
	}
	public ArrayList<Nodo> getCerrada() {
		return cerrada;
	}
	public void setCerrada(ArrayList<Nodo> cerrada) {
		this.cerrada = cerrada;
	}
	
}
