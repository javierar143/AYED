package tp3.ejercicio7;
import java.util.ArrayList;
import java.util.List;

import tp3.ejercicio1.*;

public class Caminos {
    GeneralTree<Integer> arbol;

    public Caminos(GeneralTree<Integer> arbol) {
        this.arbol = arbol;
    }
    
    public List<Integer> caminoAHojaMasLejana (){
        List<Integer> lista= new ArrayList<>();
        List<Integer> listaTemp = new ArrayList<>();
        if (this.arbol != null && !this.arbol.isEmpty())
            armarCaminoMasLargo(this.arbol,lista,listaTemp);
        return lista;
    }

    private void armarCaminoMasLargo(GeneralTree<Integer> tree, List<Integer> lista, List<Integer> listaTemp) {
        listaTemp.add(tree.getData());
        if (tree.isLeaf()){
            if (listaTemp.size() > lista.size()){
                lista.clear();
                lista.addAll(listaTemp);            
            }            
        }
        else {
            for (GeneralTree<Integer> hijo : tree.getChildren()){
                armarCaminoMasLargo(hijo, lista, listaTemp) ;                
            }
        }
        listaTemp.remove(listaTemp.size()-1);
    }

    //----------------------------Version construir lista hacia arriba--------------------------------------
    //------------------------------------------------------------------------------------------------------

    public List<Integer> caminoAHojaMasLejanaHaciaArriba (){
        List<Integer> lista= new ArrayList<>();
        
        if (this.arbol != null && !this.arbol.isEmpty())
            lista = armarCaminoMasLargoArriba(this.arbol);
        return lista;
    }

    private List<Integer> armarCaminoMasLargoArriba(GeneralTree<Integer> tree) {
        List <Integer> listaLarga =new ArrayList<>();
        if (tree.isLeaf()){
           listaLarga.add(tree.getData());          
        }
        else {
           
            for (GeneralTree<Integer> hijo : tree.getChildren()){
                List <Integer> listaHijo = armarCaminoMasLargoArriba(hijo);
                if (listaHijo.size()>listaLarga.size()){
                    listaLarga.clear();                                    
                    listaLarga.addAll(listaHijo);       
                }       

            }
            listaLarga.add(0, tree.getData());
        }        

        return listaLarga;
    }


    
    
}
