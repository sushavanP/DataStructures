package dataStructures.Trees.BinaryTrees;

public class treeFromPostAndInTraversal
{
    static class Node{
        int data;
        Node left, right;

        public Node(int data){
            this.data = data;
            left = right = null;
        }
    }
    static class Index{
        int index;
    }
    Node buildUtil(int in[], int post[], int inStart,
                   int inEnd, Index pindex){
        if(inStart > inEnd) return null;

        Node node = new Node(post[pindex.index]);
        (pindex.index)--;

        if(inStart == inEnd) return node;

        int inIndex = search(in, inStart, inEnd, node.data);
        node.right = buildUtil(in, post, inIndex + 1, inEnd, pindex);
        node.left = buildUtil(in, post, inStart, inIndex - 1, pindex);

        return node;
    }
    Node buildTree(int in[], int post[], int n){
        Index pindex = new Index();
        pindex.index = n - 1;
        return buildUtil(in, post, 0, n - 1, pindex);
    }
    int search(int arr[], int start, int end, int value){
        int i;
        for(i = 0; i <= end; i++){
            if(arr[i] == value)
                break;
        }
        return i;
    }
    void preOrder(Node node){
        if(node == null) return;

        System.out.print(node.data + " ");
        preOrder(node.left);
        preOrder(node.right);
    }
    public static void main(String[] args){
        treeFromPostAndInTraversal tree = new treeFromPostAndInTraversal();
        int in[] = new int[]{4, 8, 2, 5, 1, 6, 3, 7};
        int post[] = new int[]{8, 4, 5, 2, 6, 7, 3, 1};
        int n = in.length;

        Node root = tree.buildTree(in, post, n);
        System.out.println("PreOrder of the constructed tree is: ");
        tree.preOrder(root);
    }
}
