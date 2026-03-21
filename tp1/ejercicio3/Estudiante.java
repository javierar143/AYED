package tp1.ejercicio3;

public class Estudiante extends Persona {
    private int comision;
    private String direccion;
    
    

    public Estudiante(String nombre, String apellido, String email, int comision, String direccion) {
        super(nombre, apellido, email);
        this.comision = comision;
        this.direccion = direccion;
    }

    public int getComision() {
        return comision;
    }
    public void setComision(int comision) {
        this.comision = comision;
    }
   
    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String encabezado(){
        return ":::::: Estudiante ::::::::";
    }
    
    public String misDatos(){

        return "Comision: " + this.getComision() + "\n" +
        "Direccion: "+ this.getDireccion() + "\n" ;
    }

    /*@Override
   public String tusDatos(){
        return "Estudiante "+super.tusDatos() + "Comision: " + this.getComision() + "\n" +
        "Direccion: "+ this.getDireccion() + "\n" ;
   }*/
}
