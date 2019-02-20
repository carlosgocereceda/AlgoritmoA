package algoritmoA;

import java.util.ArrayList;

public class Algoritmo {
	
	private ArrayList<ArrayList<Nodo>> nodos;

	public Algoritmo(ArrayList<ArrayList<Integer>> tablero, int filas, int columnas) {
		this.nodos = new ArrayList<ArrayList<Nodo>>();
		transforma(tablero, filas, columnas);
		dibuja();
		System.out.println("PAUSA");
		
	}
	private void transforma(ArrayList<ArrayList<Integer>> tablero, int filas, int columnas) {
		for(int i = 0; i < filas; i++) {
			//tablero.add(new ArrayList<Integer>());
			nodos.add(new ArrayList<Nodo>());
			for(int j = 0; j < columnas; j++) {
				switch (tablero.get(i).get(j)) {
					case 0: nodos.get(i).add(new Nodo(null, 0.0, 0)); break;
					case 1: nodos.get(i).add(new Nodo(null, 0.0, 1)); break;
					case 2: nodos.get(i).add(new Nodo(null, 0.0, 2)); break;
					case 3: nodos.get(i).add(new Nodo(null, 0.0, 3)); break;
					default: nodos.get(i).add(new Nodo(null, 0.0, 0)); break;
				}
				
			}
		}
	}
	private void dibuja() {
		for(int i = 0; i < nodos.size(); i ++) {
			String aux = "";
			for(int j = 0; j < nodos.get(i).size(); j++) {
				aux += nodos.get(i).get(j).getTipo() + " ";
			}
			System.out.println(aux);
		}
	}
	
}
