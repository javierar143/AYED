package tp5.ejercicio6;
 import tp5.ejercicio1.Graph;
import tp5.ejercicio1.Vertex;
import tp5.ejercicio1.listaAdy.AdjListGraph;

public class mainCapezurdita {
   


    public static void main(String[] args) {
        // 1. Crear el grafo
        Graph<String> bosque = new AdjListGraph<>();

        // 2. Crear los vértices (Lugares / Claros)
        Vertex<String> casaCaperucita = bosque.createVertex("Casa Capezurdita");
        Vertex<String> claro1 = bosque.createVertex("Claro 1");
        Vertex<String> claro2 = bosque.createVertex("Claro 2");
        Vertex<String> claro3 = bosque.createVertex("Claro 3");
        Vertex<String> claro4 = bosque.createVertex("Claro 4");
        Vertex<String> claro5 = bosque.createVertex("Claro 5");
        Vertex<String> casaAbuelita = bosque.createVertex("Casa Abuelita");

        // 3. Crear las conexiones bidireccionales (Aristas con peso)
        
        // Conexiones desde Casa Caperucita
        conectarBidireccional(bosque, casaCaperucita, claro3, 4);
        conectarBidireccional(bosque, casaCaperucita, claro1, 3);
        conectarBidireccional(bosque, casaCaperucita, claro2, 4);

        // Conexiones de Claro 1
        conectarBidireccional(bosque, claro1, claro2, 4);
        conectarBidireccional(bosque, claro1, claro5, 3);

        // Conexiones de Claro 2
        conectarBidireccional(bosque, claro2, claro5, 11);
        conectarBidireccional(bosque, claro2, claro4, 10);

        // Conexiones de Claro 3
        conectarBidireccional(bosque, claro3, claro5, 15);

        // Conexiones hacia Casa Abuelita
        conectarBidireccional(bosque, claro5, casaAbuelita, 4);
        conectarBidireccional(bosque, claro4, casaAbuelita, 9);

        System.out.println("¡Grafo del Bosque cargado exitosamente!");
        System.out.println("Cantidad de vértices (lugares): " + bosque.getSize());

        BuscadorDeCaminos bdec =new BuscadorDeCaminos(bosque);        
        
        System.out.println("-------------------------------------");
        System.out.println("Caminos seguros:");
        System.out.println(bdec.recorridosMasSeguro());
        System.out.println("-------------------------------------");
    
    
    }

    /**
     * Método auxiliar para conectar vértices en ambos sentidos.
     */
    private static <T> void conectarBidireccional(Graph<T> graph, Vertex<T> v1, Vertex<T> v2, int peso) {
        graph.connect(v1, v2, peso);
        graph.connect(v2, v1, peso);
    }
}

