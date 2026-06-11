package AAAVarios.Parciales.Grafos.parcial290624T2;

public class Dataclass {
    private int cantAmigos;
    private boolean popular;

    public Dataclass (int cantAmigos, int umbral){
        this.cantAmigos = cantAmigos;
        this.popular = cantAmigos >= umbral;        
    }

    public int getCantAmigos(){
        return this.cantAmigos;
    }
    public boolean getEsPopular(){
        return this.popular;
    }
}
