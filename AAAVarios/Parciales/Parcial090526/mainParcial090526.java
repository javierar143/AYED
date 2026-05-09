package AAAVarios.Parciales.Parcial090526;
import tp2.ejercicio2.*;

public class mainParcial090526 {
    public static void main(String[] args) {
       BinaryTree<Integer> arbol = new BinaryTree<>(2);

    // Nivel 1
    BinaryTree<Integer> nodo3 = new BinaryTree<>(3);
    BinaryTree<Integer> nodo5 = new BinaryTree<>(5);
    arbol.addLeftChild(nodo3);
    arbol.addRightChild(nodo5);

    // Nivel 2 - hijos de 3
    BinaryTree<Integer> nodo1 = new BinaryTree<>(1);
    BinaryTree<Integer> nodo6 = new BinaryTree<>(6);
    nodo3.addLeftChild(nodo1);
    nodo3.addRightChild(nodo6);

    // Nivel 3 - hijos de 6
    BinaryTree<Integer> nodo7 = new BinaryTree<>(7);
    BinaryTree<Integer> nodo4 = new BinaryTree<>(4);
    nodo6.addLeftChild(nodo7);
    nodo6.addRightChild(nodo4);

    // Nivel 2 - hijo de 5
    BinaryTree<Integer> nodo8 = new BinaryTree<>(8);
    nodo5.addRightChild(nodo8); 

    System.out.println("Arbol 1 ");
    //impresion preorden
    arbol.imprimir();
    System.out.println();

    System.out.println("-------------DIFERENCIA DE PARES IMPARES---------------------");
   
    System.out.println("La diferencia es " + ParcialArboles.diferenciaParesImpares(arbol) );
    System.out.println("--------------------------------------------------------------");


    }
}
