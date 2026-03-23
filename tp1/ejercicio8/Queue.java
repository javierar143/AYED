package tp1.ejercicio8;
import java.util.*;

public class Queue <T> extends Sequence {
    protected List<T> data;

    public Queue() {
        this.data = new ArrayList<T>();
    }   

    public void enqueue(T dato) {
        data.add(dato);
    }
    
    public T dequeue() {
        if (data.isEmpty())throw new IllegalStateException ("No se puede remover elemntos de una cola vacia");
        return data.remove(0);
    }
    
    public T head() {
        if (data.isEmpty())throw new IllegalStateException ("No se puede remover elemntos de una cola vacia");
        return data.get(0);
    }

    @Override
    public int size() {
        return data.size();
    }
    @Override
    public boolean isEmpty() {
        return data.size()==0;
    }


    @Override
    public String toString() {
        String str = "[";
        for(T d: data){
            str += d +", ";
        }
        str = str.substring(0, str.length()-2)+"]";
        
        return str;
    }


    
}
