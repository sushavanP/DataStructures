package dataStructures.DLL;

public class dLLmergeSort
{
    static Node head;
    static class Node{
        int data;
        Node next,prev;
        Node(int d){
            data = d;
            next = prev = null;
        }
    }
    public void print(Node node){
        Node temp = node;
        System.out.println("Forward Traversal using next pointer");
        while(node != null){
            System.out.print(node.data +" ");
            temp = node;
            node = node.next;
        }
        System.out.println("\nBackward Traversal using prev pointer");
        while(temp != null){
            System.out.print(temp.data +" ");
            temp = temp.prev;
        }
    }
    Node split(Node head){
        Node fast = head, slow = head;
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        Node temp = slow.next;
        slow.next = null;
        return temp;
    }
    Node mergeSort(Node node){
        if(node == null || node.next ==null)
            return node;
        Node second = split(node);
        node = mergeSort(node);
        second = mergeSort(second);
        return merge(node, second);
    }
    Node merge(Node first, Node second){
        if(first == null)
            return second;
        if(second == null)
            return first;
        if(first.data < second.data){
            first.next = merge(first.next, second);
            first.next.prev = first;
            first.prev = null;
            return first;
        }else{
            second.next = merge(first, second.next);
            second.next.prev = second;
            second.prev = null;
            return second;
        }
    }
    public void push(int new_data){
        Node new_node = new Node(new_data);
        new_node.prev = null;
        new_node.next = head;
        if(head != null)
            head.prev = new_node;
        head = new_node;
    }
    public static void main(String[] args){
        dLLmergeSort list = new dLLmergeSort();
        list.push(5);
        list.push(20);
        list.push(4);
        list.push(3);
        list.push(30);
        list.push(10);

        Node node = null;
        node = list.mergeSort(head);
        System.out.println("Linked list after sorting: ");
        list.print(node);
    }
}
