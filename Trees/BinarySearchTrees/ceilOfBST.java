package dataStructures.Trees.BinarySearchTrees;

public class ceilOfBST {
    static class Node {
        int data;
        Node left, right;
        Node(int item) {
            data = item;
            left = right = null;
        }
    }
    Node root;
    public int ceil(Node node, int input) {
        if(node == null) return -1;
        if(node.data == input)
            return node.data;
        if(node.data < input)
            return ceil(node.right, input);
        int ceiling = ceil(node.left, input);
        return (ceiling >= input ? ceiling : node.data);
    }
    public static void main(String[] args) {
        ceilOfBST tree = new ceilOfBST();

        tree.root = new Node(8);
        tree.root.left = new Node(4);
        tree.root.right = new Node(12);
        tree.root.left.left = new Node(2);
        tree.root.left.right = new Node(6);
        tree.root.right.left = new Node(10);
        tree.root.right.right = new Node(14);

        for(int i = 0; i < 16; i++)
            System.out.println(i +" "+ tree.ceil(tree.root, i));
    }
}
