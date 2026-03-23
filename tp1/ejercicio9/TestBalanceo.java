package tp1.ejercicio9;

public class TestBalanceo {
   
public static void main(String[] args) {
String exp = "{()[()]}";
String desBalanceado = "([)]";

if (validar(exp)){
    System.out.println("La expresión " + exp + " está balanceada ");    
}
else System.out.println("La expresión " + exp + " NO está balanceada "); 

}
private static boolean validar(String expresion) {
    Stack<Character> stack = new Stack<Character>();
    
    for (int i = 0; i < expresion.length(); i++) {
        char car = expresion.charAt(i);
        
        if (car == '(' || car== '[' || car== '{')
            stack.push(car);
        else if (stack.isEmpty())
            return false;
        else {
            char tope = stack.pop();
            
            if ((car == ')' && tope != '(') ||
                (car == ']' && tope != '[') ||
                (car == '}' && tope != '{')) {
                return false;
            }

        }
        
    }
    return stack.isEmpty();
}


}
