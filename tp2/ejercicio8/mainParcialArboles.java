package tp2.ejercicio8;

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
        BinaryTree<Integer> subIzq7a = new BinaryTree<Integer>(23);
        BinaryTree<Integer> subDer7a = new BinaryTree<Integer>(6);

        subIzq2.addLeftChild(subIzq7a);
        subIzq2.addRightChild(subDer7a);

        BinaryTree<Integer> subIzq23 = new BinaryTree<Integer>(-3);
        
        subIzq7a.addLeftChild(subIzq23);
        //forma mas sintetica
        subDer7a.addLeftChild(new BinaryTree<Integer>(55));
        subDer7a.addRightChild(new BinaryTree<Integer>(11));

        //armado de rama der del arbol
        BinaryTree<Integer> subIzqM5 = new BinaryTree<Integer>(19);
        
        subDer2.addLeftChild(subIzqM5);
        
        BinaryTree<Integer> subDer19 = new BinaryTree<Integer>(4);
               
        subIzqM5.addRightChild(subDer19);

        subDer19.addLeftChild(new BinaryTree<Integer>(18));
        
        //nodos extra para que falle el metodo esPrefijo############------------------------
        /*
        BinaryTree<Integer> subDer23 = new BinaryTree<Integer>(3);
        subIzq7a.addRightChild(subDer23);
        */
        //----------------------------------------------------------------------------------


        System.out.println("Arbol 1 ");
        //impresion preorden
        arbol.imprimir();
        System.out.println();


        //arbol 2-------------------------------------------------
        //######################################################
        BinaryTree<Integer> arbol2 = new BinaryTree<Integer>(2);

        BinaryTree<Integer> a2_subIzq2 = new BinaryTree<Integer>(7);
        BinaryTree<Integer> a2_subDer2 = new BinaryTree<Integer>(-5);

        // Hijos de arbol2 principal
        arbol2.addLeftChild(a2_subIzq2);
        arbol2.addRightChild(a2_subDer2);

        // --- Armado de rama izquierda del arbol2 (hijos del 7) ---
        BinaryTree<Integer> a2_subIzq7 = new BinaryTree<Integer>(23);
        BinaryTree<Integer> a2_subDer7 = new BinaryTree<Integer>(6);

        a2_subIzq2.addLeftChild(a2_subIzq7);
        a2_subIzq2.addRightChild(a2_subDer7);

        // Hijo del 23 (Agregamos solo el -3 izquierdo. ¡Omitimos el 3 derecho!)
        BinaryTree<Integer> a2_subIzq23 = new BinaryTree<Integer>(-3);
        a2_subIzq7.addLeftChild(a2_subIzq23);
        
        // Hijos del 6
        a2_subDer7.addLeftChild(new BinaryTree<Integer>(55));
        a2_subDer7.addRightChild(new BinaryTree<Integer>(11));

        // --- Armado de rama derecha del arbol2 (hijos del -5) ---
        BinaryTree<Integer> a2_subIzqM5 = new BinaryTree<Integer>(19);
        a2_subDer2.addLeftChild(a2_subIzqM5);
        
        // ¡NODO EXTRA AGREGADO! Rama derecha del -5 con un número único (99)
        BinaryTree<Integer> a2_subDerM5_nuevo = new BinaryTree<Integer>(99);
        a2_subDer2.addRightChild(a2_subDerM5_nuevo);

        // Hijos del 19
        BinaryTree<Integer> a2_subDer19 = new BinaryTree<Integer>(4);
        a2_subIzqM5.addRightChild(a2_subDer19);

        // Hijos del 4
        a2_subDer19.addLeftChild(new BinaryTree<Integer>(18));
        // ---------------------------------------------------------------------            
        
        
        System.out.println("Arbol 2 ");
        //impresion preorden
        arbol2.imprimir();
        System.out.println();

        ParcialArboles pa = new ParcialArboles();

        System.out.println();
        System.out.println(pa.esPrefijo(arbol, arbol2) ? "Arbol1 es prefijo de Arbol 2" : "NO es prefijo 1 de 2");
        
    }

    
}

