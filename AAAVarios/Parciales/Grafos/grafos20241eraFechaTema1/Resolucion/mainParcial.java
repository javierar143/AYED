package AAAVarios.Parciales.grafos20241eraFechaTema1.Resolucion;
import tp5.ejercicio1.Graph;
import tp5.ejercicio1.Vertex;
import tp5.ejercicio1.listaAdy.AdjListGraph;
import AAAVarios.Parciales.grafos20241eraFechaTema1.Resolucion.Recinto;

public class mainParcial {
    public static void main(String[] args) {
        // 1. Instanciar el grafo con objetos de tipo Recinto
        Graph<Recinto> bioparque = new AdjListGraph<>();
        Graph<Recinto> bioparqueNull = null;

        // 2. Crear los objetos Recinto con sus nombres y tiempos de visita individuales
        Recinto rEntrada = new Recinto("ENTRADA", 15);

        Recinto rCebras = new Recinto("Cebras", 10);
        Recinto rTigres = new Recinto("Tigres", 10);
        Recinto rFlamencos = new Recinto("Flamencos", 10);
        Recinto rMurcielagos = new Recinto("Murciélagos", 20);
        Recinto rWallabies = new Recinto("Wallabies", 30);
        Recinto rTortugas = new Recinto("Tortugas", 10);
        Recinto rPumas = new Recinto("Pumas", 10);

        //2.b cargo mal la entrada asi "no existe", comentar la linea 14 para probar
        //Recinto rEntrada = new Recinto("x", 15);

        // 3. Crear los vértices del grafo encapsulando cada recinto
        Vertex<Recinto> entrada = bioparque.createVertex(rEntrada);
        Vertex<Recinto> cebras = bioparque.createVertex(rCebras);
        Vertex<Recinto> tigres = bioparque.createVertex(rTigres);
        Vertex<Recinto> flamencos = bioparque.createVertex(rFlamencos);
        Vertex<Recinto> murcielagos = bioparque.createVertex(rMurcielagos);
        Vertex<Recinto> wallabies = bioparque.createVertex(rWallabies);
        Vertex<Recinto> tortugas = bioparque.createVertex(rTortugas);
        Vertex<Recinto> pumas = bioparque.createVertex(rPumas);

        // 4. Crear los caminos bidireccionales con los tiempos de traslado (en minutos)
        
        // Conexiones desde la Entrada
        conectarBidireccional(bioparque, entrada, cebras, 10);
        conectarBidireccional(bioparque, entrada, tigres, 15);
        conectarBidireccional(bioparque, entrada, murcielagos, 20);
        conectarBidireccional(bioparque, entrada, flamencos, 25);

        // Conexiones de la zona superior / media
        conectarBidireccional(bioparque, cebras, tigres, 8);
        conectarBidireccional(bioparque, cebras, tortugas, 5);

        // Conexiones de la zona inferior / izquierda
        conectarBidireccional(bioparque, flamencos, murcielagos, 25);
        conectarBidireccional(bioparque, murcielagos, wallabies, 10);

        // Conexiones de la zona derecha / pumas
        conectarBidireccional(bioparque, wallabies, tortugas, 10);
        conectarBidireccional(bioparque, tortugas, pumas, 15);

        // Mensaje de control de carga
        System.out.println("¡Grafo del Bioparque cargado correctamente!");
        System.out.println("Cantidad de recintos: " + bioparque.getSize());



        System.out.println("----------------------------------------------------");
        Parcial parcial = new Parcial();
        int TiempoDisponible = 35;
        
        System.out.println("La cantidad de Recintos que se puede visitar en  "+ TiempoDisponible + " minutos es: "+ 
        parcial.resolver(bioparque, TiempoDisponible));
        //grafo null
        //System.out.println("La cantidad de Recintos que se puede visitar en  "+ TiempoDisponible + " minutos es: "+ 
        //parcial.resolver(bioparqueNull, TiempoDisponible));
        
        System.out.println("----------------------------------------------------");
    }

    /**
     * Método auxiliar para modelar las aristas bidireccionales del bioparque.
     */
    private static <T> void conectarBidireccional(Graph<T> graph, Vertex<T> v1, Vertex<T> v2, int peso) {
        graph.connect(v1, v2, peso);
        graph.connect(v2, v1, peso);
    }
    
}
