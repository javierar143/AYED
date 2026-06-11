package AAAVarios.Parciales.Grafos.parcial290624T2;

import tp5.ejercicio1.*;

import java.util.Iterator;
import java.util.List;

import tp1.ejercicio8.Queue;

public class Parcial {
    public Dataclass nivelPopularidad (Graph <String> red, String usuario, int distancia, int umbral){
        Dataclass  data = null;
        if (red != null && !red.isEmpty() ){
            Vertex<String> verticeUsuario = red.search(usuario);

            if (verticeUsuario != null){
                int cantAmigos =0;
                int nivel=0;
                Queue <Vertex<String>> cola = new Queue<>();
                boolean [] marca = new boolean [red.getSize()];

                int pos = verticeUsuario.getPosition();
                marca [pos]=true;

                cola.enqueue(verticeUsuario);
                cola.enqueue(null);

                while (!cola.isEmpty() && nivel <= distancia){
                    Vertex<String> verticeActual=  cola.dequeue();

                    if (verticeActual != null){
                      
                        if (nivel== distancia && distancia != 0){
                                cantAmigos++;
                        }                        

                        List <Edge<String>> aristas = red.getEdges(verticeActual);
                        Iterator <Edge<String>> it = aristas.iterator();

                        while (it.hasNext() && nivel < distancia){
                            Edge<String> arista = it.next();
                            Vertex <String> vertice = arista.getTarget();
                            int j = vertice.getPosition();
                            if (!marca[j]){
                                marca[j]=true;
                                cola.enqueue(arista.getTarget());
                            }                            
                        }
                    }

                    else {
                        if (nivel == distancia){                            
                            data = new Dataclass(cantAmigos, umbral);
                        }                       

                        if (!cola.isEmpty()){
                            nivel++;
                            cola.enqueue(null);
                        }
                    }
                   
                }
                 if (nivel< distancia || distancia == 0 ){
                        data = new Dataclass(cantAmigos, umbral);
                    }          
            
            }//fin if usuario        
        
        }//fin if princial        
        return data;

    }//fin metodo principal
}//fin clase
