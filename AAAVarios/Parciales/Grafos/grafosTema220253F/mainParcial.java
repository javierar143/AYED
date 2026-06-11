package AAAVarios.Parciales.Grafos.grafosTema220253F;

import tp5.ejercicio1.Graph;
import tp5.ejercicio1.Vertex;
import tp5.ejercicio1.Edge;
import tp5.ejercicio1.listaAdy.AdjListGraph;
import java.util.List;


public class mainParcial {
    public static void main(String[] args) {
        // 1. Instanciar el grafo
        Graph<String> mapa = new AdjListGraph<>();

        // 2. Crear los vértices (Nodos del mapa)
        Vertex<String> castillo = mapa.createVertex("Castillo");
        Vertex<String> cruceNorte = mapa.createVertex("Cruce Norte");
        Vertex<String> bosqueSombrio = mapa.createVertex("Bosque Sombrío");
        Vertex<String> aldeaLago = mapa.createVertex("Aldea del Lago");
        Vertex<String> cuevaEncantada = mapa.createVertex("Cueva Encantada");
        Vertex<String> campamentoDruidas = mapa.createVertex("Campamento de Druidas");
        Vertex<String> desfiladeroVientos = mapa.createVertex("Desfiladero de los Vientos");
        Vertex<String> aldea = mapa.createVertex("Aldea");

        // 3. Conectar los vértices bidireccionalmente con el peso (Costo en Pociones)
        
        // Conexiones desde el Castillo
        conectarBidireccional(mapa, castillo, cruceNorte, 10);
        conectarBidireccional(mapa, castillo, bosqueSombrio, 20);
        conectarBidireccional(mapa, castillo, aldeaLago, 15);
        conectarBidireccional(mapa, castillo, cuevaEncantada, 8);

        // Conexiones desde Cruce Norte
        conectarBidireccional(mapa, cruceNorte, bosqueSombrio, 5);

        // Conexiones desde Bosque Sombrío
        conectarBidireccional(mapa, bosqueSombrio, aldeaLago, 6);
        conectarBidireccional(mapa, bosqueSombrio, campamentoDruidas, 3);

        // Conexiones desde Aldea del Lago
        conectarBidireccional(mapa, aldeaLago, cuevaEncantada, 50);
        conectarBidireccional(mapa, aldeaLago, desfiladeroVientos, 30);

        // Conexiones desde Cueva Encantada
        conectarBidireccional(mapa, cuevaEncantada, desfiladeroVientos, 45);

        // Conexiones desde Campamento de Druidas
        conectarBidireccional(mapa, campamentoDruidas, desfiladeroVientos, 7);
        conectarBidireccional(mapa, campamentoDruidas, aldea, 35);

        // Conexiones desde Desfiladero de los Vientos
        conectarBidireccional(mapa, desfiladeroVientos, aldea, 15);

        // --- PRUEBA DE IMPRESIÓN ---
        //imprimirGrafo(mapa);

        ParcialGrafos parcial = new ParcialGrafos();
        String inicio="Castillo";
        String destino = "Aldea";
        int maxPociones= 70;

        System.out.println("--------------------------");
        System.out.println(parcial.rutaOptimaDistribucion(mapa, inicio, destino, maxPociones));
    }

    /**
     * Método auxiliar para simular una arista no dirigida.
     * Conecta origen con destino y viceversa con el peso indicado.
     */
    private static <T> void conectarBidireccional(Graph<T> graph, Vertex<T> v1, Vertex<T> v2, int peso) {
        graph.connect(v1, v2, peso);
        graph.connect(v2, v1, peso);
    }

    /**
     * Recorre e imprime la estructura de listas de adyacencia del grafo.
     */
    public static <T> void imprimirGrafo(Graph<T> grafo) {
        if (grafo.isEmpty()) {
            System.out.println("El grafo está vacío.");
            return;
        }

        System.out.println("--- MAPA DE AVENTURA (TOPOLOGÍA) ---");
        for (Vertex<T> vertice : grafo.getVertices()) {
            System.out.print("[" + vertice.getData() + "] conectado con: ");

            List<Edge<T>> aristas = grafo.getEdges(vertice);
            if (aristas != null && !aristas.isEmpty()) {
                for (Edge<T> arista : aristas) {
                    System.out.print(arista.getTarget().getData() + " (" + arista.getWeight() + " pociones) | ");
                }
            } else {
                System.out.print("Zona aislada");
            }
            System.out.println();
        }
        System.out.println("-------------------------------------");
    }
}
