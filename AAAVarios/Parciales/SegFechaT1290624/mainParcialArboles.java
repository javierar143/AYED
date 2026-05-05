package AAAVarios.Parciales.SegFechaT1290624;

import tp2.ejercicio2.*;

public class mainParcialArboles {
    public static void main(String[] args) {
        BinaryTree<Integer> arbol = new BinaryTree<Integer>(1);

        BinaryTree<Integer> subIzq1 = new BinaryTree<Integer>(2);
        BinaryTree<Integer> subDer1 = new BinaryTree<Integer>(3);

        // hijos de arbol principal
        arbol.addLeftChild(subIzq1);
        arbol.addRightChild(subDer1);

        // armado de rama izq del arbol
        BinaryTree<Integer> subIzq2 = new BinaryTree<Integer>(4);
        subIzq1.addLeftChild(subIzq2);

        // armado de rama der del arbol
        BinaryTree<Integer> subIzq3 = new BinaryTree<Integer>(5);
        BinaryTree<Integer> subDer3 = new BinaryTree<Integer>(6);

        subDer1.addLeftChild(subIzq3);
        subDer1.addRightChild(subDer3);
        
        subIzq3.addLeftChild(new BinaryTree<Integer>(7));

        System.out.println("Arbol 1 ");
        //impresion preorden
        arbol.imprimir();
        System.out.println();

        ParcialArboles pa = new ParcialArboles(arbol);
        

        System.out.println("Arbol NuevoTree ");
        //impresion preorden
        pa.nuevoTree().imprimir();
        System.out.println();


}
}
