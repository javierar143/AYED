package AAAVarios.Parciales.SegFechaT1290624;
import tp2.ejercicio2.*;

public class ParcialArboles {
    private BinaryTree<Integer> arbol;

    public ParcialArboles(BinaryTree<Integer> arbol){
        this.arbol=arbol;
    }

    public BinaryTree <Integer> nuevoTree (){
        BinaryTree<Integer> tree= new BinaryTree<>();
        if (this.arbol!= null && !this.arbol.isEmpty())
            tree= armarNuevoArbol (this.arbol, 0);

        return tree;

    }

    private BinaryTree<Integer> armarNuevoArbol (BinaryTree<Integer> tree, int Valor){
        BinaryTree<Integer> nuevoArbol= new BinaryTree<>();
        int valorNodo = tree.getData();
        nuevoArbol.setData(Valor + valorNodo);
        
        if (tree.hasLeftChild()){            
            nuevoArbol.addLeftChild (armarNuevoArbol(tree.getLeftChild(), valorNodo));
        }
        if (tree.hasRightChild()){
            nuevoArbol.addRightChild(armarNuevoArbol(tree.getRightChild(), 0));
        }

        return nuevoArbol;
    }

}
