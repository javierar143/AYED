package tp3.ejercicio10;
import tp3.ejercicio1.*;
import java.util.ArrayList;
import java.util.List;

public class ParcialArbolesBacktracking {
    
    public static List<Integer> resolver(GeneralTree<Integer> arbol) {
        List<Integer> lista = new ArrayList<>();
        List<Integer> listaTemp = new ArrayList<>();
        int[] maxValor = new int[]{-1}; // los cambios los ven todos

        if (arbol != null && !arbol.isEmpty()) {
            armarLista(arbol, 0, 0, listaTemp, lista, maxValor);
        }

        return lista;
    }

    private static void armarLista(GeneralTree<Integer> nodo,  int nivel,  int valorActual,  List<Integer> listaTemporal,
                            List<Integer> lista,  int[] maxValor) {

        // incluir nodo actual
        valorActual += nodo.getData() * nivel;

        boolean agregue = false;//asi no se rompe en el backtracking cuando llega a la raiz del arbol
        if (nodo.getData().equals(1)) {
            listaTemporal.add(1);
            agregue = true;
        }

        if (nodo.isLeaf()) {
            if (valorActual > maxValor[0]) {
                maxValor[0] = valorActual;
                lista.clear();
                lista.addAll(listaTemporal); 
            }
        } else {
            nivel++;
            for (GeneralTree<Integer> hijo : nodo.getChildren()) {
                armarLista(hijo, nivel, valorActual, listaTemporal, lista, maxValor);
            }
        }
        
        if (agregue) {
            listaTemporal.remove(listaTemporal.size() - 1);
        }
    }
}

