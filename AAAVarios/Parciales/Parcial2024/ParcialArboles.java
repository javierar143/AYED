package AAAVarios.Parcial2024;
import tp2.ejercicio2.*;

public class ParcialArboles {
    private BinaryTree<Integer> arbol;

    public ParcialArboles(BinaryTree <Integer> arbol){
        this.arbol =arbol;
    }

    public BinaryTree<Integer> nuevoTree (){
        BinaryTree<Integer> tree = new BinaryTree<>();

        if (this.arbol != null && !this.arbol.isEmpty())
            tree= construirArbol(this.arbol,0);
        return tree;
    }

    private BinaryTree<Integer> construirArbol (BinaryTree<Integer> original,int ValorPadre ){
        BinaryTree<Integer> nuevo = new BinaryTree<>();    
        int nuevoValor = original.getData() + ValorPadre;
        nuevo.setData(nuevoValor);

        if (original.hasLeftChild()){           
            nuevo.addLeftChild(construirArbol(original.getLeftChild(),original.getData()));
            
        }

        if (original.hasRightChild()){
            int valorNulo=0;
            nuevo.addRightChild(construirArbol(original.getRightChild(), valorNulo));
        }

        return nuevo;
    }
}
