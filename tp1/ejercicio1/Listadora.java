package tp1.ejercicio1;

public class Listadora {
    public static void impresionFor (int a, int b){
        System.out.println("Listado for\n"); 
        for (int i=a; i<=b;i++){
            //sout mas tab es atajo de la impresion            
            System.out.print(i);  
        }
        System.out.println("\n"); 
    }

    public static void imoresionWhile (int a, int b){
        System.out.println("Listado While\n"); 
        while (a<=b) {
            System.out.print(a);
            a++;            
        }
        System.out.println("\n"); 
    }

    public static void impresionRecursiva(int a, int b){
        System.out.println("Listado Recursivo\n");
        imprimirRecursivamente (a,b);
        System.out.println("\n"); 
    }

    private static void  imprimirRecursivamente (int a, int b){
        if (a<=b){
            System.out.print(a);
            a++;
            imprimirRecursivamente(a, b);
        }
    }
}
