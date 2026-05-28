package tp5.ejercicio5;

public class Persona {
    private String nombre;
    private String domicilio;
    private boolean esJubilado;
    private boolean  cobroRecibido;
    
    public Persona(String nombre, String domicilio, boolean esJubilado, boolean cobroRecibido) {
        this.nombre = nombre;
        this.domicilio = domicilio;
        this.esJubilado = esJubilado;
        this.cobroRecibido = cobroRecibido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public boolean EsJubilado() {
        return esJubilado;
    }

    public void setEsJubilado(boolean esJubilado) {
        this.esJubilado = esJubilado;
    }

    public boolean isCobroRecibido() {
        return cobroRecibido;
    }

    public void setCobroRecibido(boolean cobroRecibido) {
        this.cobroRecibido = cobroRecibido;
    }

    public boolean equals (Object objeto){
        boolean esIgual= false;
        if (objeto instanceof Persona){
            Persona otro = (Persona) objeto;
            if (this== objeto || (otro.getNombre().equals(this.getNombre()) && otro.getDomicilio().equals(this.getDomicilio()) )){
                esIgual=true;
            }
        }
        return esIgual;
    }

    

}
