package tp3.ejercicio9;
import tp3.ejercicio1.*;

public class mainParcialArboles9 {
    public static void main(String[] args) {
        // Raíz
        GeneralTree<Integer> arbolGeneral = new GeneralTree<>(12);

        // --- NIVEL 1 ---
        GeneralTree<Integer> n12_izq = new GeneralTree<>(12);
        GeneralTree<Integer> n25_der = new GeneralTree<>(25);

        arbolGeneral.addChild(n12_izq);
        arbolGeneral.addChild(n25_der);

        // --- NIVEL 2 ---
        // Hijos del 12 de la izquierda
        GeneralTree<Integer> n35_izq = new GeneralTree<>(35);
        //GeneralTree<Integer> n12_centro = new GeneralTree<>(12);
        //alternativa para que de falso: (para probarlo comenar la linea anterior)
        GeneralTree<Integer> n12_centro = new GeneralTree<>(18);

        n12_izq.addChild(n35_izq);
        n12_izq.addChild(n12_centro);

        // Hijo del 25 de la derecha
        GeneralTree<Integer> n25_hijo = new GeneralTree<>(25);
        n25_der.addChild(n25_hijo);

        // --- NIVEL 3 ---
        // Hijo del 35
        GeneralTree<Integer> n35_nieto = new GeneralTree<>(35);
        n35_izq.addChild(n35_nieto);

        // Hijos del 12 central
        GeneralTree<Integer> n14 = new GeneralTree<>(14);
        GeneralTree<Integer> n12_hoja = new GeneralTree<>(12);
        GeneralTree<Integer> n33_padre = new GeneralTree<>(33);

        n12_centro.addChild(n14);
        n12_centro.addChild(n12_hoja);
        n12_centro.addChild(n33_padre);

        // --- NIVEL 4 ---
        // Hijo del 35 (el último de la rama izquierda)
        GeneralTree<Integer> n35_bisnieto = new GeneralTree<>(35);
        n35_nieto.addChild(n35_bisnieto);

        // Hijos del 33
        GeneralTree<Integer> n35_h33 = new GeneralTree<>(35);
        GeneralTree<Integer> n83_h33 = new GeneralTree<>(83);
        GeneralTree<Integer> n90_h33 = new GeneralTree<>(90);
        GeneralTree<Integer> n33_hoja = new GeneralTree<>(33);

        n33_padre.addChild(n35_h33);
        n33_padre.addChild(n83_h33);
        n33_padre.addChild(n90_h33);
        n33_padre.addChild(n33_hoja);

        // Prueba rápida
        System.out.println("PreOrden: ");
        arbolGeneral.imprimirPreOrden();
        System.out.println();

        if (ParcialArboles.esDeSeleccion(arbolGeneral)){
            System.out.println( "Es un arbol de seleccion");
        }
        else 
             System.out.println("NO ES arbol de seleccion");
    }
}
