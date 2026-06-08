package AAAVarios.Parciales.Grafos.a20242daFechaTema1;

import tp5.ejercicio1.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import tp1.ejercicio8.Queue;


public class Parcial {
    
    public List<RedSocial> invitacionMasterClass (Graph <RedSocial> red, String usuario, int distancia , int limite){
        List <RedSocial>  invitados = new ArrayList<>();
        if  (red != null && !red.isEmpty()){
            RedSocial usuarioInicial = new RedSocial(usuario);
            Vertex <RedSocial> verticeInicio = red.search(usuarioInicial);
            if (verticeInicio != null){
                boolean marca[] = new boolean [red.getSize()];
                int pos = verticeInicio.getPosition();
                marca[pos] =true;
                Queue <Vertex<RedSocial>> cola = new Queue<>();
                cola.enqueue(verticeInicio);
                cola.enqueue(null);
                bfsArmarListaInvitados (marca, red, distancia,limite, invitados,cola);
            }
            
        }
        return invitados;

    }//fin metodo principal

    private void bfsArmarListaInvitados(boolean[] marca,  Graph<RedSocial> red, int distancia, int limite,
            List<RedSocial> invitados, Queue<Vertex<RedSocial>> cola) {
                int distanciaActual=0;

                while (!cola.isEmpty() && distanciaActual <= distancia && invitados.size() < limite){
                    Vertex <RedSocial> vertice = cola.dequeue();                    

                    if (vertice !=null){                       
                        
                        if (distanciaActual>0){
                                vertice.getData().setDistancia(distanciaActual);
                                invitados.add(vertice.getData());
                            }
                        List <Edge<RedSocial>> aristas = red.getEdges(vertice);
                        Iterator <Edge<RedSocial>> it = aristas.iterator();
                        while (it.hasNext() && distanciaActual<distancia){
                            Edge<RedSocial> arista = it.next();
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
