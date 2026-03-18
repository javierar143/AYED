package CodigosClase01;

public class Test {
    public static void main(String[] args) {
        int[] datos = {3, 4, 8, 5, 8,0};
        Calculadora cal = new Calculadora(datos);
        int max = cal.getMax();
        
        System.out.println("El máximo es " + max);
        System.out.println("El Cantidad de " + max +" es " + cal.getCantmax());

    }
}

