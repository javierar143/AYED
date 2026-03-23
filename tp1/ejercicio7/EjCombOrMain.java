package tp1.ejercicio7;

import java.util.*;

public class EjCombOrMain {
    public static void main(String[] args) {
        ArrayList <Integer> ordenada1 = new ArrayList<>(List.of(1,3,5,7));
        ArrayList <Integer> ordenada2 = new ArrayList<>(List.of(2,4));

        EjCombinarOrdenado co = new EjCombinarOrdenado();

        for (int n: co.combinarOrdenado(ordenada1,ordenada2)){
            System.out.print(n + " ");
        }
        System.out.println();
    }
}
