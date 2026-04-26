package tp3.ejercicio9;
import java.util.Iterator;
import java.util.List;

import tp3.ejercicio1.*;

public class ParcialArboles {

    public static boolean esDeSeleccion (GeneralTree<Integer> arbol){
        boolean cumple= false;
        if (arbol != null && !arbol.isEmpty())
            cumple = verificarEsDeSeleccion(arbol);

        return cumple;
    }

    private static boolean verificarEsDeSeleccion(GeneralTree<Integer> tree) {
        boolean cumple = true;
        if (!tree.isLeaf()){
            Integer minimo= Integer.MAX_VALUE;
            Iterator<GeneralTree<Integer>> it= tree.getChildren().iterator();
            
            while (it.hasNext() && cumple){
                GeneralTree<Integer> nodo= it.next();
                int valor = nodo.getData();
                cumple= verificarEsDeSeleccion(nodo);
                if ( valor < minimo)
                    minimo= valor;

            }
            if (!minimo.equals(tree.getData()))
                cumple=false;            
        }
            return cumple;
        }
        
}

