package dataStructures.Trees.BinaryTrees;

public class maxDepth
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

    int depthMax(Node node){
        if(node == null)
            return 0;
        else{
            int ldepth = depthMax(node.left);
            int rdepth = depthMax(node.right);

            if(ldepth > rdepth)
                return (ldepth + 1);
            else
                return (rdepth + 1);
        }
    }
    public static void main(String [] args){
        maxDepth tree = new maxDepth();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        System.out.println("Height of tree is : " +
                tree.depthMax(tree.root));
    }
}
