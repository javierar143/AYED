package AAAVarios.Parciales.Grafos.grafos20241eraFechaTema1.Resolucion;

public class Recinto {
    private String nombre;
    private int tiempoVisita;
    
    public Recinto(String nombre, int tiempoVisita) {
        this.nombre = nombre;
        this.tiempoVisita = tiempoVisita;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTiempoVisita() {
        return tiempoVisita;
    }

    public void setTiempoVisita(int tiempoVisita) {
        this.tiempoVisita = tiempoVisita;
    }

    public boolean equals (Object obj){
        boolean esIgual= false;

        if (obj instanceof Recinto){
            Recinto otro = (Recinto) obj;
            if (this== obj || otro.getNombre().equals(this.getNombre())){
                esIgual=true;
            }
        }

        return esIgual;
    }
}
