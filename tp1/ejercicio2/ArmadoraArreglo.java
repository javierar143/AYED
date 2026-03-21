package tp1.ejercicio2;

import java.util.ArrayList;
import java.util.List;

public class ArmadoraArreglo {
    public static List <Integer> armarArraList (Integer a){
        System.out.println("La arraylist da:\n");
        List <Integer> arreglo = new ArrayList<>();
        for (int i= a;i<=a*a;i+=a ){
                arreglo.add(i);
            }

        return arreglo;
        }



    public static int [] armarArreglo (int a){
        System.out.println("El arreglo da:\n");
        int arreglo [] = new int [a];
        int pos= 0;
        for (int i= a;i<=a*a;i+=a ){
            arreglo[pos]=i;
            pos++;
            }

        return arreglo;
        }
    }
