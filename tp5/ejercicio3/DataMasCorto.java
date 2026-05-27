package tp5.ejercicio3;

public class DataMasCorto {
    private int distanciaAcumulada;
    private int minDistancia;
    
    public DataMasCorto() {
        this.distanciaAcumulada = 0;
        this.minDistancia = Integer.MAX_VALUE;
    }
    public int getDistanciaAcumulada() {
        return distanciaAcumulada;
    }
    public void setDistanciaAcumulada(int distanciaAcumulada) {
        this.distanciaAcumulada = distanciaAcumulada;
    }
    public int getMinDistancia() {
        return minDistancia;
    }
    public void setMinDistancia(int minDistancia) {
        this.minDistancia = minDistancia;
    }
   

    
}
