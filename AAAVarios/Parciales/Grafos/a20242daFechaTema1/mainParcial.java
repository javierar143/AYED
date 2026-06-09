package AAAVarios.Parciales.Grafos.a20242daFechaTema1;

import java.util.ArrayList;
import java.util.List;
import tp5.ejercicio1.Graph;
import tp5.ejercicio1.Vertex;
import tp5.ejercicio1.Edge;
import tp5.ejercicio1.listaAdy.AdjListGraph;


public class mainParcial {
    public static void main(String[] args) {
        // 1. Instanciar el grafo con objetos de tipo RedSocial
        Graph<String> grafo = new AdjListGraph<>();

        // 2. Crear los objetos de la RedSocial
        String pLionel = "Lionel";
        String pAngel = "Ángel";
        String pRodrigo = "Rodrigo";
        String pDiego = "Diego";
        String pJulian ="Julián";
        String pEmiliano = "Emiliano";
        String pEnzo = "Enzo";
        String pLautaro = "Lautaro";

        // 3. Crear los vértices en el grafo
        Vertex<String> lionel = grafo.createVertex(pLionel);
        Vertex<String> angel = grafo.createVertex(pAngel);
        Vertex<String> rodrigo = grafo.createVertex(pRodrigo);
        Vertex<String> diego = grafo.createVertex(pDiego);
        Vertex<String> julian = grafo.createVertex(pJulian);
        Vertex<String> emiliano = grafo.createVertex(pEmiliano);
        Vertex<String> enzo = grafo.createVertex(pEnzo);
        Vertex<String> lautaro = grafo.createVertex(pLautaro);

        // 4. Conectar los vértices de forma no dirigida (el peso por defecto será 1)
        conectarBidireccional(grafo, lionel, angel);
        conectarBidireccional(grafo, lionel, rodrigo);
        
        conectarBidireccional(grafo, angel, diego);
        conectarBidireccional(grafo, angel, julian);
        conectarBidireccional(grafo, angel, enzo);

        conectarBidireccional(grafo, julian,lautaro );

        conectarBidireccional(grafo, rodrigo, julian);
        conectarBidireccional(grafo, rodrigo, emiliano);
        
        conectarBidireccional(grafo, diego, enzo); 
        conectarBidireccional(grafo, diego, lautaro);        
        
        
        conectarBidireccional(grafo, emiliano, lautaro);
        conectarBidireccional(grafo, emiliano, enzo);
 

        // --- PRUEBAS DE IMPRESIÓN ---

        // Test 1: Imprimir la topología completa del grafo
        imprimirGrafo(grafo);    

        

        System.out.println("\n--- IMPRESIÓN DE LA LISTA DE RESULTADOS ---");
        int distancia= 2;
        int limite=4;
        String usuario = "Lionel";
        
        Parcial parcial = new Parcial();
        
        imprimirListaResultado(parcial.invitacionMasterClass(grafo, usuario, distancia, limite));
    }

    /**
     * Simula una arista bidireccional conectando en ambos sentidos con peso 1.
     */
    private static void conectarBidireccional(Graph<String> graph, Vertex<String> v1, Vertex<String> v2) {
        graph.connect(v1, v2);
        graph.connect(v2, v1);
    }

    /**
     * Recorre e imprime la estructura de listas de adyacencia del grafo.
     */
    public static void imprimirGrafo(Graph<String> grafo) {
        if (grafo.isEmpty()) {
            System.out.println("El grafo está vacío.");
            return;
        }

        System.out.println("--- ESTRUCTURA DEL GRAFO (RED SOCIAL) ---");
        for (Vertex<String> vertice : grafo.getVertices()) {
            String usuarioOrigen = vertice.getData();
            System.out.print("[" + usuarioOrigen + "] conectado con: ");

            List<Edge<String>> aristas = grafo.getEdges(vertice);
            if (aristas != null && !aristas.isEmpty()) {
                for (Edge<String> arista : aristas) {
                    String usuarioDestino = arista.getTarget().getData();
                    System.out.print(usuarioDestino + " | ");
                }
            } else {
                System.out.print("Nadie (usuario aislado)");
            }
            System.out.println();
        }
        System.out.println("-----------------------------------------");
    }

    public static void imprimirListaResultado(List<RedSocial> lista) {
        if (lista == null || lista.isEmpty()) {
            System.out.println("La lista está vacía.");
            return;
        }

        for (RedSocial usuario : lista) {
            System.out.println("Usuario: " + usuario.getNombreUsuario() + " -> Distancia: " + usuario.getDistancia());
        }
    }

    
}