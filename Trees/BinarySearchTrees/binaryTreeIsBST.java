/*
    Using InOrder Traversal. Time complexity is O(n) and space complexity is O(1).
*/
package dataStructures.Trees.BinarySearchTrees;

public class binaryTreeIsBST {
    static class Node {
        int data;
        Node left, right;
        Node(int item) {
            data = item;
            left = right = null;
        }
    }
    Node root;
    Node prev;
    boolean isBST() {
        prev = null;
        return isBST(root);
    }
    boolean isBST(Node node) {
        if(node != null) {
            if(!isBST(node.left))
                return false;
            if(prev != null && node.data <= prev.data)
                return false;
            prev = node;
            return isBST(node.right);
        }
        return true;
    }
    public static void main(String[] args) {
        binaryTreeIsBST tree = new binaryTreeIsBST();
        tree.root = new Node(4);
        tree.root.left = new Node(2);
        tree.root.right = new Node(5);
        tree.root.left.left = new Node(1);
        tree.root.left.right = new Node(3);

        if (tree.isBST())
            System.out.println("IS BST");
        else
            System.out.println("Not a BST");
    }
}

/*
    Another efficient method is follow the method 3 from the below link.
    https://www.geeksforgeeks.org/a-program-to-check-if-a-binary-tree-is-bst-or-not/
*/

