package dataStructures.Queue;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

public class deque
{
    public static void main(String[] args){
        Deque <String> dq = new LinkedList<String>();

        // We can add elements to the queue in various ways.
        dq.add("Element 1(Tail)");
        dq.addFirst("Element 2(Head)");
        dq.addLast("Element 3(Tail)");
        dq.push("Element 4(Head)");
        dq.offer("Element 5(Tail)");
        dq.offerFirst("Element 6 (Head)");
        dq.offerLast("Element 7 (Tail)");

        System.out.println(dq +"\n");

        //Iterate through the queue elements.
        System.out.println("Standard Iterator");
        Iterator iterator = dq.iterator();
        while(iterator.hasNext())
            System.out.println("\t" + iterator.next());

        //Reverse order iterator
        Iterator reverse = dq.descendingIterator();
        System.out.println("Reverse Iterator");
        while(reverse.hasNext())
            System.out.println("\t" + reverse.next());

        /*
        Peek returns the head, without deleting
        it from the deque
        */
        System.out.println("\nPeek " + dq.peek());
        System.out.println("After peek" + dq);

        /*
        Pop returns the head, and removes it from
        the deque
        */
        System.out.println("\nPop" + dq.pop());
        System.out.println("After Pop" + dq);

        /*
        We can check if a specific element exists
        in the deque
        */
        System.out.println("\nContains element 3: " +dq.contains("Element 3(Tail)"));

        //We can remove the first / last element.
        dq.removeFirst();
        dq.removeLast();
        System.out.println("Deque after removing " +
                            "first and last: " +dq);

    }
}
