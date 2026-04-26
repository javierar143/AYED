package tp3.ejercicio9;
import tp3.ejercicio1.*;

public class ParcialArboles {

    public static boolean esDeSeleccion (GeneralTree<Integer> arbol){
        boolean cumple= false;
        if (arbol != null && !arbol.isEmpty())
            cumple = verificarEsDeSeleccion(arbol);

        return cumple;
    }

    private static boolean verificarEsDeSeleccion(GeneralTree<Integer> arbol) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'verificarEsDeSeleccion'");
    }
}
