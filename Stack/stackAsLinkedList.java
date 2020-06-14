package dataStructures.Stack;

public class stackAsLinkedList
{
    stackNode root;
    class stackNode{
        int data;
        stackNode next;
        stackNode(int data){
            this.data = data;
        }
    }
    public boolean isEmpty(){
        if(root == null)
            return true;
        else
            return false;
    }
    public void push(int data){
        stackNode newNode = new stackNode(data);
        if(root == null)
            root = newNode;
        else{
            stackNode temp = root;
            root = newNode;
            newNode.next = temp;
        }
        System.out.println(data +" pushed to stack.");
    }
    public int pop(){
        int popped = Integer.MIN_VALUE;
        if(root == null)
            System.out.println("Stack is empty.");
        else{
            popped = root.data;
            root = root.next;
        }
        return popped;
    }
    public int peek(){
        if(root == null){
            System.out.println("Stack is empty.");
            return Integer.MIN_VALUE;
        }else
            return root.data;
    }
    public static void main(String[] args){
        stackAsLinkedList stack = new stackAsLinkedList();
        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println(stack.pop() +" popped from stack");
        System.out.println("Top element is " +stack.peek());
    }
}
