package tp1.ejercicio7;

import java.util.ArrayList;
import java.util.List;

public class EjercicioSucesion {

    
    
    public List<Integer> calcularSucesion (int n){
        List<Integer> lista = new ArrayList<>();
        armarSucesion(n, lista);
        return lista;
    }

    private void armarSucesion(int n,List<Integer> lista){
        lista.add(n);

        if (n == 1) {
            return;
        }

        if (n % 2 == 0) {
            armarSucesion(n / 2, lista);
        } else {
            armarSucesion(3 * n + 1, lista);
        }             
    }
}
