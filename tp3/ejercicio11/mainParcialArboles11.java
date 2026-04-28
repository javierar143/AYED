package tp3.ejercicio11;
import tp3.ejercicio1.*;

public class mainParcialArboles11 {
    public static void main(String[] args) {
        // --- Nivel 0 (Raíz) ---       
        GeneralTree<Integer> arbolGeneral = new GeneralTree<>(2);

        // --- Nivel 1 ---
        // Hijos de la raíz (2):
        // Izquierdo: 1, Derecho: 25
        GeneralTree<Integer> n1_1 = new GeneralTree<>(1);
        GeneralTree<Integer> n1_25 = new GeneralTree<>(25);
       

        arbolGeneral.addChild(n1_1);
        arbolGeneral.addChild(n1_25);

        // --- Nivel 2 ---
        // Hijos de n1_1 (1):
        // Izquierdo: 5, Derecho: 4
        GeneralTree<Integer> n2_5 = new GeneralTree<>(5);
        GeneralTree<Integer> n2_4 = new GeneralTree<>(4);

        n1_1.addChild(n2_5);
        n1_1.addChild(n2_4);

        // Hijo de n1_25 (25):
        // Único hijo: 13 (a la derecha)
        GeneralTree<Integer> n2_13 = new GeneralTree<>(13);

        //#######-----------descomentar las 2 siguienes lineas  para que no sea creciente-------############
        //GeneralTree<Integer> n2_77 = new GeneralTree<>(77);
        //n1_25.addChild(n2_77);
        //#######-----------/////////////////////////////////////////////////////////////-------############

        n1_25.addChild(n2_13);

        // --- Nivel 3 ---
        // Hijos de n2_5 (5):
        // Único hijo: 18 
        GeneralTree<Integer> n3_18 = new GeneralTree<>(18);

        n2_5.addChild(n3_18);

        // Hijos de n2_4 (4):
        // Izquierdo: 7, Centro: 11, Derecho: 3
        GeneralTree<Integer> n3_7 = new GeneralTree<>(7);
        GeneralTree<Integer> n3_11 = new GeneralTree<>(11);
        GeneralTree<Integer> n3_3 = new GeneralTree<>(3);

        n2_4.addChild(n3_7);
        n2_4.addChild(n3_11);
        n2_4.addChild(n3_3);

        // --- Nivel 4 ---
        // Hijo de n3_18 (18):
        // Único hijo: 83
        GeneralTree<Integer> n4_83 = new GeneralTree<>(83);

        n3_18.addChild(n4_83);

        // Hijos de n3_3 (3):
        // Izquierdo: 33, Centro-Izq: 12, Centro-Der: 17, Derecho: 9
        GeneralTree<Integer> n4_33 = new GeneralTree<>(33);
        GeneralTree<Integer> n4_12 = new GeneralTree<>(12);
        GeneralTree<Integer> n4_17 = new GeneralTree<>(17);
        GeneralTree<Integer> n4_9 = new GeneralTree<>(9);

        n3_3.addChild(n4_33);
        n3_3.addChild(n4_12);
        n3_3.addChild(n4_17);
        n3_3.addChild(n4_9);

        // Prueba rápida
        System.out.println("PreOrden: ");
        arbolGeneral.imprimirPreOrden();
        System.out.println();

        System.out.println();
        if (ParcialArboles.resolver(arbolGeneral))
            System.out.println("Es un arbol creciente");
        else System.out.println("NO ES un arbol creciente");
        System.out.println();

    }
}
