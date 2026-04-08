package tp2.ejercicio4;

import tp2.ejercicio2.*;

public class RedBinariaLlena {
    //se utilizara recorrido en profundidad
    private BinaryTree<Integer> arbol;

    public RedBinariaLlena (BinaryTree<Integer> arbol){
        this.arbol=arbol;
    }

    
    public int retardoReenvioA(){
               
        int retardo=0;
        int max = Integer.MIN_VALUE;
        int suma = 0;
        if (this.arbol !=null)//agregar que no sea vacio el arbol
            //calcular de arriba hacia abajo
            retardo = calcularMaximoRetardo(this.arbol,max,suma);           

        return retardo;
    }  
    
    //recorrido de arriba hacia abajo
    private int calcularMaximoRetardo(BinaryTree<Integer> tree, int max, int suma) {
        suma += tree.getData();

        if (tree.isLeaf()){
            if (suma>max) 
                max=suma;
        }

        else{
            if (tree.hasLeftChild()){
                max= calcularMaximoRetardo(tree.getLeftChild(),max,suma);
            }
            if (tree.hasRightChild()){
                max = calcularMaximoRetardo(tree.getRightChild(),max,suma);
            }
        }
        
        
        return max;
    }

    //-----------------------------
    //---------------------------
    public int retardoReenvioB(){
               
        int retardo=0;
        if (this.arbol !=null)
            //calcular de abajo hacia arriba
            retardo = calcularMaximoRetardo(this.arbol);           

        return retardo;
    }
    //recorrido de abajo hacia arriba
    private int calcularMaximoRetardo(BinaryTree<Integer> tree) {
        int retardo;
        if (tree.isLeaf()) {                           
            retardo=tree.getData();            
        }
        else{
            int izquierda=0 ;
            int derecha =0;
            if (tree.hasLeftChild()){
                izquierda = calcularMaximoRetardo(tree.getLeftChild()); 

            }
            if (tree.hasRightChild()){
                 derecha =calcularMaximoRetardo(tree.getRightChild()); 

            }           

            retardo= tree.getData() + calcularMax(izquierda,derecha) ; //Math.max(izquierda,derecha)<----- se puede hacer esto
    }
    
        return retardo;
    }

    private int calcularMax(int izquierda , int derecha){
        int max= Integer.MIN_VALUE;
        if (izquierda > derecha) max= izquierda;
        else max= derecha;
        return max;
    }

    
}
