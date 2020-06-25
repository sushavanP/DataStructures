package dataStructures.Queue;

import java.util.LinkedList;
import java.util.Queue;

public class binaryGenerator
{
    static void printBinary(int n){
        Queue<String> Q = new LinkedList<>();
        Q.add("1");
        while(n-- > 0){
            String s1 = Q.peek();
            Q.remove();
            System.out.println(s1);

            String s2 = s1;
            Q.add(s1 + "0");
            Q.add(s2 + "1");
        }
    }
    public static void main(String[] args){
        int n = 10;
        printBinary(n);
    }
}
