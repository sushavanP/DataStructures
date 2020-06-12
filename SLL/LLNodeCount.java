package dataStructures.SLL;

public class LLNodeCount
{
    class Node
    {
        int data;
        Node next;
        Node(int d){
            data = d;
            next = null;
        }
    }
    Node head;
    public void append(int new_data){
        Node new_node = new Node(new_data);
        if(head == null){
            head = new Node(new_data);
            return;
        }
        new_node.next = null;
        Node last = head;
        while(last.next != null){
            last = last.next;
        }
        last.next = new_node;
        return;
    }
    /*public int getCount(){
        Node temp = head;
        int count = 0;
        while(temp != null){
            count++;
            temp = temp.next;
        }
        return count;
    }*/
    //Recursive Function, generally faster.
    public int getCountRec(Node node){
        //Base Case
        if(node == null)
            return 0;
        return 1 + getCountRec(node.next);
    }
    public int getCount(){
        return getCountRec(head);
    }
    public static void main(String [] args){
        double start = System.nanoTime();
        LLNodeCount llist = new LLNodeCount();
        llist.append(89);
        llist.append(67);
        llist.append(45);
        llist.append(56);
        llist.append(23);

        //System.out.println("The number of nodes: " + llist.getCount());
        llist.getCount();
        double end = System.nanoTime();
        System.out.println("Time Takes " + (end - start)/1000000 + " ms");
    }
}
