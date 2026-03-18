package CodigosClase01 ;

public class Calculadora {
    private  int max;
    private  int Cantmax;


    public Calculadora(int[] datos){
        max = Integer.MIN_VALUE;;
        Cantmax = 0;
        for (int i = 0; i < datos.length; i++) {
            
            if (datos[i] > max){
                Cantmax = 0;
                max = datos[i];                
            }

            if (datos[i] == max){
                Cantmax++;
                }
        }
    }


    public  int getMax() {
        return max;
    }


    public int getCantmax() {
        return Cantmax;
    }

    
}
