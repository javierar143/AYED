package tp3.ejercicio2;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import tp3.ejercicio1.*;
import tp1.ejercicio8.*;

public class RecorridosAG {
     private void verificarCargarDatos (Integer datoArbol,Integer n, List<Integer> lista){
        if (datoArbol>n && datoArbol % 2 != 0 ){
            lista.add(datoArbol);
        }
    }

    //########################
    
    public List<Integer> numerosImparesMayoresQuePreOrden (GeneralTree <Integer> a, Integer n){
        List <Integer> lista = new ArrayList<>();
        //falta verificar el arbol!!!!!!!       
        armarListaImparesPreOrden(a,n,lista);    
       
        return lista;
    }

    private void armarListaImparesPreOrden (GeneralTree <Integer> a, Integer n, List<Integer> lista){
        int numeroActual = a.getData();
        verificarCargarDatos(numeroActual,n,lista);
        List <GeneralTree<Integer>> hijos = a.getChildren();
        for(GeneralTree<Integer> hijo : hijos){
            armarListaImparesPreOrden (hijo,n,lista);
        }
    }

    //########################
     
    public List<Integer> numerosImparesMayoresQueInOrden (GeneralTree <Integer> a,Integer n){
        List <Integer> lista = new ArrayList<>();
        if (a != null && !a.isEmpty())               
            armarListaImparesInOrden(a,n,lista); 
       
        return lista;
    }

    private void armarListaImparesInOrden (GeneralTree <Integer> a, Integer n, List<Integer> lista){
        List <GeneralTree<Integer>> hijos = a.getChildren();
        Integer datoArbol = a.getData();
        if (!hijos.isEmpty())//si no tiene hijos, pasa a linea cargardatos y el for no recorre, solo se procesa
            armarListaImparesInOrden(hijos.get(0),n,lista);
        verificarCargarDatos(datoArbol,n,lista);
        for (int i=1;i< hijos.size();i++)
            armarListaImparesInOrden(hijos.get(i), n, lista); 
    }
    //inOrden con itarator
     private void armarListaImparesInOrdenConIterator (GeneralTree <Integer> a, Integer n, List<Integer> lista){
        List <GeneralTree<Integer>> hijos = a.getChildren();
        Integer datoArbol = a.getData();
        Iterator<GeneralTree<Integer>> it = hijos.iterator();
        
        if (it.hasNext())//si no tiene hijos, pasa a linea cargardatos y el for no recorre, solo se procesa
            armarListaImparesInOrden(it.next(),n,lista);
        verificarCargarDatos(datoArbol,n,lista);
        while (it.hasNext())//
            armarListaImparesInOrden(it.next(),n,lista);
        
    }

    //########################

    public List<Integer> numerosImparesMayoresQuePostOrden (GeneralTree <Integer> a, Integer n){
        List <Integer> lista = new ArrayList<>();      
        if (a != null && !a.isEmpty()) 
            armarListaImparesPostOrden(a, n, lista);
        return lista;
    }


    private void armarListaImparesPostOrden(GeneralTree<Integer> a, Integer n, List<Integer> lista) {
        int valorActual= a.getData();
        List <GeneralTree<Integer>> hijos = a.getChildren();
        for (GeneralTree<Integer> hijo : hijos)
            armarListaImparesPostOrden(hijo, n, lista);
        verificarCargarDatos(valorActual, n, lista);

    }

    //########################

    public List<Integer> numerosImparesMayoresQuePorNiveles(GeneralTree <Integer> a,Integer n){
        List <Integer> lista = new ArrayList<>();
        if (a != null && !a.isEmpty()){
            Queue <GeneralTree<Integer>> cola = new Queue<GeneralTree<Integer>>();
            GeneralTree<Integer> tree;

            cola.enqueue(a);
            while (!cola.isEmpty()){
                tree = cola.dequeue();
                verificarCargarDatos(tree.getData(), n, lista);
                List<GeneralTree<Integer>> hijos = tree.getChildren();
                for (GeneralTree<Integer> hijo : hijos)
                    cola.enqueue(hijo);

        }  
    }     
        return lista;
    }

    //------------------------------------------
    //-------------------------------------------
    //metodo para imprimir las listas
    public void imprimirRecorrido(List<Integer>lista){
        for (Integer num : lista){
            System.out.print(num + " " );
        }

    }
}
