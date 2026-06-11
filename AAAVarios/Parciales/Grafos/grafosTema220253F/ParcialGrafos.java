package AAAVarios.Parciales.Grafos.grafosTema220253F;

import java.util.*;
import tp5.ejercicio1.*;


public class ParcialGrafos {
    public List <String> rutaOptimaDistribucion (Graph<String> reino, String castillo, String aldea, int maxPociones){
        List<String> camino = new ArrayList<>();
        List<String> caminoTemp = new ArrayList<>();
        if (reino!= null && !reino.isEmpty()){
            Vertex<String> verticeInicio = reino.search(castillo);
            Vertex<String> verticeDestino = reino.search(aldea);

            if (verticeInicio != null  && verticeDestino != null){
                boolean [] marca= new boolean[reino.getSize()];
                int pos = verticeInicio.getPosition();
                marca[pos]=true;
                caminoTemp.add(castillo);
                int pocionesAcumuladas=0;

                dfsBuscarRuta(pos,reino,marca, camino,caminoTemp,maxPociones,pocionesAcumuladas,aldea );
            }


        }

        return camino;
    }//fin metodo principal

    private void dfsBuscarRuta (int pos, Graph<String> reino,boolean [] marca ,List<String> camino, List<String>caminoTemp,
         int maxPociones, int pocionesAcumuladas, String aldea){
        int j;
        Vertex <String> vertice = reino.getVertex(pos);
        List <Edge <String>> aristas = reino.getEdges(vertice);

        Iterator <Edge<String>> it = aristas.iterator();

        while (it.hasNext()){
            Edge<String> arista = it.next();
            int valorPocionesActual= pocionesAcumuladas +  arista.getWeight();
            
            Vertex <String> verticeActual = arista.getTarget();
            j= verticeActual.getPosition();
            
            if (!marca[j] && valorPocionesActual <= maxPociones){
                marca[j]=true;
                String nombreActual= verticeActual.getData();
                caminoTemp.add(nombreActual);
                
                if (nombreActual.equals(aldea) && caminoTemp.size() > camino.size()){
                    camino.clear();
                    camino.addAll(caminoTemp);
                }
                else dfsBuscarRuta(j,reino,marca, camino,caminoTemp,maxPociones,valorPocionesActual,aldea );

                marca[j]=false;
                caminoTemp.remove (caminoTemp.size()-1);
                                
            }            
        }

    }
}//fin clase
