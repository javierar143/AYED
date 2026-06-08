package AAAVarios.Parciales.Grafos.g202207021F.enunciado;

import java.util.*;
import tp5.ejercicio1.*;

public class BuscadorCamino {
    public List <String> caminoConPresupuesto (Graph <String> ciudades, String origen, String destino, int montoMaximo){
        List <String> camino = new ArrayList<>();
        List <String> caminoTemp= new ArrayList<>();

        if (ciudades!= null && !ciudades.isEmpty()){
            Vertex<String> verticeInicio = ciudades.search(origen);
            Vertex<String> verticeDestino = ciudades.search(destino);

            if (verticeInicio!= null  && verticeDestino != null){
                boolean[] marca = new boolean [ciudades.getSize()];
                int pos = verticeInicio.getPosition();
                marca[pos]=true;
                caminoTemp.add(verticeInicio.getData());
                dfsBuscarCamino(pos,ciudades,destino,montoMaximo,camino,caminoTemp, 0,marca);
            }

        }

        return camino;
    }//fin metodo principal

    private void dfsBuscarCamino(int pos, Graph<String> ciudades, String destino, int montoMaximo, List<String> camino,
            List<String> caminoTemp, int acumulado, boolean [] marca) {
        int j,acumuladoActual;
        Vertex<String> verticeActual = ciudades.getVertex(pos);
        List <Edge<String>> aristas = ciudades.getEdges(verticeActual);

        Iterator <Edge<String>> it = aristas.iterator();

        while (it.hasNext() && camino.isEmpty()) {
            Edge<String> arista = it.next();
            acumuladoActual=acumulado;
            acumulado+= arista.getWeight();
            
            if (acumulado<= montoMaximo){
                Vertex <String> verticeNuevo = arista.getTarget();
                j= verticeNuevo.getPosition();

                if (!marca[j]){
                    marca[j]=true;
                    String siguienteLugar = verticeNuevo.getData();
                    if (siguienteLugar.equals(destino)){
                        caminoTemp.add(siguienteLugar);
                        camino.addAll(caminoTemp);
                    }
                    else{  
                        caminoTemp.add(siguienteLugar);
                        dfsBuscarCamino(j,ciudades,destino,montoMaximo,camino,caminoTemp, acumulado,marca);
                    }

                    if (camino.isEmpty()){
                        caminoTemp.remove(caminoTemp.size()-1);
                        marca[j]=false;
                    }
                    

                }

            }
            acumulado= acumuladoActual;
            
        }

    }
}//fin clase
