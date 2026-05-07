package AAAVarios.Parciales.Parcial3erafecha130724;
import java.util.List;

import tp3.ejercicio1.*;

public class mainPACaminos {
    public static void main(String[] args) {

        // Hojas de nodo 2
        GeneralTree<Integer> n16 = new GeneralTree<>(16);
        GeneralTree<Integer> n9  = new GeneralTree<>(9);

        // Hojas de nodo -3
        GeneralTree<Integer> n2 = new GeneralTree<>(2);
        n2.addChild(n16);
        n2.addChild(n9);
        GeneralTree<Integer> n1 = new GeneralTree<>(1);

        // Nodo -3
        GeneralTree<Integer> nMenos3 = new GeneralTree<>(-3);
        nMenos3.addChild(n2);
        nMenos3.addChild(n1);

        // Nodo 20 (hoja)
        GeneralTree<Integer> n20 = new GeneralTree<>(20);

        // Nodo 5
        GeneralTree<Integer> n5 = new GeneralTree<>(5);
        n5.addChild(nMenos3);
        n5.addChild(n20);

        // Nodo 6 (hoja)
        GeneralTree<Integer> n6 = new GeneralTree<>(6);

        // Hojas de nodo 19
        GeneralTree<Integer> n93  = new GeneralTree<>(93);
        GeneralTree<Integer> n8   = new GeneralTree<>(8);
        n8.addChild(n93);
        GeneralTree<Integer> nMenos5 = new GeneralTree<>(-5);

        // Nodo 19
        GeneralTree<Integer> n19 = new GeneralTree<>(19);
        n19.addChild(n8);
        n19.addChild(nMenos5);

        // Nodo 4 con hijo 15
        GeneralTree<Integer> n15 = new GeneralTree<>(15);
        GeneralTree<Integer> n4  = new GeneralTree<>(4);
        n4.addChild(n15);

        // Nodo -9
        GeneralTree<Integer> nMenos9 = new GeneralTree<>(-9);
        nMenos9.addChild(n19);
        nMenos9.addChild(n4);

        // Nodo 7 (hoja)
        GeneralTree<Integer> n7 = new GeneralTree<>(7);

        // Raíz: 30
        GeneralTree<Integer> arbol = new GeneralTree<>(30);
        arbol.addChild(n5);
        arbol.addChild(n6);
        arbol.addChild(nMenos9);
        arbol.addChild(n7);

        // Prueba rápida
        System.out.println("PreOrden: ");
        arbol.imprimirPreOrden();
        System.out.println();

        ParcialArboles pa = new ParcialArboles(arbol);

        imprimirCaminos (pa.caminos());

    }

    public static void imprimirCaminos(List<List<Integer>> caminos) {
    for (List<Integer> camino : caminos) {
        System.out.print("{ ");
        for (Integer valor : camino) {
            System.out.print(valor + " ");
        }
        System.out.println("}");
    }
}
}
