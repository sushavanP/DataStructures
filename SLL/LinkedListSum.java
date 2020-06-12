package dataStructures.SLL;

public class LinkedListSum {
    static Node head1, head2;

    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    Node addTwoLists(Node first, Node second){
        Node res = null;
        Node prev = null;
        Node temp = null;
        int carry = 0, sum;

        while (first != null || second != null){
            sum = carry + (first != null ? first.data : 0) + (second != null ? second.data : 0);
            carry = (sum >= 10) ? 1 : 0;
            sum = sum % 10;
            temp = new Node(sum);
            if (res == null) {
                res = temp;
            } else {
                prev.next = temp;
            }
            prev = temp;
            if (first != null) {
                first = first.next;
            }
            if (second != null) {
                second = second.next;
            }
        }
        if (carry > 0) {
            temp.next = new Node(carry);
        }
        return res;
    }
    public void push1(int new_data){
        Node new_node1 = new Node(new_data);
        new_node1.next = head1;
        head1 = new_node1;
    }
    public void push2(int new_data){
        Node new_node2 = new Node(new_data);
        new_node2.next = head2;
        head2 = new_node2;
    }
    /*Node reverseNode(Node node){
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
    }*/
    public void printList(Node head){
        while(head != null){
            System.out.print(head.data +" ");
            head = head.next;
        }
        System.out.println();
    }
    public static void main(String[] args){
        LinkedListSum llist = new LinkedListSum();
        llist.push1(6);
        llist.push1(4);
        llist.push1(9);
        llist.push1(5);
        llist.push1(7);
        System.out.print("First List is: ");
        llist.printList(head1);

        llist.push2(4);
        llist.push2(8);
        System.out.print("Second list is: ");
        llist.printList(head2);

        Node rs = llist.addTwoLists(head1, head2);
        //Node some = llist.reverseNode(rs);
        System.out.println("Resultant List is: ");
        llist.printList(rs);
    }
}
/*
the commented lines are used to
find the sum in actual order
rather than in reverse order.
 */

