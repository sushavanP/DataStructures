package dataStructures.Trees.BinaryTrees;

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
    Node findLCA(int n1, int n2) {
        return findLCA(root, n1, n2);
    }
    Node findLCA(Node root, int n1, int n2) {
        if(root == null) return null;
        if(root.data == n1 || root.data == n2)
            return root;
        Node left_lca = findLCA(root.left, n1, n2);
        Node right_lca = findLCA(root.right, n1, n2);
        if(left_lca != null && right_lca != null)
            return root;
        return (left_lca != null) ? left_lca : right_lca;
    }
    public static void main(String args[])
    {
        lowestCommonAncestor tree = new lowestCommonAncestor();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);
        System.out.println("LCA(4, 5) = " + tree.findLCA(4, 5).data);
        System.out.println("LCA(4, 6) = " + tree.findLCA(4, 6).data);
        System.out.println("LCA(3, 4) = " + tree.findLCA(3, 4).data);
        System.out.println("LCA(2, 4) = " + tree.findLCA(2, 4).data);
    }
}
