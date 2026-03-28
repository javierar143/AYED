package tp2.ejercicio2;



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
		if ((this.getData())== null)
			return 0;
			   
		return subContarHojas();
	}

	private int subContarHojas() {
		if (this.isLeaf()){
			return 1;
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
			return izquierda + derecha;
		}

	}
		
		
    	 
    public BinaryTree<T> espejo(){
		if (this.getData()==null)
 	   		return null;
		else{
			return crearEspejo();			
		}
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
		
   }
		
}

