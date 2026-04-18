package tp3.ejercicio1;

import java.util.LinkedList;
import java.util.List;
import tp1.ejercicio8.*;

public class GeneralTree<T>{

	private T data;
	private List<GeneralTree<T>> children = new LinkedList<GeneralTree<T>>(); 

	public GeneralTree() {
		
	}
	public GeneralTree(T data) {
		this.data = data;
	}

	public GeneralTree(T data, List<GeneralTree<T>> children) {
		this(data);
		this.children = children;
	}	
	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public List<GeneralTree<T>> getChildren() {
		return this.children;
	}
	
	public void setChildren(List<GeneralTree<T>> children) {
		if (children != null)
			this.children = children;
	}
	
	public void addChild(GeneralTree<T> child) {
		this.getChildren().add(child);
	}

	public boolean isLeaf() {
		return !this.hasChildren();
	}
	
	public boolean hasChildren() {
		return !this.children.isEmpty();
	}
	
	public boolean isEmpty() {
		return this.data == null && !this.hasChildren();
	}

	public void removeChild(GeneralTree<T> child) {
		if (this.hasChildren())
			children.remove(child);
	}
	
	//--------------------------------------------------------------------------------
	//--------------------------------------------------------------------------------
	public int altura() {	 
					
		return this.isEmpty() ? 0 : calcularAltura (this,0);
	}
	
	//alternativa para  devolver altura, contando de arriba hacia abajo
	
	private int calcularAltura(GeneralTree<T> tree, int nivel) {
		int resultado = nivel;

		if (!tree.isLeaf()) {
			int maxAltura = nivel;

			for (GeneralTree<T> hijo : tree.getChildren()) {
				int alturaHijo = calcularAltura(hijo, nivel + 1);
				maxAltura = Math.max(alturaHijo, maxAltura) ; //maxAltura = altura del hijo más profundo
				
			}

			resultado = maxAltura;
		}

		return resultado;
	}
	
	
	
	/* alternativa para devolver altura con un recorrido de abajo hacia arriba
	private int calcularAltura(GeneralTree<T> tree) {
		int maxAltura= 0;
		int altura = 0;
		if (!tree.isLeaf()){			
			List<GeneralTree<T>> hijos = tree.getChildren();		
			for (GeneralTree<T> hijo : hijos){
				int alturaHijo= calcularAltura(hijo);
				maxAltura = Math.max(maxAltura, alturaHijo); //compara el máximo actual vs la altura del hijo 
															//y se queda con el mayor
															//maxAltura = altura del hijo más profundo
			}
		altura= maxAltura +1;  //suma 1 por el nivel actual
		}
		return altura;
	}*/

	//--------------------------------------------------------------------------------
	//--------------------------------------------------------------------------------

	public int nivel(T dato){
		Queue <GeneralTree<T>> cola = new Queue<GeneralTree<T>>();
		int nivel =0;
		int nivelDelDato =-1; 
		GeneralTree<T> tree;
		boolean encontre= false;
		
		cola.enqueue(this);
		cola.enqueue(null);
		while (!cola.isEmpty() && !encontre){
			tree= cola.dequeue();
			if (tree != null) {
				if (tree.getData().equals(dato)){
					encontre=true;
					nivelDelDato=nivel;
				}
				if (!encontre){
					for (GeneralTree<T> hijo : tree.getChildren()){
						cola.enqueue(hijo);
					}
				}
			}
			else if (!cola.isEmpty()){
					nivel++;
					cola.enqueue(null);
			}

		}
		return nivelDelDato;
	  }

	//--------------------------------------------------------------------------------
	//--------------------------------------------------------------------------------

	public int ancho(){
		Queue <GeneralTree<T>> cola = new Queue<GeneralTree<T>>();
		
		int ancho =0; 
		int maxAncho=0;
		GeneralTree<T> tree;		
		
		cola.enqueue(this);
		cola.enqueue(null);
		while (!cola.isEmpty()){
			tree= cola.dequeue();
			if (tree != null) {
				ancho++;
				for (GeneralTree<T> hijo : tree.getChildren()){
						cola.enqueue(hijo);
					}
			}
						
			else { 
				maxAncho = Math.max(ancho, maxAncho);	
				if (!cola.isEmpty()){
					cola.enqueue(null);
					ancho =0; 					
				}	
			}					

		}
		return maxAncho;
	  }
	


	//--------------------------------------------------------------------------------
	//--------------------------------------------------------------------------------
	public void imprimirPreOrden(){
		System.out.print(this.getData()+ " ");
		List <GeneralTree<T>> lista = this.getChildren();

		for (GeneralTree <T> hijo : lista){
			hijo.imprimirPreOrden();
		}		
	}

	public void imprimirInOrden(){
		
		List <GeneralTree<T>> lista = this.getChildren();
		if (!lista.isEmpty()){
			lista.get(0).imprimirInOrden();		
			System.out.print(this.getData()+ " ");
			for (int i=1; i< lista.size(); i++){
				lista.get(i).imprimirInOrden();
			}
		}
		else System.out.print(this.getData()+ " ");	
	}

	public void imprimirPostOrden(){
		List <GeneralTree<T>> lista = this.getChildren();
		for (GeneralTree<T> nodo: lista){
			nodo.imprimirPostOrden();
		}
		System.out.print(this.getData()+ " ");
	}
}