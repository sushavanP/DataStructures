package dataStructures.Trees.BinaryTrees;

public class treeAncestors
{
    static class Node{
        int data;
        Node left, right;
        Node(int item){
            data = item;
            left = right = null;
        }
    }

    Node root;
    public boolean printAncestors(Node node, int key){
        if(node == null) return false;

        if(node.data == key) return true;

        if(printAncestors(node.left, key) || printAncestors(node.right, key)){
            System.out.print(node.data + "  ");
            return true;
        }
        return false;
    }
    public static void main(String[] args){
        treeAncestors tree = new treeAncestors();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.left.left.left = new Node(7);

        tree.printAncestors(tree.root, 7);
    }
}
