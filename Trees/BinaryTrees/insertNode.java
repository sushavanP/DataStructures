package dataStructures.Trees.BinaryTrees;

public class insertNode
{
    static class Node{
        int data;
        Node left, right;
        Node(int item){
            data = item;
            left = right = null;
        }
    }
    Node root;
    insertNode(int key){
        root = new Node(key);
    }
    insertNode(){
        root = null;
    }
    public static void main(String[] args){
        insertNode tree = new insertNode();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
    }
}
