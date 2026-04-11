package AAAVarios.Parcial2024;
import tp2.ejercicio2.*;

public class mainParcialArboles {
    public static void main(String[] args) {
        BinaryTree <Integer> arbol = new BinaryTree<Integer>(1);

        BinaryTree <Integer> subIzq1 = new BinaryTree<Integer>(2);
        BinaryTree <Integer> subDer1 = new BinaryTree<Integer>(3);

        arbol.addLeftChild(subIzq1);
        arbol.addRightChild(subDer1);

        BinaryTree <Integer> subIzq2 = new BinaryTree<Integer>(4);

        subIzq1.addLeftChild(subIzq2);

        BinaryTree <Integer> subIzq3 = new BinaryTree<Integer>(5);
        BinaryTree <Integer> subDer3 = new BinaryTree<Integer>(6);

        subDer1.addLeftChild(subIzq3);
        subDer1.addRightChild(subDer3);

        subIzq3.addLeftChild(new BinaryTree<>(7));

        System.out.println("Impresion Preorden");
        arbol.imprimir();
        System.out.println();


        ParcialArboles pa = new ParcialArboles(arbol);

        BinaryTree<Integer> nuevoArbol =pa.nuevoTree();

        System.out.println("Impresion Preorden - Nuevo arbol");
        nuevoArbol.imprimir();
        System.out.println();


    }
    
}
