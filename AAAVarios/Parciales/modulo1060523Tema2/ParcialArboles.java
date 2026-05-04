package Parciales.modulo1060523Tema2;
import tp2.ejercicio1.*;

public class ParcialArboles {
    BinaryTree<Integer> arbol;

    public ParcialArboles(BinaryTree<Integer> arbol){
        this.arbol=arbol;
    }

    public Boolean isTwoTree (int num){
        boolean esDosHojas = false;
        BinaryTree <Integer> tree;
        int izq = -1;
        int der = -1;
        if (this.arbol != null && !this.arbol.isEmpty() ){
            tree = buscarArbolSum(this.arbol, num);

            if (tree != null && !tree.isEmpty()){
                if (tree.hasLeftChild()){
                    izq  = buscarCantArbolDosHojas (tree.getLeftChild());
                }
                if (tree.hasRightChild()){
                    der  = buscarCantArbolDosHojas (tree.getRightChild());
                }
                esDosHojas= (izq == der);            
            }
        }

        return esDosHojas;
    }

    private BinaryTree <Integer> buscarArbolSum(BinaryTree <Integer> nodo, Integer num) {
        BinaryTree <Integer> tree= null;
       
        if (num.equals(nodo.getData())){                         
                tree = nodo;                       
        }
        else {
            if (nodo.hasLeftChild()){
                tree = buscarArbolSum (nodo.getLeftChild(),num);                
            }

            if (tree ==null && nodo.hasRightChild()) {
                tree = buscarArbolSum (nodo.getRightChild(),num);                
            }
        }
        return tree;
    }

    private int buscarCantArbolDosHojas(BinaryTree<Integer> tree) {
        int cantCumple=0;
        if (tree.hasLeftChild() && tree.hasRightChild()) {
            cantCumple++;            
        }
        if (tree.hasLeftChild())
            cantCumple += buscarCantArbolDosHojas (tree.getLeftChild());
        if (tree.hasRightChild())
            cantCumple += buscarCantArbolDosHojas (tree.getRightChild());
        

        return cantCumple;
    }
}
