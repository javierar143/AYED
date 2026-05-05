package AAAVarios.Parciales.ParcialProg3;
import tp3.ejercicio1.*;
public class mainParcialP3 {
    public static void main(String[] args) {
       GeneralTree<Distribucion> total = new GeneralTree<>(new Distribucion("Total", 0));

    // Nivel 1
    GeneralTree<Distribucion> desarrollo = new GeneralTree<>(new Distribucion("Desarrollo", 0));
    GeneralTree<Distribucion> testing = new GeneralTree<>(new Distribucion("Testing", 0));
    GeneralTree<Distribucion> management = new GeneralTree<>(new Distribucion("Management", 0));

    total.addChild(desarrollo);
    total.addChild(testing);
    total.addChild(management);

    // Nivel 2
    GeneralTree<Distribucion> backend = new GeneralTree<>(new Distribucion("BackEnd", 0));
    GeneralTree<Distribucion> frontend = new GeneralTree<>(new Distribucion("FrontEnd", 0));
    GeneralTree<Distribucion> data = new GeneralTree<>(new Distribucion("Data", 0));

    desarrollo.addChild(backend);
    desarrollo.addChild(frontend);
    desarrollo.addChild(data);

    // Nivel 3 (solo una rama profundiza → desbalanceado)
    GeneralTree<Distribucion> api = new GeneralTree<>(new Distribucion("API", 0));
    backend.addChild(api);

    // Nivel 4 (hojas reales)
    GeneralTree<Distribucion> pythonDev = new GeneralTree<>(new Distribucion("Python dev", 1000000));
    GeneralTree<Distribucion> javaDev = new GeneralTree<>(new Distribucion("Java dev", 500000));

    api.addChild(pythonDev);
    api.addChild(javaDev);

    // Otras hojas (sin profundizar más)
    frontend.addChild(new GeneralTree<>(new Distribucion("React dev", 300000)));
    data.addChild(new GeneralTree<>(new Distribucion("Data analyst", 200000)));
    testing.addChild(new GeneralTree<>(new Distribucion("QA", 150000)));
    management.addChild(new GeneralTree<>(new Distribucion("PM", 400000)));

    System.out.println("Arbol original");
    imprimirArbolDeObjetos(total);
    System.out.println("-------------------------------");


    ParcialArboles pa =  new ParcialArboles();
    pa.simularCostos(total, "Python dev", 2);

    System.out.println("Arbol modificado");
    imprimirArbolDeObjetos(total);
    System.out.println("-----------FIN------------");
    }
    /*
Total
 ├── Desarrollo
 │    ├── BackEnd
 │    │     └── API
 │    │          ├── Python dev  ← OBJETIVO
 │    │          └── Java dev
 │    ├── FrontEnd
 │    │     └── React dev
 │    └── Data
 │          └── Data analyst
 ├── Testing
 │    └── QA
 └── Management
      └── PM
*/    

    public static void imprimirArbolDeObjetos(GeneralTree<Distribucion> arbol){
       System.out.println(arbol.getData().getTrabajo()+"|"+arbol.getData().getCosto() + " ");
                 
       for (GeneralTree <Distribucion> nodo : arbol.getChildren())
                imprimirArbolDeObjetos(nodo);
    }
    
}
