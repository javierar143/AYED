package recorridos arbol;

public class Inorden {
   
public void inorden() {
    
    si (tiene hijo_izquierdo)
        hijoIzquierdo.inorden();
    
    imprimir (dato);
    
    si (tiene hijo_derecho)
        hijoDerecho.inorden();
    }
}

/*    Inorden:   H /B/ I E -A- F C G   Preorden:  A B H E I C F G
Raiz: A
Subizq B H E I
raiz B
(Izq H ; der:E I)
subder: 
raiz E
(Izq I; der:)

Subder C F G
raiz C
izq F der G
       A 
     /    \
    B      C
   / \    /  \ 
  H   E   F   G
     /
    I
inorden: C B F E G A D I H y postorden: C F G E B I H D A 
(Izq: C F G E B;der:I H D)
(Izq:C; Der:I H D)
(Izq: nada der: IH)
(izq: I)
       A
     /  \
    B     D
   / \     \
  C   E     H
    /  \    /   
    F   G   I

Inorden:D /B/ E -A- F C G       Postorden: D E B F G C A
Raiz: A
(izq:D E B  Der:F G C)
SubIzq
raiz B
(izq:D  Der:E)
subder
raiz C
(izq:F  Der:G)


       A
     /    \
    B      C 
   / \    /  \ 
  D   E   F   G
         
          

    3
     \
      7
     / \
    8   9
   / \   \
  10 11   18
 imprime:3 10 8 11 7 9 18


      7
     / \
    9   8
   / \
  10 11
 imprime: 10 9 11 7 8

       8
     / \
    3   10
   / \
  1   6

  imprime: 1 3 6 8 10
*/