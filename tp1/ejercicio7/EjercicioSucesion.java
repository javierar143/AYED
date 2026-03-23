package tp1.ejercicio7;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
// contiene hasta el inciso 7i
public class EjercicioSucesion {

    
    
    public List<Integer> calcularSucesion (int n){
        List<Integer> lista = new ArrayList<>();
        armarSucesion(n, lista);
        return lista;
    }

    private void armarSucesion(int n,List<Integer> lista){
        lista.add(n);

        if (n == 1) {
            return;
        }

        if (n % 2 == 0) {
            armarSucesion(n / 2, lista);
        } else {
            armarSucesion(3 * n + 1, lista);
        }             
    }
    
    public void invertirArrayList(List<Integer> lista){
        List <Integer> ListaTemp = new ArrayList<>();
        
        invertirArray(lista.size()-1, lista,ListaTemp);
        lista.clear();
        lista.addAll(ListaTemp);
    }

    private void invertirArray (int pos,List <Integer> lista, List <Integer> ListaTemp){
        if (pos>=0){
            ListaTemp.add(lista.get(pos));
            invertirArray(--pos, lista,ListaTemp);
        }
    }

    public int sumarLinkedList(LinkedList<Integer> lista){
        int pos = lista.size()-1;
        int suma =0;
        return sumarLista(pos,suma, lista);
    }

    private int sumarLista(int pos,int suma, LinkedList<Integer> lista){
        
        if (pos >=0){
            suma+=lista.get(pos);
            return sumarLista(--pos,suma, lista);
        }
        else return suma;
    }
}

