package tp2.ejercicio3;
import java.util.ArrayList;
import java.util.List;

import tp2.ejercicio2.*;

public class ContadorArbol {
    
    private BinaryTree <Integer> arbol;    


    public ContadorArbol(BinaryTree<Integer> arbol) {
        this.arbol = arbol;
    }

    //inciso a: inOrden
    public List<Integer> numerosParesA (){ //no recibo el arbol como parametro porque se respeta la firma del metodo en el enunciado
        
        List<Integer> lista = new ArrayList<>();
       if (this.arbol != null) lista =  recorridoInOrden (this.arbol, lista);
        
        return lista;
    }

    private List<Integer> recorridoInOrden (BinaryTree<Integer> tree, List<Integer> lista){
        if (!tree.isEmpty()){
            if (tree.hasLeftChild())
                this.recorridoInOrden(tree.getLeftChild(),lista);

            if (tree.getData() % 2 == 0)
                lista.add(tree.getData());

            if (tree.hasRightChild())
                this.recorridoInOrden(tree.getRightChild(),lista);

        }     

        return lista;
    }

    //inciso B: postOrden
    public List<Integer> numerosParesB (){ //no recibo el arbol como parametro porque se respeta la firma del metodo en el enunciado
        
        List<Integer> lista = new ArrayList<>();

        if (this.arbol != null)
            lista =  recorridoPostOrden (this.arbol, lista);
                    
        return lista;
    }

    private List<Integer> recorridoPostOrden (BinaryTree<Integer> tree, List<Integer> lista){
        if (!tree.isEmpty()){
            if (tree.hasLeftChild())
                this.recorridoPostOrden(tree.getLeftChild(),lista);           

            if (tree.hasRightChild())
                this.recorridoPostOrden(tree.getRightChild(),lista);

             if (tree.getData() % 2 == 0)
                lista.add(tree.getData());

        }     

        return lista;
    }
    
}
