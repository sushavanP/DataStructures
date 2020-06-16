package dataStructures.Stack;
import java.util.Stack;

public class specialStackOptimized
{
    Stack <Integer> s;
    Integer minEle;
    specialStackOptimized(){
        s = new Stack<Integer>();
    }
    void getMin(){
        if(s.isEmpty())
            System.out.println("Stack is Empty.");
        else
            System.out.println("Mininum Element in the" +
                    "stack is: " +minEle);
    }
    void peek(){
        if(s.isEmpty()){
            System.out.println("Stack is Empty ");
            return;
        }
        Integer t = s.peek();
        System.out.print("Top most element is: ");
        if(t < minEle)
            System.out.println(minEle);
        else System.out.println(t);
    }
    void pop(){
        if(s.isEmpty()){
            System.out.println("Stack is empty");
            return;
        }
        System.out.print("Top most element removed: ");
        Integer t = s.pop();
        if(t < minEle){
            System.out.println(minEle);
            minEle = 2 * minEle - t;
        }
        else System.out.println(t);
    }
    void push(Integer x){
        if(s.isEmpty()){
            minEle = x;
            s.push(x);
            System.out.println("Number Inserted: " +x);
            return;
        }
        if(x < minEle){
            s.push(2 * x - minEle);
            minEle = x;
        }
        else s.push(x);
        System.out.println("Number Inserted: " +x);
    }
    public static void main(String [] args){
        specialStackOptimized s = new specialStackOptimized();
        s.push(3);
        s.push(5);
        s.getMin();
        s.push(2);
        s.push(1);
        s.getMin();
        s.pop();
        s.getMin();
        s.pop();
        s.peek();
    }
}
