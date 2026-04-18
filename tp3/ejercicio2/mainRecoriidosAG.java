package tp3.ejercicio2;
import java.util.*;
import tp3.ejercicio1.*;

public class mainRecoriidosAG {
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

        System.out.println("Impresion InOrden");
        arbolG.imprimirInOrden();
        System.out.println();

        System.out.println("Impresion PostOrden");
        arbolG.imprimirPostOrden();
        System.out.println();

        System.out.println("La altura del arbol es " + arbolG.altura());

        RecorridosAG rag =new RecorridosAG();

        //numero para enviar
        int numero= 17;
        System.out.println("PreOrden -- Los numeros Impares mayores a "+ numero + " son:  ");
        rag.imprimirRecorrido(rag.numerosImparesMayoresQuePreOrden(arbolG,numero));
        System.out.println();

        numero=5;
        System.out.println("InOrden --Los numeros Impares mayores a "+ numero + " son:  ");
        rag.imprimirRecorrido(rag.numerosImparesMayoresQueInOrden(arbolG,numero));
        System.out.println();


        numero=12;
        System.out.println("postOrden --Los numeros Impares mayores a "+ numero + " son:  ");
        rag.imprimirRecorrido(rag.numerosImparesMayoresQuePostOrden(arbolG,numero));
        System.out.println();

        numero=12;
        System.out.println("Por Niveles --Los numeros Impares mayores a "+ numero + " son:  ");
        rag.imprimirRecorrido(rag.numerosImparesMayoresQuePorNiveles(arbolG,numero));
        System.out.println();


    }
}
