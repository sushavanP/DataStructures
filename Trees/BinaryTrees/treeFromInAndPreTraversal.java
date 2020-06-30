/*
    time complexity - O(n^2)
*/
package dataStructures.Trees.BinaryTrees;

public class treeFromInAndPreTraversal
{
    static class Node{
        char data;
        Node left, right;

        Node(char item){
            data = item;
            left = right = null;
        }
    }

    static int preIndex = 0;

    Node buildTree(char in[], char pre[], int inStart, int inEnd){
        if(inStart > inEnd)
            return null;

        Node tnode = new Node(pre[preIndex++]);
        if(inStart == inEnd)
            return tnode;

        int inIndex = search(in, inStart, inEnd, tnode.data);

        tnode.left = buildTree(in, pre, inStart, inIndex - 1);
        tnode.right = buildTree(in, pre, inIndex + 1, inEnd);

        return tnode;
    }
    public int search(char[] in, int inStart, int inEnd, char data){
        int i;
        for(i = 0; i <= inEnd; i++){
            if(in[i] == data)
                return i;
        }
        return i;
    }
    void printInorder(Node node){
        if(node == null)
            return;

        printInorder(node.left);
        System.out.print(node.data +" ");
        printInorder(node.right);
    }
    public static void main(String[] args){
        treeFromInAndPreTraversal tree = new treeFromInAndPreTraversal();
        char in[] = new char[] { 'D', 'B', 'E', 'A', 'F', 'C' };
        char pre[] = new char[] { 'A', 'B', 'D', 'E', 'C', 'F' };
        int len = in.length;
        Node root = tree.buildTree(in, pre, 0, len - 1);

        // building the tree by printing inorder traversal
        System.out.println("Inorder traversal of constructed tree is : ");
        tree.printInorder(root);
    }
}
