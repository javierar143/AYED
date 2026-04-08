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

        System.out.println("Arbol principal: ");
        arbol.imprimir();
        System.out.println();
        
        BinaryTree<Integer> espejo = arbol.espejo();

        System.out.println("Arbol Espejo: ");
        espejo.imprimir();
        System.out.println();

        //parametros de los niveles
        int n = 1;
        int m= 2;

        System.out.println("Arbol principal entre Niveles: "+ n +" y "+ m);
        arbol.entreNiveles(n,m);
        System.out.println();

        System.out.println("Arbol espejo entre Niveles: "+ n +" y "+ m);
        espejo.entreNiveles(n,m);
        System.out.println();

        System.out.println("Arbol principal por Niveles: ");
        arbol.imprimirNiveles();
        System.out.println();

        System.out.println("Arbol Espejo por Niveles: ");
        espejo.imprimirNiveles();
        System.out.println();

        System.out.println("La cantidad de hojas que posee el arbol principal es: "+ arbol.contarHojas());
        
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
