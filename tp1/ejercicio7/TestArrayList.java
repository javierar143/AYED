package tp1.ejercicio7;

import java.util.*;

public class TestArrayList {
    
    
    
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

        System.out.println("****Numeros ingresados*****");
        for (int n: listaNumeros){            
            System.out.print(n + " ");
            
        } 
        System.out.println();


    }


}
    

