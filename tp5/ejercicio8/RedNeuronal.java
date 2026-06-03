package tp5.ejercicio8;

import java.util.Iterator;
import java.util.List;

import tp5.ejercicio1.*;

public class RedNeuronal {

    public int neuronasActivadas(Graph<String> grafo, String inicio, int impulso){
        int cantActivadas = 0;
        if (!grafo.isEmpty()){
            boolean [] marca = new boolean[grafo.getSize()];
            Vertex<String> verticeInicio  = grafo.search(inicio);
            if (verticeInicio != null){
                int pos = verticeInicio.getPosition();
                marca[pos]=true;
                cantActivadas++;
                cantActivadas += dfsCalcularNeuronasActivadas (pos, grafo, marca, impulso);

            }
        }

        return cantActivadas;
    }

    private int  dfsCalcularNeuronasActivadas(int pos, Graph<String> grafo,boolean [] marca ,int impulso) {
        int j;
        int cantActivadas =0;        
        Vertex<String> vertice = grafo.getVertex(pos);
        List<Edge<String>> aristas= grafo.getEdges(vertice);

        int  intensidad = (int) (impulso * 0.90);
        Iterator <Edge<String>> it = aristas.iterator();

        while (it.hasNext()){
            Edge<String> aristaActual = it.next();
            int fuerza = aristaActual.getWeight();
            Vertex <String> verticeActual = aristaActual.getTarget();
            j= verticeActual.getPosition();
           
            if (!marca[j] && fuerza >= impulso ){
                marca[j]= true;
                cantActivadas++;                
                cantActivadas += dfsCalcularNeuronasActivadas (j, grafo, marca, intensidad);
                marca[j]= false;
            }        

        }

        return cantActivadas;
    }
}
