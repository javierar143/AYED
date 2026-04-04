package tp2.ejercicio5;
import tp2.ejercicio2.*;
import tp1.ejercicio8.*;

public class ProfundidadDeArbolBinario {
    BinaryTree<Integer> arbol;

    public ProfundidadDeArbolBinario(BinaryTree<Integer> arbol) {
        this.arbol = arbol;
    }

    public int sumaElementosProfundidad (int p){
        int suma =0;
        int nivel=0;
        int cantidad=0;
        
        if (this.arbol != null) {
            Queue <BinaryTree<Integer>> cola = new Queue<>(); 
            cola.enqueue(this.arbol);

            while (!cola.isEmpty() && nivel <= p){
                cantidad = cola.size();
                for (int i=0; i<cantidad;i++){
                    BinaryTree<Integer> nodo = cola.dequeue();

                    if (nivel == p){
                        suma += nodo.getData();
                    }
                    if (nodo.hasLeftChild())
                        cola.enqueue(nodo.getLeftChild());
                    if (nodo.hasRightChild())
                        cola.enqueue(nodo.getRightChild());
                }
                
                nivel++;
            }

        }      

        return suma;
    }


    //solucion en profundidad
    public int sumaElementosProfundidadB(int p) {
        int suma;
        int nivelActual =0;
        if (this.arbol == null) suma= 0;
        suma= sumaRecursiva(this.arbol, nivelActual, p);
    return suma;
}

    private int sumaRecursiva(BinaryTree<Integer> tree, int nivelActual, int p) {
        int suma = 0;

        if (nivelActual == p) {
            suma = tree.getData();
        } else {
            if (tree.hasLeftChild())
                suma += sumaRecursiva(tree.getLeftChild(), ++nivelActual, p);

            if (tree.hasRightChild())
                suma += sumaRecursiva(tree.getRightChild(), nivelActual + 1, p);
        }

        return suma;
    }

    

}
