
import tp5.ejercicio1.*;
import tp5.ejercicio1.listaAdy.AdjListGraph;

import java.util.List;

public class mainRecorridos {
    public static void main(String[] args) {
        Graph<Integer> grafo = new AdjListGraph<>();

        Vertex<Integer> v1 = grafo.createVertex(143);
        Vertex<Integer> v2 = grafo.createVertex(15);
        Vertex<Integer> v3 = grafo.createVertex(22);
        Vertex<Integer> v4 = grafo.createVertex(25);
        Vertex<Integer> v5 = grafo.createVertex(99);
        Vertex<Integer> v6 = grafo.createVertex(1978);
        Vertex<Integer> v7 = grafo.createVertex(2003);
        Vertex<Integer> v8 = grafo.createVertex(26);

        //  conexiones 
        grafo.connect(v1, v2);
        grafo.connect(v1, v3);
        grafo.connect(v2, v4);
        grafo.connect(v3, v5);
        grafo.connect(v5, v6);
        grafo.connect(v6, v7);
        grafo.connect(v7, v8);

        Recorridos<Integer> recorridos = new Recorridos<>();
        List<Integer> resultadoDfs = recorridos.dfs(grafo);
        List<Integer> resultadoBfs = recorridos.bfs(grafo);

        System.out.println("--------------");
        System.out.println("Resultado DFS: " + resultadoDfs);
        System.out.println("--------------");

        System.out.println("--------------");
        System.out.println("Resultado DFS: " + resultadoBfs);
        System.out.println("--------------");
    }
}
