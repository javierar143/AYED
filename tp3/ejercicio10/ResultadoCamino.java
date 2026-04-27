package tp3.ejercicio10;

import java.util.ArrayList;
import java.util.List;

public class ResultadoCamino {
    private int valor;
    private List<Integer> listaTemporal;

    public ResultadoCamino(int valor, List<Integer> listaTemporal) {
        this.valor = valor;
        this.listaTemporal = listaTemporal;
    }

     public ResultadoCamino(int valor) {
        this.valor = valor;
        this.listaTemporal = new ArrayList<>();
    }

    public ResultadoCamino() {
        this.valor = 0;
        this.listaTemporal = new ArrayList<>();
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public List<Integer> getListaTemporal() {
        return listaTemporal;
    }

    public void setListaTemporal(List<Integer> listaTemporal) {
        this.listaTemporal = listaTemporal;
    }

    



    
}
