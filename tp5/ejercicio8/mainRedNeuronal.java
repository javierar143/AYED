package tp5.ejercicio8;
  import tp5.ejercicio1.Graph;
import tp5.ejercicio1.Vertex;
import tp5.ejercicio1.listaAdy.AdjListGraph;

public class mainRedNeuronal {
    public static void main(String[] args) {
        // 1. Crear el grafo dirigido
        Graph<String> grafo = new AdjListGraph<>();

        // 2. Crear los vértices (N1 a N9)
        Vertex<String> n1 = grafo.createVertex("N1");
        Vertex<String> n2 = grafo.createVertex("N2");
        Vertex<String> n3 = grafo.createVertex("N3");
        Vertex<String> n4 = grafo.createVertex("N4");
        Vertex<String> n5 = grafo.createVertex("N5");
        Vertex<String> n6 = grafo.createVertex("N6");
        Vertex<String> n7 = grafo.createVertex("N7");
        Vertex<String> n8 = grafo.createVertex("N8");
        Vertex<String> n9 = grafo.createVertex("N9");

        // 3. Conectar los vértices según el sentido de las flechas y sus pesos
        
        // Conexiones desde N1
        grafo.connect(n1, n2, 200);
        grafo.connect(n1, n3, 80);
        grafo.connect(n1, n7, 100);

        // Conexiones desde N3
        grafo.connect(n3, n2, 20);
        grafo.connect(n3, n4, 1000);
        grafo.connect(n3, n5, 5);
        grafo.connect(n3, n6, 100);

        // Conexiones desde N7
        grafo.connect(n7, n9, 10);
        grafo.connect(n7, n8, 90);

        // Conexiones desde N8
        grafo.connect(n8, n9, 70);

        // Impresión en consola para verificar la carga
        System.out.println("¡Grafo cargado exitosamente!");
        System.out.println("Cantidad de vértices: " + grafo.getSize());

        RedNeuronal rn = new RedNeuronal();
        
        int impulso = 100;
        String inicio = "N1";

        System.out.println("---------------------------");
        System.out.println("La cantidad de Neuronas activadas es: "+ rn.neuronasActivadas(grafo, inicio, impulso));

    }


}
