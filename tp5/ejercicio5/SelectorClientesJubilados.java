package tp5.ejercicio5;

import tp5.ejercicio1.*;
import tp1.ejercicio8.Queue;
import java.util.*;


public class SelectorClientesJubilados {
    
    public List <Persona> seleccionarJubilados (Graph <Persona> personas, Persona empleado, int distancia){
        List<Persona> listaJubilados= new ArrayList<>();
        
        if (!personas.isEmpty()){
            Vertex <Persona> empleadoInicial =  personas.search(empleado);
            if (empleadoInicial != null){
                boolean [] marca = new boolean[personas.getSize()];
                int pos = empleadoInicial.getPosition();
                
                bfsCargarJubilados (pos, personas, distancia, marca, listaJubilados);
            }

        }
        return listaJubilados;
    }

    private void bfsCargarJubilados(int pos, Graph<Persona> personas, int distancia, boolean[] marca,
            List<Persona> listaJubilados) {
        
        Queue <Vertex<Persona>> cola = new Queue<Vertex<Persona>>();
        cola.enqueue(personas.getVertex(pos));
        cola.enqueue(null);
        marca[pos]=true;
        int nivel =0;
        
        while (!cola.isEmpty() && nivel<=distancia && listaJubilados.size() < 40 ){
            Vertex<Persona> verticePersona = cola.dequeue();

            if (verticePersona != null ){
                Persona personaAcual = verticePersona.getData();
                if (personaAcual.EsJubilado() && !personaAcual.isCobroRecibido() ){
                    listaJubilados.add(personaAcual);
                }
                List <Edge<Persona>> aristas = personas.getEdges(verticePersona);
                for (Edge <Persona> arista : aristas){
                    Vertex<Persona> vertice = arista.getTarget();
                    int j = vertice.getPosition();
                    if (!marca[j]){
                        marca[j]=true;
                        cola.enqueue(vertice);
                    }                    
                }

            }
            else {
               
                if (!cola.isEmpty()){
                    nivel++;
                    cola.enqueue(null);
                }
            }
        }
        
        
    }
}
