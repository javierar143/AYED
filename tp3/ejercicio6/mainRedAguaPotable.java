package tp3.ejercicio6;
import tp3.ejercicio1.*;

public class mainRedAguaPotable {
public static void main(String[] args) {
    GeneralTree<Character> A = new GeneralTree<>('A');

    // Nivel 1 (hijos de A)
    GeneralTree<Character> B = new GeneralTree<>('B');
    GeneralTree<Character> C = new GeneralTree<>('C');
    GeneralTree<Character> D = new GeneralTree<>('D');
    GeneralTree<Character> E = new GeneralTree<>('E'); // hoja

    A.addChild(B);
    A.addChild(C);
    A.addChild(D);
    A.addChild(E);

    // C tiene 2 hijos
    GeneralTree<Character> F = new GeneralTree<>('F');
    GeneralTree<Character> G = new GeneralTree<>('G');
    C.addChild(F);
    C.addChild(G);

    // El 2do hijo de C (G) tiene 1 hijo
    GeneralTree<Character> L = new GeneralTree<>('L');
    G.addChild(L);

    // D tiene 5 hijos
    GeneralTree<Character> H = new GeneralTree<>('H');
    GeneralTree<Character> I = new GeneralTree<>('I');
    GeneralTree<Character> J = new GeneralTree<>('J');
    GeneralTree<Character> K = new GeneralTree<>('K');
    GeneralTree<Character> P = new GeneralTree<>('P');

    D.addChild(H);
    D.addChild(I);
    D.addChild(J);
    D.addChild(K);
    D.addChild(P);

    // J tiene 2 hijos
    GeneralTree<Character> N = new GeneralTree<>('N');
    GeneralTree<Character> M = new GeneralTree<>('M');
    J.addChild(N);
    J.addChild(M);

    System.out.println("Impresion PreOrden");
    A.imprimirPreOrden();
    System.out.println();

    RedAguaPotable red = new RedAguaPotable(A);

    System.out.println("El caudal minimo que recibe una casa en esta red es de " + red.minimoCaudal(1000) + " L");

}
}
