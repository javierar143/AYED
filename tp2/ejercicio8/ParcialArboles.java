package tp2.ejercicio8;
import tp2.ejercicio2.*;

public class ParcialArboles {
    
    public boolean esPrefijo(BinaryTree<Integer> arbol1, BinaryTree<Integer> arbol2){
        boolean cumple = false;

        if (arbol1 != null && arbol2 !=null)
            cumple = verificarEsPrefijo (arbol1,arbol2);

        return cumple;
    }

    private boolean verificarEsPrefijo(BinaryTree<Integer> arbol1, BinaryTree<Integer> arbol2) {
        boolean cumple= false;

        if (arbol1.getData().equals(arbol2.getData())){
                cumple=true;
                if (arbol1.hasLeftChild()){
                    if (arbol2.hasLeftChild())
                        cumple= verificarEsPrefijo(arbol1.getLeftChild(), arbol2.getLeftChild());
                    else cumple=false;                    
                }               
                    
                if (cumple && arbol1.hasRightChild() ){
                    if (arbol2.hasRightChild())
                        cumple = verificarEsPrefijo(arbol1.getRightChild(), arbol2.getRightChild());
                    else cumple=false;    
                }
        }
        return cumple;
    }

}
