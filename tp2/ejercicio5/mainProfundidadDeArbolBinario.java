package tp2.ejercicio5;
import tp2.ejercicio2.*;

public class mainProfundidadDeArbolBinario {
    public static void main(String[] args) {
        BinaryTree<Integer> arbol = new BinaryTree<Integer>(10);

        BinaryTree<Integer> subIzq10 = new BinaryTree<Integer>(2);
        BinaryTree<Integer> subDer10 = new BinaryTree<Integer>(3);

        //hijos de arbol principal
        arbol.addLeftChild(subIzq10);
        arbol.addRightChild(subDer10);

        //armado de rama izq del arbol
        BinaryTree<Integer> subIzq2 = new BinaryTree<Integer>(5);
        BinaryTree<Integer> subDer2 = new BinaryTree<Integer>(4);

        subIzq10.addLeftChild(subIzq2);
        subIzq10.addRightChild(subDer2);

        BinaryTree<Integer> subIzq5 = new BinaryTree<Integer>(7);
        BinaryTree<Integer> subDer5 = new BinaryTree<Integer>(8);

        subIzq2.addLeftChild(subIzq5);
        subIzq2.addRightChild(subDer5);

        //forma mas sintetica
        subDer2.addLeftChild(new BinaryTree<Integer>(5));
        subDer2.addRightChild(new BinaryTree<Integer>(6));

        //armado de rama der del arbol
        BinaryTree<Integer> subIzq3 = new BinaryTree<Integer>(9);
        BinaryTree<Integer> subDer3 = new BinaryTree<Integer>(8);

        subDer10.addLeftChild(subIzq3);
        subDer10.addRightChild(subDer3);

        subIzq3.addLeftChild(new BinaryTree<Integer>(12));
        subIzq3.addRightChild(new BinaryTree<Integer>(8));

        subDer3.addLeftChild(new BinaryTree<Integer>(2));
        subDer3.addRightChild(new BinaryTree<Integer>(1));

        //impresion preorden
        arbol.imprimir();

        ProfundidadDeArbolBinario pab= new ProfundidadDeArbolBinario(arbol);
        int profundidad = 2;

        System.out.println("");
        System.out.println("La suma de los nodos con profundidad "+ profundidad + " es: "+ pab.sumaElementosProfundidad(profundidad));
    }
}
