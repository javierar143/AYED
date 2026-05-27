package tp5.ejercicio3;

public class DataCombustible {
    private int cantCombustible;
    private int cantCargas;
    private int tanquelleno;
    private int cantMinimaCargas;
    
    public DataCombustible(int cant) {
        this.cantCombustible= cant;
        this.cantCargas=0;
        this.tanquelleno=cant;
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
        this.cantCombustible= this.tanquelleno;
    }

    public int getTanquelleno(){
        return this.tanquelleno;
    }

    public boolean cantCargasEsLaMenor() {
        return this.cantCargas < this.cantMinimaCargas;
    }
    
    
    
}
