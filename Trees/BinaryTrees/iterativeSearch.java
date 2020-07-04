package dataStructures.Trees.BinaryTrees;

import java.util.LinkedList;
import java.util.Queue;

public class iterativeSearch {
    static class Node {
        int key;
        Node left, right;

        Node(int data) {
            key = data;
            left = right = null;
        }
    }
    Node root;

    static boolean search(Node root, int key) {
        if(root == null) return false;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while(queue.size() > 0) {
            Node node = queue.peek();
            if(node.key == key) return true;

            queue.remove();
            if(node.left != null) {
                queue.add(node.left);
            }
            if(node.right != null) {
                queue.add(node.right);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Node newRoot = null;
        Node root = new Node(2);
        root.left = new Node(7);
        root.right = new Node(5);
        root.left.right = new Node(6);
        root.left.right.left = new Node(1);
        root.left.right.right = new Node(11);
        root.right.right = new Node(9);
        root.right.right.left = new Node(4);

        System.out.print((search(root, 6)?
                "Found\n": "Not Found\n"));
        System.out.print((search(root, 12)?
                "Found\n": "Not Found\n"));
    }
}