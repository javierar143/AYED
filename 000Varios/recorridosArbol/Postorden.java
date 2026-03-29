package recorridos arbol;

public class Postorden {
    public void postorden() {
    
    si (tiene hijo_izquierdo)
        hijoIzquierdo.postorden();
    
    si (tiene hijo_derecho)
        hijoDerecho.postorden();
    
    
    imprimir (dato);
    
    }
}

/*   
    3
     \
      7
     / \
    8   9
   / \   \
  10 11   18
 imprime: 10 11 18 9 7 3

      7
     / \
    9   8
   / \
  10 11
 imprime: 10 11 9 8 7
 
      8
     / \
    3   10
   / \
  1   6

  imprime: 1 6 3 10 8
*/

