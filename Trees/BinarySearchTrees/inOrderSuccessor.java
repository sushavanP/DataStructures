package dataStructures.Trees.BinarySearchTrees;

public class inOrderSuccessor {
    static class Node {
        int data;
        Node left, right;
        Node(int item) {
            data = item;
            left = right = null;
        }
    }
    static Node root;
    public static void insertion(int data) {
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
    public static Node findMin(Node root) {
        while(root.left != null) {
            root = root.left;
        }
        return root;
    }
    public static Node getSuccessor(Node root, Node successor,  int key) {
        if(root == null) return null;
        if(root.data == key) {
            if(root.right != null)
                return findMin(root.right);
        }
        else if(root.data > key) {
            successor = root;
            return getSuccessor(root.left, successor, key);
        }
        else
            return getSuccessor(root.right, successor, key);
        return successor;
    }
    public static void main(String[] args) {
        //int keys[] = {15, 10, 20, 8, 12, 16, 25};
        insertion(15);
        insertion(10);
        insertion(20);
        insertion(8);
        insertion(12);
        insertion(16);
        insertion(25);

        Node ans = getSuccessor(root, null, 15);
        System.out.println(ans.data);

    }
}
