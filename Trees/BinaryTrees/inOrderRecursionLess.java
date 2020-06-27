package dataStructures.Trees.BinaryTrees;

import java.util.Stack;

public class inOrderRecursionLess
{
    static class Node{
        int data;
        Node left, right;

        public Node(int item){
            data = item;
            left = right = null;
        }
    }
    Node root;
    void inorder(){
        if(root == null)
            return;
        Stack<Node> s = new Stack<>();
        Node curr = root;

        while(curr != null || s.size() > 0) {
            while (curr != null) {
                s.push(curr);
                curr = curr.left;
            }
            curr = s.pop();
            System.out.print(curr.data + " ");
            curr = curr.right;
        }
    }
    public static void main(String[] args){
        inOrderRecursionLess tree = new inOrderRecursionLess();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.inorder();
    }
}
