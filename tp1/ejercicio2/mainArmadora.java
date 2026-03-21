package tp1.ejercicio2;
import java.util.List;
import java.util.Scanner;

public class mainArmadora {
    public static void main(String[] args) {
        System.out.println("Ingrese un numero mayor a 0");
        Scanner input = new Scanner(System.in);
        Integer num = input.nextInt();

        while (num < 1){
            System.out.println("Error: \n Debe ingresar un numero mayor a 0");
            num = input.nextInt();
        }

        //List <Integer> arregloDivisibles = ArmadoraArreglo.armarArraList(num);        
        for (Integer a : ArmadoraArreglo.armarArraList(num)) 
            System.out.print(a + " ");
        System.out.println("\n ");

               
        for (int a : ArmadoraArreglo.armarArreglo(num)) 
            System.out.print(a + " ");
        System.out.print("\n ");
    }
}
