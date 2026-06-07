package AAAVarios.Parciales.Parcial3erafecha130724;
import java.util.*;

import tp3.ejercicio1.*;

public class ParcialArboles {
    GeneralTree<Integer> arbol;

    public ParcialArboles(GeneralTree<Integer> arbol){
        this.arbol=arbol;

    }

    public List <List<Integer>> caminos(){
        List <List<Integer>> resultado= new ArrayList<>();
        List <Integer> listaTemp= new ArrayList<>();

        if (this.arbol !=null && !this.arbol.isEmpty())
            if (this.arbol.getData() % 2 == 0)  {                             
                buscaryArmarCaminos(arbol, resultado,listaTemp, 0, 0);
            }

        return resultado;
    }


    private void buscaryArmarCaminos (GeneralTree<Integer> tree,List <List<Integer>> resultado, 
        List <Integer> listaTemp,int cantPares, int cantImpares){
           
            if (cantPares < 2){
                int valor = tree.getData();
                if (valor % 2 == 0){
                    cantPares++;                   
                }
                else {
                    cantImpares++;
                    
                }
                listaTemp.add(valor);
            }
            if (cantPares == 2){
                if (cantImpares >0)
                    resultado.add(new ArrayList<>(listaTemp));                            
                }
            else{
                for (GeneralTree<Integer> hijo : tree.getChildren())
                    buscaryArmarCaminos(hijo, resultado, listaTemp, cantPares, cantImpares);
            }
        
            listaTemp.remove(listaTemp.size()-1);           

    }
}

    

