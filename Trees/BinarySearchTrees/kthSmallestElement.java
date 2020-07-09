package dataStructures.Trees.BinarySearchTrees;

public class kthSmallestElement {
    static class Node {
        int data;
        Node left, right;
        Node(int item) {
            data = item;
            left = right = null;
        }
    }
    static Node root;
    static int count = 0;
    public static void insert(int data) {
        root = insertRec(root, data);
    }
    public static Node insertRec(Node root, int data) {
        if(root == null) {
            root = new Node(data);
            return root;
        }
        if(data < root.data)
            root.left = insertRec(root.left, data);
        else if(data > root.data)
            root.right = insertRec(root.right, data);
        return root;
    }
    public static Node findKthElement(Node root, int k) {
        if(root == null) return null;
        Node left = findKthElement(root.left, k);
        if(left != null)
            return left;
        count++;
        if(count == k)
            return root;
        else return findKthElement(root.right, k);
    }
    public static void printKthElement(Node root, int k) {
        count = 0;
        Node res = findKthElement(root, k);
        if(res == null)
            System.out.println("There are less "
                    + "than k nodes in the BST");
        else
            System.out.println("K-th Smallest"
                    + " Element is " + res.data);
    }
    public static void main(String[] args) {
        insert(20);
        insert(8);
        insert(22);
        insert(4);
        insert(12);
        insert(10);
        insert(14);

        printKthElement(root, 3);
    }
}
