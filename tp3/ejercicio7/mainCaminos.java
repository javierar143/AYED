package tp3.ejercicio7;
import tp3.ejercicio1.GeneralTree;

public class mainCaminos {
    public static void main(String[] args) {

        // Raíz
        GeneralTree<Integer> arbolGeneral = new GeneralTree<>(12);

        // Nivel 1
        GeneralTree<Integer> n17 = new GeneralTree<>(17);
        GeneralTree<Integer> n9 = new GeneralTree<>(9);
        GeneralTree<Integer> n15 = new GeneralTree<>(15);

        arbolGeneral.addChild(n17);
        arbolGeneral.addChild(n9);
        arbolGeneral.addChild(n15);

        // Hijos de 17
        GeneralTree<Integer> n10 = new GeneralTree<>(10);
        GeneralTree<Integer> n6 = new GeneralTree<>(6);

        n17.addChild(n10);
        n17.addChild(n6);

        // Hijo de 6
        GeneralTree<Integer> n1 = new GeneralTree<>(1);
        n6.addChild(n1);

        // Hijo de 9
        GeneralTree<Integer> n8 = new GeneralTree<>(8);
        n9.addChild(n8);

        // Hijos de 15
        GeneralTree<Integer> n14 = new GeneralTree<>(14);
        GeneralTree<Integer> n18 = new GeneralTree<>(18);

        n15.addChild(n14);
        n15.addChild(n18);

        // Hijos de 14
        GeneralTree<Integer> n16 = new GeneralTree<>(16);
        GeneralTree<Integer> n7 = new GeneralTree<>(7);

        n14.addChild(n16);
        n14.addChild(n7);

        // Prueba rápida
        System.out.println("PreOrden: ");
        arbolGeneral.imprimirPreOrden();
        System.out.println();

        System.out.println("Lista de arriba hacia abajo");
        Caminos caminoMasLargo = new Caminos(arbolGeneral);
        System.out.println("La lista de numeros del camino mas largo es "+ caminoMasLargo.caminoAHojaMasLejana().toString());

        System.out.println("Lista de abajo hacia arriba");
       
        System.out.println("La lista de numeros del camino mas largo es "+ caminoMasLargo.caminoAHojaMasLejanaHaciaArriba().toString());
    }
}


