package AYED.PruebaInicial;

public class Main {
    public static void main(String[] args) {
        Dato n = new Dato(25);
        Operacion op = new Operacion();
        op.duplicar(n);
        System.out.println("El resultado es: " + n.valor);
    }
}
