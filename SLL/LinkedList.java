package dataStructures.SLL;

public class LinkedList
{
    Node head;
    static class Node{
        int data;
        Node next;
        Node(int d){
            data = d;
            next = null;
        }
    }
    public static void main(String[] args){
        LinkedList llist = new LinkedList();
        llist.head = new Node(1); // initialization of values in the node
        Node second = new Node(2);
        Node third = new Node(3);

        llist.head.next = second;
        second.next = third;
        llist.printList();
    }
    private void printList()
    {
        //traversal in the node
        Node n = head;
        while(n != null){
            System.out.print(n.data +" ");
            n = n.next;
        }
    }
}
