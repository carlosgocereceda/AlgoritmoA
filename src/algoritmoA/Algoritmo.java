package algoritmoA;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;

public class Algoritmo {
	
	private ArrayList<ArrayList<Nodo>> nodos;
	private PriorityQueue<Nodo> abierta = new PriorityQueue<Nodo>();

	public Algoritmo(ArrayList<ArrayList<Integer>> tablero, int filas, int columnas) {
		this.nodos = new ArrayList<ArrayList<Nodo>>();
		transforma(tablero, filas, columnas);
		Comparator<Nodo> comparadorNodos = new Comparator<Nodo>() {

			@Override
			public int compare(Nodo nodo1, Nodo nodo2) {
				if(nodo1.getD() < nodo2.getD()) {
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
		dibuja();
		System.out.println("PAUSA");
		
	}
	private void transforma(ArrayList<ArrayList<Integer>> tablero, int filas, int columnas) {
		Random r = new Random();
		for(int i = 0; i < filas; i++) {
			//tablero.add(new ArrayList<Integer>());
			nodos.add(new ArrayList<Nodo>());
			for(int j = 0; j < columnas; j++) {
				switch (tablero.get(i).get(j)) {
					case 0: nodos.get(i).add(new Nodo(null, r.nextDouble(), 0)); break;
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
