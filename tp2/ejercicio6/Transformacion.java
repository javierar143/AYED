package tp2.ejercicio6;
import tp2.ejercicio2.*;

public class Transformacion {
    BinaryTree<Integer> arbol;

    public Transformacion(BinaryTree<Integer> arbol) {
        this.arbol = arbol;
    }

    public BinaryTree<Integer> suma(){
        BinaryTree<Integer> tree = new BinaryTree<>();
        if (this.arbol !=null)
            transformarArbol(this.arbol,tree);
        
        return tree;
    }

    private int transformarArbol(BinaryTree<Integer> original, BinaryTree<Integer> nuevo) {
        
        int valor=0;
        
        //si es hoja pasa de largo en los if y devuleve 0    
        if (original.hasLeftChild()){
            BinaryTree<Integer> left = new BinaryTree<>();//creacion del subarbol
            valor += transformarArbol(original.getLeftChild(),left); //acumulo en valor el valor de los hijos de la rama izq
            nuevo.addLeftChild(left);               
            }
            
        if (original.hasRightChild()){
            BinaryTree<Integer> right = new BinaryTree<>();
            valor += transformarArbol(original.getRightChild(),right);
            nuevo.addRightChild(right);                 
            }           
        nuevo.setData(valor); //guardo el valor de la suma de los subarboles izquierdos y derechos si entro a los if, sino se guarda 0
                             //porque es hoja
        valor =original.getData()+ valor; //acumulo en valor la suma de los subarboles mas mi valor, para que lo sume el padre
          

        return valor;
    }


    //alternativa refactorizada
    public BinaryTree<Integer> sumaRefactorizada() {
        BinaryTree<Integer> nuevo = new BinaryTree<>();
        if (this.arbol != null)
            resolver(this.arbol, nuevo);
    return nuevo;
    }

    private int resolver(BinaryTree<Integer> nodo, BinaryTree<Integer> copia) {
        int totalHijos = sumaHijos(nodo, copia);
        copia.setData(totalHijos);
        return totalHijos + nodo.getData();
    }

    private int sumaHijos(BinaryTree<Integer> nodo, BinaryTree<Integer> copia) {
        int suma = 0;

        if (nodo.hasLeftChild()) {
            BinaryTree<Integer> left = new BinaryTree<>();
            copia.addLeftChild(left);
            suma += resolver(nodo.getLeftChild(), left);
        }

        if (nodo.hasRightChild()) {
            BinaryTree<Integer> right = new BinaryTree<>();
            copia.addRightChild(right);
            suma += resolver(nodo.getRightChild(), right);
        }

        return suma;
    }

}
