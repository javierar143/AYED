package RepasoRecursividad;

public class Operaciones {
    public void suma(Nodo nodo, int acumulado) {

        acumulado = acumulado + nodo.valor;

        if (nodo.hijos.isEmpty()) {
            System.out.println("Suma hasta hoja: " + acumulado);
            return;
        }

        for (Nodo hijo : nodo.hijos) {
            suma(hijo, acumulado);
        }
    }
}
