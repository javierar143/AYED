package tp1.ejercicio3;

public class Test {
    public static void main(String[] args) {
        
        Persona e1 = new Estudiante("Pedro", "PAez",
        "pedro@pedro.com",1,"calle1");

        Persona e2 = new Estudiante("josefina", "josefa",
        "jose@pedro.com",2,"calle14");

        Persona p1 = new Profesor("pepe", "sosa", "pepe@sosa.com",
         "Ayed", "Informatica");

        Persona p2 = new Profesor("horacio", "capataz", "horacio@sosa.com",
         "Ayed", "Informatica");

        Persona p3 = new Profesor("laura", "fava", "laura@sosa.com",
         "Ayed", "Informatica");

        Persona [] academicos = {e1,e2,p1,p2,p3};

        for (Persona p : academicos) System.out.println(p.tusDatos());



    }
}

