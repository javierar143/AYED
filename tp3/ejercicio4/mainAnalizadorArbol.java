package tp3.ejercicio4;
import java.util.LinkedList;
import java.util.List;

import tp3.ejercicio1.*;

public class mainAnalizadorArbol {
    public static void main(String[] args) {
        GeneralTree <AreaEmpresa> arbolG = new GeneralTree<AreaEmpresa>(new AreaEmpresa("M", 14));

        
        List <GeneralTree<AreaEmpresa>> hijos14 = new LinkedList<>();

        GeneralTree<AreaEmpresa> h13 = new GeneralTree<AreaEmpresa>(new AreaEmpresa("J",13));
        GeneralTree<AreaEmpresa> h25 = new GeneralTree<AreaEmpresa>(new AreaEmpresa("K",25));
        GeneralTree<AreaEmpresa> h10 = new GeneralTree<AreaEmpresa>(new AreaEmpresa("L",10));
        
        arbolG.setChildren(hijos14);
        hijos14.addAll(List.of(h13, h25, h10));

        List <GeneralTree<AreaEmpresa>> hijos13 = new LinkedList<>();
        List <GeneralTree<AreaEmpresa>> hijos25 = new LinkedList<>();
        List <GeneralTree<AreaEmpresa>> hijos10 = new LinkedList<>();

        GeneralTree<AreaEmpresa> h4 = new GeneralTree<AreaEmpresa>(new AreaEmpresa("A",4));
        GeneralTree<AreaEmpresa> h7 = new GeneralTree<AreaEmpresa>(new AreaEmpresa("B",7));
        GeneralTree<AreaEmpresa> h5 = new GeneralTree<AreaEmpresa>(new AreaEmpresa("C",5));
        
        hijos13.addAll(List.of(h4, h7, h5));
        h13.setChildren(hijos13);

        GeneralTree<AreaEmpresa> h6 = new GeneralTree<AreaEmpresa>(new AreaEmpresa("D",6));
        GeneralTree<AreaEmpresa> h10b = new GeneralTree<AreaEmpresa>(new AreaEmpresa("E",10));
        GeneralTree<AreaEmpresa> h18 = new GeneralTree<AreaEmpresa>(new AreaEmpresa("F",18));

        hijos25.addAll(List.of(h6, h10b, h18));
        h25.setChildren(hijos25);


        GeneralTree<AreaEmpresa> h9 = new GeneralTree<AreaEmpresa>(new AreaEmpresa("G",9));
        GeneralTree<AreaEmpresa> h12 = new GeneralTree<AreaEmpresa>(new AreaEmpresa("H",12));
        GeneralTree<AreaEmpresa> h19 = new GeneralTree<AreaEmpresa>(new AreaEmpresa("I",19));

        hijos10.addAll(List.of(h9, h12, h19));
        
        h10.setChildren(hijos10);

        System.out.println("Impresion PreOrden");
        arbolG.imprimirPreOrden();
        System.out.println();

        AnalizadorArbol analizador = new AnalizadorArbol();

        System.out.println();
        System.out.println(" El mayor promedio entre todos los promedios de los niveles es "+ analizador.devolverMaximoPromedio(arbolG));
        System.out.println();
    }
}
