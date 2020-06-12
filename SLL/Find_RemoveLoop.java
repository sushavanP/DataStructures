package dataStructures.SLL;

//Implementing Floyd's Cycle-Finding Algorithm
public class Find_RemoveLoop
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
    public void push(int new_data){
        Node new_node = new Node(new_data);
        new_node.next = head;
        head = new_node;
    }
    int detectAndRemoveLoop(Node node){
        Node slow = node, fast = node;
        while(slow != null && fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                System.out.println("Found Loop");
                removeLoop(slow, node);
                return 1;
            }
        }
        return 0;
    }
    public void removeLoop(Node loop, Node curr){
        Node ptr1 = null, ptr2 = null;
        ptr1 = curr;
        while(1 == 1){
            ptr2 = loop;
            while(ptr2.next != loop && ptr2.next != ptr1){
                ptr2 = ptr2.next;
            }
            if(ptr2.next == ptr1)
                break;
            ptr1 = ptr1.next;
        }
        ptr2.next = null;
    }
    public void printList(Node node){
        while(node != null){
            System.out.print(node.data +" ");
            node = node.next;
        }
    }
    public static void main(String[] args){
        Find_RemoveLoop llist = new Find_RemoveLoop();
        llist.push(50);
        llist.push(20);
        llist.push(15);
        llist.push(4);
        llist.push(10);
        head.next.next.next.next.next = head.next.next;
        llist.detectAndRemoveLoop(head);
        System.out.println("Linked list after removing Loop : ");
        llist.printList(head);
    }
}
