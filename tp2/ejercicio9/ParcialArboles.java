package tp2.ejercicio9;
import tp2.ejercicio2.*;

public class ParcialArboles {
   
    public BinaryTree<Data> sumAndDif(BinaryTree<Integer> arbol){
        int suma=0;
        int NumPadre=0;
        BinaryTree<Data> newTree = new BinaryTree<>();
        if (arbol!= null)
            newTree = armarArbolData(arbol,NumPadre,suma);
         
        return newTree;
    }

    private BinaryTree<Data> armarArbolData(BinaryTree<Integer> arbolOriginal, int padre, int suma) {
        BinaryTree<Data> newTree = new BinaryTree<>();
        Data datos = new Data();
        suma+= arbolOriginal.getData();
        
        datos.setAcumulado(suma);
        datos.setDiferencia(arbolOriginal.getData()-padre);
        
        newTree.setData(datos);

        if (arbolOriginal.hasLeftChild())
            newTree.addLeftChild(armarArbolData(arbolOriginal.getLeftChild(),arbolOriginal.getData(),suma));
        

        if (arbolOriginal.hasRightChild())
            newTree.addRightChild(armarArbolData(arbolOriginal.getRightChild(),arbolOriginal.getData(),suma));

        return newTree;
     }

}
