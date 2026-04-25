package tp3.ejercicio8;
import java.util.*;



import tp3.ejercicio1.*;

public class Navidad {
    GeneralTree<Integer> arbol;

    public Navidad(GeneralTree<Integer> arbol) {
        this.arbol = arbol;
    }

    public String esAbetoNavidenio(){
        String resultado = "NO ES abeto";
        if (this.arbol !=null && !this.arbol.isEmpty() )
           if (esAbeto(this.arbol))
                   resultado= "Es Abeto Navideño";

        return resultado;
    }

    private boolean esAbeto(GeneralTree<Integer> tree) {
        boolean cumple= true;

        if (!tree.isLeaf()){
            List<GeneralTree<Integer>> lista = tree.getChildren();
            if (!sonTresHojas (lista)){
                cumple=false;
            }
        }
        return cumple;
    }

    private boolean sonTresHojas(List<GeneralTree<Integer>> lista) {
        Iterator <GeneralTree<Integer>> it = lista.iterator();
        int hojas=0;
        boolean cumple = true;
        while (it.hasNext() && cumple ) {
            GeneralTree<Integer> nodo = it.next();
            if (nodo.isLeaf() ){
                hojas++;                
            }
            else {
                cumple = esAbeto(nodo);
            }
        }

       return hojas >=3 && cumple;
    }
}
