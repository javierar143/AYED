package tp2.ejercicio3;
import java.util.ArrayList;
import java.util.List;

import tp2.ejercicio2.*;


public class mainCOntadorArboles {
    public static void main(String[] args) {
        BinaryTree <Integer> arbol = new BinaryTree<>(1);

        BinaryTree <Integer> subIzq = new BinaryTree<>(2);

        BinaryTree <Integer> subDer = new BinaryTree<>(3);
        
        arbol.addLeftChild(subIzq);

        arbol.addRightChild(subDer);

        BinaryTree <Integer> subIzq2 = new BinaryTree<>(4);

        BinaryTree <Integer> subDer2 = new BinaryTree<>(5);


        subIzq.addLeftChild(subIzq2);

        subIzq.addRightChild(subDer2);

        BinaryTree <Integer> subIzq3 = new BinaryTree<>(6);

        subDer.addLeftChild(subIzq3);

        List <Integer> listaA = new ArrayList<>();
        List <Integer> listaB = new ArrayList<>();
        
        ContadorArbol ca= new ContadorArbol(arbol);

        listaA= ca.numerosParesA();
        listaB= ca.numerosParesB();

        //imprime inOrder
        System.out.println("Impresion InOrden");
        imprimir (listaA);

        System.out.println("Impresion PostOrden");
        imprimir (listaB);


       
        

    }

    public static void imprimir (List<Integer> lista){
        for (Integer numero : lista) 
            System.out.print(numero + " ");

        System.out.println();
    }
}
