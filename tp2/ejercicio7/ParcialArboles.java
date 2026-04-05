package tp2.ejercicio7;
import tp2.ejercicio2.*;

public class ParcialArboles {
    BinaryTree<Integer> arbol;

    public ParcialArboles(BinaryTree<Integer> arbol) {
        this.arbol = arbol;
    }

    public boolean isLeftTree(int num) {
        // arreglo para guardar el resultado
        boolean[] resultado = new boolean[1]; // Por defecto se inicializa en false

        if (this.arbol != null) {
            buscarArbol(this.arbol, num, resultado);
        }

        return resultado[0];
    }

    private int buscarArbol(BinaryTree<Integer> nodo, int num, boolean[] resultado) {
        int izq = 0;
        int der = 0;
        
        if (nodo.hasLeftChild()) {
            izq = buscarArbol(nodo.getLeftChild(), num, resultado);
        }
        if (nodo.hasRightChild()) {
            der = buscarArbol(nodo.getRightChild(), num, resultado);
        }

        //  Evaluar si es el nodo buscado
        if (nodo.getData() == num) {
            int cantIzq = nodo.hasLeftChild() ? izq : -1;
            int cantDer = nodo.hasRightChild() ? der : -1;

            // se Guarda el resultado de la comparación en el  arreglo
            resultado[0] = (cantIzq > cantDer); 
        }

        // cantidad de nodos con 1 hijo de ESTE subárbol
        int total = izq + der; // Siempre sumo lo que arrastro de mis hijos

        // Si el nodo actual tiene exactamente un hijo, se suma a la cuenta
        if ((nodo.hasLeftChild() && !nodo.hasRightChild()) || (!nodo.hasLeftChild() && nodo.hasRightChild())) {
            total++;
        }

        
        return total;
    }
}


       