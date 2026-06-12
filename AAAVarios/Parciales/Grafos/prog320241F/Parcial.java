package AAAVarios.Parciales.Grafos.prog320241F;

import java.util.*;
import tp5.ejercicio1.*;

public class Parcial {

    public List <DataClass> menosTrasbordos (Graph <String> maps, String origen){
        List <DataClass>  listaTrasbordos = new ArrayList<>();
        
        if (maps != null && !maps.isEmpty()){
            boolean [] marca = new boolean[maps.getSize()];
            Vertex <String> verticeInicio =  maps.search(origen);
            //no compruebo si es null ya q asumo q si seguro es el origen, tambien seguro existe
            int pos = verticeInicio.getPosition();
            marca[pos] = true;
            int cantTransbordos= 0;
           
            dfsCargarMinimosTrasborbordos (pos, maps, marca, listaTrasbordos, cantTransbordos, origen);           
        
        }   
        return listaTrasbordos;
    }//fin metodo principal

        private void dfsCargarMinimosTrasborbordos (int pos, Graph <String> maps, boolean [] marca, List <DataClass> listaTrasbordos, 
            int cantTrasbordos, String origen){
            int j;

            Vertex<String> verticeActual = maps.getVertex(pos);
            List <Edge<String>> aristas = maps.getEdges(verticeActual);
                
            if (aristas.size()>2){
                cantTrasbordos++;
            }
            if (aristas.size() ==1 && !verticeActual.getData().equals(origen)  ){
                    actualizarMinimo (listaTrasbordos,verticeActual.getData(),cantTrasbordos);             
                
            }
            else{
                 Iterator <Edge<String>> it = aristas.iterator();

                 while (it.hasNext()){
                    Edge<String> arista = it.next();
                    Vertex <String> verticeSiguiente = arista.getTarget();
                    j = verticeSiguiente.getPosition();
                    if (!marca[j]){
                        marca[j]=true;
                        dfsCargarMinimosTrasborbordos (j, maps, marca, listaTrasbordos, cantTrasbordos, origen); 
                    } 
                }
            }
            marca[pos]=false;

        }   

        private void actualizarMinimo (List <DataClass> listaTrasbordos, String nombreActual, int cantTrasbordos ){
            Iterator <DataClass> it = listaTrasbordos.iterator();
            boolean encontre = false;
            while (it.hasNext() && !encontre){
                DataClass data = it.next();
                if (data.getEstacion().equals(nombreActual)){
                    encontre=true;
                    if (cantTrasbordos < data.getCantTransbordos()){
                        data.setCantTransbordos(cantTrasbordos);                      
                    }
                }
            }
            if (!encontre) listaTrasbordos.add(new DataClass(nombreActual, cantTrasbordos));
       }



}//fin clase
