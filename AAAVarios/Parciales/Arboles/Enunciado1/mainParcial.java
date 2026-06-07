package AAAVarios.Parciales.Enunciado1;
import tp2.ejercicio2.*;

public class mainParcial {
    public static void main(String[] args) {
        BinaryTree <Integer> arbol = new BinaryTree<Integer>(2);

        BinaryTree <Integer> subIzq2 = new BinaryTree<Integer>(1);
        
        arbol.addLeftChild(subIzq2);
        
        BinaryTree <Integer> subIzq1 = new BinaryTree<Integer>(5);
        BinaryTree <Integer> subDer1 = new BinaryTree<Integer>(4);

        subIzq2.addLeftChild(subIzq1);
        subIzq2.addRightChild(subDer1);

        BinaryTree <Integer> subIzq4 = new BinaryTree<Integer>(1);
        BinaryTree <Integer> subDer4 = new BinaryTree<Integer>(1);

        subDer1.addLeftChild(subIzq4);
        subDer1.addRightChild(subDer4);

        //----------
        //rama der
        BinaryTree <Integer> SubDer2 = new BinaryTree<Integer>(2);
        arbol.addRightChild(SubDer2);

        BinaryTree <Integer> SubIzq2b = new BinaryTree<Integer>(1);
        //para que no de monodistante, comentar la linea de arriba y descomentar la de abajo
        //BinaryTree <Integer> SubIzq2b = new BinaryTree<Integer>(7);

        BinaryTree <Integer> SubDer2b = new BinaryTree<Integer>(2);

        SubDer2.addLeftChild(SubIzq2b);
        SubDer2.addRightChild(SubDer2b);

        SubIzq2b.addLeftChild(new BinaryTree<Integer>(3));

        SubDer2b.addRightChild(new BinaryTree<Integer>(2));


        System.out.println();
        System.out.println("Impresion preorden");
        arbol.imprimir();
        System.out.println();

        int mandato = 8;

        Parcial p = new Parcial(arbol);

        if (p.resolver(mandato)){
            System.out.println("Es monodistante de " + mandato );
        }
        else System.out.println("NO ES monodistante de " + mandato);

    }
}
