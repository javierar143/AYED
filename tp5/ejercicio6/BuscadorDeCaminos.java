package tp5.ejercicio6;

import java.util.ArrayList;
import java.util.List;

import tp5.ejercicio1.*;

public class BuscadorDeCaminos {
    private Graph<String> bosque;
    
    public BuscadorDeCaminos(Graph<String> bosque) {
        this.bosque = bosque;
    }



    public List <List <String>> recorridosMasSeguro(){
        List<List<String>> caminosSeguros = new ArrayList<>();
        List <String> listaTemp= new ArrayList<>();

        if (!this.bosque.isEmpty()){
            String lugarInicio = "Casa Capezurdita";
            String lugarDestino = "Casa Abuelita";
            Vertex <String> verticeInicial = bosque.search(lugarInicio);
            Vertex <String> verticeDestino = bosque.search(lugarDestino);

            if (verticeInicial !=null && verticeDestino!=null){
                boolean [] marca = new boolean[bosque.getSize()];
                int pos = verticeInicial.getPosition();
                marca[pos]= true;
                listaTemp.add(verticeInicial.getData());

                dfsCargarCaminos(pos,bosque,marca,caminosSeguros,listaTemp, lugarDestino);
            }
        }

        return caminosSeguros;
    }



    private void dfsCargarCaminos(int pos, Graph<String> bosque, boolean[] marca, List<List<String>> caminosSeguros,
            List<String> listaTemp, String lugarDestino) {
        int j;
        Vertex<String> verticeInicio = bosque.getVertex(pos);
        List <Edge<String>> aristas = bosque.getEdges(verticeInicio);

        for (Edge<String> arista : aristas){
            Vertex <String> verticeActual = arista.getTarget();
            j= verticeActual.getPosition();
            int cantFrutales = arista.getWeight();

            if (cantFrutales < 5 && !marca[j]){
                marca[j]=true;
                listaTemp.add(verticeActual.getData());
                if (verticeActual.getData().equals(lugarDestino)){
                    caminosSeguros.add(new ArrayList<>(listaTemp));
                }
                else{
                    dfsCargarCaminos(j,bosque,marca,caminosSeguros,listaTemp,lugarDestino);
                }
                marca[j]=false;
                listaTemp.remove(listaTemp.size()-1);
            }
        }

    }



}//fin de la clase