package tp5.ejercicio7;
import java.util.*;

import tp5.ejercicio1.*;

public class MapaDijkstra {
    private Graph <String> mapaCiudades;

    public MapaDijkstra(Graph<String> mapaCiudades) {
        this.mapaCiudades = mapaCiudades;
    }

    //ejercicio 7.1
    //------------------------------------------------------------------------------------------------
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

     //ejercicio 7.2
    //------------------------------------------------------------------------------------------------

    public List <String>  caminoMasCortoFloyd (String ciudad1, String ciudad2){
        List<String> camino = new ArrayList<>();

        if (!this.mapaCiudades.isEmpty() && !ciudad1.equals(ciudad2)){
            Vertex<String> verticeInicio= this.mapaCiudades.search(ciudad1);
            Vertex<String> verticeFin= this.mapaCiudades.search(ciudad2);

            if (verticeInicio!=null && verticeFin!=null){
                int longitudGrafo = this.mapaCiudades.getSize();
                int [][] distancias = new int [longitudGrafo][longitudGrafo];

                Vertex<String>[][] previos = new Vertex[longitudGrafo][longitudGrafo];

                //inicializar matrices
                inicializarMatricesFloyd(this.mapaCiudades,distancias,previos);
                
                for (int k=0; k< mapaCiudades.getSize();k++){//vertice intermedio
                    for (int i=0; i< mapaCiudades.getSize();i++){//vertice origen
                        for (int j=0; j< mapaCiudades.getSize();j++){//vertice destino
                            //evaluar si ir de i a j pasando por k es mas corto
                            if (distancias [i][k]!= Integer.MAX_VALUE && distancias [k][j] != Integer.MAX_VALUE &&
                               distancias [i][k] +  distancias [k][j] < distancias[i][j]){
                                    distancias[i][j] = distancias [i][k] +  distancias [k][j] ;
                                    previos [i][j]= previos [k][j];//se actualiza el camino
                               }
                    }
                  }
                }
                armarCaminoFloyd(previos,verticeInicio.getPosition(), verticeFin.getPosition(),this.mapaCiudades,camino);
            
            }//fin if con nulls
        
        
        }//fin if pricipal       
        
        return camino;
    }//fin del meetodo floyd

   
    private void inicializarMatricesFloyd(Graph<String> mapaCiudades, int[][] distancias, Vertex<String>[][] previos) {
        
        for (int i=0; i< mapaCiudades.getSize();i++){
            for (int j=0; j< mapaCiudades.getSize();j++) {
                if(i==j) distancias[i][j]=0;
                else  distancias[i][j]=Integer.MAX_VALUE;
            
                previos[i][j]=null;
            }

        }
        List <Vertex<String>> vertices = mapaCiudades.getVertices();
        for (Vertex<String> v : vertices){
            for (Edge<String> e : mapaCiudades.getEdges(v)){
                int i = v.getPosition();
                int j = e.getTarget().getPosition();

                distancias[i][j] = e.getWeight();
                previos[i][j] = v;
    }
}
    }

     private void armarCaminoFloyd(Vertex<String>[][] previos, int origen, int destino, Graph<String> mapaCiudades,
            List<String> camino) {

                // Solo  se arma si se encontró un camino
        if (previos[origen][destino] != null) {
            List<String> listaTemp = new ArrayList<>();
            Vertex<String> actual = mapaCiudades.getVertex(destino);

            // se retorcede desde el destino hasta el origen usando la matriz
            while (actual != null && actual.getPosition() != origen) {
                listaTemp.add(0, actual.getData()); 
                actual = previos[origen][actual.getPosition()];
        }
        
        // se agrea el origen 
        listaTemp.add(0, actual.getData());
        camino.addAll(listaTemp);
    }
     }



}//fin de la clase


//ejercicio 7.2
//------------------------------------------------------------------------------------------------
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


Algoritmo Floyd:
                        O(|V|³)



*/