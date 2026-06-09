package AAAVarios.Parciales.Grafos.a20242daFechaTema1;

import tp5.ejercicio1.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import tp1.ejercicio8.Queue;


public class Parcial {
    
    public List<RedSocial> invitacionMasterClass (Graph <String> red, String usuario, int distancia , int limite){
        List <RedSocial>  invitados = new ArrayList<>();
        if  (red != null && !red.isEmpty()){
            
            Vertex <String> verticeInicio = red.search(usuario);
            if (verticeInicio != null){
                boolean marca[] = new boolean [red.getSize()];
                int pos = verticeInicio.getPosition();
                marca[pos] =true;
                Queue <Vertex<String>> cola = new Queue<>();
                cola.enqueue(verticeInicio);
                cola.enqueue(null);
                bfsArmarListaInvitados (marca, red, distancia,limite, invitados,cola);
            }
            
        }
        return invitados;

    }//fin metodo principal

    private void bfsArmarListaInvitados(boolean[] marca,  Graph<String> red, int distancia, int limite,
            List<RedSocial> invitados, Queue<Vertex<String>> cola) {
                int distanciaActual=0;

                while (!cola.isEmpty() && distanciaActual <= distancia && invitados.size() < limite){
                    Vertex <String> vertice = cola.dequeue();                    

                    if (vertice !=null){                       
                        
                        if (distanciaActual>0){
                                RedSocial usuarioActual = new RedSocial(vertice.getData(),distanciaActual);                                
                                invitados.add(usuarioActual);
                            }
                        List <Edge<String>> aristas = red.getEdges(vertice);
                        Iterator <Edge<String>> it = aristas.iterator();
                        while (it.hasNext() && distanciaActual<distancia){
                            Edge<String> arista = it.next();
                            int j = arista.getTarget().getPosition();
                            if (!marca[j]){
                                marca [j]=true;
                                cola.enqueue(arista.getTarget());                            
                            
                            }
                        }
                       
                    }

                    else 
                         if (!cola.isEmpty()){
                            distanciaActual++;
                            cola.enqueue(null);
                        }
                    

                }
        
     }
}//fin clase
