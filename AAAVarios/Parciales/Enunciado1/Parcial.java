package AAAVarios.Parciales.Enunciado1;

import tp2.ejercicio2.*;

public class Parcial {
    BinaryTree<Integer> arbol;

    public Parcial(BinaryTree<Integer> arbol) {
        this.arbol = arbol;
    }

    public boolean resolver (int k){
        boolean cumple= false;
        if (this.arbol != null && !this.arbol.isEmpty()){
            cumple = verificarMonodistantek(this.arbol, k, 0);
        }

        return cumple;
    }

    private boolean verificarMonodistantek (BinaryTree<Integer> tree, int k, int suma ){
        boolean cumple = true;
        Integer total= tree.getData()+ suma;

        if (tree.isLeaf()){            
            cumple  = total.equals(k);  //==
        }

        if (cumple && tree.hasLeftChild()){
            cumple= verificarMonodistantek (tree.getLeftChild(), k, total);
        }

        if (cumple && tree.hasRightChild()){
            cumple= verificarMonodistantek (tree.getRightChild(), k, total);
        }


        return cumple;
    }
}
