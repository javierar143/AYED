package tp3.ejercicio10;
import tp3.ejercicio1.*;

public class mainParcialArboles10 {
  public static void main(String[] args) {
        // Raíz (Nivel 0)
        GeneralTree<Integer> arbolGeneral = new GeneralTree<>(1);

        // --- NIVEL 1 ---
        GeneralTree<Integer> n0_izq = new GeneralTree<>(0);
        GeneralTree<Integer> n1_centro = new GeneralTree<>(1);
        GeneralTree<Integer> n1_der = new GeneralTree<>(1);

        arbolGeneral.addChild(n0_izq);
        arbolGeneral.addChild(n1_centro);
        arbolGeneral.addChild(n1_der);

        // --- NIVEL 2 ---
        // Hijos de n0_izq
        GeneralTree<Integer> n1_nieto_izq = new GeneralTree<>(1);
        GeneralTree<Integer> n1_nieto_centro = new GeneralTree<>(1);
        n0_izq.addChild(n1_nieto_izq);
        n0_izq.addChild(n1_nieto_centro);

        // Hijos de n1_centro
        GeneralTree<Integer> n1_nieto_der1 = new GeneralTree<>(1);
        GeneralTree<Integer> n0_nieto_der2 = new GeneralTree<>(0);
        n1_centro.addChild(n1_nieto_der1);
        n1_centro.addChild(n0_nieto_der2);

        // Hijo de n1_der
        GeneralTree<Integer> n0_nieto_der3 = new GeneralTree<>(0);
        n1_der.addChild(n0_nieto_der3);

        // --- NIVEL 3 ---
        // Hijos del n1_nieto_izq
        GeneralTree<Integer> n0_bis_1 = new GeneralTree<>(0);
        GeneralTree<Integer> n0_bis_2 = new GeneralTree<>(0);
        GeneralTree<Integer> n1_bis_3 = new GeneralTree<>(1);
        n1_nieto_izq.addChild(n0_bis_1);
        n1_nieto_izq.addChild(n0_bis_2);
        n1_nieto_izq.addChild(n1_bis_3);

        // Hijo del n0_nieto_der2
        GeneralTree<Integer> n0_bis_4 = new GeneralTree<>(0);
        n0_nieto_der2.addChild(n0_bis_4);

        // Hijo del n0_nieto_der3
        GeneralTree<Integer> n0_bis_5 = new GeneralTree<>(0);
        n0_nieto_der3.addChild(n0_bis_5);

        // --- NIVEL 4 ---
        // Hijo del n0_bis_4
        GeneralTree<Integer> n1_tataranieto = new GeneralTree<>(1);
        n0_bis_4.addChild(n1_tataranieto);

        // Hijos del n0_bis_5
        GeneralTree<Integer> n0_tataranieto_1 = new GeneralTree<>(0);
        GeneralTree<Integer> n0_tataranieto_2 = new GeneralTree<>(0);
        n0_bis_5.addChild(n0_tataranieto_1);
        n0_bis_5.addChild(n0_tataranieto_2);

        // Prueba rápida
        System.out.println("PreOrden: ");
        arbolGeneral.imprimirPreOrden();
        System.out.println();
        
        System.out.println("Camino filtrado de valor maximo");
        for (Integer num: ParcialArboles.resolver(arbolGeneral))
            System.out.print(num+ " ");
        System.out.println();

         System.out.println("Camino filtrado de valor maximo con backtracking");
        for (Integer num: ParcialArbolesBacktracking.resolver(arbolGeneral))
            System.out.print(num+ " ");
        System.out.println();
  }
}
