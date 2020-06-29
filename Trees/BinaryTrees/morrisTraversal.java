/*
    Java program to print inorder traversal without recursion and stack.
    Time - O(n), Space - O(1).
*/
package dataStructures.Trees.BinaryTrees;

public class morrisTraversal {
    static class Node{
        int data;
        Node left, right;

        Node(int item){
            data = item;
            left = right = null;
        }
    }
    Node root;

    void traversal(Node root){
        Node current, predecessor;
        if(root == null)
            return;

        current = root;
        while(current != null){
            if(current.left == null){
                System.out.print(current.data +" ");
                current = current.right;
            }
            else{
                predecessor = current.left;
                while(predecessor.right != null &&
                    predecessor.right != current)
                    predecessor = predecessor.right;
                if(predecessor.right == null){
                    predecessor.right = current;
                    current = current.left;
                }
                else{
                    predecessor.right = null;
                    System.out.print(current.data +" ");
                    current = current.right;
                }
            }
        }
    }
    public static void main(String[] args){
        morrisTraversal tree = new morrisTraversal();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        tree.traversal(tree.root);
    }
}
