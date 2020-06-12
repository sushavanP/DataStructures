package dataStructures.DLL;

public class dLLinsertion
{
    Node head;
    class Node{
        int data;
        Node prev, next;
        Node(int d){
            data = d;
        }
    }
    //Adding a node at the front of of the list
    public void push(int new_data){
        Node new_node = new Node(new_data);
        new_node.next = head;
        new_node.prev = null;
        if(head != null)
            head.prev = new_node;
        head = new_node;
    }
    /*
    Given a node as prev_node, insert a new node
    after the given node.
     */
    public void insertAfter(Node prev_node, int new_data){
        if(prev_node == null){
            System.out.println("The given previous node cannot be null");
            return;
        }
        Node new_node = new Node(new_data);
        new_node.next = prev_node.next;
        prev_node.next = new_node;
        new_node.prev = prev_node;
        if(new_node.prev != null)
            new_node.next.prev = new_node;
    }
    //Add a node at the end of the list
    public void append(int new_data){
        Node new_node = new Node(new_data);
        Node last = head;
        new_node.next = null;
        if(head == null){
            new_node.prev = null;
            head = new_node;
            return;
        }
        while(last.next != null){
            last = last.next;
        }
        last.next = new_node;
        new_node.prev = last;
    }
    public void printList(Node node){
        Node last = null;
        System.out.println("Traversal in forward direction.");
        while(node != null){
            System.out.print(node.data +" ");
            last = node;
            node = node.next;
        }
        System.out.println();
        System.out.println("Traversal in forward direction.");
        while(last != null){
            System.out.print(last.data +" ");
            last = last.prev;
        }
    }
    public static void main(String[] args){
        dLLinsertion list = new dLLinsertion();
        list.append(6);
        list.push(7);
        list.push(1);
        list.append(4);
        list.insertAfter(list.head.next, 8);
        list.printList(list.head);
    }
}
