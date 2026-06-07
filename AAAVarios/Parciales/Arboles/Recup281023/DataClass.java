package AAAVarios.Parciales.Recup281023;

public class DataClass {
    private Integer acumulado;
    private Integer diferencia;

    public DataClass (int acumulado, int diferencia){
        this.acumulado=acumulado;
        this.diferencia=diferencia;
    }

    public void setAcumulado(Integer num){
        this.acumulado=num;
    }

    public Integer getAcumulado (){
        return this.acumulado;
    }

    public void setDiferencia (Integer num){
        this.diferencia=num;
    }

    public Integer getDiferencia (){
        return this.diferencia;
    }
}
