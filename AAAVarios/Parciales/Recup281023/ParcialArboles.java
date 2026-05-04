package AAAVarios.Parciales.Recup281023;
import tp2.ejercicio2.*;

public class ParcialArboles {
    public BinaryTree<DataClass> sumAndDif(BinaryTree<Integer> arbol){
        BinaryTree <DataClass> tree= null;
        
        if (arbol != null && !arbol.isEmpty()){
            tree = armarNuevoArbol (arbol,  0 , 0);
        }

        return tree;
    }

    private BinaryTree <DataClass> armarNuevoArbol(BinaryTree<Integer> tree, int acumulado, int valorPadre) {
        int valorNodo = tree.getData();
        DataClass dc = new DataClass(acumulado +valorNodo, valorNodo - valorPadre);
        BinaryTree<DataClass> newTree= new BinaryTree<DataClass>(dc);
        
        if (tree.hasLeftChild()){
            newTree.addLeftChild(armarNuevoArbol(tree.getLeftChild(), dc.getAcumulado(), valorNodo));
        }

        if (tree.hasRightChild()){
            newTree.addRightChild(armarNuevoArbol(tree.getRightChild(), dc.getAcumulado(), valorNodo));
        }
        

        return newTree;
    }
}
