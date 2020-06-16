package dataStructures.Stack;
import java.util.Stack;

public class specialStack extends Stack <Integer> {
    Stack <Integer> min = new Stack<>();
    void push(int x){
        if(isEmpty() == true){
            super.push(x);
            min.push(x);
        }else{
            super.push(x);
            int y = min.pop();
            min.push(y);
            if(x < y)
                min.push(x);
            else
                min.push(y);
        }
    }
    public Integer pop(){
        int x = super.pop();
        min.pop();
        return x;
    }
    int getMin(){
        int x = min.pop();
        min.push(x);
        return x;
    }
    public static void main(String[] args){
        specialStack s = new specialStack();
        s.push(10);
        s.push(20);
        s.push(30);
        System.out.println(s.getMin());
        s.push(5);
        System.out.println(s.getMin());
    }
}
/*
    Time Complexity = O(1).
    Extra Space Complexity = O(n).
*/
