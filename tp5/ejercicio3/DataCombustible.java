package tp5.ejercicio3;

public class DataCombustible {
    private int cantCombustible;
    private int cantCargas;
    private final int TANQUE_LLENO;
    private int cantMinimaCargas;
    
    public DataCombustible(int tanqueLleno) {
        this.cantCombustible= tanqueLleno;
        this.cantCargas=0;
        this.TANQUE_LLENO=tanqueLleno;
        this.cantMinimaCargas = Integer.MAX_VALUE;
    }

    public int getCantCombustible() {
        return cantCombustible;
    }

    public void setCantCombustible(int cantCombustible) {
        this.cantCombustible = cantCombustible;
    }

    public int getCantCargas() {
        return cantCargas;
    }

    public void AumentarCantCargas() {
        this.cantCargas++;
    }

    public void BajarCantCargas(){
        this.cantCargas--;
    }    

    public int getCantMinimaCargas() {
        return cantMinimaCargas;
    }

    public void setCantMinimaCargas(int cantMinimaCargas) {
        this.cantMinimaCargas = cantMinimaCargas;
    }

    public void llenarTanque(){
        this.cantCombustible= this.TANQUE_LLENO;
    }

    public int getTANQUE_LLENO(){
        return this.TANQUE_LLENO;
    }

    public boolean cantCargasEsLaMenor() {
        return this.cantCargas < this.cantMinimaCargas;
    }
    
    
    
}
