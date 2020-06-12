package dataStructures.SLL;

public class LLdeletPos
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
        Node new_node =  new Node(new_data);
        new_node.next = head;
        head = new_node;
    }
    public void deleteNode(int pos){
        if(head == null)
            return;
        Node temp = head;
        if(pos == 0){
            head = temp.next;
            return;
        }
        for(int i = 0; temp != null && i < pos-1; i++){
            temp = temp.next;
        }
        if(temp == null || temp.next == null)
            return;
        Node next = temp.next.next;
        temp.next = next;
    }
    public void printList(){
        Node tnode = head;
        while(tnode != null){
            System.out.print(tnode.data +" ");
            tnode = tnode.next;
        }
    }
    public static void main(String[] args){
        LLdeletPos llist = new LLdeletPos();
        llist.push(6);
        llist.push(8);
        llist.push(3);
        llist.push(0);
        llist.push(2);
        llist.printList();

        System.out.println();
        llist.deleteNode(3);
        llist.printList();
    }
}
