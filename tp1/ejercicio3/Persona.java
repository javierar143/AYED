package tp1.ejercicio3;

public abstract class Persona {
    private String nombre;
    private String apellido;    
    private String email;

    
    public Persona(String nombre, String apellido, String email) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
    }
    
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

     public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }


    public String tusDatos(){

        return this.encabezado()+ "\n  " +"Nombre y Apellido:  "+ this.getNombre() + " " +this.getApellido() 
        + "\n Correo: "+ this.getEmail() + "\n  " + this.misDatos();
    }
    public abstract String encabezado();
    public abstract String misDatos();

    /*public String tusDatos(){

        return "Nombre y Apellido:  "+ this.getNombre() + " " +this.getApellido() 
        + "\n Correo: "+ this.getEmail() + "\n  ";
    }*/
}
