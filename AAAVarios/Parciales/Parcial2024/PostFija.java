package AAAVarios.Parciales.Parcial2024;
import tp2.ejercicio2.*;
import tp1.ejercicio9.*;

public class PostFija {
    


    public BinaryTree<Character> convertirPostfija(String exp) {
        Character c = null;
        BinaryTree<Character> result;
        Stack<BinaryTree<Character>> p = new Stack<BinaryTree<Character>>();
       
        for (int i = 0; i < exp.length(); i++) {
            c = exp.charAt(i);
            result = new BinaryTree<Character>(c);
            if ((c == '+') || (c == '-') || (c == '/') || (c == '*')) {
                // Es operador
                result.addRightChild(p.pop());
                result.addLeftChild(p.pop());
            }
            p.push(result);
        }
        return (p.pop());
    }
}
