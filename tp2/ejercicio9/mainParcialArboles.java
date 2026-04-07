package tp2.ejercicio9;
import tp2.ejercicio2.*;

public class mainParcialArboles {
    public static void main(String[] args) {
        BinaryTree<Integer> arbol = new BinaryTree<Integer>(20);

        BinaryTree<Integer> subIzq20 = new BinaryTree<Integer>(5);
        BinaryTree<Integer> subDer20 = new BinaryTree<Integer>(30);

        // hijos de arbol principal
        arbol.addLeftChild(subIzq20);
        arbol.addRightChild(subDer20);

        // armado de rama izq del arbol
        BinaryTree<Integer> subIzq5 = new BinaryTree<Integer>(-5);
        BinaryTree<Integer> subDer5 = new BinaryTree<Integer>(10);

        subIzq20.addLeftChild(subIzq5);
        subIzq20.addRightChild(subDer5);

        // hijo izquierdo de 10 (usando forma más sintética)
        subDer5.addLeftChild(new BinaryTree<Integer>(1));

        // armado de rama der del arbol
        BinaryTree<Integer> subIzq30 = new BinaryTree<Integer>(50);
        BinaryTree<Integer> subDer30 = new BinaryTree<Integer>(-9);

        subDer20.addLeftChild(subIzq30);
        subDer20.addRightChild(subDer30);

        // hijo derecho de 50
        BinaryTree<Integer> subDer50 = new BinaryTree<Integer>(4);
        
        subIzq30.addRightChild(subDer50);

        // hijo derecho de 4 (usando forma más sintética)
        subDer50.addRightChild(new BinaryTree<Integer>(6));

        System.out.println("Arbol 1 ");
        //impresion preorden
        arbol.imprimir();
        System.out.println();

        ParcialArboles pa = new ParcialArboles();
        

        System.out.println("Arbol 2 ");
        //impresion preorden
        imprimirArbolDeObjetos(pa.sumAndDif(arbol));
        System.out.println();


    }


    public static void imprimirArbolDeObjetos(BinaryTree<Data> arbol){
        System.out.print(arbol.getData().getAcumulado()+"|"+arbol.getData().getDiferencia() + " ");
        		
		if (arbol.hasLeftChild()){
            imprimirArbolDeObjetos(arbol.getLeftChild()); 
        }
        if (arbol.hasRightChild()){
            imprimirArbolDeObjetos (arbol.getRightChild());
        }
    }
}
