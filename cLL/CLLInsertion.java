package dataStructures.cLL;

public class CLLInsertion
{
    static class Node{
        int data;
        Node next;
    }
    static Node addToEmpty(Node last, int data){
        if(last != null)
            return last;
        Node temp = new Node();
        temp.data = data;
        last = temp;
        last.next = last;
        return last;
    }
    static Node addToBegin(Node last, int data){
        if(last == null)
            return addToEmpty(last, data);
        Node temp = new Node();
        temp.data = data;
        temp.next = last.next;
        last.next = temp;
        return last;
    }
    static Node addToEnd(Node last, int data){
        if(last == null)
            return addToEmpty(last, data);
        Node temp = new Node();
        temp.data = data;
        temp.next = last.next;
        last.next = temp;
        last = temp;
        return last;
    }
    static Node addAfter(Node last, int data, int item){
        if(last == null)
            return null;
        Node temp, p;
        p = last.next;
        do{
            if(p.data == item){
                temp = new Node();
                temp.data = data;
                temp.next = p.next;
                p.next = temp;
                if(p == last)
                    last = temp;
                return last;
            }
            p = p.next;
        }while(p != last.next);
        System.out.println(item + "  not present in the last.");
        return last;
    }
    static void traverse(Node last){
        Node p;
        if(last == null){
            System.out.println("List is empty.");
            return;
        }
        p = last.next;
        do{
            System.out.print(p.data +" ");
            p = p.next;
        }while(p != last.next);
    }
    public static void main(String[] args){
        Node last = null;
        last = addToEmpty(last, 6);
        last = addToBegin(last, 4);
        last = addToBegin(last, 2);
        last = addToEnd(last, 8);
        last = addToEnd(last, 12);
        last = addAfter(last, 10, 8);
        traverse(last);
        double time2 = System.nanoTime();
    }
}
