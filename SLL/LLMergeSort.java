package dataStructures.SLL;

public class LLMergeSort
{
    Node head = null;
    static class Node {
        int val;
        Node next;
        Node(int val){
            this.val = val;
            next = null;
        }
    }
    Node sortedMerge(Node a, Node b){
        Node result = null;
        if(a == null)
            return b;
        if(b == null)
            return a;
        if(a.val <= b.val){
            result = a;
            result.next = sortedMerge(a.next, b);
        }else{
            result = b;
            result.next = sortedMerge(a, b.next);
        }
        return result;
    }
    Node mergeSort(Node h){
        if(h == null || h.next == null)
            return h;
        Node middle = getMiddle(h);
        Node nextofmiddle = middle.next;
        middle.next = null;
        Node left = mergeSort(h);
        Node right = mergeSort(nextofmiddle);
        Node sortedList = sortedMerge(left, right);
        return sortedList;
    }
    public static Node getMiddle(Node head){
        if(head == null)
            return head;
        Node slow = head, fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public void push(int new_data){
        Node new_node = new Node(new_data);
        new_node.next = head;
        head = new_node;
    }
    public void printList(){
        Node tnode = head;
        while(tnode != null){
            System.out.print(tnode.val +" ");
            tnode = tnode.next;
        }
    }
    public static void main(String[] args){
        LLMergeSort llist = new LLMergeSort();
        llist.push(15);
        llist.push(10);
        llist.push(5);
        llist.push(20);
        llist.push(3);
        llist.push(2);
        llist.push(69);
        llist.head = llist.mergeSort(llist.head);
        llist.printList();
    }
}
