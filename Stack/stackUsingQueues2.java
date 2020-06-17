/*
   By making pop operation costly. Pop at O(n) time.
   Push at O(1) time.
*/
package dataStructures.Stack;
import java.util.Queue;
import java.util.LinkedList;

public class stackUsingQueues2
{
    static class Stack{
        static Queue <Integer> q1 = new LinkedList<Integer>();
        static Queue <Integer> q2 = new LinkedList<Integer>();
        static int curr_size;
        public Stack(){
            curr_size = 0;
        }
        static void remove(){
            if(q1.isEmpty())
                return;
            while(q1.size() != 1){
                q2.add(q1.peek());
                q1.remove();
            }
            q1.remove();
            curr_size--;
            Queue <Integer> q = q1;
            q1 = q2;
            q2 = q;
        }
        static void add(int x){
            q1.add(x);
            curr_size++;
        }
        static int top(){
            if(q1.isEmpty())
                return -1;
            while(q1.size() != 1){
                q2.add(q1.peek());
                q1.remove();
            }
            int temp = q1.peek();
            q1.remove();
            q2.add(temp);

            Queue <Integer> q = q1;
            q1 = q2;
            q2 = q;
            return temp;
        }
        static int size(){
            return curr_size;
        }
    }
    public static void main(String[] args){
        Stack s = new Stack();
        s.add(1);
        s.add(2);
        s.add(3);
        s.add(4);

        System.out.println("Current size: " +s.size());
        System.out.println(s.top());
        s.remove();
        System.out.println(s.top());
        s.remove();
        System.out.println(s.top());
        System.out.println("Current size: " +s.size());
    }
}
