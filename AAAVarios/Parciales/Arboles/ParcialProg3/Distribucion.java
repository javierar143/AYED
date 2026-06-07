package AAAVarios.Parciales.ParcialProg3;

public class Distribucion {
    private String trabajo;
    private int costo;
    private int sumarCosto;

    public Distribucion (String t, int c){
        this.trabajo=t;
        this.costo=c;   
        this.sumarCosto=0;     
    }

    public void setTrabajo(String t){
        this.trabajo=t;
    }

    public String getTrabajo(){
        return this.trabajo;        
    }

    public void setCosto (int c){
        this.costo=c;
    }

    public int getCosto(){
        return this.costo;
    }

    public void setSumarCosto(int s){
        this.sumarCosto=s;
    }

    public int getSumarCosto(){
        return this.sumarCosto;
    }
}
