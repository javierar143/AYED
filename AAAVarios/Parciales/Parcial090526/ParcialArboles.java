package AAAVarios.Parciales.Parcial090526;

import tp2.ejercicio2.BinaryTree;

public class ParcialArboles {
    public static int diferenciaParesImpares(BinaryTree<Integer> arbol){
        int resultado=0;
        Data data = new Data();

        if (arbol!=null && !arbol.isEmpty()){
            calcularValor (arbol,data);
            resultado= data.getValorPares() - data.getValorImpares();
        }

        return resultado;
    }

    private static void calcularValor(BinaryTree<Integer> tree, Data data) {
        if (tree.hasLeftChild() && tree.hasRightChild()){
            if (tree.getData()% 2 == 0)
                data.setValorPares(data.getValorPares()+tree.getData());
        }
        else if (tree.hasLeftChild() || tree.hasRightChild())
                if (tree.getData()% 2 != 0)
                     data.setValorImpares(data.getValorImpares()+tree.getData());
        
        if (tree.hasLeftChild())
                calcularValor(tree.getLeftChild(),data);

        if (tree.hasRightChild())
                calcularValor(tree.getRightChild(),data);

    }
}
