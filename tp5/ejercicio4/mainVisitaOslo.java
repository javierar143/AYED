package tp5.ejercicio4;

import java.util.ArrayList;
import java.util.List;

import tp5.ejercicio1.Graph;
import tp5.ejercicio1.Vertex;
import tp5.ejercicio1.listaAdy.AdjListGraph;

public class mainVisitaOslo {
    public static void main(String[] args) {
        // 1.  grafo
        Graph<String> mapaOslo = new AdjListGraph<>();

        // 2. vértices (Lugares)
        Vertex<String> holmenkollen = mapaOslo.createVertex("Holmenkollen");
        Vertex<String> parqueVigeland = mapaOslo.createVertex("Parque Vigeland");
        Vertex<String> galeriaNacional = mapaOslo.createVertex("Galería Nacional");
        Vertex<String> parqueBotanico = mapaOslo.createVertex("Parque Botánico");
        Vertex<String> museoMunch = mapaOslo.createVertex("Museo Munch");
        Vertex<String> ayuntamiento = mapaOslo.createVertex("Ayuntamiento");
        Vertex<String> palacioReal = mapaOslo.createVertex("Palacio Real");
        Vertex<String> folkMuseum = mapaOslo.createVertex("FolkMuseum");
        Vertex<String> museoFram = mapaOslo.createVertex("Museo Fram");
        Vertex<String> museoBarcoPolar = mapaOslo.createVertex("Museo del Barco Polar");
        Vertex<String> museoVikingo = mapaOslo.createVertex("Museo Vikingo");
        Vertex<String> akkerBrigge = mapaOslo.createVertex("Akker Brigge");
        Vertex<String> elTigre = mapaOslo.createVertex("El Tigre");
        Vertex<String> laOpera = mapaOslo.createVertex("La Ópera");
        Vertex<String> fortalezaAkershus = mapaOslo.createVertex("Fortaleza Akershus");

        //lista de lugares restringidos
        List<String> lugaresRestingidos = new ArrayList<>(List.of("Holmenkollen", 
            "Palacio Real","Akker Brigge","La Ópera","Fortaleza Akershus"));
        
        // 3.  conexiones bidireccionales (Aristas con peso)
        
        // Zona Alta / Noroeste
        conectarBidireccional(mapaOslo, holmenkollen, parqueVigeland, 30);
        conectarBidireccional(mapaOslo, parqueVigeland, galeriaNacional, 10);
        conectarBidireccional(mapaOslo, galeriaNacional, parqueBotanico, 15);
        conectarBidireccional(mapaOslo, parqueBotanico, museoMunch, 1);
        
        // Zona Centro / Ayuntamiento
        conectarBidireccional(mapaOslo, parqueBotanico, ayuntamiento, 10);
        conectarBidireccional(mapaOslo, ayuntamiento, palacioReal, 5);
        conectarBidireccional(mapaOslo, ayuntamiento, akkerBrigge, 20);
        conectarBidireccional(mapaOslo, ayuntamiento, elTigre, 15);
        
        // Zona FolkMuseum / Península (Suroeste)
        conectarBidireccional(mapaOslo, parqueVigeland, folkMuseum, 20);
        conectarBidireccional(mapaOslo, folkMuseum, palacioReal, 5);
        conectarBidireccional(mapaOslo, folkMuseum, akkerBrigge, 30);
        conectarBidireccional(mapaOslo, folkMuseum, museoFram, 5);
        
        // Museos Marítimos / Vikingo
        conectarBidireccional(mapaOslo, museoFram, museoBarcoPolar, 5);
        conectarBidireccional(mapaOslo, museoBarcoPolar, museoVikingo, 5);
        conectarBidireccional(mapaOslo, museoVikingo, akkerBrigge, 30);
        
        // Zona Este / Ópera (Sureste)
        conectarBidireccional(mapaOslo, museoMunch, elTigre, 15);
        conectarBidireccional(mapaOslo, elTigre, laOpera, 5);
        conectarBidireccional(mapaOslo, laOpera, fortalezaAkershus, 10);
        
        System.out.println("¡Grafo de Oslo cargado exitosamente! Cantidad de vértices: " + mapaOslo.getSize());
        
        VisitaOslo vo = new VisitaOslo();
        int tiempoMaximo =91;         
        System.out.println("-------------------------------------------");
        System.out.println("Ciudades que se pueden visitar en "+ tiempoMaximo + " minutos");
        System.out.println(vo.paseoEnBici(mapaOslo, "Museo Vikingo", tiempoMaximo, lugaresRestingidos));

        System.out.println("-------------------------------------------");
    }

    /**
     * Método auxiliar para simular un grafo no dirigido en una estructura dirigida.
     * Conecta el origen con el destino y viceversa con el mismo peso.
     */
    private static <T> void conectarBidireccional(Graph<T> graph, Vertex<T> v1, Vertex<T> v2, int peso) {
        graph.connect(v1, v2, peso);
        graph.connect(v2, v1, peso);
    }
}

