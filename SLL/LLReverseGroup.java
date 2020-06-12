package dataStructures.SLL;

public class LLReverseGroup
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
    Node reverse(Node head, int k){
        Node current = head;
        Node next = null;
        Node prev = null;
        int count = 0;
        while(count < k && current != null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            count++;
        }
        if(next != null)
            head.next = reverse(next, k);
        return prev;
    }
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
    public void printList(){
        Node tnode = head;
        while(tnode != null){
            System.out.print(tnode.data +" ");
            tnode = tnode.next;
        }
    }
    public static void main(String[] args){
        LLReverseGroup llist = new LLReverseGroup();
        llist.append(76);
        llist.append(34);
        llist.append(89);
        llist.append(90);
        llist.append(65);
        llist.append(11);
        llist.append(29);
        llist.append(69);
        llist.append(49);
        llist.printList();
        System.out.println();

        llist.head = llist.reverse(llist.head, 3);
        llist.printList();
    }
}
