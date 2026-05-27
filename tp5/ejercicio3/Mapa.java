package tp5.ejercicio3;
import java.util.*;

import tp5.ejercicio1.*;
import tp1.ejercicio8.Queue;


public class Mapa {
    private Graph <String> mapaCiudades;

    public Mapa(Graph<String> mapaCiudades) {
        this.mapaCiudades = mapaCiudades;
    }


    //Ejercicio 3.1
    public List<String> devolverCamino(String ciudad1, String ciudad2){
        List<String> camino = new ArrayList<>();
        List <String> listaTemp = new ArrayList<>();
        boolean[] marca = new boolean[this.mapaCiudades.getSize()];
        
        if (!this.mapaCiudades.isEmpty()){
            Vertex<String> verticeIncio= mapaCiudades.search(ciudad1);
            Vertex<String> verticeFin= mapaCiudades.search(ciudad2);
            if (verticeIncio!=null && verticeFin!=null){
                int pos = verticeIncio.getPosition();
                marca[pos]= true;
                listaTemp.add(ciudad1);
                dfsBuscarCamino(pos, this.mapaCiudades, ciudad2, marca, listaTemp, camino);
            }
        }
        
        return camino;
    }

    private void dfsBuscarCamino(int pos, Graph<String> mapaCiudades, String ciudad2 ,boolean[] marca, List<String> listaTemp,
            List<String> camino) {
        int j;
        Vertex<String> verticeIncio = mapaCiudades.getVertex(pos);
        List <Edge<String>> aristas = mapaCiudades.getEdges(verticeIncio);
       
        Iterator <Edge<String>>  it= aristas.iterator();

        while (it.hasNext() && camino.isEmpty()){//si esta vacia la lista camino significa q aun se debe seguir explorando
            Vertex<String> verticeNuevo = it.next().getTarget();
            j= verticeNuevo.getPosition();
            if (!marca[j]) {            
                marca[j]=true;
                listaTemp.add(verticeNuevo.getData());            

                if (verticeNuevo.getData().equals(ciudad2)){
                    camino.addAll(listaTemp);                    
                }
                else{                 
                        dfsBuscarCamino(j, mapaCiudades, ciudad2, marca, listaTemp, camino);
                    }
                if (camino.isEmpty()){ //si esta vacia la lista camino significa q aun se debe seguir explorando
                    listaTemp.remove(listaTemp.size()-1);
                    marca[j]=false;
                }
        }     

        }
    }

    //---------------------------------------------------------------------------------------------------
    //Ejercicio 3.2
    public List <String> devolverCaminoExceptuando(String ciudad1, String ciudad2, List<String> ciudades){
        List<String> camino = new ArrayList<>();
        List <String> listaTemp = new ArrayList<>();
        boolean[] marca = new boolean[this.mapaCiudades.getSize()];
        
        if (!this.mapaCiudades.isEmpty() && !ciudad1.equals(ciudad2)){
            Vertex<String> verticeIncio= this.mapaCiudades.search(ciudad1);
            Vertex<String> verticeFin= this.mapaCiudades.search(ciudad2);
            if (verticeIncio!=null && verticeFin!=null && !ciudades.contains(ciudad1) && !ciudades.contains(ciudad2) ){
                int pos = verticeIncio.getPosition();
                marca[pos]= true;
                listaTemp.add(ciudad1);
                dfsBuscarCaminoExceptuando(pos, this.mapaCiudades, ciudad2, marca, listaTemp, camino, ciudades);
            }
        
        }
        return camino;
    }


    private void dfsBuscarCaminoExceptuando(int pos, Graph<String> mapaCiudades, String ciudad2, boolean[] marca,
            List<String> listaTemp, List<String> camino, List<String> ciudades) {
        int j;
        Vertex<String> verticeInicio = mapaCiudades.getVertex(pos);
        List <Edge<String>> aristas = mapaCiudades.getEdges(verticeInicio);
       
        Iterator <Edge<String>>  it= aristas.iterator();

        while (it.hasNext() && camino.isEmpty()){//si esta vacia la lista camino significa q aun se debe seguir explorando
            Vertex<String> verticeNuevo = it.next().getTarget();
            j= verticeNuevo.getPosition();
            if (!marca[j] && !ciudades.contains(verticeNuevo.getData())) {            
                marca[j]=true;
                listaTemp.add(verticeNuevo.getData());            

                if (verticeNuevo.getData().equals(ciudad2)){
                    camino.addAll(listaTemp);                    
                }
                else{                 
                        dfsBuscarCaminoExceptuando(j, mapaCiudades, ciudad2, marca, listaTemp, camino,ciudades);
                    }
                if (camino.isEmpty()){ //si esta vacia la lista camino significa q aun se debe seguir explorando
                    listaTemp.remove(listaTemp.size()-1);
                    marca[j]=false;
                }
            }            

       }   

    }

    //-----------------------------------------------------------------------------
    //Ejercicio 3.3
    


}//este es el cierre de la clase


   
