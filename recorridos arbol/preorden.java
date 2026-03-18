package recorridos arbol;

public class preorden {
    
public void preorden() {
    imprimir (dato);
    
    si (tiene hijo_izquierdo)
        hijoIzquierdo.preorden();

    si (tiene hijo_derecho)
        hijoDerecho.preorden();
    }
}

/*  3
     \
      7
     / \
    8   9
   / \   \
  10 11   18
 imprime:3 7 8 10 11 9 18


      7
     / \
    9   8
   / \
  10 11
 imprime: 7 9 10 11 8




       8
     / \
    3   10
   / \
  1   6

  imprime: 8 3 1 6 10



*/