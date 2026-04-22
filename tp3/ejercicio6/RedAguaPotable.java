package tp3.ejercicio6;
import java.util.List;

import tp3.ejercicio1.*;

public class RedAguaPotable {
    
    private GeneralTree<Character> arbol;

    public RedAguaPotable(GeneralTree<Character> arbol) {
        this.arbol = arbol;
    }

    public double minimoCaudal(double caudal){
        double cantCaudal = 0;
        if (this.arbol != null && !this.arbol.isEmpty())
            cantCaudal = calcularMinimoCaudal(this.arbol,caudal );

        return cantCaudal;

    }
    /* 
    private double calcularMinimoCaudal(GeneralTree<Character> tree, double caudal) {
        double caudalCasa=0; 
        double minimoCaudal = caudal;      
        if (tree.isLeaf()){ 
            minimoCaudal=caudal;
        }

        else {
            List <GeneralTree<Character>> hijos = tree.getChildren();
            for (GeneralTree<Character> hijo : hijos){
                caudalCasa = calcularMinimoCaudal (hijo, caudal/hijos.size());
                minimoCaudal = Math.min(caudalCasa, minimoCaudal);
                
            }
        }
        return minimoCaudal;
    }*/

    private double calcularMinimoCaudal(GeneralTree<Character> tree, double caudal) {
        double caudalCasa=0; 
        double minimoCaudal = caudal;      
        List <GeneralTree<Character>> hijos = tree.getChildren();
        for (GeneralTree<Character> hijo : hijos){
            caudalCasa = calcularMinimoCaudal (hijo, caudal/(double)hijos.size());
            minimoCaudal = Math.min(caudalCasa, minimoCaudal);
                
        }
        
        return minimoCaudal;
    }
}
