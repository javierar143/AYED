package RepasoRecursividad;

public class MainRecursividad {
    public static void main(String[] args) {

        Nodo raiz = new Nodo(10);

        Nodo n1 = new Nodo(5);
        Nodo n2 = new Nodo(3);

        Nodo n3 = new Nodo(2);
        Nodo n4 = new Nodo(1);

        raiz.agregarHijo(n1);
        raiz.agregarHijo(n2);

        n1.agregarHijo(n3);
        n1.agregarHijo(n4);

        Operaciones op = new Operaciones();

        op.suma(raiz, 0);
    }
}
