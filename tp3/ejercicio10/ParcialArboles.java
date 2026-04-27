package tp3.ejercicio10;
import tp3.ejercicio1.*;

import java.util.ArrayList;
import java.util.List;

public class ParcialArboles {
    public static List<Integer> resolver(GeneralTree<Integer> arbol){
        List <Integer> lista = new ArrayList<>();
        List <Integer> listaTemporal = new ArrayList<>();
        ResultadoCamino rc = new ResultadoCamino(0, listaTemporal);
     
      
        if (arbol!=null && !arbol.isEmpty()){
            rc= armarLista(arbol,0,0);
            lista.addAll(rc.getListaTemporal());
        }

      return lista;
    }

    private static ResultadoCamino armarLista(GeneralTree<Integer> tree,int nivel,int valorActual) {
            valorActual+= tree.getData() * nivel;
            ResultadoCamino rc = new ResultadoCamino();   
            if (tree.isLeaf()){
                 
                rc.setValor(valorActual);
                if (tree.getData().equals(1))
                    rc.getListaTemporal().add(1);              
            }
            
            else{
                nivel++;
                int maxValor=-1;
                
                for (GeneralTree <Integer> nodo : tree.getChildren()){
                    ResultadoCamino resultadoHijo = armarLista(nodo,nivel,valorActual);
                    if (resultadoHijo.getValor() > maxValor){
                        maxValor=resultadoHijo.getValor();
                        rc.getListaTemporal().clear();
                        rc.getListaTemporal().addAll(resultadoHijo.getListaTemporal());
                        rc.setValor(maxValor); 
                    }                    
                }
                if (tree.getData().equals(1))
                    rc.getListaTemporal().add(0,1);

            }           

            return rc;
        }

}
