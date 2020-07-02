package dataStructures.Trees.BinaryTrees;

public class nodeAtKdistantFromRoot
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
    void printKdistant(Node node, int k){
        if(node == null) return;
        if(k == 0){
            System.out.print(node.data + " ");
            return;
        }else{
            printKdistant(node.left, k - 1);
            printKdistant(node.right, k - 1);
        }
    }
    public static void main(String[] args){
        nodeAtKdistantFromRoot tree = new nodeAtKdistantFromRoot();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(8);

        tree.printKdistant(tree.root, 2);
    }
}
