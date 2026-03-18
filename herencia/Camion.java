package herencia;

public class Camion extends Vehiculo {
    private double cargaMaxima;

    public double getCargaMaxima() {
        return cargaMaxima;
    }

    public void setCargaMaxima(double cargaMaxima) {
        this.cargaMaxima = cargaMaxima;
    }

     @Override
    public String toString() {
        return super.toString() + " la carga maxima es " + this.cargaMaxima;
    }

    
}
