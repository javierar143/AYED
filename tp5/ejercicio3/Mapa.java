package tp5.ejercicio3;
import java.util.*;
import java.util.concurrent.TransferQueue;

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
    public List <String> caminoMasCorto(String ciudad1, String ciudad2){
        List<String> camino = new ArrayList<>();
        List <String> listaTemp = new ArrayList<>();
        boolean[] marca = new boolean[this.mapaCiudades.getSize()];
        
        if (!this.mapaCiudades.isEmpty() && !ciudad1.equals(ciudad2)){
            Vertex<String> verticeInicio= this.mapaCiudades.search(ciudad1);
            Vertex<String> verticeFin= this.mapaCiudades.search(ciudad2);
            DataMasCorto data = new DataMasCorto();
            
            if (verticeInicio!=null && verticeFin!=null){
                int pos = verticeInicio.getPosition();
                marca[pos]= true;
                listaTemp.add(ciudad1);
                dfsBuscarCaminoMasCorto(pos, this.mapaCiudades, ciudad2, marca, listaTemp, camino, data);
            }
        
        }
        return camino;
    }


    private void dfsBuscarCaminoMasCorto(int pos, Graph<String> mapaCiudades, String ciudad2, boolean[] marca,
            List<String> listaTemp, List<String> camino, DataMasCorto data) {
        int j;    
        Vertex<String> verticeInicio = mapaCiudades.getVertex(pos);
        List <Edge<String>> aristas = mapaCiudades.getEdges(verticeInicio);
        
        Iterator <Edge<String>>  it= aristas.iterator();

        while (it.hasNext()){
            Edge<String> arista = it.next();
            Vertex<String> verticeNuevo = arista.getTarget();
            j= verticeNuevo.getPosition();
            int distancia  = arista.getWeight();
            data.setDistanciaAcumulada(data.getDistanciaAcumulada()+distancia);

            if (!marca[j] && data.getDistanciaAcumulada() < data.getMinDistancia()) {            
                marca[j]=true;
                listaTemp.add(verticeNuevo.getData());            
                
                if (verticeNuevo.getData().equals(ciudad2)){
                    data.setMinDistancia(data.getDistanciaAcumulada());
                    camino.clear();
                    camino.addAll(listaTemp);                    
                }
                else{                 
                        dfsBuscarCaminoMasCorto(j, mapaCiudades, ciudad2, marca, listaTemp, camino,data);
                    }
                listaTemp.remove(listaTemp.size()-1);
                marca[j]=false;                

                }
            data.setDistanciaAcumulada(data.getDistanciaAcumulada()-distancia);   
            }           
    }


    //-----------------------------------------------------------------------------
    //Ejercicio 3.4

    public List<String> caminoSinCargarCombustible(String ciudad1, String ciudad2, int tanqueAuto){
        List<String> camino = new ArrayList<>();
        List <String> listaTemp = new ArrayList<>();
        boolean[] marca = new boolean[this.mapaCiudades.getSize()];
        
        if (!this.mapaCiudades.isEmpty() && !ciudad1.equals(ciudad2)){
            Vertex<String> verticeInicio= this.mapaCiudades.search(ciudad1);
            Vertex<String> verticeFin= this.mapaCiudades.search(ciudad2);            
            
            if (verticeInicio!=null && verticeFin!=null){
                int pos = verticeInicio.getPosition();
                marca[pos]= true;
                listaTemp.add(ciudad1);
                dfsBuscarCaminoSinCargarCombustible(pos, this.mapaCiudades, ciudad2, marca, listaTemp, camino, tanqueAuto);
            }        
        }
        return camino;
    }


    private void dfsBuscarCaminoSinCargarCombustible(int pos, Graph<String> mapaCiudades, String ciudad2,
            boolean[] marca, List<String> listaTemp, List<String> camino, int tanqueAuto) {
        int j;    
        Vertex<String> verticeInicio = mapaCiudades.getVertex(pos);
        List <Edge<String>> aristas = mapaCiudades.getEdges(verticeInicio);
        
        Iterator <Edge<String>>  it= aristas.iterator();

        while (it.hasNext() && camino.isEmpty()){
            Edge<String> arista = it.next();
            Vertex<String> verticeNuevo = arista.getTarget();
            j= verticeNuevo.getPosition();
            int gasto  = arista.getWeight();
            
            if (!marca[j] && (tanqueAuto-gasto >= 0)) {            
                marca[j]=true;
                listaTemp.add(verticeNuevo.getData());            
                
                if (verticeNuevo.getData().equals(ciudad2)){                    
                    camino.addAll(listaTemp);                    
                }
                else{                 
                    dfsBuscarCaminoSinCargarCombustible(j, mapaCiudades, ciudad2, marca, listaTemp, camino,tanqueAuto-gasto);
                    }
                if (camino.isEmpty()){
                    listaTemp.remove(listaTemp.size()-1);
                    marca[j]=false;
                }              

            }             
        }           
      
    }

    //-----------------------------------------------------------------------------
    //Ejercicio 3.5

    public List<String> caminoConMenorCargaDeCombustible (String ciudad1, String ciudad2, int tanqueAuto){
        List<String> camino = new ArrayList<>();
        List <String> listaTemp = new ArrayList<>();
        boolean[] marca = new boolean[this.mapaCiudades.getSize()];
        DataCombustible data = new DataCombustible(tanqueAuto);
        
        if (!this.mapaCiudades.isEmpty() && !ciudad1.equals(ciudad2)){
            Vertex<String> verticeInicio= this.mapaCiudades.search(ciudad1);
            Vertex<String> verticeFin= this.mapaCiudades.search(ciudad2);            
            
            if (verticeInicio!=null && verticeFin!=null){
                int pos = verticeInicio.getPosition();
                marca[pos]= true;
                listaTemp.add(ciudad1);
                dfsBuscarCaminoMenorCargaCombustible(pos, this.mapaCiudades, ciudad2, marca, listaTemp, camino, data);
            }        
        }
        return camino;

    }

    private void dfsBuscarCaminoMenorCargaCombustible(int pos, Graph<String> mapaCiudades, String ciudad2,
            boolean[] marca, List<String> listaTemp, List<String> camino, DataCombustible data) {
        int j;    
        Vertex<String> verticeInicio = mapaCiudades.getVertex(pos);
        List <Edge<String>> aristas = mapaCiudades.getEdges(verticeInicio);
        
        Iterator <Edge<String>>  it= aristas.iterator();

        while (it.hasNext()){
            Edge<String> arista = it.next();
            Vertex<String> verticeNuevo = arista.getTarget();
            j= verticeNuevo.getPosition();
            int gastoCombustible= arista.getWeight();
            int tanqueActual= data.getCantCombustible();
            boolean esNecesarioCargar =  tanqueActual - gastoCombustible < 0;
                       

            if (!marca[j] && gastoCombustible <= data.getTanquelleno()) {   
                if (esNecesarioCargar ){
                    data.llenarTanque();
                    data.AumentarCantCargas();
                }
                if (data.cantCargasEsLaMenor()){
                    data.setCantCombustible(data.getCantCombustible()- gastoCombustible);
                    marca[j]=true;
                    listaTemp.add(verticeNuevo.getData());            
                
                    if (verticeNuevo.getData().equals(ciudad2)){
                        data.setCantMinimaCargas(data.getCantCargas());
                        camino.clear();                    
                        camino.addAll(listaTemp);                    
                    }
                    else{                 
                        dfsBuscarCaminoMenorCargaCombustible(j, mapaCiudades, ciudad2, marca, listaTemp, camino,data);
                    }
                    listaTemp.remove(listaTemp.size()-1);
                    marca[j]=false;                    
                    
                }
                if (esNecesarioCargar){
                        data.BajarCantCargas();                       
                    }               
                data.setCantCombustible(tanqueActual); 
                }                             

            }
                        
    } 
              
    

}//este es el cierre de la clase


   
