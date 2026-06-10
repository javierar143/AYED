package AAAVarios.Parciales.Grafos.grafos20241eraFechaTema1.Resolucion;
import java.util.Iterator;
import java.util.List;

import tp5.ejercicio1.*;

public class Parcial {
    public int resolver (Graph <Recinto> sitios, int tiempo){
        int cantRecintos=0;
        
        if (sitios != null && !sitios.isEmpty()){
            Recinto inicio = new Recinto("ENTRADA", 0);
            Vertex<Recinto> verticeInicial = sitios.search(inicio);
            
            if (verticeInicial!= null){
                int tiempoAcumulado = verticeInicial.getData().getTiempoVisita();
                boolean [] marca = new boolean [sitios.getSize()];
                int pos = verticeInicial.getPosition();
                marca [pos]= true;
                if (tiempoAcumulado <= tiempo){
                    cantRecintos++;
                
                     if (tiempoAcumulado < tiempo){
                    cantRecintos+= dfsBuscarCantRecintos (sitios, tiempo, tiempoAcumulado, pos, marca);
                }
                }
            }
            
        }
        return cantRecintos;
    }//fin metodo pub

    private int dfsBuscarCantRecintos(Graph<Recinto> sitios, int tiempoMax, int tiempoAcumulado,int pos, boolean[] marca) {
        
        int j;
        Vertex<Recinto> verticeActual = sitios.getVertex(pos);
              
        List <Edge<Recinto>> aristas = sitios.getEdges(verticeActual);
        Iterator <Edge<Recinto>> it = aristas.iterator();

        int cantMax= Integer.MIN_VALUE;
        int cantRecintos=0;
        while(it.hasNext() ){
            Edge<Recinto> arista = it.next();
            Vertex<Recinto> verticeNuevo = arista.getTarget();
            j= verticeNuevo.getPosition();
            

            if (!marca[j]){ 
                int tiempoAcumuladoActual=tiempoAcumulado;
                tiempoAcumulado += arista.getWeight()+ verticeNuevo.getData().getTiempoVisita();
                if (tiempoAcumulado<=tiempoMax){
                    marca[j]=true;
                    cantRecintos++;
                
                    if ( tiempoAcumulado<tiempoMax){
                        cantRecintos+=dfsBuscarCantRecintos (sitios, tiempoMax, tiempoAcumulado, j, marca);          
                   
                    }
               
                    marca[j]=false;                    
                }
                tiempoAcumulado=tiempoAcumuladoActual;
            } 
            if (cantRecintos > cantMax ){
                        cantMax= cantRecintos;
                    }           
            
            cantRecintos=0;        
        }      

        return cantMax != Integer.MIN_VALUE ? cantMax : cantRecintos;

    }//fin metodo priv
}//fin clase
