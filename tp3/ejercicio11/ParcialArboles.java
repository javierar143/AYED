package tp3.ejercicio11;
import tp3.ejercicio1.*;
import tp1.ejercicio8.*;

public class ParcialArboles {
    public static boolean resolver(GeneralTree<Integer> arbol){
        boolean esCreciente=true;
        if (arbol ==null || arbol.isEmpty())
            esCreciente=false;
        else{
            Queue <GeneralTree<Integer>> cola = new Queue();
            GeneralTree<Integer> tree;
            int nodos=0;
            int nivel=0;

            cola.enqueue(arbol);
            cola.enqueue(null);

            while (!cola.isEmpty() && esCreciente){
                tree= cola.dequeue();
                if (tree !=null ){                    
                    nodos++;
                    for (GeneralTree<Integer> hijo : tree.getChildren())
                        cola.enqueue(hijo);
                }
                else{
                    if (nodos != (nivel +1))
                        esCreciente=false;
                    if(!cola.isEmpty()){
                        nodos=0;
                        nivel++;
                        cola.enqueue(null);
                    }

                }
            }
        }


        return esCreciente;
    }
}
