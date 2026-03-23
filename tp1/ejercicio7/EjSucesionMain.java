package tp1.ejercicio7;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
// contiene hasta el inciso 7i
public class EjSucesionMain {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        EjercicioSucesion ej = new EjercicioSucesion();

        System.out.println("Ingrese un numero positivo mayor a 0");
        int num = input.nextInt();

        while (num < 1){
             System.out.println("Atencion: Debe un numero positivo mayor a 0");
             num = input.nextInt();
        }
        
        List <Integer> lista = ej.calcularSucesion(num);
        
        imprimir (lista);
        
        ej.invertirArrayList(lista);
        System.out.println("Lista invertida");
        imprimir(lista);

        LinkedList <Integer> copiaLista = new LinkedList<>(lista);
        System.out.println("La suma de la lista es:  " + ej.sumarLinkedList(copiaLista) );

        


        
    }

    
    


    public static void imprimir (List<Integer> lista){
        System.out.println(":::::::::::Lista de Sucesion de numeros:::::::::::");
        
        for (int n : lista ){
            System.out.print(n +" ");
        }
        System.out.println();
    }
}
