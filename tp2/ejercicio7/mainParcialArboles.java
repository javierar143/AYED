package tp2.ejercicio7;
import tp2.ejercicio2.*;

public class mainParcialArboles {
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
        //forma mas sintetica
        subDer7.addLeftChild(new BinaryTree<Integer>(55));
        subDer7.addRightChild(new BinaryTree<Integer>(11));

        //armado de rama der del arbol
        BinaryTree<Integer> subIzqM5 = new BinaryTree<Integer>(19);
        
        subDer2.addLeftChild(subIzqM5);
        
        BinaryTree<Integer> subDer19 = new BinaryTree<Integer>(4);
               
        subIzqM5.addRightChild(subDer19);

        subDer19.addLeftChild(new BinaryTree<Integer>(18));
        

        //impresion preorden
        arbol.imprimir();
        System.out.println();
    }
    
}
