
import java.util.*;

import tp5.ejercicio1.*;
import tp1.ejercicio8.Queue;


public class Recorridos <T>{
    
    public List <T> dfs(Graph<T> grafo) {
        List<T> lista = new ArrayList<>();
        boolean[] marca = new boolean[grafo.getSize()];
        for (int i = 0; i < grafo.getSize(); i++) {
            if (!marca[i]) {
                dfs(i, grafo, marca, lista);
            }
        }
        return lista;
    }
    
    private void dfs(int i, Graph<T> grafo, boolean[] marca, List<T> lista) {
        marca[i] = true;
        Vertex<T> v = grafo.getVertex(i);
        lista.add(v.getData());
        List<Edge<T>> adyacentes = grafo.getEdges(v); //adyacentes
        for (Edge<T> e: adyacentes){
            int j = e.getTarget().getPosition();            
            if (!marca[j]) {
                dfs(j, grafo, marca,lista);
            }
        }
    }

    public List<T> bfs(Graph<T> grafo) {
        List<T> list = new ArrayList<>();
        boolean[] marca =new boolean[grafo.getSize()];
        for (int i = 0; i < grafo.getSize(); i++) {
            if (!marca[i]) {
                this.bfs(i, grafo, marca,list);
                }
        }
        return list;
    }


    private void bfs(int i, Graph<T> grafo, boolean[] marca,List<T> list) {
        Queue<Vertex<T>> q = new Queue<Vertex<T>>();
        q.enqueue(grafo.getVertex(i));
        marca[i] = true;
        while (!q.isEmpty()) {
            Vertex<T> w = q.dequeue();
            list.add(w.getData());
            // para todos los vecinos de w:
            List<Edge<T>> adyacentes = grafo.getEdges(w);
            for (Edge<T> e: adyacentes) {
                int j = e.getTarget().getPosition();
                if (!marca[j]) {
                    marca[j] = true;
                    //Vertex<T> v = e.getTarget();
                    q.enqueue(e.getTarget());
                }
            }
        }
    }
}



/*
​ Estimar el orden de ejecución de los métodos anteriores:
Para DFS y BFS:
****Lista de Adyacencias: El orden es O(∣V∣+∣E∣) (Vértices + Aristas). Esto se debe a que solo se recorren los 
vecinos reales de cada vértice

****Matriz de Adyacencias: El orden es O(∣V∣^2). Para cada vértice se revisa toda su fila en la matriz
 (las ∣V∣ columnas) para verificar cuáles conexiones existen.-




*/


