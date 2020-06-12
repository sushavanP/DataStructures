package dataStructures.cLL;

public class CLLSplit
{
    static Node head, head1, head2;
    static class Node{
        int data;
        Node next, prev;
        Node(int d){
            data = d;
            next = prev = null;
        }
    }
    public void splitList(){
        Node slow_ptr = head;
        Node fast_ptr = head;
        if(head == null)
            return;
        while(fast_ptr.next != head
                && fast_ptr.next.next != head){
            fast_ptr = fast_ptr.next.next;
            slow_ptr = slow_ptr.next;
        }
        if(fast_ptr.next.next == head)
            fast_ptr = fast_ptr.next;
        head1 = head;
        if(head.next != head)
            head2 = slow_ptr.next;
        fast_ptr.next = slow_ptr.next;
        slow_ptr.next = head;
    }
    public void printList(Node node){
        Node temp = node;
        if(node != null){
            do{
                System.out.print(temp.data +" ");
                temp = temp.next;
            }while(temp != node);
        }
        System.out.println();
    }
    public static void main(String [] args){
        CLLSplit list = new CLLSplit();
        list.head = new Node(12);
        list.head.next = new Node(56);
        list.head.next.next = new Node(2);
        list.head.next.next.next = new Node(11);
        list.head.next.next.next.next = new Node(13);
        list.head.next.next.next.next.next = new Node(17);
        list.head.next.next.next.next.next.next = new Node(19);
        list.head.next.next.next.next.next.next.next = list.head;
        System.out.println("Original CLL");
        list.printList(head);

        list.splitList();
        System.out.println("First CLL");
        list.printList(head1);
        System.out.println("Second CLL");
        list.printList(head2);
    }
}
