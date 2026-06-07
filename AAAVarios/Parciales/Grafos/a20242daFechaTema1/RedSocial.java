package AAAVarios.Parciales.Grafos.a20242daFechaTema1;

public class RedSocial {
    private String nombreUsuario;
    private int distancia;

    public RedSocial(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
        this.distancia=0;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public int getDistancia() {
        return distancia;
    }

    public void setDistancia(int distancia) {
        this.distancia = distancia;
    }

    public boolean equals (Object objeto){
        boolean esIgual= false;

        if (objeto instanceof RedSocial){
            RedSocial otro = (RedSocial) objeto;
            if (this == objeto || otro.getNombreUsuario().equals(this.getNombreUsuario()) ){
                esIgual=true;
            }
        }

        return esIgual;
    }
}
