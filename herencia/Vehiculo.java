package herencia;

public class Vehiculo {
    private double precio;

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Vehiculo [precio=" + precio + "]";
    }

    
}
