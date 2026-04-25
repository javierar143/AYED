package tp3.ejercicio8;
import tp3.ejercicio1.*;

public class mainNavidad {
    public static void main(String[] args) {
        
        // Raíz
        GeneralTree<Integer> arbol = new GeneralTree<>(1);

        // Nivel 1 (la raíz tiene 3 hijos, todos hojas)
        GeneralTree<Integer> n2 = new GeneralTree<>(2);
        GeneralTree<Integer> n3 = new GeneralTree<>(3);
        GeneralTree<Integer> n4 = new GeneralTree<>(4);

        arbol.addChild(n2);
        arbol.addChild(n3);
        arbol.addChild(n4);
        

        //######################--NO ES ABETO---######################---------------------------
        /*
        // Raíz
        GeneralTree<Integer> arbol = new GeneralTree<>(1);

        // Nivel 1, no cumple porque solo tiene 2 hojas
        GeneralTree<Integer> n2 = new GeneralTree<>(2);
        GeneralTree<Integer> n3 = new GeneralTree<>(3);
        GeneralTree<Integer> n4 = new GeneralTree<>(4);

        arbol.addChild(n2);
        arbol.addChild(n3);
        arbol.addChild(n4);

        // Nivel 2 (solo n2 tiene hijos → y cumple la regla)
        GeneralTree<Integer> n5 = new GeneralTree<>(5);
        GeneralTree<Integer> n6 = new GeneralTree<>(6);
        GeneralTree<Integer> n7 = new GeneralTree<>(7);

        n2.addChild(n5);
        n2.addChild(n6);
        n2.addChild(n7);
        
*/
        // Prueba rápida
        System.out.println("PreOrden: ");
        arbol.imprimirPreOrden();
        System.out.println();

        Navidad n = new Navidad(arbol);

        System.out.println( n.esAbetoNavidenio()); 

        }
}
