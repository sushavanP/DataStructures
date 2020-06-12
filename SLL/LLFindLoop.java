package dataStructures.SLL;

//Implementing Floyd's Cycle-Finding Algorithm
public class LLFindLoop
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
    int detectLoop(){
        Node slow_p = head, fast_p = head;
        while(slow_p != null && fast_p != null && fast_p.next != null){
            slow_p = slow_p.next;
            fast_p = fast_p.next.next;
            if(slow_p == fast_p){
                System.out.println("Found Loop");
                return 1;
            }
        }
        return 0;
    }
    public static void main(String[] args){
        LLFindLoop llist = new LLFindLoop();
        llist.push(20);
        llist.push(4);
        llist.push(15);
        llist.push(10);

        llist.head.next.next.next.next = llist.head;
        llist.detectLoop();
    }
}
