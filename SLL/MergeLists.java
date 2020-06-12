package dataStructures.SLL;

class Node{
    int data;
    Node next;
    Node(int d){
        data = d;
        next = null;
    }
}
public class MergeLists
{
    Node head;
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
    public static void main(String [] args){
        MergeLists llist1 = new MergeLists();
        MergeLists llist2 = new MergeLists();

        //First List
        llist1.append(5);
        llist1.append(10);
        llist1.append(15);

        //Second List
        llist2.append(2);
        llist2.append(3);
        llist2.append(20);

        llist1.head = new sortMerge().sortedMerge(llist1.head, llist2.head);
        llist1.printList();
    }
}
class sortMerge{
    Node sortedMerge(Node headA, Node headB){
        Node dummyNode = new Node(0);
        Node tail = dummyNode;
        while(true){
            if(headA == null){
                tail.next = headB;
                break;
            }
            if(headB == null){
                tail.next = headA;
                break;
            }
            if(headA.data <= headB.data){
                tail.next = headA;
                headA = headA.next;
            }else{
                tail.next = headB;
                headB = headB.next;
            }
            tail = tail.next;
        }
        return dummyNode.next;
    }
}
