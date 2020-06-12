package dataStructures.SLL;

public class LLRotate
{
    Node head;
    class Node{
        int data;
        Node next;
        Node(int d){
           data = d;
           next = null;
        }
    }
    void rotate(int k){
        if(k == 0)
            return;
        Node current = head;
        int count = 1;
        while(count < k && current != null){
            current = current.next;
            count++;
        }
        if(current == null)
            return;
        Node kthnode = current;
        while(current.next != null)
            current = current.next;
        current.next = head;
        head = kthnode.next;
        kthnode.next = null;
    }
    public void append(int new_data){
        Node new_node  = new Node(new_data);
        if(head == null){
            head = new Node(new_data);
            return;
        }
        new_node.next = null;
        Node last = head;
        while(last.next != null)
            last = last.next;
        last.next = new_node;
        return;
    }
    public void printList(){
        Node tnode = head;
        while(tnode != null){
            System.out.print(tnode.data +" ");
            tnode = tnode.next;
        }
        System.out.println();
    }
    public static void main(String[] args){
        LLRotate list = new LLRotate();
        for(int i = 10; i <= 60; i += 10)
            list.append(i);
        System.out.println("Given List");
        list.printList();

        list.rotate(4);
        System.out.println("Rotated Linked List");
        list.printList();
    }
}
