package AAAVarios.Parciales.Grafos.prog320241F;
import java.util.ArrayList;
import java.util.List;
import tp5.ejercicio1.Graph;
import tp5.ejercicio1.Vertex;
import tp5.ejercicio1.Edge;
import tp5.ejercicio1.listaAdy.AdjListGraph;
import AAAVarios.Parciales.Grafos.prog320241F.DataClass;

public class mainParcialEstaciones {
    public static void main(String[] args) {
        // 1. Instanciar el grafo utilizando String
        Graph<String> redSubte = new AdjListGraph<>();

        // 2. Crear los vértices (Nodos con el nombre de cada estación)
        Vertex<String> butanta = redSubte.createVertex("Butantã");
        Vertex<String> pinheiros = redSubte.createVertex("Pinheiros");
        Vertex<String> villaLobos = redSubte.createVertex("Villa Lobos");
        Vertex<String> cUniversitaria = redSubte.createVertex("C. Universitaria");
        Vertex<String> hebraica = redSubte.createVertex("Hebraica");
        Vertex<String> cidadeJardim = redSubte.createVertex("Cidade Jardim");
        Vertex<String> vilaOlimpia = redSubte.createVertex("Vila Olímpia");
        Vertex<String> fariaLima = redSubte.createVertex("Faria Lima");
        Vertex<String> paulista = redSubte.createVertex("Paulista");
        Vertex<String> vilaMadalena = redSubte.createVertex("Vila Madalena");
        Vertex<String> clinicas = redSubte.createVertex("Clínicas");
        Vertex<String> trianon = redSubte.createVertex("Trianon");
        Vertex<String> brigadeiro = redSubte.createVertex("Brigadeiro");
        Vertex<String> tiradentes = redSubte.createVertex("Tiradentes");
        Vertex<String> armenia = redSubte.createVertex("Armenia");
        Vertex<String> republica = redSubte.createVertex("Republica");
        Vertex<String> luz = redSubte.createVertex("Luz");
        Vertex<String> paraiso = redSubte.createVertex("Paraiso");
        Vertex<String> sauda = redSubte.createVertex("Saúda");

        // 3. Conectar las estaciones de forma no dirigida (Bidireccional)
        
        // Eje Horizontal Principal
        conectarBidireccional(redSubte, butanta, pinheiros);
        conectarBidireccional(redSubte, pinheiros, fariaLima);
        conectarBidireccional(redSubte, fariaLima, paulista);
        conectarBidireccional(redSubte, paulista, republica);
        conectarBidireccional(redSubte, republica, luz);

        // Ramal vertical superior izquierdo (desde Pinheiros)
        conectarBidireccional(redSubte, pinheiros, cUniversitaria);
        conectarBidireccional(redSubte, cUniversitaria, villaLobos);

        // Ramal vertical inferior izquierdo (desde Pinheiros)
        conectarBidireccional(redSubte, pinheiros, hebraica);
        conectarBidireccional(redSubte, hebraica, cidadeJardim);
        conectarBidireccional(redSubte, cidadeJardim, vilaOlimpia);

        // Conexiones superiores desde Paulista
        
        conectarBidireccional(redSubte, paulista, clinicas);
        conectarBidireccional(redSubte, paulista, tiradentes);
        conectarBidireccional(redSubte, clinicas, vilaMadalena);

        // Ramal vertical inferior desde Paulista
        conectarBidireccional(redSubte, paulista, trianon);
        conectarBidireccional(redSubte, trianon, brigadeiro);

        // Conexiones desde Tiradentes
        conectarBidireccional(redSubte, tiradentes, armenia);
        conectarBidireccional(redSubte, tiradentes, republica);

        // Ramal vertical inferior derecho (desde Republica)
        conectarBidireccional(redSubte, republica, paraiso);
        conectarBidireccional(redSubte, paraiso, sauda);


        Parcial parcial = new Parcial();

        System.out.println("--------------------------------------------------------------");
        String origen = "Butantã";
        imprimirLista(parcial.menosTrasbordos(redSubte, origen));
        
    }

    /**
     * Simula una arista no dirigida conectando en ambos sentidos.
     */
    private static void conectarBidireccional(Graph<String> graph, Vertex<String> v1, Vertex<String> v2) {
        graph.connect(v1, v2);
        graph.connect(v2, v1);
    }

    /**
     * Recibe una lista de objetos DataClass e imprime sus atributos.
     */
    public static void imprimirLista(List<DataClass> lista) {
        if (lista == null || lista.isEmpty()) {
            System.out.println("La lista está vacía.");
            return;
        }

        for (DataClass item : lista) {
            System.out.println("Estación: " + item.getEstacion() + " | Transbordos: " + item.getCantTransbordos());
        }
    }
}
