package AAAVarios.Parciales.Grafos.a20242daFechaTema1;
import java.util.ArrayList;
import java.util.List;
import tp5.ejercicio1.Graph;
import tp5.ejercicio1.Vertex;
import tp5.ejercicio1.Edge;
import tp5.ejercicio1.listaAdy.AdjListGraph;
import AAAVarios.Parciales.Grafos.a20242daFechaTema1.RedSocial;

public class mainParcial {
    public static void main(String[] args) {
        // 1. Instanciar el grafo con objetos de tipo RedSocial
        Graph<RedSocial> grafo = new AdjListGraph<>();

        // 2. Crear los objetos de la RedSocial
        RedSocial pLionel = new RedSocial("Lionel");
        RedSocial pAngel = new RedSocial("Ángel");
        RedSocial pRodrigo = new RedSocial("Rodrigo");
        RedSocial pDiego = new RedSocial("Diego");
        RedSocial pJulian = new RedSocial("Julián");
        RedSocial pEmiliano = new RedSocial("Emiliano");
        RedSocial pEnzo = new RedSocial("Enzo");
        RedSocial pLautaro = new RedSocial("Lautaro");

        // 3. Crear los vértices en el grafo
        Vertex<RedSocial> lionel = grafo.createVertex(pLionel);
        Vertex<RedSocial> angel = grafo.createVertex(pAngel);
        Vertex<RedSocial> rodrigo = grafo.createVertex(pRodrigo);
        Vertex<RedSocial> diego = grafo.createVertex(pDiego);
        Vertex<RedSocial> julian = grafo.createVertex(pJulian);
        Vertex<RedSocial> emiliano = grafo.createVertex(pEmiliano);
        Vertex<RedSocial> enzo = grafo.createVertex(pEnzo);
        Vertex<RedSocial> lautaro = grafo.createVertex(pLautaro);

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
    private static void conectarBidireccional(Graph<RedSocial> graph, Vertex<RedSocial> v1, Vertex<RedSocial> v2) {
        graph.connect(v1, v2);
        graph.connect(v2, v1);
    }

    /**
     * Recorre e imprime la estructura de listas de adyacencia del grafo.
     */
    public static void imprimirGrafo(Graph<RedSocial> grafo) {
        if (grafo.isEmpty()) {
            System.out.println("El grafo está vacío.");
            return;
        }

        System.out.println("--- ESTRUCTURA DEL GRAFO (RED SOCIAL) ---");
        for (Vertex<RedSocial> vertice : grafo.getVertices()) {
            RedSocial usuarioOrigen = vertice.getData();
            System.out.print("[" + usuarioOrigen.getNombreUsuario() + "] conectado con: ");

            List<Edge<RedSocial>> aristas = grafo.getEdges(vertice);
            if (aristas != null && !aristas.isEmpty()) {
                for (Edge<RedSocial> arista : aristas) {
                    RedSocial usuarioDestino = arista.getTarget().getData();
                    System.out.print(usuarioDestino.getNombreUsuario() + " | ");
                }
            } else {
                System.out.print("Nadie (usuario aislado)");
            }
            System.out.println();
        }
        System.out.println("-----------------------------------------");
    }

    /**
     * Recibe una lista de objetos RedSocial e imprime sus nombres junto con la distancia calculada.
     */
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