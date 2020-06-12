package dataStructures.DLL;

public class dLLdeletion
{
    Node head;
    class Node{
        int data;
        Node next, prev;
        Node(int d){
            data = d;
        }
    }
    public void push(int new_data){
        Node new_node = new Node(new_data);
        new_node.next = head;
        new_node.prev = null;
        if(head != null)
            head.prev = new_node;
        head = new_node;
    }
    public void printList(Node node){
        Node last = null;
        while (node != null){
            System.out.print(node.data +" ");
            last = node;
            node = node.next;
        }
        System.out.println();
    }
    public void deleteNode(Node head_ref, Node del){

        // Base case
        if(head == null || del == null)
            return;

        // If node to be deleted is head node
        if(head == del)
            head = del.next;

        /*Change next only if node to be deleted
        is NOT the last node
        */
        if(del.next != null)
            del.next.prev = del.prev;

        /*Change prev only if node to be deleted
        is NOT the first node
        */
        if(del.prev != null)
            del.prev.next = del.next;

        //Delete last node
        if(del.next == null)
            del.prev.next = null;
        return;
    }
    public static void main(String[] args){
        dLLdeletion list = new dLLdeletion();
        list.push(2);
        list.push(4);
        list.push(8);
        list.push(10);
        System.out.print("Created DLL is: ");
        list.printList(list.head);
        list.deleteNode(list.head, list.head);
        System.out.print("\nList after deleting first node: ");
        list.printList(list.head);
        /*list.deleteNode(list.head, list.head.next);
        System.out.print("\nList after Deleting middle node: ");
        list.printList(list.head);*/
        list.deleteNode(list.head, list.head.next.next);
        System.out.print("\nList after deleting the last node: ");
        list.printList(list.head);

    }
}
