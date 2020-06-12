package dataStructures.SLL;

public class LLReverse
{
    static Node head;
    class Node{
        int data;
        Node next;
        Node(int d){
            data = d;
            next = null;
        }
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
    Node reverseNode(Node node){
        Node prev = null;
        Node current = node;
        Node next = null;
        while(current != null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        node = prev;
        return node;
    }
    public void printList(Node tnode){
        while(tnode != null){
            System.out.print(tnode.data +" ");
            tnode = tnode.next;
        }
    }
    public static void main(String [] args){
        LLReverse llist = new LLReverse();
        llist.append(1);
        llist.append(2);
        llist.append(3);
        llist.append(4);
        llist.append(5);
        llist.append(6);
        llist.append(7);
        llist.append(8);
        llist.printList(head);
        System.out.println();

        head = llist.reverseNode(head);
        llist.printList(head);
    }
}
