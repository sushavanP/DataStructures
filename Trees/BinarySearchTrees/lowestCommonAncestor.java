package dataStructures.Trees.BinarySearchTrees;

public class lowestCommonAncestor {
    static class Node {
        int data;
        Node left, right;
        Node(int item) {
            data = item;
            left = right = null;
        }
    }
    Node root;
    Node LCA(Node node, int n1, int n2) {
        if(node == null)
            return null;
        if(node.data < n1 && node.data < n2)
            return LCA(node.right, n1, n2);
        if(node.data > n1 && node.data > n2)
            return LCA(node.left, n1, n2);
        return node;
    }
    void insert(int data) {
        root = insertRec(root, data);
    }
    public Node insertRec(Node root, int data) {
        if(root == null) {
            root = new Node(data);
            return root;
        }
        if(data > root.data)
            root.right = insertRec(root.right, data);
        else if(data < root.data)
            root.left = insertRec(root.left, data);
        return root;
    }
    public static void main(String [] args) {
        lowestCommonAncestor tree = new lowestCommonAncestor();
        tree.insert(20);
        tree.insert(8);
        tree.insert(22);
        tree.insert(4);
        tree.insert(12);
        tree.insert(10);
        tree.insert(14);

        int n1 = 10, n2 = 14;
        Node commonAncestor = tree.LCA(tree.root, n1, n2);
        System.out.println("LCA of " + n1 + " and " + n2 + " is " + commonAncestor.data);

        n1 = 14;
        n2 = 8;
        commonAncestor = tree.LCA(tree.root, n1, n2);
        System.out.println("LCA of " + n1 + " and " + n2 + " is " + commonAncestor.data);

        n1 = 10;
        n2 = 22;
        commonAncestor = tree.LCA(tree.root, n1, n2);
        System.out.println("LCA of " + n1 + " and " + n2 + " is " + commonAncestor.data);
    }
}
