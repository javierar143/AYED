package tp2.ejercicio2;

public class mainEj2 {
    //voy a crear el arbol del ejercicio
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


        arbol.imprimir();
        System.out.println();
        
        BinaryTree<Integer> espejo = arbol.espejo();

        espejo.imprimir();
        System.out.println();

        int n = 1;
        int m= 1;

        arbol.entreNiveles(n,m);
        System.out.println();

        espejo.entreNiveles(n,m);
        System.out.println();

        arbol.imprimirNiveles();
        System.out.println();

        espejo.imprimirNiveles();
        System.out.println();
        
    }
    

    /*public static void imprimir(BinaryTree<Integer> arbol){
        System.out.print(arbol.toString()+ " ");
        if (arbol.hasLeftChild()){
              imprimir(arbol.getLeftChild() );
        }
        if (arbol.hasRightChild()){
            imprimir(arbol.getRightChild() );
        }
    }*/

}
