package AAAVarios.Parciales.Grafos.prog320241F;

public class DataClass {
    private String estacion;
    private int cantTransbordos;

    public DataClass (String nombre, int cantTransbordos){
        this.estacion = nombre;
        this.cantTransbordos=cantTransbordos;
    }

    public String getEstacion() {
        return estacion;
    }

    public void setEstacion(String estacion) {
        this.estacion = estacion;
    }

    public int getCantTransbordos() {
        return cantTransbordos;
    }

    public void setCantTransbordos(int cantTransbordos) {
        this.cantTransbordos = cantTransbordos;
    }

    
}
