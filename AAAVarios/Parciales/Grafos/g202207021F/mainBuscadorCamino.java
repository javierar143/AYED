package AAAVarios.Parciales.Grafos.g202207021F;

import tp5.ejercicio1.Graph;
import tp5.ejercicio1.Vertex;
import tp5.ejercicio1.Edge;
import tp5.ejercicio1.listaAdy.AdjListGraph;
import java.util.List;

public class mainBuscadorCamino {
    public static void main(String[] args) {
        // 1. Instanciar el grafo
        Graph<String> mapaCiudades = new AdjListGraph<>();

        // 2. Crear los vértices (Nodos con nombres de las ciudades)
        Vertex<String> lincoln = mapaCiudades.createVertex("Lincoln");
        Vertex<String> chascomus = mapaCiudades.createVertex("Chascomús");
        Vertex<String> canuelas = mapaCiudades.createVertex("Cañuelas");
        Vertex<String> dolores = mapaCiudades.createVertex("Dolores");
        Vertex<String> veronica = mapaCiudades.createVertex("Verónica");
        Vertex<String> villaUrquiza = mapaCiudades.createVertex("Villa Urquiza");
        Vertex<String> ranchos = mapaCiudades.createVertex("Ranchos");
        Vertex<String> berisso = mapaCiudades.createVertex("Berisso");

        // 3. Conectar los vértices de forma no dirigida (Bidireccional) con sus pesos
        
        // Conexiones desde la capa superior (Lincoln)
        conectarBidireccional(mapaCiudades, lincoln, chascomus, 70);
        conectarBidireccional(mapaCiudades, lincoln, canuelas, 50);
        conectarBidireccional(mapaCiudades, lincoln, dolores, 90);

        // Conexiones desde Chascomús
        conectarBidireccional(mapaCiudades, chascomus, veronica, 80);
        conectarBidireccional(mapaCiudades, chascomus, villaUrquiza, 60);

        // Conexiones desde Cañuelas
        conectarBidireccional(mapaCiudades, canuelas, veronica, 85);
        conectarBidireccional(mapaCiudades, canuelas, ranchos, 90);

        // Conexiones desde Dolores
        conectarBidireccional(mapaCiudades, dolores, villaUrquiza, 70);
        conectarBidireccional(mapaCiudades, dolores, ranchos, 70);

        // Conexiones hacia la capa inferior (Berisso)
        conectarBidireccional(mapaCiudades, veronica, berisso, 60);
        conectarBidireccional(mapaCiudades, villaUrquiza, berisso, 90);
        conectarBidireccional(mapaCiudades, ranchos, berisso, 75);

        // --- PRUEBA DE IMPRESIÓN ---
        imprimirGrafo(mapaCiudades);


        BuscadorCamino buscar = new BuscadorCamino();
        String inicio = "Lincoln" ;
        String destino = "Berisso";
        int montoMaximo = 200;
        List <String > camino = buscar.caminoConPresupuesto(mapaCiudades, inicio, destino,montoMaximo);
        
        System.out.println("-------------------------------------------------");
        if (camino.isEmpty()){
            System.out.println("No hay camino");
        }
        else System.out.println(camino);
        System.out.println("Camino");
    }

    /**
     * Método auxiliar para simular una arista no dirigida agregando la conexión de ida y vuelta.
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

        System.out.println("--- ESTRUCTURA DEL GRAFO (RUTAS) ---");
        for (Vertex<T> vertice : grafo.getVertices()) {
            System.out.print("[" + vertice.getData() + "] conectado con: ");

            List<Edge<T>> aristas = grafo.getEdges(vertice);
            if (aristas != null && !aristas.isEmpty()) {
                for (Edge<T> arista : aristas) {
                    System.out.print(arista.getTarget().getData() + " $ " + arista.getWeight() +" " );
                }
            } else {
                System.out.print("Ninguna conexión");
            }
            System.out.println();
        }
        System.out.println("-------------------------------------");
    }
}
