package tp1.ejercicio5;

public class Calculadora {
    private static Datos dato;
    private static int [] arregloC;

    public static void setCalculadora (int [] arreglo){
        dato = new Datos();
        arregloC= arreglo;
    }

    public static Datos getDato() {
        return dato;
    }

    public static Datos calcularValores (int [] arreglo){
        if (arreglo.length < 1) 
            throw new IllegalArgumentException("El arreglo no debe estar vacío");

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;        
        Datos datos = new Datos();        
        double suma = 0;
        
        

        for (int n : arreglo){
            if (n > max) max=n;
            if (n <min) min = n;
            suma+=n;            
        }
        datos.setMaximo(max);
        datos.setMinimo(min);
        datos.setPromedio(suma/arreglo.length);

        return datos; 
    }

    public static void calcularValoresB(int [] arregloB, Datos datos) {
         if (arregloB.length < 1) {
            throw new IllegalArgumentException("El arreglo no debe estar vacío");
        }
        
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;             
        double suma = 0;       

        for (int n : arregloB){
            if (n > max) max=n;
            if (n <min) min = n;
            suma+=n;            
        }
        datos.setMaximo(max);
        datos.setMinimo(min);
        datos.setPromedio(suma/arregloB.length);
    }

    public static void calcularValoresC() {
         if (arregloC.length < 1) {
            throw new IllegalArgumentException("El arreglo no debe estar vacío");
        }
                
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;            
        double suma = 0;       
        
       

        for (int n : arregloC){
            if (n > max) max=n;
            if (n <min) min = n;
            suma+=n;            
        }
        Calculadora.dato.setMaximo(max);
        Calculadora.dato.setMinimo(min);
        Calculadora.dato.setPromedio(suma/arregloC.length);
    }


}
