package tp1.ejercicio7;

import java.util.Scanner;

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

        
        System.out.println(":::::::::::Lista de Sucesion de numeros:::::::::::");
        
        for (int n : ej.calcularSucesion(num) ){
            System.out.print(n +" ");
        }
        System.out.println();
    }
}
