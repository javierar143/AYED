package Parciales.modulo1060523Tema2;
import tp2.ejercicio2.*;

public class mainParcialArbolesisLeft {
    public static void main(String[] args) {
        
    
        BinaryTree<Integer> arbol = new BinaryTree<Integer>(2);

        BinaryTree<Integer> subIzq2 = new BinaryTree<Integer>(7);
        BinaryTree<Integer> subDer2 = new BinaryTree<Integer>(-5);

        //hijos de arbol principal        
        arbol.addLeftChild(subIzq2);
        arbol.addRightChild(subDer2);

        //armado de rama izq del arbol
        BinaryTree<Integer> subIzq7 = new BinaryTree<Integer>(23);
        BinaryTree<Integer> subDer7 = new BinaryTree<Integer>(6);

        subIzq2.addLeftChild(subIzq7);
        subIzq2.addRightChild(subDer7);

        BinaryTree<Integer> subIzq23 = new BinaryTree<Integer>(-3);
        
        subIzq7.addLeftChild(subIzq23);

        BinaryTree<Integer> subIzq6 = new BinaryTree<Integer>(55);
        //forma mas sintetica
        subDer7.addLeftChild(subIzq6);

        subIzq6.addLeftChild(new BinaryTree<Integer>(9));
        subIzq6.addRightChild(new BinaryTree<Integer>(16));
       
        //armado de rama der del arbol
        BinaryTree<Integer> subIzqM5 = new BinaryTree<Integer>(19);
        
        subDer2.addLeftChild(subIzqM5);        
        
        BinaryTree<Integer> subDerM5 = new BinaryTree<Integer>(4);
        subDer2.addRightChild(subDerM5);

        BinaryTree<Integer> subDer4 = new BinaryTree<Integer>(18);
        subDerM5.addRightChild(subDer4); 
        
        subDer4.addLeftChild(new BinaryTree<Integer>(8));
        subDer4.addRightChild(new BinaryTree<Integer>(24));        
        

        //impresion preorden
        arbol.imprimir();
        System.out.println();
}
}
