package tp5.ejercicio5;

import tp5.ejercicio1.*;
import tp1.ejercicio8.Queue;
import java.util.*;


public class SelectorClientesJubilados {
    
    public List <Persona> seleccionarJubilados (Graph <Persona> personas, Persona empleado, int distancia){
        List<Persona> listaJubilados= new ArrayList<>();
        List<Persona> listaTemp = new ArrayList<>();

        if (!personas.isEmpty()){
            Vertex <Persona> empleadoInicial =  personas.search(empleado);
            if (empleadoInicial != null){
                boolean [] marca = new boolean[personas.getSize()];
                int pos = empleadoInicial.getPosition();
                marca[pos] = true;
                bfsCargarJubilados (pos, personas, distancia, marca, listaJubilados, listaTemp);
            }

        }

        


        return listaJubilados;
    }

    private void bfsCargarJubilados(int pos, Graph<Persona> personas, int distancia, boolean[] marca,
            List<Persona> listaJubilados, List<Persona> listaTemp) {
        
        Queue <Vertex<Persona>> cola = new Queue<Vertex<Persona>>();
        cola.enqueue(personas.getVertex(pos));
        cola.enqueue(null);
        int nivel =0;
        
        while (!cola.isEmpty()){
            Vertex<Persona> personaAcual = cola.dequeue();

            if (personaAcual != null && nivel<distancia){
                List <Edge<Persona>> aristas = personas.getEdges(personaAcual);
            }
        }
        
        
    }
}
