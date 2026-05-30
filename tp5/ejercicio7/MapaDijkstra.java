package tp5.ejercicio7;
import java.util.*;

import tp5.ejercicio1.*;

public class MapaDijkstra {
    private Graph <String> mapaCiudades;

    public MapaDijkstra(Graph<String> mapaCiudades) {
        this.mapaCiudades = mapaCiudades;
    }

    public List <String>  caminoMasCortoDijkstra (String ciudad1, String ciudad2){
        List<String> camino = new ArrayList<>();

        if (!this.mapaCiudades.isEmpty() && !ciudad1.equals(ciudad2)){
           Vertex<String> verticeInicio= this.mapaCiudades.search(ciudad1);
           Vertex<String> verticeFin= this.mapaCiudades.search(ciudad2);
            
           if (verticeInicio!=null && verticeFin!=null){
                int longitudGrafo = this.mapaCiudades.getSize();
                int [] distancias = new int [longitudGrafo];

                Vertex<String>[] previos = new Vertex[longitudGrafo];
                boolean [] marca = new boolean[longitudGrafo];

                //inicializacion Dijkstra
                for (int i=0; i < longitudGrafo;i++){
                    distancias[i] = Integer.MAX_VALUE;
                    previos[i]=null;
                    marca[i]=false;                    
                }
                distancias [verticeInicio.getPosition()]=0;

                int i =0;
                Vertex<String> u =obtenerVerticeDesconocidoMenorDistancia (this.mapaCiudades,distancias,marca);

                while (i<longitudGrafo && u!=null){      //cuando no quedan vertices alcanzables u es null             
                    
                    int posU = u.getPosition();
                    marca[posU]=true;

                    for (Edge<String> arista : this.mapaCiudades.getEdges(u)){
                        int posW = arista.getTarget().getPosition();
                        int distancia = arista.getWeight();
                            
                        //si encontramos un camino mas corto se sobreescribe
                        if (!marca[posW] && distancias[posU] != Integer.MAX_VALUE && distancias [posU] + distancia < distancias[posW]){
                            distancias[posW] = distancias[posU]+ distancia;
                             previos[posW]= u;
                         }
                    }
                    
                    i++;
                    u =obtenerVerticeDesconocidoMenorDistancia (this.mapaCiudades,distancias,marca);                
                
                }//fin for que procesa el grafo
                if (distancias[verticeFin.getPosition()] != Integer.MAX_VALUE){ //Si la distancia al destino sigue siendo infinito,
                                                                                // entonces no existe camino desde el origen al destino.
                    armarCaminoDesdePrevios(previos,verticeFin,camino);
                }



           }//fin if  null
        }
        return camino;

    }

    private Vertex<String> obtenerVerticeDesconocidoMenorDistancia(Graph<String> mapaCiudades, int[] distancias,
            boolean[] marca) {        

        Vertex<String> menor = null;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < mapaCiudades.getSize(); i++) {

            if (!marca[i] && distancias[i] < min) {
                min = distancias[i];
                menor = mapaCiudades.getVertex(i);
            }
        }

        return menor;
        }

    private void armarCaminoDesdePrevios(Vertex<String>[] previos, Vertex<String> verticeFin, List<String> camino) {
      
        List<String> listaTemp = new ArrayList<>();

        Vertex<String> actual = verticeFin;

        while (actual != null) {
            listaTemp.add(0,actual.getData());

            actual = previos[actual.getPosition()];
        }
        
        camino.addAll(listaTemp);
    }

}//fin de la clase



/*
Algoritmo original: un  DFS normal visita cada nodo y arista una sola vez, costando O(∣V∣+∣E∣) .
Como el algoritmo del punto 3.3 explora todos los caminos posibles, crece de forma factorial, es decir
las iteraciones tiene ∣V∣−1 opciones, para cada una el siguiente nivel tiene ∣V∣−2 opciones, y así sucesivamente,
entonces sera (∣V∣−1)!
... no se como se pone aca: O(|V|!)

Algorimo Dijkstra:
tiempo de ejecucion:    O(|V|²+ |E|)

si usara una heap:
                        O(|E| log |V|)


*/