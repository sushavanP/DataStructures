package dataStructures.Trees.BinarySearchTrees;

public class minimumNodeBST {
    static class Node {
        int data;
        Node left, right;

        Node(int item) {
            data = item;
            left = right = null;
        }
    }
    Node root;

    void insert(int data) {
        root = insertRec(root, data);
    }

    public Node insertRec(Node root, int data) {
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

    int minValue(Node root) {
        Node current = root;

        while(current.left != null) {
            current = current.left;
        }
        return current.data;
    }

    public static void main(String[] args) {
        minimumNodeBST tree = new minimumNodeBST();

        tree.insert(4);
        tree.insert(2);
        tree.insert(3);
        tree.insert(1);
        tree.insert(6);
        tree.insert(9);
        tree.insert(7);

        System.out.println("The minimum element is: " +tree.minValue(tree.root));
    }
}
