package dataStructures.SLL;


public class nodeSwap
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
    public void append(int new_data) {
        Node new_node = new Node(new_data);
        if (head == null) {
            head = new Node(new_data);
            return;
        }
        new_node.next = null;
        Node last = head;
        while (last.next != null) {
            last = last.next;
        }
        last.next = new_node;
        return;
    }
    public void swapNodes(int X, int Y){
        if(X == Y)
            return;
        Node prevX = null, currX = head;
        while(currX != null && currX.data != X){
            prevX = currX;
            currX = currX.next;
        }
        Node prevY = null, currY = head;
        while(currY != null && currY.data != Y){
            prevY = currY;
            currY = currY.next;
        }
        if(currX == null || currY == null)
            return;
        if(prevX != null)
            prevX.next = currY;
        else head = currY;
        if(prevY != null)
            prevY.next = currX;
        else head = currX;
        Node temp = currX.next;
        currX.next = currY.next;
        currY.next = temp;
    }
    public void printList(){
        Node tnode = head;
        while(tnode != null){
            System.out.print(tnode.data +" ");
            tnode = tnode.next;
        }
    }
    public static void main(String[] args){
        nodeSwap llist = new nodeSwap();
        llist.append(69);
        llist.append(45);
        llist.append(34);
        llist.append(90);
        llist.append(67);
        llist.append(99);
        llist.append(23);

        llist.printList();
        llist.swapNodes(45, 67);
        System.out.println();
        llist.printList();
    }
}
