package AAAVarios.Parciales.ParcialAGNiveles;
import tp2.ejercicio2.*;


public class mainPANiveles {
    public static void main(String[] args) {
        // Nivel 3 (hojas)
        BinaryTree<Integer> hoja5  = new BinaryTree<>(5);
        BinaryTree<Integer> hoja11 = new BinaryTree<>(11);
        BinaryTree<Integer> hoja4  = new BinaryTree<>(4);

        // Nivel 2
        BinaryTree<Integer> hoja2 = new BinaryTree<>(2); // hoja
        BinaryTree<Integer> nodo6 = new BinaryTree<>(6);
        BinaryTree<Integer> nodo9 = new BinaryTree<>(9);

        nodo6.addLeftChild(hoja5);
        nodo6.addRightChild(hoja11);

        nodo9.addLeftChild(hoja4); // solo hijo izquierdo

        // Nivel 1
        BinaryTree<Integer> nodo7 = new BinaryTree<>(7);
        BinaryTree<Integer> nodo5 = new BinaryTree<>(5);

        nodo7.addLeftChild(hoja2);
        nodo7.addRightChild(nodo6);

        nodo5.addRightChild(nodo9); // sin hijo izquierdo

        // Raíz
        BinaryTree<Integer> arbol = new BinaryTree<>(2);
        arbol.addLeftChild(nodo7);
        arbol.addRightChild(nodo5);

        // --- Tests ---
        // nivel 1 → null (7 y 5 no son hojas)
        // nivel 2 → 2    (única hoja)
        // nivel 3 → 4    (menor entre 5, 11, 4)

        // Prueba rápida
        System.out.println("PreOrden: ");
        arbol.imprimir();
        System.out.println();

        
        NivelArbolBinario na = new NivelArbolBinario(arbol);
        int nivel =2;
        BinaryTree<Integer> tree = na.minEnArbolDeAB(nivel);
        if (tree !=null){
            System.out.println("Arbol Minimo: ");
            tree.imprimir();
            System.out.println();
            System.out.println("----------------------FIN ARBOL MINIMO----------------------------");
        }
        else System.out.println("----------------------NO EXITE ARBOL MINIMO----------------------------");
    }
}
