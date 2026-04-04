package tp2.ejercicio2;

import tp1.ejercicio8.*;

public class BinaryTree <T> {
	
	private T data;
	private BinaryTree<T> leftChild;   
	private BinaryTree<T> rightChild; 

	
	public BinaryTree() {
		super();
	}

	public BinaryTree(T data) {
		this.data = data;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	/**
	 * Preguntar antes de invocar si hasLeftChild()
	 * @return
	 */
	public BinaryTree<T> getLeftChild() {
		return leftChild;
	}
	/**
	 * Preguntar antes de invocar si hasRightChild()
	 * @return
	 */
	public BinaryTree<T> getRightChild() {
		return this.rightChild;
	}

	public void addLeftChild(BinaryTree<T> child) {
		this.leftChild = child;
	}

	public void addRightChild(BinaryTree<T> child) {
		this.rightChild = child;
	}

	public void removeLeftChild() {
		this.leftChild = null;
	}

	public void removeRightChild() {
		this.rightChild = null;
	}

	public boolean isEmpty(){
		return (this.isLeaf() && this.getData() == null);
	}

	public boolean isLeaf() {
		return (!this.hasLeftChild() && !this.hasRightChild());

	}
		
	public boolean hasLeftChild() {
		return this.leftChild!=null;
	}

	public boolean hasRightChild() {
		return this.rightChild!=null;
	}
	@Override
	public String toString() {
		return this.getData().toString();
	}

	public  int contarHojas() {
		int cantHojas;
		if ((this.getData())== null)
			cantHojas=0;
			   
		else cantHojas= subContarHojas();

		return cantHojas;
	}

	private int subContarHojas() {
		int cantHojas;
		if (this.isLeaf()){
			cantHojas= 1;
		}
		else
		{
			int izquierda  = 0;
			if (this.hasLeftChild()){				
				izquierda = this.getLeftChild().subContarHojas ();
			}
			int derecha  = 0;
			if (this.hasRightChild()){				
				derecha = this.getRightChild().subContarHojas ();
			}
			cantHojas= izquierda + derecha;
		}
		return cantHojas;
	}
		
		
    	 
    public BinaryTree<T> espejo(){
		BinaryTree<T> arbolEspejo;
		if (this.getData()==null)
 	   		arbolEspejo= null;
		else{
			arbolEspejo= crearEspejo();			
		}

		return arbolEspejo;
    }
	
	private BinaryTree<T> crearEspejo(){
		BinaryTree<T> arbolTemp = new BinaryTree<>();
		arbolTemp.setData(this.getData());
		if (this.hasLeftChild()){			
			arbolTemp.addRightChild(this.getLeftChild().crearEspejo());
						
			}
		if (this.hasRightChild()){				
			arbolTemp.addLeftChild(this.getRightChild().crearEspejo());
			}
		return arbolTemp;
	}


	// 0<=n<=m
	public void entreNiveles(int n, int m){
		int nivel =0;
		int cantidad=0;

		Queue<BinaryTree<T>> cola = new Queue<>();
        cola.enqueue(this);

            while (!cola.isEmpty()){
				cantidad = cola.size();
                for (int i=0;i<cantidad;i++){
					BinaryTree <T> nodo = cola.dequeue();
					
					if (nivel >= n && nivel <= m) 
						System.out.print(nodo.getData()+ " ");
					
					if (nodo.hasLeftChild())
                    	cola.enqueue(nodo.getLeftChild());
                	
                	if (nodo.hasRightChild())
                  		cola.enqueue(nodo.getRightChild());
				
			}//este if es para poner separador de niveles
				if (nivel >= n && nivel <= m) 
					System.out.print(" | ");
				nivel++;
            }
   }

   //metodo que imprime por niveles basico
   
   public void imprimirNiveles(){
            Queue<BinaryTree<T>> cola = new Queue<>();
            cola.enqueue(this);

            while (!cola.isEmpty()){
                BinaryTree <T> nodo = cola.dequeue();
                System.out.print(nodo.getData()+ " ");
                if (nodo.hasLeftChild()){
                    cola.enqueue(nodo.getLeftChild());
                }
                if (nodo.hasRightChild()){
                    cola.enqueue(nodo.getRightChild());
                }
				

            }

   }

   	
   
	public void imprimir(){
		System.out.print(this.toString()+ " ");
        		
		if (this.hasLeftChild()){
            this.getLeftChild().imprimir(); 
        }
        if (this.hasRightChild()){
            this.getRightChild().imprimir();
        }
	}
}

