package dataStructures.SLL;

public class LLinsertion
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
    public void push(int new_data){
        Node new_node = new Node(new_data);
        new_node.next = head;
        head = new_node;
    }
    public void insertAfter(Node prev_node, int new_data){
        if(prev_node == null){
            System.out.println("This can't be null.");
            return;
        }
        Node new_node = new Node(new_data);
        new_node.next = prev_node.next;
        prev_node.next = new_node;
    }
    public void append(int new_data){
        Node new_node = new Node(new_data);
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
    public static void main(String[] args){
        LLinsertion llist = new LLinsertion();
        llist.append(7);
        llist.append(60);
        llist.push(65);
        llist.insertAfter( llist.head, 45);
        llist.insertAfter(llist.head.next.next, 69);

        System.out.println("The data provided are: ");
        llist.printList();
    }
    private void printList(){
      Node tnode = head;
      while(tnode != null){
          System.out.print(tnode.data +" ");
          tnode = tnode.next;
      }
    }
}
