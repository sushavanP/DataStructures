package dataStructures.Trees.BinarySearchTrees;

public class deleteFromBST {
    static class Node {
        int data;
        Node left, right;

        Node(int key) {
            data = key;
            left = right = null;
        }
    }
    Node root;

    void deleteKey(int data) {
        root = deleteKeyRec(root, data);
    }

    Node deleteKeyRec(Node root, int data) {
        if(root == null) return root;

        if(data < root.data)
            root.left = deleteKeyRec(root.left, data);
        else if(data > root.data)
            root.right = deleteKeyRec(root.right, data);
        else{
            if(root.left == null)
                return root.right;
            else if(root.right == null)
                return root.left;

            root.data =  minValue(root.right);
            root.right = deleteKeyRec(root.right, root.data);
        }
        return root;
    }

    public int minValue(Node right) {
        int minV = root.data;

        while(root.left != null) {
            minV = root.left.data;
            root = root.left;
        }
        return minV;
    }

    void insert(int data) {
        root = insertRec(root, data);
    }

    Node insertRec(Node root, int data) {
        if(root == null){
            root = new Node(data);
            return root;
        }

        if(data < root.data)
            root.left = insertRec(root.left, data);
        else if(data > root.data)
            root.right = insertRec(root.right, data);

        return root;
    }

    void inOrder(){
        inorderTraversal(root);
    }

    void inorderTraversal(Node root) {
        if(root != null){
            inorderTraversal(root.left);
            System.out.print(root.data +" ");
            inorderTraversal(root.right);
        }
    }

    public static void main(String[] args){
        deleteFromBST tree = new deleteFromBST();

        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

        System.out.println("Inorder traversal of the given tree");
        tree.inOrder();

        System.out.println("\nDelete 20");
        tree.deleteKey(20);
        System.out.println("Inorder traversal of the modified tree");
        tree.inOrder();

        System.out.println("\nDelete 30");
        tree.deleteKey(30);
        System.out.println("Inorder traversal of the modified tree");
        tree.inOrder();

        System.out.println("\nDelete 50");
        tree.deleteKey(50);
        System.out.println("Inorder traversal of the modified tree");
        tree.inOrder();
    }
}

