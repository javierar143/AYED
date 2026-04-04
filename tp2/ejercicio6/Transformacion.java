package tp2.ejercicio6;
import tp2.ejercicio2.*;

public class Transformacion {
    BinaryTree<Integer> arbol;

    public Transformacion(BinaryTree<Integer> arbol) {
        this.arbol = arbol;
    }

    public BinaryTree<Integer> suma(){
        BinaryTree<Integer> tree = new BinaryTree<>();
        if (this.arbol !=null)
            transformarArbol(this.arbol,tree);
        
        return tree;
    }

    private int transformarArbol(BinaryTree<Integer> original, BinaryTree<Integer> nuevo) {
        
        int valor=0;
        if (original.isLeaf()){
            valor=original.getData();
            nuevo.setData(0);
        }

        else{
            int izquierdo=0;
            int derecho=0;
            
            if (original.hasLeftChild()){
                BinaryTree<Integer> tree = new BinaryTree<>();
                izquierdo = transformarArbol(original.getLeftChild(),tree); 
                nuevo.addLeftChild(tree);               
            }
            
            if (original.hasRightChild()){
                BinaryTree<Integer> tree = new BinaryTree<>();
                derecho  =transformarArbol(original.getRightChild(),tree);
                nuevo.addRightChild(tree);                 
            }           
            nuevo.setData(izquierdo + derecho);
            valor =original.getData()+ izquierdo + derecho;
            
        }    

        return valor;
    }
}
