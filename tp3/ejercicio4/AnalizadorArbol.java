package tp3.ejercicio4;
import tp1.ejercicio8.*;
import tp3.ejercicio1.GeneralTree;

public class AnalizadorArbol {
   
   
    public double devolverMaximoPromedio (GeneralTree<AreaEmpresa>arbol){
        double maxPromedio= Integer.MIN_VALUE;
        if (arbol != null && !arbol.isEmpty()){
            Queue <GeneralTree<AreaEmpresa>> cola = new Queue<>();
            GeneralTree<AreaEmpresa> tree;
            int acumulador =0;
            int cant = 0;
            
            cola.enqueue(arbol);
            cola.enqueue(null);

            while (!cola.isEmpty()){
                tree = cola.dequeue();
               
                if (tree != null){
                    acumulador+=tree.getData().getTardanza();
                    cant++;
                    for (GeneralTree<AreaEmpresa> hijo : tree.getChildren()){
                        cola.enqueue(hijo);
                    }
                }
                else {
                    maxPromedio = Math.max(maxPromedio, acumulador/cant);
                    
                    if (!cola.isEmpty()){
                        cola.enqueue(null);
                        acumulador=0;
                        cant=0;
                    }
                }
            }            
        }
        return maxPromedio;    
    }



}
