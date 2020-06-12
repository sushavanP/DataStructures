package dataStructures.cLL;

public class CLLTraverse
{
    static class Node{
        int data;
        Node next;
    }
    static Node push(Node head, int data){
        Node ptr1 = new Node();
        Node temp = head;
        ptr1.data = data;
        ptr1.next = head;
        if(head != null){
            while(temp.next != head)
                temp = temp.next;
            temp.next = ptr1;
        }
        else
            ptr1.next = ptr1;
        head = ptr1;
        return head;
    }
    static void printList(Node head){
        Node temp = head;
        if(head != null){
            do{
                System.out.print(temp.data +" ");
                temp = temp.next;
            }while(temp != head);
        }
    }
    public static void main(String [] args){
        Node head = null;
        head = push(head, 12);
        head = push(head, 56);
        head = push(head, 2);
        head = push(head, 11);
        System.out.println("Contents of Cicular Linked List: ");
        printList(head);
    }
}
