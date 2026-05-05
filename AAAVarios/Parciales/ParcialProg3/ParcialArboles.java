package AAAVarios.Parciales.ParcialProg3;
import java.util.*;
import tp3.ejercicio1.*;

public class ParcialArboles {
    public void simularCostos (GeneralTree<Distribucion> proyecto, String nombre, int multiplicador) {
        if (proyecto != null && !proyecto.isEmpty())
            buscarYActualizarProyecto(proyecto,nombre,multiplicador);
    }



private boolean buscarYActualizarProyecto (GeneralTree<Distribucion> tree, String nombre, int multiplicador) {
    boolean encontre = false;
    Iterator <GeneralTree <Distribucion>> it = tree.getChildren().iterator();

    while (it.hasNext() && !encontre){
        GeneralTree<Distribucion>  nodo = it.next();
        encontre =  buscarYActualizarProyecto(nodo,nombre,multiplicador);
        if (encontre){            
            tree.getData().setCosto(tree.getData().getCosto()+nodo.getData().getSumarCosto()); 
            tree.getData().setSumarCosto(nodo.getData().getSumarCosto());           
        }
    }

    if ( tree.isLeaf()){
        if (tree.getData().getTrabajo().equals(nombre)){
            int valorOriginal= tree.getData().getCosto();
            int valorActualizado= valorOriginal *multiplicador;
            tree.getData().setCosto(valorActualizado);
            tree.getData().setSumarCosto(valorActualizado-valorOriginal);
            encontre=true;
        }
    }


    return encontre;
}

}
