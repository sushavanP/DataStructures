package dataStructures.Trees.BinarySearchTrees;

import java.util.Arrays;

public class binaryTreeToBST {
    static class Node {
        int data;
        Node right;
        Node left;
        Node(int item) {
            data = item;
            left = right = null;
        }
    }
    Node root;
    int treeArray[];
    int index = 0;
    public binaryTreeToBST() {
        root = null;
    }
    public Node convertToBST(Node node) {
        int treeSize = calculateSize(node);
        treeArray = new int[treeSize];
        convertBTtoArray(node);
        Arrays.sort(treeArray);
        Node d = createBST(0, treeArray.length - 1);
        return d;
    }
    public int calculateSize(Node node) {
        int size = 0;
        if(node == null) return 0;
        else{
            size = calculateSize(node.left) + calculateSize(node.right) + 1;
            return size;
        }
    }
    private void convertBTtoArray(Node node) {
        if(root == null) {
            System.out.println("tree is empty!");
            return;
        }
        else {
            if(node.left != null)
                convertBTtoArray(node.left);
            treeArray[index] = node.data;
            index++;
            if(node.right != null)
                convertBTtoArray(node.right);
        }
    }
    private Node createBST(int start, int end) {
        if(start > end)
            return null;
        int mid = (start + end) / 2;
        Node node = new Node(treeArray[mid]);
        node.left = createBST(start, mid - 1);
        node.right = createBST(mid + 1, end);
        return node;
    }
    public void inOrderTraversal(Node node) {
        if(node == null) {
            System.out.println("Tree is empty.");
            return;
        }
        else {
            if(node.left != null)
                inOrderTraversal(node.left);
            System.out.print(node.data + " ");
            if(node.right != null)
                inOrderTraversal(node.right);
        }
    }
    public static void main(String[] args) {
        binaryTreeToBST bt = new binaryTreeToBST();
        bt.root = new Node(1);
        bt.root.left = new Node(2);
        bt.root.right = new Node(3);
        bt.root.left.left = new Node(4);
        bt.root.left.right = new Node(5);
        bt.root.right.left = new Node(6);
        bt.root.right.right = new Node(7);

        //Display given binary tree
        System.out.println("Inorder representation of binary tree: ");
        bt.inOrderTraversal(bt.root);

        //Converts binary tree to corresponding binary search tree
        Node bst = bt.convertToBST(bt.root);

        //Display corresponding binary search tree
        System.out.println("\nInorder representation of resulting binary search tree: ");
        bt.inOrderTraversal(bst);
    }
}
