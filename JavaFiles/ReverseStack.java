import java.util.*;

public class ReverseStack{
    
    Stack<Integer> st = new Stack<Integer>();
     public static void main(String []args){
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(6);
        stack.push(5);
        stack.push(4);
        stack.push(3);
        stack.push(2);
        ReverseStack hw = new ReverseStack();
        
        hw.reverse(stack);
        while(!stack.isEmpty()){
            System.out.println(stack.pop());
        }
    
     }
     
     private void reverse(Stack<Integer> stack){
        if(!stack.isEmpty()){
            int val = stack.pop();
            reverse(stack);
            append(stack, val);
        }
        else{
            return;
        }
     }
     
     private void append(Stack<Integer> stack, int a){
        if(!stack.isEmpty()){
            int val = stack.pop();
            append(stack, a);
            stack.push(val);
        }
        else{
            stack.push(a);
            return;
        }
     }
}