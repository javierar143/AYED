package tp3.ejercicio5;

import java.util.LinkedList;
import java.util.List;


public class mainEsAncestro {
    public static void main(String[] args) {
        
    
    GeneralTree <Integer> arbolG = new GeneralTree<Integer>(14);

        
        List <GeneralTree<Integer>> hijos14 = new LinkedList<>();

        GeneralTree<Integer> h13 = new GeneralTree<Integer>(13);
        GeneralTree<Integer> h25 = new GeneralTree<Integer>(25);
        GeneralTree<Integer> h10 = new GeneralTree<Integer>(10);
        
        arbolG.setChildren(hijos14);
        hijos14.addAll(List.of(h13, h25, h10));

        List <GeneralTree<Integer>> hijos13 = new LinkedList<>();
        List <GeneralTree<Integer>> hijos25 = new LinkedList<>();
        List <GeneralTree<Integer>> hijos10 = new LinkedList<>();

        GeneralTree<Integer> h4 = new GeneralTree<Integer>(4);
        GeneralTree<Integer> h7 = new GeneralTree<Integer>(7);
        GeneralTree<Integer> h5 = new GeneralTree<Integer>(5);
        
        hijos13.addAll(List.of(h4, h7, h5));
        h13.setChildren(hijos13);

        GeneralTree<Integer> h6 = new GeneralTree<Integer>(6);
        GeneralTree<Integer> h10b = new GeneralTree<Integer>(10);
        GeneralTree<Integer> h18 = new GeneralTree<Integer>(18);

        hijos25.addAll(List.of(h6, h10b, h18));
        h25.setChildren(hijos25);


        GeneralTree<Integer> h9 = new GeneralTree<Integer>(9);
        GeneralTree<Integer> h12 = new GeneralTree<Integer>(12);
        GeneralTree<Integer> h19 = new GeneralTree<Integer>(19);

        hijos10.addAll(List.of(h9, h12, h19));
        
        h10.setChildren(hijos10);
        
        System.out.println("Impresion PreOrden");
        arbolG.imprimirPreOrden();
        System.out.println();

        //test de esAncestro()
        int a = 13; //ancestro
        int b= 6; //descendiente de a

        if (arbolG.esAncestro(a,b)){
            System.out.println( a +" es ancestro de " + b);
        }
        else System.out.println( a +" NO es ancestro de " + b);
}
}
