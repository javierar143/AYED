package tp2.ejercicio7;
import tp2.ejercicio2.*;

public class ParcialArboles {
    BinaryTree<Integer> arbol;

    public ParcialArboles(BinaryTree<Integer> arbol) {
        this.arbol = arbol;
    }

    public boolean isLeftTree(int num) {
        // arreglo para guardar el resultado
        boolean resultado =false;
       // Por defecto se inicializa en false

        if (this.arbol != null) {
            BinaryTree<Integer>tree= buscarArbol(this.arbol,num);
            int izq=0;
            int der=0;;
            if (!tree.isEmpty()){
                if (tree.hasLeftChild())
                    izq=procesarArbol(tree.getLeftChild());
                else izq = -1; 

                if (tree.hasRightChild())
                    der=procesarArbol(tree.getRightChild());
                else der= -1;
                resultado=(izq>der);
            }
               
        }

        return resultado;
    }

    private BinaryTree<Integer> buscarArbol(BinaryTree<Integer> nodo,int num) {
        boolean encontre= false;
        BinaryTree<Integer> tree= new BinaryTree<>();
                if (nodo.getData() == num) {
                    encontre=true;
                    tree=nodo;
                }
                else{
                    if (nodo.hasLeftChild()) {
                        tree = buscarArbol(nodo.getLeftChild(), num);
                        encontre= !tree.isEmpty();
                }
                    if (!encontre && nodo.hasRightChild()) {
                        tree = buscarArbol(nodo.getRightChild(), num);
                    }

                }        
        return tree;
    }

    private int procesarArbol(BinaryTree<Integer>nodo){
        int izq = 0;
        int der = 0;
        //  Evaluar si es el nodo buscado
        if (nodo.hasLeftChild()) 
                izq = procesarArbol(nodo.getLeftChild());
                        
                
        if (nodo.hasRightChild()) 
                der = procesarArbol(nodo.getRightChild());
                    
        // cantidad de nodos con 1 hijo de ESTE subárbol
        int total = izq + der; // Siempre sumo lo que arrastro de mis hijos

        // Si el nodo actual tiene exactamente un hijo, se suma a la cuenta
        if ((nodo.hasLeftChild() && !nodo.hasRightChild()) || (!nodo.hasLeftChild() && nodo.hasRightChild())) {
            total++;
        }

        return total;
    }
}


       