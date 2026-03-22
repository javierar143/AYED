package tp1.ejercicio7;

import java.util.*;

public class IncisoF {
    public boolean esCapicua(List <Integer> lista){
        int i = 0;
        int j = lista.size()-1;

        while (j>=0){
            if ((!lista.get(i).equals(lista.get(j)))){
                return false;      
            }
            j--;
            i++;        
        }
        return true;
    }
}
