package tp1.ejercicio7;

import java.util.ArrayList;

public class EjCombinarOrdenado {
    public ArrayList<Integer> combinarOrdenado(ArrayList<Integer> lista1,
    ArrayList<Integer> lista2){
        ArrayList <Integer> listaCombinada = new ArrayList<>();
        int i=0;
        int j=0;

        while (i<lista1.size() && j < lista2.size()){
            if ((lista1.get(i)) < (lista2.get(j))){
                listaCombinada.add(lista1.get(i));
                i++;
            }
            else {
                listaCombinada.add(lista2.get(j));
                j++;

            }
        }

        if (i<lista1.size() ){
            listaCombinada.addAll(lista1.subList(i, lista1.size()));
        }

        if (j<lista2.size() ){
            listaCombinada.addAll(lista2.subList(j, lista2.size()));
        }



        return listaCombinada;
    }
}
