package recorridos arbol;

public class Niveles {
    public void porNiveles() {
        encolar(raíz);
        mientras (cola no se vacíe) {
            desencolar(v);
            imprimir (dato de v);
            si (tiene hijo_izquierdo)
                encolar(hijo_izquierdo);
            si (tiene hijo_derecho)
                encolar(hijo_derecho);
    }
}
/*
       8
     / \
    3   10
   / \
  1   6
  situaciones: e8 d8, e3 e10 d 3
  imprime: 8 
*/
