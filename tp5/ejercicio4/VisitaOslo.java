package tp5.ejercicio4;

import java.util.*;


import tp5.ejercicio1.*;

public class VisitaOslo {
    
    public  List<String> paseoEnBici(Graph<String> lugares, String destino, int maxTiempo, List<String>
lugaresRestringidos){
    List <String> camino = new ArrayList<>();
    List <String> listaTemp = new ArrayList<>();
    
    if (!lugares.isEmpty()){
        boolean [] marca = new boolean[lugares.getSize()];
        String partida = "Ayuntamiento";
        Vertex<String> lugarPartida = lugares.search(partida);
        Vertex<String> lugarDestino = lugares.search(destino);
        int tiempo = 0;
        if (lugarPartida != null && lugarDestino!=null && !lugaresRestringidos.contains(destino) ){
            int pos = lugarPartida.getPosition();
            marca[pos]=true;            
            listaTemp.add(partida);
            dfsBuscarCamino (pos, lugares,destino, marca, tiempo,  maxTiempo, lugaresRestringidos, camino, listaTemp );

        } 
    }

    return camino;
}

    private void dfsBuscarCamino(int pos, Graph<String> lugares, String destino, boolean [] marca, int tiempo, int maxTiempo,
            List<String> lugaresRestringidos, List<String> camino, List<String> listaTemp ) {
       int j;
       Vertex <String> verticeActual = lugares.getVertex(pos);
       List<Edge<String>> aristas = lugares.getEdges(verticeActual);

       Iterator <Edge<String>> it = aristas.iterator();

       while (it.hasNext() && camino.isEmpty() ){
            Edge<String> arista = it.next();
            Vertex <String> verticeNuevo = arista.getTarget();
            String lugarActual = verticeNuevo.getData();
            j=verticeNuevo.getPosition();

            if(!marca[j] && !lugaresRestringidos.contains(lugarActual)){
                     
                int NuevoTiempo=tiempo+arista.getWeight();                

                if (NuevoTiempo <= maxTiempo){
                    marca[j]=true;
                    listaTemp.add(lugarActual);
                    if (lugarActual.equals(destino)){
                        camino.addAll(listaTemp);
                    }
                    else{
                        dfsBuscarCamino (j, lugares,destino, marca, NuevoTiempo,  maxTiempo, lugaresRestringidos, camino, listaTemp );
                    }
                    listaTemp.remove(listaTemp.size()-1);
                    marca[j]=false;
                }   
                
            }
        }
    }


}//final de la clase
