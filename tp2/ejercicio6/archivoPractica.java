package tp2.ejercicio6;
import tp2.ejercicio2.*;
public class archivoPractica {
    BinaryTree<Integer> arbol;

    public archivoPractica(BinaryTree<Integer> arbol) {
        this.arbol = arbol;
    }

     public BinaryTree<Integer> suma(){
        BinaryTree<Integer> tree = new BinaryTree<>();
        if (this.arbol !=null && !this.arbol.isEmpty() )
            tree=transformarArbol(this.arbol);        
        return tree;
    }

    private BinaryTree<Integer>  transformarArbol(BinaryTree<Integer> original ){
        BinaryTree<Integer> tree= new BinaryTree<>();
        if (original.isLeaf())
        {
            tree.setData(0);
        }
        else{
            int suma=0;
            
            if(original.hasLeftChild()){                
                suma+=original.getLeftChild().getData();
                BinaryTree<Integer> temp= transformarArbol(original.getLeftChild());
                suma+=temp.getData();
                tree.addLeftChild(temp);
            }
            if (original.hasRightChild()){
                suma+= original.getRightChild().getData();
                BinaryTree<Integer> temp=transformarArbol(original.getRightChild());
                suma+=temp.getData();
                tree.addRightChild(temp);
            }

            tree.setData(suma);
        }

        return tree;
    }
     
}
