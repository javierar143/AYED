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

/*
########El Inorden separa el árbol en izquierda y derecha.######
Preorden dice la raíz al inicio
Postorden dice la raíz al final


Ejemplo:
Postorden → el último elemento es la raíz
Buscás esa raíz en el Inorden
Eso divide:
izquierda
derecha

Paso 1

La raíz es:
último de postorden

Paso 2

Buscás esa raíz en Inorden:
izquierda | raíz | derecha

Paso 3

Dividís postorden en:
izquierda (misma cantidad de nodos que en Inorden izquierda)
derecha (el resto, antes de la raíz)

Ejemplo concreto:
Inorden:   [1, 3, 6, 8, 10]
Postorden: [1, 6, 3, 10, 8]

Paso 1: raíz
Postorden:
[1, 6, 3, 10, 8]
                ↑
              raíz = 8

Paso 2: dividir Inorden
[1, 3, 6 | 8 | 10]
izquierda: [1,3,6]
derecha: [10]

Paso 3: dividir Postorden
Sabemos que:

izquierda tiene 3 elementos

Entonces:
[1, 6, 3 | 10 | 8]
izquierda: [1,6,3]
derecha: [10]

Paso 4: subárbol izquierdo
Inorden:   [1, 3, 6]
Postorden: [1, 6, 3]

Paso 4: subárbol izquierdo
Inorden:   [1, 3, 6]

Raíz:
3

Dividimos:
[1 | 3 | 6]

Paso 5: subárbol derecho
Inorden: [10]
Postorden: [10]

Paso 5: subárbol derecho
Inorden: [10]
Postorden: [10]

5. Árbol final
        8
       / \
      3   10
     / \
    1   6
    
*/



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