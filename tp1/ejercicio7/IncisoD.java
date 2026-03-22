package tp1.ejercicio7;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IncisoD {
    public static void main(String[] args) {
        
        ArrayList<Estudiante> estudiantes = new ArrayList <> (List.of(new Estudiante("jose"),
        new Estudiante("pepa"),new Estudiante("pepe")));
        
        ArrayList <Estudiante> copiaEstudiantes = new ArrayList<>();
        copiaEstudiantes.addAll(estudiantes);

        //ArrayList <Estudiante> copiaEstudiantes = new ArrayList<>(estudiantes);
        
        //ArrayList <Estudiante> copiaEstudiantes = (ArrayList<Estudiante>)estudiantes.clone();
    
        /*la siguiente es una manera DISTINTA DE COPIAR, tiene referencias 
        independientes */
        
        /*ArrayList <Estudiante> copiaEstudiantes = new ArrayList<>();
        for (Estudiante e: estudiantes){
            copiaEstudiantes.add(new Estudiante(e.getNombre()));
        }*/

        String nuevoEstudiante = "SoyNuevo";
        String nuevoEstudiante1 = "pepe";
        agregarEstudiante(nuevoEstudiante,estudiantes);
        //agregarEstudiante(nuevoEstudiante1,estudiantes);


        imprimir(estudiantes,copiaEstudiantes);

        estudiantes.get(0).setNombre("Carozo");
        //estudiantes.set(0,new Estudiante("Romelo"));

        imprimir(estudiantes,copiaEstudiantes);
    
    }
    
        public static void imprimir (ArrayList<Estudiante> estudiante,ArrayList<Estudiante> copiaEstudiante){

            System.out.println(":::::::::Lista original::::::::");
            for (Estudiante s : estudiante) {
                System.out.println(s.getNombre());
                
            }

            System.out.println(":::::::::Lista Copiada::::::::");
            Iterator <Estudiante>it = copiaEstudiante.iterator();
            
            while (it.hasNext()) {
                System.out.println(it.next().getNombre());
            } 
        }

            public static void agregarEstudiante (String nombre, ArrayList<Estudiante> estudiantes){
                boolean agregar = true;
                for (Estudiante e: estudiantes){
                    if (nombre.equals(e.getNombre())) {                  
                        agregar=false;
                    }
                }
                if (agregar){
                    estudiantes.add(new Estudiante(nombre));
                    System.out.println("Estudiante Agregado");
                }
                else System.out.println("No se puede repetir Estudiante");
                
            }
}
        
    

        
        

    

