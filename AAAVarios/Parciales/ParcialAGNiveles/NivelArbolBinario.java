package AAAVarios.Parciales.ParcialAGNiveles;
import tp2.ejercicio2.*;
import tp1.ejercicio8.*;;

public class NivelArbolBinario {
    BinaryTree<Integer> arbol;

    public NivelArbolBinario (BinaryTree<Integer> arbol){
        this.arbol=arbol;
    }

    public BinaryTree<Integer> minEnArbolDeAB (int n) {
        Queue <BinaryTree<Integer>> cola= new Queue<>();
        BinaryTree<Integer> tree;
        BinaryTree<Integer> arbolMinimo= null;
        int nivel=0;
        
        int minValor= Integer.MAX_VALUE;

        cola.enqueue(this.arbol);
        cola.enqueue(null);

        while (!cola.isEmpty() && nivel <= n){
            tree = cola.dequeue();
            if (tree != null){
                if (nivel == n && tree.isLeaf()){
                    if (tree.getData() < minValor){
                        minValor= tree.getData();
                        arbolMinimo = tree;
                    }
                }
                if (tree.hasLeftChild())
                    cola.enqueue(tree.getLeftChild());
                if (tree.hasRightChild())
                    cola.enqueue(tree.getRightChild());
            }

            else{
                if (!cola.isEmpty()){
                    nivel++;
                    cola.enqueue(null);
                }
            }
        }



        return arbolMinimo;
    }

}
