package dataStructures.Trees.BinaryTrees;

import java.util.LinkedList;
import java.util.Queue;
//Using Queue.

public class maxWidthOfBinaryTree {
    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
        }
    }

    static int maxWidth(Node root) {
        if (root == null) return 0;

        int maxwidth = 0;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int count = queue.size();
            maxwidth = Math.max(count, maxwidth);

            while (count-- > 0) {
                Node temp = queue.remove();
                if (temp.left != null)
                    queue.add(temp.left);
                if (temp.right != null)
                    queue.add(temp.right);
            }
        }
        return maxwidth;
    }
    public static void main(String[] args){
        Node root = new Node(1);
        root.left = new Node(3);
        root.right = new Node(2);
        root.left.left = new Node(5);
        root.left.right = new Node(3);
        root.right.right = new Node(9);
        //root.right.right.left = new Node(6);
        //root.right.right.right = new Node(7);

        System.out.println("Maximum width is: " +maxWidth(root));

    }
}
