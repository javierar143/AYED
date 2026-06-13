package AAAVarios.Parciales.Grafos.Parcial;
import java.util.*;
import tp5.ejercicio1.*;

public class ParcialGrafos {
    public List <String> rutaConCifrado(Graph <String> red, String origen, String destino){
        List< String> ruta = new ArrayList<>();
        if (red != null && !red.isEmpty()){
            Vertex<String> verticeInicio = red.search(origen);
            Vertex<String> verticeDestino = red.search(destino);
             if (verticeInicio != null  && verticeDestino != null){
                List< String> rutatemp = new ArrayList<>();
                boolean [] marca= new boolean[red.getSize()];
                int pos = verticeInicio.getPosition();
                marca[pos]=true;
                rutatemp.add(origen);
                String anterior = "impar";
                dfsBuscarRuta (pos,red,destino,anterior,ruta,rutatemp,marca);//no pase marca []
             }

        }



        return ruta;
    }

    private void dfsBuscarRuta(int pos, Graph<String> red, String destino, String anterior, List<String> ruta,
            List<String> rutaTemp, boolean [] marca) {

        int j;
        Vertex <String> vertice = red.getVertex(pos);
        List <Edge <String>> aristas = red.getEdges(vertice);

        Iterator <Edge<String>> it = aristas.iterator();

        while (it.hasNext()  && ruta.isEmpty()){
            Edge<String> arista = it.next();
            Vertex <String> verticeSiguiente = arista.getTarget();
            j= verticeSiguiente.getPosition();

            if (!marca[j]){
                marca[j]= true;
                int valorArista=arista.getWeight();
                if (verticeSiguiente.getData().equals(destino) && ( (valorArista % 2 ==0 && anterior.equals("impar")) ||
                    (valorArista % 2 !=0 && anterior.equals("par")) )){
                        rutaTemp.add(destino);
                        ruta.addAll(rutaTemp);
                    }
                else{ if (anterior.equals("impar") &&  valorArista %2==0){
                    rutaTemp.add(verticeSiguiente.getData());
                    dfsBuscarRuta (j,red,destino,"par",ruta,rutaTemp,marca);
                    rutaTemp.remove(rutaTemp.size()-1);
                    }

                    else if (anterior.equals("par") && valorArista %2 != 0){
                    rutaTemp.add(verticeSiguiente.getData());
                    dfsBuscarRuta (j,red,destino,"impar",ruta,rutaTemp,marca);
                    rutaTemp.remove(rutaTemp.size()-1);

                    }


                }//fin del 1er else
                marca[j] =false;

            }

        }//fin while

    }//fin metodo priv
}//fin clase
