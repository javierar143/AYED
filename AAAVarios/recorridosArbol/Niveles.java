package recorridosArbol;

import tp1.ejercicio8.*;
import tp2.ejercicio2.*;

public class Niveles {

    public void imprimirNiveles(){
            Queue<BinaryTree<T>> cola = new Queue<>();
            cola.enqueue(this);

            while (!cola.isEmpty()){
                BinaryTree <T> nodo = cola.dequeue();
                System.out.println(nodo.getData());
                if (nodo.hasLeftChild()){
                    cola.enqueue(nodo.getLeftChild());
                }
                if (nodo.hasRightChild()){
                    cola.enqueue(nodo.getRightChild());
                }

            }

   }
}

/*
    public void porNiveles() {
        encolar(raíz);
        mientras (cola no se vacíe) {
            desencolar(v);
            imprimir (dato de v);
            si (tiene hijo_izquierdo)
                encolar(hijo_izquierdo);
            si (tiene hijo_derecho)
                encolar(hijo_derecho);
    }
}*/
/*
       8
     / \
    3   10
   / \
  1   6
  situaciones: e8 d8, e3 e10 d 3
  imprime: 8 
*/
