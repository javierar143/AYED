package tp1.ejercicio7;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class TestIterator {
    public static void main(String[] args) {
        List <Integer> listaNumeros = new ArrayList<>();
        
        
        Scanner input = new Scanner(System.in);
        String seguir;
        System.out.println("::::Siempre responder abajo:::: ");

        
        do{            
            System.out.println("Ingrese un numero para agregar ");
            int num = input.nextInt();
            listaNumeros.add(num);
            
            System.out.println("Desea continuar? (s/n) ");
            seguir = input.next();
        }while (seguir.equalsIgnoreCase("s"));


        Iterator <Integer>it = listaNumeros.iterator();

        System.out.println("****Numeros ingresados*****");
        while (it.hasNext())
            System.out.print(it.next() + " ");
        
        System.out.println();


    }

}
