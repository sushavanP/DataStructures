package dataStructures.SLL;

public class LLdeletekey
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
    public void deleteNode(int key){
        Node temp = head;
        Node prev = null;
        if(temp != null && temp.data == key){
            head = temp.next;
            return;
        }
        while(temp != null && temp.data != key){
            prev = temp;
            temp = temp.next;
        }
        if(temp == null) //if key was not present in list.
            return;
        prev.next = temp.next;
    }
    public void printList(){
        Node tnode = head;
        while(tnode != null){
            System.out.print(tnode.data +" ");
            tnode = tnode.next;
        }
    }
    public static void main(String [] args){
        LLdeletekey llist = new LLdeletekey();
        llist.push(67);
        llist.push(56);
        llist.push(69);
        llist.push(45);
        llist.printList();

        System.out.println();
        llist.deleteNode(56);
        llist.printList();
    }
}
