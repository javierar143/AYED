package tp1.ejercicio7;

import java.util.ArrayList;
import java.util.List;

public class incisoFMain {
    public static void main(String[] args) {
        List <Integer> lista = new ArrayList<>();

        /*lista.add(1);
        lista.add(2);
        lista.add(5);
        lista.add(2);
        lista.add(1);
        lista.add(1);*/

        /*lista.add(2);
        lista.add(5);
        lista.add(2);*/

        lista.add(4);
        lista.add(5);
        lista.add(6);
        lista.add(3);
        lista.add(4);
        
        
        if (new IncisoF().esCapicua(lista)){
            System.out.println("###### La secuencia ingresada es capicua #####");
        }
        else    System.out.println("xxxxx La secuencia ingresada NO es capicua xxxx");
    }
}
